# AACS2204 MAY 2023 Answers

[Link to the paper](https://eprints.tarc.edu.my/25088/1/AACS2204.pdf)

- [Question 1](#question-1)
- [Question 2](#question-2)
- [Question 3](#question-3)
- [Question 4](#question-4)

## Answers

### Question 1

- still cooking

### Question 2

a)

```java
public class CustomerAccount {
  private String accountNumber;
  private String customerName;
  private double balance;
  private static int totalCustomer;

  public CustomerAccount() {
    this(null, null, 0.0);
  }

  public CustomerAccount(String accountNumber, String customerName, double balance) {
    this.accountNumber = accountNumber;
    this.customerName = customerName;
    this.balance = balance;
    totalCustomer++;
  }

  public String getAccountNumber() {
    return this.accountNumber;
  }

  public String getCustomerName() {
    return this.customerName;
  }

  pubic double getBalance() {
    return this.balance;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public static int getTotalCustomer() {
    return CustomerAccount.totalCustomer;
  }

  @Override
  public String toString() {
    return "Account Number: " + this.accountNumber +
         "\nCustomer Name: " + this.customerName +
         "\nBalance: " + this.balance +
         "\n";
  }
}
```

b)

```java
public class MainClass {
  public static void main(String[] args) {
    CustomerAccount cust1 = new CustomerAccount();
    cust1.setAccountNumber("AC1234");
    cust1.setCustomerName("Abbel Leowanday");
    cust1.setBalance(6000.0);
  
    CustomerAccount cust2 = new CustomerAccount("AC9876", "Abigail Chong", 3000.0);
  
    System.out.println(cust1);
    System.out.println(cust2);
    System.out.println("Total of Customer: " + CustomerAccount.getTotalCustomer());
  }
}
```

### Question 3

a) 

```java
public class Employee {
  protected String name;
  protected String staffID;

  public Employee(String name, String staffID) {
    this.name = name;
    this.staffID = staffID;
  }

  @Override
  public String toString() {
    return "Name: " + this.name +
         "\nStaff ID: " + this.staffID +
         "\n";
  }
}
```

b)

```java
public class SalesAssistant extends Employee {
  private double salesAmount;
  private static final double COMMISSION_RATE = 0.1;

  public SalesAssistant(String name, String staffID, double salesAmount) {
    super(name, staffID);
    this.salesAmount = salesAmount;
  }

  public double calcComission() {
    return this.salesAmount * COMMISSION_RATE;
  }

  @Override
  public String toString() {
    return "Sales Assistant\n" +
            super.toString() +
           "Sales Amount: " + this.salesAmount +
         "\nTotal Commission: " + calcComission() +
         "\n";
  }
}
```

c)

```java
public class MainClass {
  public static void main(String[] args) {
    Employee emp1 = new SalesAssistant("Jared Justin", "1234", 5600.0);
    Employee emp2 = new AccountingClerk("Alia Tasmin", "7890", 20.0);

    System.out.println(emp1);
    System.out.println(emp2);
  }
}
```

### Question 4

a) i)

```java
public interface Language {
  public void Java();
  public void Python();
}
```

ii)

```java
public class ProgrammingLanguage implements Language {
  @Override
  public void Java() {
    System.out.pritnln("Java is a high-level, class-based, object-oriented programming language");
  }

  @Override
  public void Python() {
    System.out.println("Python is a high-level, general purpose programming language");
  }
}
```

b)

```java
public class Name {
  private String firstName;
  private String lastName;
}
```

```java
public class Address {
  private String addressLine;
  private int postcode;
}
```

```java
public class Person {
  protected Name name;
  protected Address address;
}
```

```java
public class Borrower extends Person {
  private String borrowerID;
  private Date dateBorrow;
  private Book[] book;
}
```

```java
public class Book {
  private String author;
  private String title;
  private Borrower borrower;
}
```
