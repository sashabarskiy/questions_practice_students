package extention;

public class Program {

    // snippet 3
    /*
    public static void main(String[] args) {

        Person tom = new Person("Tom");
        tom.display();
        Employee sam = new Employee("Sam");
        sam.display();
    }
    */

    // snippet 4
    public static void main(String[] args) {

        Employee sam = new Employee("Sam", "Microsoft");
        sam.display();  // Sam
        sam.work();     // Sam works in Microsoft

        B subClass = new B(1, 2);
        subClass.show();

    }


}

class Person {

    private String name;
    public String getName(){ return name; }

    public Person(String name){

        this.name=name;
    }

    public void display(){

        System.out.println("Name: " + name);
    }
}

class Employee extends Person{

    // add to snippet 3
    public Employee(String name){
        super(name);
    }

    // snippet 4
    private String company;

    public Employee(String name, String company) {

        super(name);
        this.company=company;
    }
    public void work(){
        System.out.printf("%s works in %s \n", getName(), company);
    }

    // snippet 5
    @Override
    public void display(){

        // snippet 5
        //System.out.printf("Name: %s \n", getName());

        // snippet 6
        super.display();

        System.out.printf("Works in %s \n", company);
    }

}

class A {
    int i;
}

// наследуемся от класса A
class B extends A {
    int i; // имя переменной совпадает и скрывает переменную i в классе A

    B(int a, int b) {
        super.i = a; // обращаемся к переменной i из класса A
        i = b; // обращаемся к переменной i из класса B
    }

    void show() {
        System.out.println("i из суперкласса: " + super.i);
        System.out.println("i в подклассе: " + i);
    }
}
