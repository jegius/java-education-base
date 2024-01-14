package menu.commands.tasks.calculator.kristina;

public class Workplace {
    public static void main(String[] args) {
        Calculator result = new Calculator();
        System.out.println(result.sum(2, 2));
        System.out.println(result.difference(5, 2));
        System.out.println(result.division(2, 2));
        System.out.println(result.multiplication(2, 2));
        System.out.println(result.pow(3, 3));
        System.out.println(result.sqrt(256));
        System.out.println(result.triangle(5));
        System.out.println(result.factorial(5));
    }
}
