package net.elazzaouy.model;

import java.util.Objects;
import java.util.UUID;

public abstract class BankAccount { /* " extends Object {"  toutes les classes (à l'exception des énumérations) sont héritées
    de la classe "java.lang.Object" par defaut. */
    // les niveaux de protection : public, protected, package(par defaut), private.
    // public : Accessible partout.
    // protected : Accessible dans cette classe et ses sous-classes.
    // package : Accessible dans le même paquetage (Lorsqu'aucun modificateur n'est spécifié).
    //private : Accessible uniquement dans cette classe.
    private String accountId;
    private double balance;
    private String currency;
    private AccountStatus status;

    public BankAccount(){ // Constructeur
        accountId = UUID.randomUUID().toString(); // id unique
        status =AccountStatus.CREATED;
    }

    public BankAccount(double balance, String currency){
        this(); // appelee le constructeur sans paramethers => accountId = UUID.randomUUID().toString(); status ="CREATED";
        // balance = balance; error de compilation
        this.balance = balance;
        this.currency = currency;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public String getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }

    public String getCurrency() {
        return currency;
    }

    public AccountStatus getStatus() {
        return status;
    }

    @Override
    public String toString() { ////return par defaut package.ClassName@AddrissRam
        return "BankAccount{" +
                "accountId='" + accountId + '\'' +
                ", balance=" + balance +
                ", currency='" + currency + '\'' +
                ", status=" + status +
                '}';
    }

    /* Par défaut, la methode "equals()" dans la classe Object effectue simplement
     une comparaison des "adresses mémoire" */
    @Override
    public boolean equals(Object object) {
        BankAccount account = (BankAccount) object;
        return (this.getAccountId() == account.getAccountId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.accountId) +
                Objects.hashCode(this.balance) +
                Objects.hashCode(this.currency) +
                Objects.hashCode(this.status);
    }

    public abstract String getType(); /* Une méthode abstraite "getType()" est une méthode déclarée dans une classe abstraite
     "BankAccount" qui n'a pas d'implémentation concrète dans cette classe.
     Cela signifie que les sous-classes "CurrentAccount, SavingAccount" doivent fournir une implémentation concrète de cette méthode. */

    public final void printBank(){
        /* une methode final est une méthode qui ne peut pas être REDEFINIE dans les sous-classes */
        /*le compilateur Java peut optimiser l'appel de méthodes final. Étant donné que la méthode
          NE peut PAS être redéfinie, le compilateur peut effectuer une liaison DIRECTE (appel en ligne)
          sans nécessiter de résolution dynamique.
         */
        System.out.println("------------------------ BANK --------------------------");
    }
}
