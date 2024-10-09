class Account {
    private String accountNumber;
    private double balance;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return this.balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
        System.out.println(String.format("Transaction: Deposit Rm%.2f", amount));
        System.out.println(String.format("Updated balance: RM%.2f", this.balance));
    }

    public void withdraw(double amount) {
        this.balance -= amount;
        System.out.println(String.format("Transaction: Withdraw Rm%.2f", amount));
        System.out.println(String.format("Updated balance: RM%.2f", this.balance));
    }

    public String toString() {
        return String.format("account %s has balance: RM%.2f", this.accountNumber, this.balance);
    }
}

class CheckingAccount extends Account {
    private static double transactionFee = 5.0;

    public CheckingAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    public void deductTransactionFee() {
        this.setBalance(this.getBalance() - transactionFee);
    }

    public String toString() {
        return String.format("Checking %s", super.toString());
    }

}

class SavingAccount extends Account {
    private static double interestRate = 0.05;

    public SavingAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    public double calcInterest() {
        return getBalance() * interestRate / 12;
    }

    public void addInterest() {
        setBalance(getBalance() + calcInterest());
    }

    public String toString() {
        return String.format("Saving %s", super.toString());
    }
}

public class TestAccounts {
    public static void main(String[] args) {
        SavingAccount sa = new SavingAccount("S1234", 5000.00);
        System.out.println(sa);
        sa.deposit(50.0);
        sa.addInterest();
        System.out.println("============================");
        System.out.println(String.format("Final Balance: RM%.2f", sa.getBalance()));
    }
}