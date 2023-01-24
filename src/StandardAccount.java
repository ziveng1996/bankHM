public class StandardAccount implements IAccount {
    private int accountNumber;
    private double creditLimit;
    private double balance;


    public StandardAccount(int accountNumber, double creditLimit) {
        if (creditLimit > 0) {
            System.out.println("credit limit cannot be positive,your credit is set to 0");
            setCreditLimit(0);
            this.accountNumber = accountNumber;
            this.balance = 0;
        } else {
            this.creditLimit = creditLimit;
            this.accountNumber = accountNumber;
            this.balance = 0;
        }
    }

    public double getCreditLimit() {
        return this.creditLimit;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    @Override
    public void Deposit(double amount) {
        if (amount < 0) {
            System.out.println("you cannot deposit a negative amount");
        } else if (amount > this.creditLimit * (-1)) {
            System.out.println("deposit amount is higher then credit limit, you can deposit up to:" + this.creditLimit);
        } else {
            double newCredit;
            newCredit = this.creditLimit - amount;
            setCreditLimit(newCredit);
            System.out.println(newCredit);
        }


    }

    @Override
    public double Withdraw(double amount) {
        double withDrawLimit = getBalance() + (getCreditLimit() * -1);
        if (getBalance() < 0) {
            System.out.println("you cannot withdraw money please deposit first");
            return 0;
        } else if (amount > withDrawLimit) {
            this.balance = getBalance() - withDrawLimit;
            return withDrawLimit;

        }

        setBalance(getBalance() - amount);
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
        return "StandardAccount{" +
                "accountNumber=" + accountNumber +
                ", creditLimit=" + creditLimit +
                ", balance=" + balance +
                '}';
    }
}