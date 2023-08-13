package net.elazzaouy.model;

public class SavingAccount extends BankAccount {
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
