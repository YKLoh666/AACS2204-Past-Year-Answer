# AACS2204 DEC 2021 Answers

[Link to the paper](https://eprints.tarc.edu.my/20890/1/AACS2204.pdf)

- [Question 1](#question-1)
- [Question 2](#question-2)
- [Question 3](#question-3)
- [Question 4](#question-4)

## Answers

### Question 1

a) i) A method's identity consists of the method's name and parameter list. The compiler uses it to recognise the method implementation to invoke during the method call at compile time.

ii) The variables that are declared in the method header which is used within the method body. The value within the parameter influences the output of the method.

iii) The variable that is passed when calling the methods. The parameter will be substituted with the values from the actual parameters before running the method body.

b) 

- `double [] radius`
  - Problem: This only creates the reference variable of a double array, but it points to no array object, which will cause NullPointerException when being accessed.
  - Solution: `double[] radius = new double[10];`
- `for (int i=0; i<radius.length();i++)`
  - Problem: length is a data field, not a method
  - Solution: `for (int i=0; i<radius.length;i++)`
- `radius[i] = Math.random;`
  - Problem: random is a static method from Math class, but it doesn't call the method because it missed the parenthesis
  - Solution: `radius[i] = Math.random();`
- `System.out.printf("Area of circle %d is: %.2f\n", i, area(i));`
  - Problem: The area is not a method but an array, the indexing method is wrong
  - Solution: `System.out.printf("Area of circle %d is: %.2f\n", i, area[i]);`
 
c)

i) `System.out.println(s1.toUpperCase());`

ii) `System.out.println(s1.replace("java", "HTML));`

iii) `System.out.println(s1.substring(8));`

iv) `System.out.println(s1.concat(" & easy!"));`

### Question 2

a) 

```java
public class Student {
  protected String studentID, studentName, programme, contact, homeAddress;
  protected int year;

  public Student(String studentID, String studentName, String programme, int year, String contact, String homeAddress) {
    this.studentID = studentID;
    this.studentName = studentName;
    this.programme = programme;
    this.year = year;
    this.contact = contact;
    this.homeAddress = homeAddress;
  }

  public String toString() {
    return String.format("Student ID: %s\nStudent Name: %s\nProgramme: %s\nYear: %d\ncontact: %s\nHome Address: %s\n", this.studentID, this.studentName, this.programme, this.year, this.contact, this.homeAddress);
  }
}
```

b)

```java
public class FullTimeStudent extends Student {
  private String parentContact;

  public FullTimeStudent(String studentID, String studentName, String programme, int year, String contact, String homeAddress, String parentContact) {
    super(studentID, studentName, programme, year, contact, homeAddress);
    this.parentContact = parentContact;
  }

  public String getParentContact() {
    return this.parentContact;
  }

  public void setParentContact(String parentContact) {
    this.parentContact = parentContact;
  }

  public String toString() {
    return String.format("====== Full-Time Student ======\n\n%sParent Contact: %s\n", super.toString(), this.parentContact);
  }
}
```

c)

```java
public class MainClass {
  public static void main(String[] args) {
    Object[] students = new Object[]{
      new FullTimeStudent("D1234", "Lee Chong Wei", "DFT", 2, "016-1234567", "Lorong 3, No. 1 Jalan Ceria", "016-3453456"),
      new PartTimeStudent("D2345", "Rashid Sidek", "DSF", 1, "016-8787876", "No. 2 Jalan Bersatu", "Level 5, Bangunan Duta", "03-1234567")
    };

    for (Object student : students) {
      System.out.println(student);
    }
  }
}
```

### Question 3

a) i)

```java
public interface Circle {
  public static final double PI = 3.142;
  public double calculatePerimeter();
  public double calculateArea();
}
```

ii)

```java
public class Coin implements Circle {
  private double radius;

  public Coin(double radius) {
    this.radius = radius;
  }

  public double calculatePerimeter() {
    return 2 * PI * radius;
  }

  public double calculateArea() {
    return PI * radius * radius;
  }
}
```

b)

```
public class PublicTransport {
  protected String transportationType;
}

public class ExpressBus extends PublicTransport {
  private double ticketPrice;
  private int seatNo;
}

public class Passenger {
  private String icNo;
  private String name;
  private Address address;
  private ExpressBus[] reservation;
}

public class Address {
  private String addressLine1, addressLine2;
}
```

c)

// lazy to draw
