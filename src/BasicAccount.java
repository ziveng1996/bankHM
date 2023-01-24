public class BasicAccount implements IAccount {
    private int accountNumber;
    private double withdrawlLimit;
    private double balance;

    public BasicAccount(int accountNumber, double withdrawlLimit) {
        if(withdrawlLimit<0){
            this.withdrawlLimit=0;
            this.accountNumber=accountNumber;
            this.balance=0;

        }else {
            this.accountNumber = accountNumber;
            this.withdrawlLimit = withdrawlLimit;
            this.balance=0;
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }



    public double getWithdrawlLimit() {
        return this.withdrawlLimit;
    }

    public void setWithdrawlLimit(double withdrawlLimit) {
        this.withdrawlLimit = withdrawlLimit;
    }

    @Override
    public void Deposit(double amount) {
        if (amount<0) {
            System.out.println("you cannot deposit a negative amount");
        }else {
            setBalance(this.balance+amount);

        }

    }

    @Override
    public double Withdraw(double amount) {
        double withdrawLimit = getWithdrawlLimit();
        if (getBalance() <= 0) {
            System.out.println("you cannot withdraw money please deposit first");
            return 0;
        } else if (amount > (withdrawLimit * -1)) {
            if (amount < getBalance()) {
                setBalance(getBalance() - withdrawLimit);
                return withdrawLimit;
            } else {
                double tempBalnace = getBalance();
                setBalance(0);
                return tempBalnace;
            }
        } else {
            if (amount > getBalance()) {
                double tempBalnace = getBalance();
                setBalance(0);
                return tempBalnace;
            } else {
                setBalance(getBalance() - amount);
                return amount;
            }
        }
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
        return "BasicAccount{" +
                "accountNumber=" + accountNumber +
                ", withdrawlLimit=" + withdrawlLimit +
                ", balance=" + balance +
                '}';
    }
}