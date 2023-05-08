# Java Prep

## Features of Java

### Portable

Java is highly portable language as it follows the 'write once run anywhere' model.

### Robust

The memory in java is allocated at runtime and it is handled by the Java Garbage Collector, which takes care of memory management.

### Object Oriented

Everything in java is a object except from the primitive data types which are high performance non-objects.

### Multithreded

Java supports multithreading which allows you to use cpu resoures efficiently.

## How Java Works

Java code is first compiled into java bytecode and stored in a classfile(once a '.java' file is compiled, java compiler creates a '.class' file).

This Bytecode is then fed to JVM where it is optimised using JIT and interpreted into source code and then executed.

## Three OOP principles

### Encapsulation

This is mechanism which binds together code and data. Also it keeps safe the data and the code from other interfernce. It is acheived in java by class. A class in java contains variables and methods. The variables in java represents the state of the class and methods  represents the behaviour.
Simply put if you have a class named 'Pet' and it contains a variable named 'emotion' and a method named 'setEmotionToHappy'. If you want to know the state of a 'Pet' you will check the 'emotion' variable and if you want to make change his emotion we can call the method 'setEmotionToHappy' which changes the emotion to happy.

### Inheritance

Inheritance is process by which one object can inherit properties of other object. One class can inherit the other using the extends keyword.
If we have a class named 'SimpleHouse' and another class named 'Mansion', we want the mansion to have all the methods that a simple house will have and we will add additional utilities to it then we can just do so by inheriting those methods from the 'SimpleHouse'. In java we can simply write "Mansion extends Simple house"

### Polymorphism

It means one thing having many forms. So you can define a method and have different methods as per the need (Method 'Overloading')or we can have a method which can be implemented as per the demand (Method 'Overriding').
If we have a class Calculator in which we have a method named add() which can add any two numbers and return the addition. Now if you want to add integers and also you should be able to add the double values, in such scenario you can define add method with different parameters i.e. it can add two different integers or doubles. So we can have add method as 'int add(int a, int b){}' and 'double add(double a, double b){}'. So we have multiple methods with same name but it can accept different type of numbers and add them. This is known as method overloading.
Now think if you have a 'sound' method inside a 'Pet' class, as such we can have different Pet's like Cat or Dog and each one will make different sound. Dog will go like "grr" cat will go like "meow" (or the Japanese cat can sound like "nyan" X). In such cases we can write Dog class which inherits all the properties of Pet, but it should have different sound than any other Pet in such case we can write the method 'sound' in Dog class which will have same signature as Pet but will return a different sound. So this is called as method overloading

## [Method 'Overloading' in Java](./Files_with_Code/Method-Overloading.md)

Methods can have same name but they can implement different functionalities. The overloaded methods must have different number of parameters.

NOTE: Having different return type is not sufficient to distinguish overloaded methods.

## Memory allocation for objects in Java

All objects are allocated memory at runtime using the 'new' keyword. The object will continue to exists as long as there is a refernce to the object. Once all the references to the object are removed, the memory occupied by the object is freed in next garbage collection cycle.
Java heap is a part of memory inside which  memory for newly created objects is allocated

## Access Modifiers Types

Public: The member variables can be accessed from anywhere within a program.
Private: Member variable can be accessed within the class only
Protected: The variables can be accessed by the inherited classes only and for inherited classes they will be 'private'.
Default: If you don't define the access modifier, the variables will be accessible within the package.

## Inner classes

We can nest the class inside other class, called the inner classes. We also define the classes inside other blocks of code like 'for' loop. This classes are divided into two types: Static Inner Classes and Non-Static classes.
Static Classes: This are inner classes defined as 'static' which can access the member variables of enclosing class by creating a object of the enclosing class(You know right :>)
Non-Static Classes: The non-static classes can access the member variables of the class.

## Strings and their immutability

Strings are not primitive data type in java as they are defined as class in java. When you define a String, you actually create the object of it. For e.g. The String is the defined inside a sysout("This is also String") is also a object of String class. So each time you create assign a value to String type variable in java, the string is first searched in the java string pool and if it is present then its reference will be assigned to the current string. If String is not present with given value then a new String object is created in string pool and that objects reference is assigned to the String variable.
We have classes like StringBuffer and StringBuilder which supports mutable strings.

Note: The string pool is space within the Java heap which is used to store the strings.

## Why Strings are immutable in java?

1. It saves us space, if string with similar name does exist then we can use that string objects reference and assign it to new variable.
2. The string is thread safe as we can not modify the string object(as immutable), instead we have to assign a new reference to that variable.

## 'this' & 'super'

### 'this'

Sometimes method need to refer to object that invoked the method for this purpose we use 'this' keyword.

### 'super'

Whenever subclass needs to refer its immediate superclass it can do that by using the 'super' keyword.
To access super class constructor, we can use:
super(arg-list);
We can also use the 'super' to access the instance methods or variables of the superclass.

```
super.methodName();
super.variableName();
```

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

    ```java
    final double PI = 3.1426;
    ```

2. We can declare variable as class member and then we can define its value inside the constructor. See below:

```java
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

```java
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

```java
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

```java
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

```java
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

```java
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

```java
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

```java
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

```java
Collections.sort(Collection_name);
```

We can also pass in a another class object to sort along with Collection_name which can tell the sort method how to sort the collection. This object is the object which implements 'Comparator' interface.

### Comparable

The comparable interface defines single method named 'compareTo()'. This method is used to sort the collection, it is defined inside the domain class for which we want to sort elements. For e.g. if we have a Student class for which we have a array list of students which we want to sort according to the roll number. We can implement the Comparable interface in the Student class and then override the 'compareTo()' method. Then we can sort collection using the Collections.sort(). See below example:

```java
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

## Collections in Java

### Collection

declares the core methods that all collections will have,
    Methods:
        boolean add(E obj) - adds obj to invoking collection
        boolean addAll(Collection<? extends E>c) - adds all elements to invoking collection from the passed collection
        void clear() - removes all elements from invoking collection
        boolean contains(E obj) - if obj exists returns true else false
        boolean containsAll(Collection<?> c) - returns true if all elements of c is present in invoking collection
        boolean equals(Object obj) - returnd true if invoking collection is equal to the obj
        int hashCode() - return hashcode for invoking collection
        boolean isEmpty() - return true if invoking function is empty
        Iterator<E> iterator() - returns iterator for invoking collection
        boolean remove(Object obj) - removes obj from invoking collection and returns true if successful
        boolean removeAll(Collection<?>c) - removes all elements of 'c' from invoking collection
        int size() - returns the size of the invoking set
        Stream<E> stream() - returns stream for the given collection
        Object[] toArray() - returns array

### List

stores a sequence of elements, uses a zero-based index, null elements are not allowed in the list,
A list may contain duplicate element,
    Methods:
    void add(int index, E obj) - Inserts obj into invoking list at the index passed
    boolean addAll(int index, Collection<? extends E>c) - adds collection values at specified index. returns true if list is changed
    int indexOf(Object obj) - returns first occurence index of object
    int lastIndexOf(Object obj) - returns index of last occurence of the 'obj' in list, if not present -1 is returned
    static <E> List<E> of(parameters) - returns a list of lists which are passed as parameters to 'of'
    ListIteratort<E> listIterator() /(int index) - returns iterator for the list / starting from the index
    E remove(int index) - removes and returns removed element
    void replaceAll(UnaryOperator<E> op) - we can change all the elements of the list with given op object, which can be defined by a class implementing UnaryOperator<E> interface and overriding apply method (apply specifies the operation to be performed on list elements)
    void sort(Comparator<? super E> comp) - sorts the list as per the comparator specified
    List<E> subList(int start,int end) - returns sub list from start index to end

### Set

Set is collection of the unique set of elements
    Null values are not allowed inside the set
    static<E> Set<E> copyOf(Collection<? extends E> coll) - returns a unmodifiable set of 'coll'  

#### SortedSet - Declares the behaviour of a set in sorted ascending order

   E first() - returns first element in the list
    E last() - returns last element in the list
    SortedSet<E> headSet(E end) - returns the set with values less than end
    SortedSet<E> tailSet(E start) - returns the set with values greater than start
    SortedSet<E> subSet(E start, E end) - returns the set greater than start and less than end

#### NavigableSet

declares the behavior of a collection that supports the retrieval of elements based on the closest match to a given value or values
| Method | Description |
| ---    | ---         |
| E ceiling(E obj) | returns smallest element such that e >= obj else null |
| E floor(E obj) | returns biggest element such that e <= obj else null |
| E higher(E obj) | returns smallest element such that e > obj |
| E lower(E obj) | returns the largest element, such that e < obj |
| E pollFirst() | returns and removes the first element else returns null |
| E pollLast() | returns and removes the Last element else returns null |
| NavigableSet<E> headSet(E upperBound, boolean incl) | returns set of all elements less than upperBound and includes upperBound if 'incl' is true |
| NavigableSet<E> tailSet(E lowerBound, boolean incl) | returns set of all elements greater than lowerBound and includes lowerBound id 'incl' |
| NavigableSet<E> tailSet(E lowerBound, boolean lowIncl, E upperBound, boolean upperIncl) | |

### Queue

declares the behavior of a queue, which is often a first-in, first-out list. However, there are types of queue

| Method | Description |
| ---    | ---         |
| E element() | returns the head of the queue, gives NoSuchElementException if queue is empty |
| E peek() | returns the head of the queue if not present then returns null |
| boolean offer(E obj) | adds and returns true if successful |
| E poll() | removes and returns the head of queue else null |
| E remove() | removes and returns the head of queue else NoSuchElementException |

### Deque

Double-ended queues can function as standard,first-in, first-out queues or as last-in, first-out stacks.

| Method | Description|
| ---    | ---        |
|void addFirst(E obj)| adds obj to head of queue| |
|void addLast(E obj) | adds obj to tail of queue|
|E getFirst() | returns first element in deque.element is not removed|
|E getLast() | returns last element of deque|
|boolean offerFirst(E obj)| Inserts the obj at head of queue and returns true if successful|
|boolean offerLast(E obj)| Inserts the obj at tail of queue and returns true if successful|
| E peekFirst() | retrns the element at head of queue and is not removed, null if empty|
| E peekLast() | returns the element at tail of queue|
| E pollLast() | returns and removes element at tail, null if empty|
| void push(E obj)|add the obj to head|
| E pop() | Returns and removes the head|
| E removeFirst() | removes and returns the head of queue|
| E removeLast() | removes and returns last element|
| boolean removeFirstOccurrence(Object obj)| removes first occurence of obj in queue, true if successful|

### Map

A map is an object that stores key and value pairs. The map interface contains a inner interface called Entry<K,V> which defines each entry's structure inside the map.

## Collection classes

### ArrayList

ArrayList class extends AbstractList and implements the List interface
ArrayList is a dynamic array with the indexed elements, accessing the elements is fast
ArrayList has Three Constructors:

ArrayList() - creates empty list
ArrayList(Collection<? extends E> c) - ArrayList with constructor arg as collection
ArrayList(int capacity) - builds an arrayList with initial capacity

### LinkedList

Linked List class extends AbstractSequentialList and implements the
List, Deque, and Queue interfaces
This enables us to use the doubly linked list so the update and delete operations will be fast
have 2 constructors:
LinkedList() - creates empty list
LinkedList(Collection<? extends E> c) - LinkedList with constructor arg as collection

### HashSet

HashSet extends AbstractSet and implements the Set interface
It creates a collection that uses a hash table for storage.
The HashSet has for constructors:

1. HashSet(); - internally creates a HashMap which will have the key as a value in hashset and value as a dummy value named "PRESENT".
2. HashSet(Collection<? extends E> c) - creates a hashset from 'c'
3. HashSet(int capacity) - creates a hashset with given capacity(default is 16)
4. HashSet(int capacity, float fillRatio) - creates HashSet with given capacity and fillRation(load factor)

Methods Avaialable:
boolean - add/All(E), remove/All(E),conains/All(E), isEmpty(), retainAll(Collection)
void - clear()
int - size()

### LinkedHashSet

Linked HashSet extends HashSet and does not add any new members.
Linked HashSet allows to maintain the order in which the elements are entered
It has same methods as the hashset

### TreeSet

TreeSet extends AbstractSet and implements the NavigableSet interface. It
creates a collection that uses a tree for storage. Objects are stored in sorted, ascending order.

It defines following four constructors:

1. TreeSet() - Initializes a empty tree set
2. TreeSet(Collection c) - Initializes new Treeset with the given collection 'c'
3. TreeSet(Comparator comp) - creates a treeset which will be ordered as per the given comparator 'comp'
4. TreeSet(SortedSet ss) - Creates a treeset containing 'ss'

Methods - All methods by Navigable Set such as, headSet(), tailSet() etc.

### Priority Queue

PriorityQueue extends AbstractQueue and implements the Queue interface.
It creates a queue that is prioritized based on the queue’s comparator.

Constructors -

1. PriorityQueue() - empty queue
2. PriorityQueue(int capacity) - with capacity
3. PriorityQueue(Comparator<? extends E> comp) - with comparator
4. PriorityQueue(int capacity,Comparator<? extends E> c) - with capacity and comparator
5. PriorityQueue(Collection<? extends E> c) - From collection c
6. PriorityQueue(PriorityQueue<? extends E> p) - from priority queue p
7. PriorityQueue(SortedSet<? extends E> ss) - create queue from sorted set ss

## How Key value pairs are stored inside the hash map

The hash map contains a table which is first initialized with the 16 buckets, these buckets are then filled with the nodes(A map node contains hash, key, value and next variables).
These buckets are filled with the nodes. For each insertion of node we calculate a hash value using the key-value pair which is used to find the index at which the node is to be stored.
If hash collision occurs then we store this new node in linked list by assigning the reference of new node to the next variable. It can happen that even though the hash is different for two nodes they might be mapped to same index, in such cases as well we add the node to this linked list.
When the size of this linked list increases and is more than a predefined threshold(TREEIFY_THRESHOLD), this linked list is converted into a balanced tree.
For getting a value from hashmap, we use get method which calculates the hash value and which again used to calculate the index, once index is calculated the node at the index is checked. First the hash value is checked if it matches then the key is checked and if the key matches then we return the value for the node.

## final vs finally vs finalize

|final|finally|finalize|
|---  ||---   ||---    |
|'final' is access specifier|'finally' is used to define the code that must be executed after a exception occurs|'finzlize' is called by 'JVM' when object does not have any references and is going to be garbage collected.|
