package src.chapter5DesigningWithLambdaExpressions;

public class DesigningWithLambdaExpressionsInstanceBuilder {

    public static void main(String[] args) {
        DesigningWithLambdaExpressionsInstanceBuilder demo = new DesigningWithLambdaExpressionsInstanceBuilder();
        demo.sayHello();
        demo.sayGoodbye();
        demo.sayHello2()
                .sayGoodbye2();
    }

    public void sayHello() {
        System.out.println("Hello");
    }

    public void sayGoodbye() {
        System.out.println("Goodbye");
    }

    public DesigningWithLambdaExpressionsInstanceBuilder sayHello2() {
        System.out.println("Hello 2");
        return this;
    }

    public DesigningWithLambdaExpressionsInstanceBuilder sayGoodbye2() {
        System.out.println("Goodbye 2");
        return this;
    }
}