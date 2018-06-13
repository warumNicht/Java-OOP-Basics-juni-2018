package _2_StaticIdandRate;

public class BankAccount {
    private final static double DEFAULT_INTEREST=0.02;

    private static double rate=DEFAULT_INTEREST;
    private static  int bankAccountCount;
    private int id;
    private double balance;


    public BankAccount() {
        this.id = ++bankAccountCount;
    }

    public double getBalance() {
        return balance;
    }

    public static void setInterestRate(double interest) {
        rate = interest;
    }


    public void deposit (double amount){
        this.balance+=amount;
    }

    public double getInterest(int years){
        return  this.getBalance()*rate*years;
    }

    @Override
    public String toString(){
        return "ID"+this.id;
    }
}
