package net.elazzaouy;

import net.elazzaouy.business.BankAccountService;
import net.elazzaouy.business.BankAccountServiceImpl;
import net.elazzaouy.model.BankAccount;
import net.elazzaouy.model.CurrentAccount;
import net.elazzaouy.model.SavingAccount;

import java.util.List;

public class Main3 {
    public static void main(String[] args) {
        BankAccountService bankAccountService = new BankAccountServiceImpl();
        System.out.println("========== addBankAccount() ================");
        bankAccountService.addBankAccount(new CurrentAccount("MAD", 15000, 650));
        bankAccountService.addBankAccount(new SavingAccount(185000, "MAD", 5));
        BankAccount bankAccount = new CurrentAccount("MAD", 30000, 150);
        bankAccount.setAccountId("bt-000-med");
        bankAccountService.addBankAccount(bankAccount);

        System.out.println("=================== getAllAccounts() ===============");
        List<BankAccount> allAccounts = bankAccountService.getAllAccounts();

        System.out.println("============= expressions-lambda / forEach() ==============");
        /*
        for (int i=0; i<allAccounts.size(); i++){
            System.out.println(allAccounts.get(i));
        }
         */

        /*
        for (BankAccount bankAccount : allAccounts){
            System.out.println(bankAccount);
        }
         */

        /*
        allAccounts.forEach(new Consumer<BankAccount>() {
            /* forEach() est une méthode introduite dans l'interface Iterable en "Java 8" et elle est également disponible dans
             les COLLECTIONS telles que les listes, les ensembles et les maps. Elle permet d'appliquer
             une opération (représentée par une INSTANCE de l'interface fonctionnelle CONSUMER) à chaque élément de la collection.
             */
            /* Consumer est une interface fonctionnelle (@FunctionalInterface) qui contient une seul methode abstraite "accept"*/ /*
            @Override
            public void accept(BankAccount account) {
                System.out.println(account);
            }
        });
        */

        /*
        allAccounts.forEach((account) -> {
            System.out.println(account);
            /* Les expressions lambda sont une caractéristique importante introduite dans Java 8. Elles permettent de définir
             des fonctions ANONYMES de manière concise et expressive, ce qui facilite le traitement des données et
             la programmation fonctionnelle. Les expressions lambda sont particulièrement utiles lorsqu'elles sont combinées avec
              des interfaces fonctionnelles telles que Consumer, Predicate, Function, etc.
              syntaxe : (parameters) -> { Bloc de déclarations et d'instructions }.
             */ /*
        });
        */

        /*
        allAccounts.forEach(account -> System.out.println(account)); // pas de ";" apres SOUT
        */
        /*
        allAccounts.forEach(System.out::println); // Les bonnes pratiques
         */

        System.out.println("=========== getBankAccountById ============");
        System.out.println(bankAccountService.getBankAccountById("bt-000-med"));
        //System.out.println(bankAccountService.getBankAccountById("med")); //error catch by jvm
    }
}
