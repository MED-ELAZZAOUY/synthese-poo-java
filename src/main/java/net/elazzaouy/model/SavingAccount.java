package net.elazzaouy.model;

public final class SavingAccount extends BankAccount {
    /*   Une classe finale est une classe qui ne peut pas être utilisée comme classe PARENTE
      pour créer des SOUS-CLASSES.*/
    /*   Un attribut final DOIT être INITIALISE soit lors de sa déclaration, soit dans
      le constructeur de la classe. Une fois qu'une valeur a été assignée à un attribut final,
      elle NE peut PAS être CHANGEE par la suite.*/
    /* final ==> erreur de compilation */

    private double interesRate;

    public SavingAccount(){
        super();
    }
    public SavingAccount(double initialBalance, String currency, double interesRate){
        super(initialBalance, currency);
        this.interesRate = interesRate;
    }

    public double getInteresRate() {
        return interesRate;
    }

    public void setInteresRate(double interesRate) {
        this.interesRate = interesRate;
    }

    public String toString(){
        return "Saving Account : interesRate = "+ this.interesRate +" "+super.toString();
    }

    @Override
    public String getType() {
        return "Saving_Account";
    }
}
