# AACS2204 MAY 2024 Answers

[Link to the paper](https://eprints.tarc.edu.my/28540/1/AACS2204.pdf)

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

Inheritance allows the creation of classes from existing classes. The classes created from inheritance are subclasses of existing superclasses. Subclasses can use the general states and behaviour defined in the superclass, which promotes code reusability. Inheritance also can represent the relationship hierarchy which increases the code understandability.

- Polymorphism

Polymorphism describes an ability to reuse the same expression to achieve different operations. This can be achieved in two manners, which is method overloading, where similar methods share the same name but different parameter lists within a class family, and method overriding, where subclasses provide their own implementation of superclass methods. This promotes flexibility and reusability, which allow the system to be extended easily.

b)

| Procedural Paradigm | Object-Oriented Paradigm |
|-|-|
|Data and methods are loosely coupled. The methods do not own the data that they worked on.|Data and methods are coupled into objects. Methods can directly work on the data which belongs to the same class|
|Focuses on designing methods. The program is designed to carry out contiguous operations and solve complex tasks.|Focuses on designing objects, their states and their behaviours. The program simulates the entity's real-world behaviour, where objects interact with each other to carry out complex tasks|
|Methods consume data by having them passed as arguments.|Data and operations that act on the data are being wrapped in a single object.|

c) 

- Class is a blueprint of objects that defines the states and behaviours possessed by all of its instances.
- Object is a physical/concrete representation of a class, which possesses the states and behaviour specified by the class. However, each object maintains its own states, which is manipulated by its behaviour.

### Question 2

a) i) Method Overloading, or Compile-Time Polymorphism. This concept is the practice of using the same method name with different parameter lists to define different methods. Three methods within the same class, `Calculator`, share the same method name called `add()`, and each of them has its own set of parameter lists. The methods carry out a similar operation, which is to add the numbers and return the result.

a) ii) 
- Line 6 output: `30`

This output uses the overloaded instance of the method at line *3* in `Calculator.java`, whereby the method returns an integer value which is the sum of all two integer parameters, in this case `10` and `20`.

- Line 7 output: `30.0`

This output uses the overloaded instance of the method at line *7* in `Calculator.java`, whereby the method returns a double value which is the sum of all two double parameters, in this case `10.0` and `20.0`.

- Line 8 output: `60`

This output uses the overloaded instance of the method at line *11* in `Calculator.java`, whereby the method returns an integer value which is the sum of all three integer parameters, in this case `10`, `20` and `30`.

a) iii) The compiler checks the method call against the method signature of each overloaded instance and uses the most specific match. For example, the first `add()` call has 2 integer arguments, which match the method signature at line 3 in `Calculator.java`, hence the result is produced using the method mentioned.

b) i) Method Overriding, or Runtime Polymorphism. This concept is the practice of the subclass providing its own implementation to the one declared in the superclass. In the sample program shown, The `Car `and `ElectricCar` are subclasses extended from the superclass, `Vehicle`. While `Vehicle` has the `run()` method declared, the subclasses override the method with their own implementation which performs operations that are more specific to the class.

b) ii) `The electric car is running efficiently`. Although `myVehicle` has the type of `Vehicle`, the underlying object is `ElectricCar`. When performing the `run()` method, the program finds the matching one from the bottommost hierarchy, hence, the implementation of `run()` in `ElectricCar` is chosen to run.

### Question 3

a) 

```java
public class Book {
  private String bookID;
  private String bookTitle;
  private int quantity;
  private static int totalBook;

  public Book() {
    this(null, null, 0);
  }

  public Book(String bookID, String bookTitle, int quantity) {
    this.bookID = bookID;
    this.bookTitle = bookTitle;
    this.quantity = quantity;
    Book.totalBook++;
  }

  public String getBookID() {
    return this.bookID;
  }

  public String getBookTitle() {
    return this.bookTitle;
  }

  public int getQuantity() {
    return this.quantity;
  }

  public void setBookID(String bookID) {
    this.bookID = bookID;
  }

  public void setBookTitle(String bookTitle) {
    this.bookTitle = bookTitle;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public static int getTotalBook() {
    return Book.totalBook;
  }

  public String toString() {
    return "Book ID: " + this.bookID +
           "\nBook Title: " + this.bookTitle +
           "\nQuantity: " + this.quantity + "\n";
  }
}
```

b)

```java
public class MainClass {
  public static void main(String[] args) {
    Book book1 = new Book();
    book1.setBookID("B0012");
    book1.setBookTitle("Introduction to Algorithms");
    book1.setQuantity(8);

    Book book2 = new Book("B2340", "Thinking in Java", 6);

    System.out.println(book1);
    System.out.println(book2);

    System.out.println("Total of Book: " + Book.getTotalBook());
  }
}
```

### Question 4

a) 

```java
public class Cone{
  private double slantHeight;

  public Cone() {
    this(null, 0.0, 0.0);
  }

  public Cone(String color, double radius, double slantHeight) {
    super(color, radius);
    this.slantHeight = slantHeight;
  }

  public double getSlantHeight() {
    return this.slantHeight;
  }

  public void setSlantHeight(double slantHeight) {
    this.slantHeight = slantHeight;
  }

  public String toString() {
    return super.toString() + "Slant Height: " + this.slantHeight + "\n";
  }

  public double findArea() {
    return super.findArea() + (Math.PI * this.getRadius() * this.slantHeight);
  }
}
```

b)
```java
public class MainCass() {
  public static void main(String[] args) {
    GeometricObject circle = new Circle("Blue", 2.3);
    GeometricObject cone = new Cone("Yellow", 3.4, 6.0);

    print(circle);
    print(cone);
  }

  private static void print(GeometricObject obj) {
    System.out.println(obj.toString() + "The area is " + obj.findArea() + "\n");  
  }
}
```
