## Method 'Overloading' in Java
Methods can have same name but they can implement different functionalities. The overloaded methods must have different number of parameters.
NOTE: Having different return type is not sufficient to distinguish overloaded methods.

```
class A {
    static int returnSomeNumber() {
        return 2;
    }
    static int returnSomeNumber(int returnThisNumber) {
        return returnThisNumber;
    }
    // Following gives error, as it does not contain different number of parameters.
    // double returnSomeNumber() {
    //     return 5.0;
    // }
}

class MainClass {
    public static void main(String[] args) {
        int a = A.returnSomeNumber();
        System.out.println("First Time: "+a); // writes First Time: 2
        a = A.returnSomeNumber(25);            
        System.out.println("Second Time: "+a); // writes Second Time: 25
    }
}
```