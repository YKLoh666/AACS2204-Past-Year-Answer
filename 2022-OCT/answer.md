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

Cooking...
