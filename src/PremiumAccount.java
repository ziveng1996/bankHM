import java.util.List;

public class PremiumAccount implements IAccount{
    private int accountNumber;
    private double balance=0;

    public PremiumAccount(int accountNumber) {
        this.accountNumber=accountNumber;

    }



    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public double getBalance() {
        return this.balance;
    }

    @Override
    public void Deposit(double amount) {
        if (amount<0) {
            System.out.println("you cannot deposit a negative amount");
        }else {
            balance=getBalance()+amount;

        }
    }

    @Override
    public double Withdraw(double amount) {
        setBalance(getBalance()-amount);
        return amount;
    }

    @Override
    public double GetCurrentBalance() {
        return getBalance();
    }

    @Override
    public int GetAccountNumber() {
        return getAccountNumber();
    }

    @Override
    public String toString() {
        return "PremiumAccount{" +
                "accountNumber=" + accountNumber +
                ", balance=" + balance +
                '}';
    }
}