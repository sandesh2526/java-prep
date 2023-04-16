# Java Prep
## Features of Java
### Portable
Java is highly portable language as it follows the 'write once run anywhere' model.
### Robust
The memory in java is allocated at runtime and it is handled by the Java Garbage Collector, which takes care of memory management.
### Object Oriented 
Everything in java is a object except from the primitive data types which are high performance nonobjects.
### Multithreded
Java supports multithreading which allows you to use resources efficiently.

## How Java Works
Java code is first compiled into java bytecode and stored in a classfile(once compiled a .java is compiled it creates .class file).
This Bytecode is then fed to JVM where it is optimised using JIT and interpreted into source code and then executed.

## Three OOP principles

### Encapsulation: 
This is mechanism by which binds together code and data. Also it keeps safe the data and the code from other interfernce. It is acheived in java by class.

### Inheritance: 
Inheritance is process by which one object can inherit properties of other object. One class can inherit the other using the extends keyword. You know right?:>

### Polymorphism: 
It means one thing having many forms. So you can define a method and have different methods as per the need(Method 'Overloading')or we can have a method which can be implementes as per the demand(Method 'Overriding');

## [ Method 'Overloading' in Java ](./Files_with_Code/Method-Overloading.md)

Methods can have same name but they can implement different functionalities. The overloaded methods must have different number of parameters.

NOTE: Having different return type is not sufficient to distinguish overloaded methods.

## Memory allocation for objects in Java
All objects are allocated memory at runtime using the 'new' keyword. The object will continue to exists as long as there is a refernce to the object. Once all the 

## Access Modifiers
Public: The member variables can be accessed from anywhere within a program. 
Private: Member variable can be accessed within the class only 
Protected: The variables can be accessed by the inherited classes only and for inherited classes they will be 'private'.
Default: If you don't define the access modifier the variables will be accessible within the package.

## Inner classes
We can nest the class inside other class, called the inner classes. We also define the classes inside other blocks of code like 'for' loop. This classes are divided into two types: Static Inner Classes and Non-Static classes.
Static Classes: This are inner classes defined as 'static' which can access the member variables of enclosing class by creating a object of the enclosing class(You know right :>)                        
Non-Static Classes: The non-static classes can access the member variables of the class.;

## Strings and their immutability
Strings are not primitive data type in java as they are defined as Class in java. When you define a String, you actually create the object of it. For e.g. The String is the defined inside a sysout(This is also String) is also a object of String class. So each time you create assign a value to String type variable in java, the string is first searched in the java and if it is present then its reference will be assigned to the current string. If String is not present with given value then a new String object is created and that objects reference is assigned to the String variable.

## Why Strings are immutable in java?
1. It saves us space as if the string with similar name does exist then we can use that string objects reference and assign it to new variable.
2. The string will be thread safe as we can not modify the String instead we have to assign a new reference to that variable.

## 'this' & 'super'

### 'this' 
Sometimes method need to refer to object that invoked the method for this purpose we use 'this' keyword.

### 'super'
Whenever subclass needs to refer its immediate superclass it can do that by using the 'super' keyword.
To access super class constructor, we can use: 
super(arg-list);
We can also use the 'super' to access the instance methods or variables of the superclass. 
.: super.methodName();super.variableName();

## VarArgs (Variable Length Arguments)
In java we can pass variable number of arguments to a method, we can do so by using array of the type we want to pass, as shown below:
```
someMethod(int array[]);
```
but if we have variable number of arguments, as follows: 
```
someMethod(1,2,2,5,2); 
someMethod(1,2);
```
Then in this case we must first package this values as a array and then pass to the someMethod().
For this java defines the 'varargs', so that we can pass variable arguments to a method. we can do so by: 
```
someMethod(int ...a);
```
now the a will act as array and we can use it as normal array, but we get the additional functionality to pass arguments as: 
```
someMethod(1,2,3,4,5,6);
someMethod(1,2,2);
someMethod(); // It works without parameter as well 
```

## Method Overriding
In a class hierarchy when a method in a subclass have same name & type signature as a method in superclass then we say that method is overriden in subclass. 
So by overriding a method we can hide its version in superclass.
Note: A superclass variable can refer to a subclass object.

## Dynamic Method Dispatch
Dynamic Method Dispatch is a mechanism by which a call to the overriden method is resolved at runtime.
So java at runtime defines, which overriden method should be called. 
This is done by using a superclass refence which is assigned the value of the subclass reference, so JRE checks which type of method is referred to, and calls the method of referring object.  

## Abstract Classes
A abstract class is defined by keyword 'abstract' and which contains atleast one abstract method, where abstract method is a method that is implemented by the subclass.
Every abstract method must be implemented by the subclass. 
So abstract classes define a generalized form that will be shared by all its subclasses, leaving the responsibility to fill the details to the subclass.

## 'final' keyword
A final keyword have three uses: 

### Declare constant equivalent
To declare a constant equivalent in java, we use the 'final' keyword. 
We can initiate the variables in two ways: 
1. We can initiate the variable at the time of declaration as :
```
final double PI = 3.1426;
```
2. We can declare variable as class member and then we can define its value inside the constructor. See below:
```
class A {
    final double PI;
    A() {
        PI = 3.1426;
    }
}
```

### Prevent method overriding
To prevent a method to be overriden in subclasses by declaring that method as 'final'. 
#### Early and Late Binding 
##### Early Binding
When a method is declared as 'final'
##### Late Binding
When a method is overriden by its subclass, we resolve the method at the runtime using the 'Dynamic Method Dispatch' it is called as Late Binding 

```
class A {
    final void method(){
        // do something
    }
}
class B extends A {
    void method() {
        // gives error as superclass has declred this 
        // method as 'final'
    }
}
```

### To prevent class from getting inherited
To prevent a class from getting inheritted, we can declare that class as 'final'.
```
final class A {
    // define Structure
} 
class B extends A {
    // Gives error as the A is declared 'final'
}
```
## How JRE looks for the packages?
1. If we declare it in subdirectory JRE will resolve it automatically.
2. We can define paths to the packages using environmental variable called 'classpath'.
3. You can specify the path to the packages using '-classpath' while compiling using 'javac' in commandline.

## Access Modifiers
 | ---                            | private  |  no modifier |   protected   |  public |
 | ---                            | ---      | ---          | ---           | ---     |    
 | Same Class                     |   Yes    |    Yes       |      Yes      |   Yes   |
 | Same Package subclass          |   No     |    Yes       |      Yes      |   Yes   |
 | Same Package Non-subclass      |   No     |    Yes       |      Yes      |   Yes   |
 | Different Package subclass     |   No     |    No        |      Yes      |   Yes   |
 | Different package Non-Subclass |   No     |    No        |      No       |   Yes   |
 
For first line, methods/variables with private, protected, public or without modifiers can be accessed within the same class. 
Second line, the private methods/variables are not not accessible for the sub-class within same package but other defined as protected/no modifier/public are accessible.

## Interfaces
We use interfaces to hide the implementation of methods from other classes.  For e.g. if you have a class Shape with method 'area' and a class Rectangle which also should have a method named 'area' as it is a 'Shape'. Now there is a method named print area, this method will print the area of a Shape and it does not care which 'Shape' it is printing the area for, so in this case we will use a object of the 'Shape' interface to print the area.
The interfaces can be abstract, public or they can have default access specifier.  


## variables in interface
Variables inside the interface are by default public, static and final. So we can access the variable declared inside the interface as long as we have access to the interface. Variables inside interface are final so we can not change them explicitely/externally. 

## Nested Interfaces
A interface declared as member of a class is called as nested interface. It can be public, private or protected. 
Refer following e.g.
```
class A {
    protected interface NestedInterface {
        boolean isNotNegative(int x);
    }
}
class B implements A.NestedInterface {
    public boolean isNotNegative(int x) {
        return (x < 0);
    }
}
public class MainClass {
    public static void main(String[] args) {
        A.NestedInterface object = new B();
        System.out.println(object.isNotNegative(-5)); 
    }   
}
```
## Methods with body inside interface
Interfaces can contain either a default or a static method body with implementation.  

### Default Methods
Default methods are methods which will be used if the implementation for that method is not provided by the implementing class.
If implementing class provides the implementation for the method then it is overriden.
#### Why to use default method
If you want to add some additional functionality to the class using the method then we can use default method.
 
```
interface C {
    default int a() { // If you don't want to implement the method, that is ok
        return 6;
    }
    default int b() {
        return 6;
    }
}
class D implements C {
    public int b() {
        return 5;
    }
}

public class MainClass  
{
    public static void main(String[] args) {
        C c = new D();
        System.out.println(c.a());  // returns 6 as no implementation for method a in D 
        System.out.println(c.b());  // return 5 as method b() is overriden by D
    }   
}
```

### static method
Just like static methods in a class, a static method defined by an interface can be called independently of any object. 
Note: static interface methods are not inherited by the implementing class or subinterface.

```
interface C {
    static int a() {
        return 6;
    }
}
class D implements C {
    public int b() {
        return 5;
    }
}

public class MainClass  
{
    public static void main(String[] args) {
        C c = new D();
        //System.out.println(c.a());    // Not Allowed
        System.out.println(C.a());
    }   
}
```

## intreface vs abstract classes
Once we declare a interface can only contain static and default methods the interfaces. 
The abstract class can contain the normal methods as well as abstract methods which will declare the method definition and not the body, the body is given by the class which extends the abstract class.
Abstract methods does not have the restrictions of access modifiers where as methods of interface are implicitly public. Here for abstract classes we can have a implemented method as protected but for the interface the implemented method must be public.
```
abstract class A {
    abstract void someMethod();
}
interface I {
    void someMethod1();
}

class MainClass extends A implements I {
    protected void someMethod() {
        System.out.println("Inside a protected abstract implemented");
    }
    // Following gives an error, as the methods implemented by the interface should be public
    protected void someMethod1() {
        System.out.println("Inside a protected abstract implemented");
    }
}
```

## Interface extending interface
A interface can extend other interface. The interface which extends other interface must provide all implementations of extended interface.
```
interface A {
    void meth1();
}
interface B extends A {
    void meth2();
}
class MainClass implements B {
    void meth1() {
        sysout("Something");
    }
}
```


## Comparable versus Comparator
The interfaces Comparable and Comparator both provide a way to sort the collections. Collections have a 'sort()' method which helps in sorting a collections. 
For e.g. we can sort a arraylist named studentList using the 'Collections.sort(studentList)' so general syntax for sorting a colleaction can be written as: 
```
Collections.sort(Collection_name);
```
We can also pass in a another class object to sort along with Collection_name which can tell the sort method how to sort the collection. This object is the object which implements 'Comparator' interface. 

### Comparable
The comparable interface defines single method named 'compareTo()'. This method is used to sort the collection, it is defined inside the domain class for which we want to sort elements. For e.g. if we have a Student class for which we have a array list of students which we want to sort according to the roll number. We can implement the Comparable interface in the Student class and then override the 'compareTo()' method. Then we can sort collection using the Collections.sort(). See below example: 
```
public class Student implements Comparable<Student> {
    String name;
    int id;
    int age;
    Student(int i,String name,int a) {
        id = i;
        this.name = name;
        age = a;
    }
    @Override
    public int compareTo(Student o) {
        return this.id - o.id;
    }
}
class MainClass {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(8); 
        students.add(new Student(15,"Harry",15));
        students.add(new Student(5,"Voldemort",17));
        students.add(new Student(10,"Dobby",14));
        Collections.sort(students);
    }
}

``` 







3
