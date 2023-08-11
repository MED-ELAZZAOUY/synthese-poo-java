  package net.elazzaouy;

  import net.elazzaouy.model.BankAccount;

  public class Main {

    public static void main(String[] args) {
        /*String s1 =new String("azerty");
        String s2 =new String("azerty");
        System.out.println(s1 == s2); // false adresse memoire #
        System.out.println(s1.equals(s2)); // true le compilateur compare le contenu de deux objets.
        */
        BankAccount account1 = new BankAccount();
        account1.setBalance(10500.7);
        account1.setCurrency("MAD");
        //printAccount(account1); // Méthode ou Attribut statique directement appelée dans "main"

        BankAccount account2 = new BankAccount(7000, "MAD");
        //printAccount(account2);
        //System.out.println(account1.toString());

        BankAccount account3 = new BankAccount(7000, "MAD");
        account3.setAccountId(account2.getAccountId());
        System.out.println(account2.toString());
        System.out.println(account3.toString());
        System.out.println(account2.equals(account3));
        System.out.println(account2 == account3);
    }

      

      public static void  printAccount(BankAccount account){
         /*une methode static (methode de classe) est partagée par toutes les instances (objets) de la classe
          et peut être appelée directement sur la classe elle-même, sans nécessiter la création d'une instance
          "nomDeClasse.nomDeLaMethode()". */
          System.out.println("***********************************************");
          System.out.println("Account ID ="+account.getAccountId());
          System.out.println("Account balance ="+account.getBalance());
          System.out.println("Account currency ="+account.getCurrency());
          System.out.println("Account status ="+account.getStatus());
          System.out.println("***********************************************");
    }



}