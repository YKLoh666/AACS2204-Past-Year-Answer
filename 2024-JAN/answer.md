# AACS2204 JAN 2024 Answers

[Link to the paper](https://eprints.tarc.edu.my/27895/1/AACS2204.pdf)

- [Question 1](#question-1)
- [Question 2](#question-2)
- [Question 3](#question-3)
- [Question 4](#question-4)

## Answers

### Question 1

a) 

- Data 
  - State of an object, all objects from the same class have the same set of states, but the value can be unique to each object (instance), or associated with the class instead of the objects(static).
  - Example: A Student class has a `name` attribute, and each of the student objects has a different name. The class also has a state `studentCount` that is associated with the class, recording the number of instances created from the class.
- Method
  -  Define the operation that the object can carry out, which is the object's behaviour in each class, used to manipulate the object's internal state.
  -  Example: A Car class has the method of `move()`, which is implemented with the instructions to be carried out when the car is moving.
 
b)

- A practice of implementing a method which describes a more specific behaviour in the subclass to override the method already defined in the parent class, using the same method signature. This practice enables runtime polymorphism, which describes the ability of an object to invoke the subclass-specific behaviour, even though it is being referenced by the superclass type.

c) 

i) A practice of wrapping all data and methods which act on those data into a class. This secures the data from unintentional tampering, only allowing the class methods to manipulate them, making the system robust to unintentional behaviour and errors.

ii) A practice of creating new classes using the existing classes. This encourages reusability by defining states and behaviours that are shared among classes in their parent class. This practice also allows the system to define a clearer hierarchical relationship among classes, and enhance code understandability and maintainability.

iii) A practice of allowing the same expression to be used to carry out different task-specific operations. This encourages reusability and code extensibility, making the code robust to changes, at the same time enhance code readability.

iv) Method signature consists of the method name and the parameter list, allowing the system to locate the correct behaviour to be invoked. All the methods within the same class must have a unique method signature, while the same method signature in the subclass will override the behaviour of the one defined in the superclass.

v) Formal parameters are variables defined in the parameter list, which are substituted with the values of the arguments when the method is invoked, and are being used within the method.

### Question 2

a)

Access Modifier | `public` | `protected` | `default` | `private`
-|-|-|-|-
Same class | Visible | Visible | Visible | Visible |
Same package, subclass | Visible | Visible | Visible | Not Visible
Same package, non-subclass | Visible | Visible | Visible | Not Visible
Different package, subclass | Visible | Visible | Not Visible | Not Visible
Different package, non-subclass | Visible | Not Visible | Not Visible | Not Visible

b)

Method Matching | Method Binding
-|-
Used by method overloading | Used by method binding
Decide method implementation to use at compile time | Method implementation is binded at runtime
Class type of the reference variable decides the method implementation to use | Actual class of the referenced object decides the method implementation to use
Match with method header, which consists of the method name and parameter list (data type, order and number of parameters) | Match with method signature

c) 

- The entities involved in the problem case are identified. Those entities are the ones who contribute to the solution.
- The entity states are identified, and consecutively the behaviours that will manipulate the data are identified.
- The relationships among the objects are identified, so the class can work together to perform the tasks.

d) 

- Constants can substitute the magic numbers with readable names, enhancing the code readability.
- Constants can enforce the rule of read-only to the variables, preventing the variable from unintentional tampering.
- Constants encourage reusability, the changes made to the constant can take effect on all code instances that use it simultaneously, enhancing maintainability.

### Question 3

```java
public class Smartphone {
  private String id;
  private String brand;
  private String model;
  private int storageCapacity;
  private static int totalSmartphoneSold;

  public Smartphone() {
    this(null, null, null, 0);
  }

  public Smartphone(String id, String brand, String model, int storageCapacity) {
    this.id = id;
    this.brand = brand;
    this.model = model;
    this.storageCapacity = storageCapacity;
    Smartphone.totalSmartphoneSold++;
  }

  public String getId() {
    return this.id;
  }

  public String getBrand() {
    return this.brand;
  }

  public String getModel() {
    return this.model;
  }

  public int getStorageCapacity() {
    return this.storageCapacity;
  }

  public static int getTotalSmartphoneSold() {
    return Smartphone.totalSmartphoneSold;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public void setStorageCapacity(int storageCapacity) {
    this.storageCapacity = storageCapacity;
  }

  @Override
  public String toString() {
    return "ID: " + this.id +
         "\nBrand: " + this.brand +
         "\nModel: " + this.model +
         "\nStorage Capacity: " + this.storageCapacity +
         "\n";
  }
}
```

b)

```java
public class MainClass {
  public static void main(String[] args) {
    Smartphone smartphone1 = new Smartphone();
    smartphone1.setId("A1111");
    smartphone1.setBrand("Samsung");
    smartphone1.setModel("S23 Ultra");
    smartphone1.setStorageCapacity(256);

    Smartphone smartphone2 = new Smartphone("B1111", "Apple", "Iphone 15", 512);

    System.out.println(smartphone1);
    System.out.println(smartphone2);
    System.out.println("Total Smartphone Sold: " + Smartphone.getTotalSmartphoneSold());
  }
}
```

### Question 4

a) i)

```
public interface ContentManager {
  public String publishContent();
  public String saveDraft();
  public String deleteContent();
}
```


ii)

```java
public class BlogPostManager implements ContentManager {
  @Override
  public String publishContent() {
    return "Blog post published successfully";
  }

  @Override
  public String saveDraft() {
    return "Blog post saved as a draft";
  }

  @Override
  public String deleteContent() {
    return "Blog post deleted successfully";
  }
}
```

b)

```java
public class MainClass {
  public static void main(String[] args) {
    ContentManager blogpostManager = new BlogPostManager();

    System.out.println(blogpostManager.saveDraft());
    System.out.println(blogpostManager.publishContent());
    System.out.println(blogpostManager.deleteContent());
  }
}
```

c)

Abstract class | Interface
-|-
Class to generalise the methods with the same purpose and have the subclasses to override it with a more specific business logic implementation | A contract to enforce behaviours onto the implemented classes. 
Has variables | Has no variable
Can have constructor, but cannot be used to instantiate object itself, are to be invoked by the subclasses with `super()` | Cannot have constructor, thus cannot instantiate objects with it
Have concrete methods and abstract methods(no implementation), and abstract method needs to be override by its subclass, cannot be `private` | All methods have no implementation, as it is used to enforce the implementations to define the methods listed.
