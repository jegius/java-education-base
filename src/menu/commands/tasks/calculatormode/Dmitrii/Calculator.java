package menu.commands.tasks.calculatormode.Dmitrii;

import java.util.Scanner;


public class Calculator {

    private DmitriiCalculatorCommand calculatorCommand;
    private static Scanner scanner;

    Scanner in = new Scanner(System.in);

    Calculator(DmitriiCalculatorCommand instance) {
        scanner = new Scanner(System.in);
        this.calculatorCommand = instance;
    }

    DmitriiCalculatorCommand sum() {

        try {
            System.out.println("Введите первое число:");
            int one = in.nextInt();
            System.out.println("Введите второе число:");
            int two = in.nextInt();
            int sum = getSum(one, two);
            System.out.println("Сумма чисел: " + sum);
        } catch (Exception exception) {
            System.out.println("Вводите только цифры");
            in.next();
            sum();
        }
        return calculatorCommand;
    }

    private int getSum(int one, int two) {
        return one + two;
    }

    DmitriiCalculatorCommand subtraction() {
        try {
            System.out.println("Введите перовое число");
            int one = in.nextInt();
            System.out.println("Введите второе число");
            int two = in.nextInt();
            int sub = getSub(one, two);
            System.out.println("Вычитание чисел: " + sub);
        } catch (Exception exception) {
            System.out.println("Вводите только цифры");
            in.next();
            subtraction();
        }
        return calculatorCommand;
    }

    private int getSub(int one, int two) {
        return one - two;
    }

    DmitriiCalculatorCommand division() {
        try {
            System.out.println("Введите перовое число");
            double one = in.nextDouble();
            System.out.println("Введите второе число");
            double two = in.nextDouble();
            if (two == 0) {
                System.out.println("Деление на Ноль нельзя!");
                division();
            }
            double sub = getDivision(one, two);
            System.out.println("Деление чисел: " + sub);
        } catch (Exception exception) {
            System.out.println("Вводите только цифры");
            in.next();
            division();
        }

        return calculatorCommand;
    }

    private double getDivision(double one, double two) {
        return one / two;
    }

    DmitriiCalculatorCommand multiplication() {
        try {
            System.out.println("Введите перовое число");
            double one = in.nextDouble();
            System.out.println("Введите второе число");
            double two = in.nextDouble();
            double multi = getMulti(one, two);
            System.out.println("Умножение чисел: " + multi);
        } catch (Exception exception) {
            System.out.println("Вводите только цифры");
            in.next();
            multiplication();
        }
        return calculatorCommand;
    }

    private double getMulti(double one, double two) {
        return one * two;
    }

    DmitriiCalculatorCommand sqrt() {
        try {
            System.out.println("Введите число");
            long one = in.nextLong();
            double sqrt = getSqrt(one);
            System.out.println("Квадратный корень: " + sqrt);
        } catch (Exception exception) {
            System.out.println("Вводите только цифры");
            in.next();
            sqrt();
        }
        return calculatorCommand;
    }

    private double getSqrt(long one) {
        return Math.sqrt(one);
    }

    DmitriiCalculatorCommand pow() {
        try {
            System.out.println("Введите перовое число");
            int one = in.nextInt();
            System.out.println("Введите степень");
            int two = in.nextInt();
            long pow = getPow(one, two);
            System.out.println("Степень числа: " + pow);
        } catch (Exception exception) {
            System.out.println("Вводите только цифры");
            in.next();
            pow();
        }
        return calculatorCommand;
    }

    private long getPow(int one, int pow) {
        return (long) Math.pow(one, pow);
    }

    DmitriiCalculatorCommand log() {
        try {
            System.out.println("Введите число");
            int one = in.nextInt();
            double log = getLog(one);
            System.out.println("Логарифм числа: " + log);
        } catch (Exception exception) {
            System.out.println("Вводите только цифры");
            in.next();
            log();
        }
        return calculatorCommand;
    }

    private double getLog(int one) {
        return Math.log(one);
    }

    DmitriiCalculatorCommand sin() {
        try {
            System.out.println("Введите число");
            int one = in.nextInt();
            double sin = getSin(one);
            System.out.println("Синус угла: " + sin);
        } catch (Exception exception) {
            System.out.println("Вводите только цифры");
            in.next();
            sin();
        }
        return calculatorCommand;
    }

    private double getSin(int one) {
        return Math.sin(one);
    }

    DmitriiCalculatorCommand cos() {
        try {
            System.out.println("Введите число");
            int one = in.nextInt();
            double cos = getCos(one);
            System.out.println("Косинус угла: " + cos);
        } catch (Exception exception) {
            System.out.println("Вводите только цифры");
            in.next();
            cos();
        }
        return calculatorCommand;
    }

    private double getCos(int one) {
        return Math.cos(one);
    }

    DmitriiCalculatorCommand tan() {
        try {
            System.out.println("Введите число");
            int one = in.nextInt();
            double tan = getTan(one);
            System.out.println("Тангенс угла: " + tan);
        } catch (Exception exception) {
            System.out.println("Вводите только цифры");
            in.next();
            tan();
        }
        return calculatorCommand;
    }

    private double getTan(int one) {
        return Math.tan(one);
    }
}

