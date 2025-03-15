package lr2;

interface BankAccountInterface {
    void deposit(double amount);
    void withdraw(double amount);
    double getBalance();
}

class BankAccount implements BankAccountInterface {
    private double balance;

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }
}
