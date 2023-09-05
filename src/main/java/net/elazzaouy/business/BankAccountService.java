package net.elazzaouy.business;

import net.elazzaouy.exceptions.AccountNotFoundException;
import net.elazzaouy.exceptions.BalanceNotSufficientException;
import net.elazzaouy.model.BankAccount;

import java.util.List;

public interface BankAccountService {
    /*   Une interface est un contrat définissant un ensemble de méthodes
     et de constantes que les classes qui l'implémentent doivent fournir.
     */
    /*   les méthodes sont par défaut "public" et "abstract" même si ces modificateurs ne sont pas explicitement spécifiés.
     */
    /*   Une constante déclarée dans une interface est implicitement "public", "static" et "final".
     */

    BankAccount addBankAccount(BankAccount account);
    List<BankAccount> getAllAccounts(); // == public abstract List<BankAccount> getAllAccounts();
    BankAccount getBankAccountById(String id) throws AccountNotFoundException;
    void addRandomData(int size);
    void credit(String accountId, double amount) throws AccountNotFoundException;
    void debit(String accountId, double amount) throws AccountNotFoundException, BalanceNotSufficientException;
    void transfer(String accountSource, String accountDestination, double amount) throws AccountNotFoundException, BalanceNotSufficientException;
    List<BankAccount> getSavingAccount();
    List<BankAccount> getCurrentAccount();
    double getTotalBalance();


}
