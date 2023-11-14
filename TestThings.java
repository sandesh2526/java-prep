import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.print.attribute.IntegerSyntax;

/**
 * TestThings
 */
public class TestThings {

    static Integer myFun(Integer i) {
        return ++i;
    }

    static Student myStud(Student s) {
        s.rollNumber = 62;
        return s;
    }

    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(56);
        treeSet.add(4);
        List<Integer> l = treeSet.stream()
                .collect(Collectors.toList());
        System.out.println(l.get(0));
        Collection<Integer> a = Arrays.asList(1, 2, 3, 5, 6, 6, 8, 2, 5, 9, 9, 9);
        a.stream().forEach(System.out::println);
        Map<String, Integer> m = new TreeMap<>();
        m.put("One", 1);
        m.put("One", 1);
        m.put("One", 1);
        m.put("One", 1);
        m.put("One", 1);
        m.put("One", 1);
        System.out.println("**** Printing all the numbers 5 ****");
        a.stream()
                .filter((i) -> i > 5)
                .forEach(System.out::println);
        String s = "SOMESTRINGSAREMEANTOOTAKEOVERTTHEWORLD";
        s.chars()
                .sorted()
                .forEach(p -> {
                    System.out.println((char) p);
                });

        System.out.println(a.stream().max(Integer::compareTo).get());
        System.out.println(a.stream()
                .filter((i) -> i > 5)
                .count());

        System.out.println("The Value is: " + a.stream()
                .reduce((prevValue, nextValue) -> {
                    System.out.println(prevValue + " " + nextValue);
                    if (prevValue.equals(nextValue)) {
                        return prevValue + nextValue;
                    } else {
                        return nextValue;
                    }
                }));
        s.chars()
         .reduce((prev,next) -> {
            if(prev == next) {
                System.out.println("Ans: "+(char)prev);
                return prev;
            }
            else {
                return next;
            }
         });
        /*
         * ChildClass c = new ChildClass();
         * System.out.println(c.getData());
         * Student s = new Student(0, "null");
         * Integer i = new Integer(56);
         * System.out.println(myFun(i));
         * System.out.println(i);
         * System.out.println(myStud(s));
         * System.out.println(s);
         */ /*
             * System.out.println("Starting the timer: ");
             * int count = 0;
             * Long start = System.currentTimeMillis();
             * for (int i = 0; i < 100000000; i++) {
             * if (i % 2 == 0) {
             * count++;
             * }
             * }
             * Long endTime = System.currentTimeMillis();
             * System.out.println("For \"%\" it took : " + (endTime - start));
             * count = 0;
             * start = System.currentTimeMillis();
             * for (int i = 0; i < 100000000; i++) {
             * if ((i & 1) == 0) {
             * count++;
             * }
             * }
             * endTime = System.currentTimeMillis();
             * System.out.println("For \"&\" it took : " + (endTime - start));
             * Comparator<Student> sortByRollNumber = new Comparator<Student>() {
             * public int compare(Student o1, Student o2) {
             * return o1.rollNumber.compareTo(o2.rollNumber);
             * }
             * };
             * Comparator<Student> sortByName = new Comparator<Student>() {
             * public int compare(Student o1, Student o2) {
             * return o1.name.compareTo(o2.name);
             * }
             * };
             * 
             * Comparator<Student> sortByName1 = (Student s1, Student s2) ->
             * s1.name.compareTo(s2.name);
             * 
             * Student s1 = new Student(1, "Ritagi Senjougahara");
             * Student s2 = new Student(2, "Naruto Uzumaki");
             * Student s3 = new Student(3, "Sasuke Uchiha");
             * Student s4 = new Student(4, "Sakura Haruna");
             * Student s5 = new Student(5, "Hinata Hyuga");
             * Student s6 = new Student(6, "Kakashi Hatake");
             * Student s7 = new Student(7, "Shino Aburane");
             * HashMap<Integer, Student> students = new HashMap<>();
             * students.put(s1.rollNumber, s1);
             * students.put(s4.rollNumber, s4);
             * students.put(s2.rollNumber, s2);
             * students.put(s3.rollNumber, s3);
             * students.put(s5.rollNumber, s5);
             * students.put(s6.rollNumber, s6);
             * students.put(s7.rollNumber, s7);
             */
        /*
         * System.out.println(students.entrySet());
         * DecimalFormat d = new DecimalFormat("###.######");
         * System.out.println(d.format(Math.E * 500));
         * 
         * Runnable r = () -> {
         * synchronized (s1) {
         * System.out.println(
         * "Inside of thread: " + Thread.currentThread().getName() +
         * "Student in s1 is: " + s1.getName());
         * }
         * };
         * Thread t = new Thread(r);
         * Thread t1 = new Thread(r);
         * t.start();
         * t1.start();
         */
        /*
         * List<Student> c = new ArrayList<>();
         * c.addAll(students.values());
         * Collections.sort(c, sortByName1);
         * System.out.println(c);
         * Long l1 = 128L;
         * Long l2 = 128L;
         * if (l1.equals(l2)) {
         * System.out.println("THey Are Equal!");
         * } else {
         * System.out.println("They Are not Equal! ");
         * }
         * 
         */ }
}

class Student implements Comparable<Student> {
    Integer rollNumber;
    String name;

    public Student(int rollNumber, String name) {
        this.rollNumber = rollNumber;
        this.name = name;
    }

    public synchronized String getName() {
        try {
            System.out.println("Thread " + Thread.currentThread().getName() + " is going to sleep!");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.name;
    }

    public String toString() {
        return this.name + this.rollNumber;
    }

    @Override
    public int compareTo(Student o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }
}

class ParentClass {
    ParentClass() {
        System.out.println("Hey There");
    }
}

class ChildClass extends ParentClass {
    private int data = 8925;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

}