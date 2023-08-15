package net.elazzaouy.business;

import net.elazzaouy.model.BankAccount;

import java.util.List;

public class BankAccountServiceImpl implements BankAccountService{
    /* Chaque methode de l'interface BankAccountService doit etre implementee dans la classe BankAccountServiceImpl. */

    @Override
    public BankAccount addBankAccount(BankAccount account) {
        return null;
    }

    @Override
    public List<BankAccount> getAllAccounts() {
        return null;
    }

    @Override
    public BankAccount getBankAccountById(String id) {
        return null;
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
