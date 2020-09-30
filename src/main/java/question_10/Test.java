package question_10;

public class Test {
    class A{
        String str = "ab";

        A(){
            printLength();
        }

        void printLength(){
            System.out.println(str.length());
        }
    }

    class B extends A{
        String str = "abc";

        void printLength(){
            System.out.println("str = " + str);
            System.out.println(str.length());
        }

    }

    public static void main(String[] args) {
        Integer a = 1;
        Test test = new Test();
        System.out.println(a.hashCode());
        System.out.println(test.hashCode());
    }

}
