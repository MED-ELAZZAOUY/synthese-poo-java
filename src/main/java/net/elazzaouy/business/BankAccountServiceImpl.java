package net.elazzaouy.business;

import net.elazzaouy.exceptions.AccountNotFoundException;
import net.elazzaouy.model.AccountStatus;
import net.elazzaouy.model.BankAccount;
import net.elazzaouy.model.CurrentAccount;
import net.elazzaouy.model.SavingAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
                .orElseThrow(()->new AccountNotFoundException("BankAccount Not Found")); // Optional<BankAccount>
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
    public void credit(String accountId, double amount) {

    }

    @Override
    public void dedit(String accountId, double amount) {

    }

    @Override
    public void transfer(String accountSource, String accountDestination, double amount) {

    }
}
