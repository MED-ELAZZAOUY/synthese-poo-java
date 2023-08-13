package net.elazzaouy.model;

public class CurrentAccount extends BankAccount {
    /* heritage permet de créer une nouvelle classe (sous-classe) basée sur
    une classe existante (superclasse) en héritant de ses attributs
    et de ses comportements (méthodes).*/
    private double overDraft;

    public CurrentAccount(){
        super(); // appeler le constructeur de la superclasse "BankAccount".
    }
    public CurrentAccount(String currency, double initialBalance, double overDraft){
        super(initialBalance, currency); //appeler le constructeur de la superclasse "BankAccount".
        this.overDraft = overDraft;
    }

    public void setOverDraft(double overDraft){
        this.overDraft = overDraft;
    }

    public double getOverDraft(){
        return this.overDraft;
    }

    public String toString(){
        return "Current Account : OverDraft= "+overDraft +" "+ super.toString(); // appeler la methode toString de la superclasse " BankAccount".
    }
}
