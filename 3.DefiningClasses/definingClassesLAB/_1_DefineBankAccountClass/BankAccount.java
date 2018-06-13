public class BankAccount {
    private int id;
    private double balance;

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }
    public void deposit (double amount){
        if(amount>0){
            this.balance+=amount;
        }
    }
    public void withdraw(double amount){
        if(this.getBalance()<amount){
            System.out.println("Insufficient balance");
        }else {
            this.balance-=amount;
        }
    }
    @Override
    public String toString(){
        return String.format("Account ID%d, balance %.2f",this.id,this.getBalance());
    }
}
