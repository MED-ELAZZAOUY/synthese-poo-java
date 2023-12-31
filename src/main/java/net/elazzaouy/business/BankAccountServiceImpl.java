package net.elazzaouy.business;

import net.elazzaouy.exceptions.AccountNotFoundException;
import net.elazzaouy.exceptions.BalanceNotSufficientException;
import net.elazzaouy.model.AccountStatus;
import net.elazzaouy.model.BankAccount;
import net.elazzaouy.model.CurrentAccount;
import net.elazzaouy.model.SavingAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class BankAccountServiceImpl implements BankAccountService{
    /* Chaque methode de l'interface BankAccountService doit etre implementee dans la classe BankAccountServiceImpl. */
    private List<BankAccount> bankAccountList = new ArrayList<>(); // <== java 5+
    /* Avant Java 5, lorsque "les génériques" n'étaient pas encore introduits, vous pouviez déclarer une liste comme List
     sans spécifier son TYPE GENERIQUE, ce qui signifie que tous les objets stockés dans cette liste étaient de type "Object"
      => List bankAccountList = new ArrayList(); */
    @Override
    public BankAccount addBankAccount(BankAccount account) {
        bankAccountList.add(account);
        return account;
    }

    @Override
    public List<BankAccount> getAllAccounts() {
        return bankAccountList;
    }

    @Override
    public BankAccount getBankAccountById(String id) throws AccountNotFoundException {
        //Declarative Approach (les bonnes pratiques)
        return bankAccountList
                .stream()
                .filter(acc -> acc.getAccountId().equals(id))
                .findFirst()
                .orElseThrow(()->new AccountNotFoundException(String.format("BankAccount %s Not Found",id))); // Optional<BankAccount>
                /* "Optional" est une classe puissante pour gérer les valeurs potentiellement NULLES de manière plus propre et plus SURE.
                 Elle favorise une programmation défensive et aide à éviter les "NullPointerException".
                 */


        //Imperative Approach
        /*for (BankAccount account : bankAccountList){
            if (account.getAccountId().equals(id)){
                return account;
            }
        }*/
        /* Les exceptions sont regroupées en trois catégories principales :
          les exceptions vérifiées (checked exceptions), les exceptions non vérifiées (unchecked exceptions)
          et les erreurs (errors).*/
        //throw new Exception("BankAccount Not Found"); //checked exception (verifiée)
        //throw new RuntimeException("BankAccount Not Found"); //unchecked exception (non vérifiée)
        //throw new AccountNotFoundException("BankAccount Not Found");
    }

    @Override
    public void addRandomData(int size) {
        AccountStatus[] values = AccountStatus.values();
        Random radom = new Random();
        for(int i=0; i<size; i++){
            BankAccount bankAccount;
            if(Math.random()>0.5){ // Expression ternaire
                bankAccount = new CurrentAccount(Math.random()>0.5?"MAD":"USA", Math.random()*1000000, Math.random()*500);
                bankAccount.setStatus(values[radom.nextInt(values.length)]);
            }else {
                bankAccount = new SavingAccount(Math.random()*1000000, Math.random()<0.5?"MAD":"USA",  3+Math.random()*7);
                bankAccount.setStatus(values[radom.nextInt(values.length)]);
            }
            bankAccountList.add(bankAccount);
        }
    }

    @Override
    public void credit(String accountId, double amount) throws AccountNotFoundException {
        BankAccount accountById = getBankAccountById(accountId);
        accountById.setBalance(accountById.getBalance()+amount);
    }

    public void debit(String accountId, double amount) throws AccountNotFoundException, BalanceNotSufficientException {
        BankAccount accountById = getBankAccountById(accountId);
        if (accountById.getBalance() < amount) throw new BalanceNotSufficientException("Balance Not Sufficient");
        accountById.setBalance(accountById.getBalance()-amount);
    }

    @Override
    public void transfer(String accountSource, String accountDestination, double amount) throws AccountNotFoundException, BalanceNotSufficientException {
        debit(accountSource, amount);
        credit(accountDestination, amount);
    }

    @Override
    public List<BankAccount> getSavingAccount() {
        return bankAccountList
                .stream()
                .filter(account ->account instanceof SavingAccount )
                .collect(Collectors.toList());
    }

    @Override
    public List<BankAccount> getCurrentAccount() {
        return bankAccountList
                .stream()
                .filter(account ->account instanceof CurrentAccount )
                .collect(Collectors.toList());
    }

    @Override
    public double getTotalBalance() {
        //Declarative Approach
        return bankAccountList
                .stream()
                .map(bankAccount -> bankAccount.getCurrency().equals("USA")? bankAccount.getBalance()*10: bankAccount.getBalance())
                .reduce(0.0, Double::sum);
        /*return bankAccountList
                .stream()
                .mapToDouble(BankAccount::getBalance)
                .sum();

        //Imperative Approach
        /*double totalBalance = 0;
        for (BankAccount account : bankAccountList){
            totalBalance+=account.getBalance();
        }
        return totalBalance;
        */
    }

    @Override
    public List<BankAccount> searchAccounts(Condition<BankAccount> condition) {
        List<BankAccount> results = new ArrayList<>();
        for (BankAccount account: bankAccountList){
            if(condition.test(account)){
                results.add(account);
            }
        }
        return results;
    }
}
