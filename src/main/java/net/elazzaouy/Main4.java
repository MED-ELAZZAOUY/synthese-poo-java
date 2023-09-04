package net.elazzaouy;

import net.elazzaouy.business.BankAccountService;
import net.elazzaouy.business.BankAccountServiceImpl;
import net.elazzaouy.exceptions.AccountNotFoundException;
import net.elazzaouy.exceptions.BalanceNotSufficientException;
import net.elazzaouy.model.BankAccount;
import net.elazzaouy.model.CurrentAccount;
import net.elazzaouy.utils.DataTransformationUtils;

public class Main4 {
    public static void main(String[] args) {
        BankAccountService bankAccountService = new BankAccountServiceImpl();
        bankAccountService.addRandomData(10);

        BankAccount bankAccount = new CurrentAccount("MAD", 30000, 150);
        bankAccount.setAccountId("bt-000-med");
        bankAccountService.addBankAccount(bankAccount);

        /*bankAccountService.getAllAccounts()
                .stream()
                .map(DataTransformationUtils::toJson)
                .forEach(System.out::println);
         */

        /*try {
            BankAccount account = bankAccountService.getBankAccountById("bt-000-Med");
            System.out.println(DataTransformationUtils.toJson(account));
        } catch (AccountNotFoundException e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }
         */

        try {
            BankAccount account = bankAccountService.getBankAccountById("bt-000-med");
            System.out.println(DataTransformationUtils.toJson(account));
            System.out.println("=========================================");
            bankAccountService.credit(account.getAccountId(), 50000);
            System.out.println(DataTransformationUtils.toJson(account));
            System.out.println("========================================");
            bankAccountService.debit(account.getAccountId(), 6000);
            System.out.println(DataTransformationUtils.toJson(account));

        } catch (AccountNotFoundException | BalanceNotSufficientException e){
            System.out.println(e.getMessage());
        }
        
        /*catch (Exception e){
            System.out.println(e.getMessage());
        }*/

        /*catch (AccountNotFoundException e) {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        } catch (BalanceNotSufficientException e) {
            System.out.println(e.getMessage());
        }*/
    }
}
