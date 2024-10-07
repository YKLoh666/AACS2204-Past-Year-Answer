# AACS2204 OCT 2022 Answers

[Link to the paper](https://eprints.tarc.edu.my/23325/1/AACS2204.pdf)

- [Question 1](#question-1)
- [Question 2](#question-2)
- [Question 3](#question-3)
- [Question 4](#question-4)

## Answers

### Question 1

a) i) A practice of wrapping data and operations that act on the data into single units. This reduces the scope of data to within the class only, prevents the data from unintentional tampering and leads to unexpected behaviours.

ii) A practice of creating classes using the existing class. The data that are shared among multiple classes can be placed in their parent class, reduce code duplication and increase maintainability, and at the same time enhance readability by drawing clear hierarchical relationships among classes.

iii) A practice of allowing the same expression to perform different operations. This encourages code reusability while making the system more scalable.

b)

Access Modifier | Public | Protected | Package (Default) | Private
-|-|-|-|-
Same Class | Yes | Yes | Yes | Yes
Subclass in same package | Yes | Yes | Yes | No
Non-subclass in same package | Yes | Yes | Yes | No
Subclass in different package | Yes | Yes | No | No
Non-subclass in different package | Yes | No | No | No

c) Method is a unit that contains a series of instructions to carry out a task. Within a class, the method can represent the behaviour of a class, able to mutate the class's internal states. Method encourages reusability, by using methods, we can reduce code duplication when performing similar tasks.

d) i)

Inheritance | Aggregation
-|-
Shows "is-a" relationship between a parent and child classes | Shows "has-a" relationship among two classes, which indicates ownership
The class are tightly coupled | The class are less coupled

ii)

Interface | Abstract class
-|-
A contract that enforces behaviour onto the implemented classes | A class that abstracts the general data and behaviour, which allows the specific implementation to be separated into other class
Cannot have instance variable | Can have instance variable
Cannot have method implementation | Can have method implementation if the method is not marked with `abstract` keyword

e) i) The declaration is valid. It creates a 2D array called `array` with a dimension of `1` row and `6` columns

ii) The declaration is invalid. The variable name is a reserved keyword `new`.

iii) The declaration is valid. It creates a String array called `strings` that stores three elements, which are `"one"`, `"two"` and `"three"`.

### Question 2

a)

```java
public class Fruit {
  private String id;
  private String type;
  private String color;
  private double price;
  private static int totalTypeOfFruit;

  public Fruit() {
    this(null, null, null, 0.0);
  }

  public Fruit(String id, String type, String color, double price) {
    this.id = id;
    this.type = type;
    this.color = color;
    this.price = price;
    Fruit.totalTypeOfFruit++;
  }

  public String getId() {
    return this.id;
  }

  public String getType() {
    return this.type;
  }

  public String getColor() {
    return this.color;
  }

  public double getPrice() {
    return this.price;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public static int getTotalTypeOfFruit() {
    return Fruit.totalTypeOfFruit;
  }

  public String toString() {
    return String.format("ID: %s\nType: %s\nColor: %s\nPrice: RM%.2f\n", this.id, this.type, this.color, this.price);
  }
}
```

b)

```java
public class MainClass {
  public static void main(String[] args) {
    Fruit fruit1 = new Fruit();
    fruit1.setId("FR1005");
    fruit1.setType("Rambutan");
    fruit1.setColor("Red");
    fruit1.setPrice(15.0);

    Fruit fruit2 = new Fruit("FR1006", "Banana", "Yellow", 10.0);

    System.out.println(fruit1);
    System.out.println(fruit2);
    System.out.println("Total Type of Fruit: " + Fruit.getTotalTypeOfFruit());
  }
}
```

c)

- Class is a definition of an entity's traits, but an object is a concrete representation of an entity. Hence we can use a class as a blueprint to create an object that belongs to that class.
- The structure of a class is static and fixed at compile time, but an object is created dynamically in runtime, except being marked with a static modifier
- Instance method cannot be invoked from a class, but can be from an object. It is because the instance method shall make changes to the internal state, hence if there is no concrete object, there are no instance states.

d) Constructor is a special method that is possessed by all classes to create its instance and initialise the internal states.

### Question 3

a)

```java
public interface Tax {
  public static final double INCOMETAX = 0.02;
}
```

b)

```java
public abstract class Tutor implements Tax {
  protected String name;
  protected boolean permit;
  protected int teachingHours;
  protected static double teachingRate = 80.0;
  protected static final double ALLOWANCE = 30.0;

  protected Tutor(String name, boolean permit, int teachingHours) {
    this.name = name;
    this.permit = permit;
    this.teachingHours = teachingHours;
  }

  public abstract double calculateSalary();

  @Override
  public String toString() {
    return String.format("Name:%s\nTeaching Permit:%s\nTeaching Hours:%d\n", this.name, this.permit ? "Yes" : "No", this.teachingHours);
  }
}
```

c)

```java
public class PartTimeTutor {
  public PartTimeTutor(String name, boolean permit, int teachingHours) {
    super(name, permit, teachingHours);
  }

  @Override
  public double calculateSalary() {
    return (teachingHours * teachingRate + ALLOWANCE) * (1 - (permit ? INCOMETAX : 0));
  }

  @Override
  public String toString() {
    return String.format("PartTimeTutor\n---------------\n%sSalary: RM %.2f\n", super.toString(), calculateSalary());
  }
}
```

```java
public class FullTimeTutor {
  private double basicSalary;

  public FullTimeTutor(String name, boolean permit, int teachingHours, double basicSalary) {
    super(name, permit, teachingHours);
    this.basicSalary = basicSalary;
  }

  private double calculateOvertimePay() {
    if (teachingHours <= 50) return 0;
    return (50 - teachingHours) * teachingRate;
  }

  @Override
  public double calculateSalary() {
    return (basicSalary + calculateOvertimePay() + ALLOWANCE) * (1 - (permit ? INCOMETAX : 0));
  }

  @Override
  public String toString() {
    return String.format("FullTimeTutor\n---------------\n%sBasic Salary: RM%.2f\nSalary: RM%.2f\n", super.toString(), basicSalary, calculateSalary());
  }
}
```

d)

```
public class MainClass {
  public static void main(String[] args) {
    Object[] tutors = new Object[]{
      new PartTimeTutor("Mario Ani", false, 60),
      new FullTimeTutor("Normala Junin", false, 60, 5000.0),
      new PartTimeTutor("Michaelis Daniel", true, 50),
      new FullTimeTutor("Delisha Danish", true, 40, 3000.0)
    }

    for (Object tutor : tutors) {
      if (tutor instanceof PartTimeTutor)
        System.out.println((PartTimeTutor)tutor);
      else if (tutor instanceof FullTimeTutor)
        System.out.println((FullTimeTutor)tutor);
      else
        System.out.println(tutor);
    }
  }
}
```
