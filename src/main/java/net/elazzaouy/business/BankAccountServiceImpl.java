package net.elazzaouy.business;

import net.elazzaouy.model.BankAccount;

import java.util.ArrayList;
import java.util.List;

public class BankAccountServiceImpl implements BankAccountService{
    /* Chaque methode de l'interface BankAccountService doit etre implementee dans la classe BankAccountServiceImpl. */
    private List<BankAccount> bankAccountList = new ArrayList<>(); // <== java 5+
    /* Avant Java 5, lorsque "les génériques" n'étaient pas encore introduits, vous pouviez déclarer une liste comme List
     sans spécifier son TYPE générique, ce qui signifie que tous les objets stockés dans cette liste étaient de type "Object"
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
    public BankAccount getBankAccountById(String id) {
        for (BankAccount account : bankAccountList){
            if (account.getAccountId().equals(id)){
                return account;
            }
        }
        throw new RuntimeException("Account Not Found");
    }

    @Override
    public void addRandomData(int size) {

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
