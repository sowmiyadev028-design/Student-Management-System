public class Person {

    String name;
    int age;

    // Constructor
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Display method
    void display() {
        System.out.println("Name : " + name);
        System.out.println("Age : " + age);
    }
}