# AACS2204 OCT 2023 Answers

[Link to the paper](https://eprints.tarc.edu.my/26841/1/AACS2204.pdf)

Credit: [OldManDoug](https://github.com/OldManDoug)

- [Question 1](#question-1)
- [Question 2](#question-2)
- [Question 3](#question-3)
- [Question 4](#question-4)

## Answers

### Question 1

a) 

- Encapsulation

Encapsulation is the practice of wrapping data and methods that operate on the data into a single unit, which restricts other classes from accessing them. This prevents unintended data tampering to ensure the state of an object is only manipulated through well-defined behaviours. This could achieve low coupling, high maintainability and information hiding.

- Inheritance

Inheritance allows the creation of classes from existing classes. The classes created from inheritance are subclasses of existing superclasses. Subclasses can use the general states and behaviour defined in the superclass, which promotes code reusability. Inheritance also can model the hierarchical relationship among classes which increases the code understandability.

- Polymorphism

Polymorphism describes an ability to reuse the same expression to achieve different operations. This can be achieved in two manners, which is method overloading, where similar methods share the same name but different parameter lists within a class family, and method overriding, where subclasses provide their own implementation of superclass methods. This promotes flexibility and reusability, which allow the system to be extended easily.

b)

- Explicit Casting
  - For primitive type, the data type is changed from a higher range value to smaller range value
  - For non-primitive type, the class type is changed into a more specific subclass
    
  ```java
  double x = 1.23;
  int y = (int) x;
  ```
- Implicit Casting
  - For primitive type, the data type is changed into higher range type
  - For non-primitive type, the class type is changed into its superclass type
    
  ```java
  int x = 3;
  double y = x;
  ```

c) A practice of defining multiple methods with same name but different parameter list (different types, number or order of parameters) within the same class family. Java determines which implementation to use based on the method signature at compile time. This allow the methods with similar functionality to have the same name, which improves code reusability and readability.

d)

- Methods improve code reusability (Avoid code duplication)
- Achieve information hiding (Other programmer don't need to know the implementation detail of the class, hence less thing to know, easier to understand)
- Reduce code complexity (Shorter code)
- Ease of maintenance (Changes in the method definition can take effect to all parts that uses it)

### Question 2

a)

| Procedural Paradigm | Object-Oriented Paradigm |
|-|-|
|Data and methods are loosely coupled. The methods do not own the data that they worked on.|Data and methods are coupled into objects. Methods can directly work on the data which belongs to the same class|
|Focuses on designing methods. The program is designed to carry out contiguous operations and solve complex tasks.|Focuses on designing objects, their states and their behaviours. The program simulates the entity's real-world behaviour, where objects interact with each other to carry out complex tasks|
|Methods consume data by having them passed as arguments.|Data and operations that act on the data are being wrapped in a single object.|

b) 

i) `i'm learning object oriented programming technnique and PHP`

ii) `I'm learning PHP`

iii) `I'm learnAng Object OrAented ProgrammAng TechnnAque`

c)

![String concept](/2023-JAN/Q4a.png)

- String pool stores all string values existed during the system runtime.
- When a String variable is created, it checks against the string pool if the value is already exists, otherwise a new value will be created, and the String variable will point its value to the corresponding one within the string pool
- If the value of the String variable modified, the value it pointed to inside the string pool doesn't change, instead, a new value is created and the object is pointed to the new one. Hence, the object is immutable.

d)

- Overloading Polymorphism
  - Compile time polymorphism
  - Define methods with same name in a same class family which has different parameter list
  - Method implementation to used is decide statically using the parameter passed when method call
  - Allow method with similar functionality to reuse name, enhance readability
- Overriding Polymorphism
  - Runtime polymorphism
  - Define methods with same method signature as in the superclass to override it with more specific behaviour
  - Allow subclasses objects to be referred with higher level class, but still maintain their behaviour specifically to the subclass.
  - Make system easily extensible with new features and functionality

### Question 3

a) 

```java
public class Book{
  private String id, title;
  private double price;
  private static int totalNumberofBook;

  public Book() {
    this("","",0.0);
  }

  public Book(String id, String title, double price){
    this.id = id;
    this.title = title;
    this.price = price;
    totalNumberofBook++;
  }

  public String getId(){
    return id;
  }

  public String getTitle(){
    return title;
  }

  public double getPrice(){
    return price;
  }

  public void setId(String id){
    this.id = id;
  }

  public void setTitle(String title){
    this.title = title;
  }

  public void setPrice(double price){
    this.price = price;
  }

  // Most of the time this should be static method, but it doesn't defined as so in the UML
  public int getTotalNumberOfBook() {
    return Book.totalNumberOfBook;
  }

  public String toString(){
    return String.format("Id : %s\nTitle : %s\nPrice : $%.2f\n", this.id, this.title, this.price);
  }
}
```

b)

```java
public class TestBook{
  public static void main(String[] args){
    Book b1 = new Book();
    b1.setId("A1234");
    b1.setTitle("The Hobbit");
    b1.setPrice(39.9);

    Book b2 = new Book("A1235", "The Girl on the Train", 59.9);

    System.out.println(b1);
    System.out.println(b2);
    System.out.println("Total Number of Book : " + b2.getTotalNumberOfBook());
  }
}
```

### Question 4

> Although this question tell us to excludes the getter and setter in the answer, but I assume it is just means that we don't need to write it out, but the class that we use afterwards are implicitly having them
>
> The complete code is [here](/2023-OCT/TestAccounts.java)

a)

```java
public class Account {
  private String accountNumber;
  private double balance;

  public Account(String accountNumber, double balance) {
    this.accountNumber = accountNumber;
    this.balance = balance;
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
```

b)

```java
public class CheckingAccount extends Account {
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
```

c)

```java
public class TestAccounts{
  public static void main(String [] args) {
    SavingAccount sa = new SavingAccount("S1234",5000.00);
    System.out.println(sa);
    sa.deposit(50.0);
    sa.addInterest();
    System.out.println("============================");
    System.out.println(String.format("Final Balance: RM%.2f", sa.getBalance()));
  }
}
```
