package menu.commands.tasks.calculator.max;

class Calculator {

    long sum(long x, long y) {
        return  x + y;
    }

    long dif(long x, long y) {
        return  x - y;
    }

    long div(long x, long y) {
        return  x / y;
    }

    long multi(long x, long y) {
        return  x * y;
    }

    long pow(long x, long y){
        long a = 1;
        for (long i = 1; i <= y; i++) a *= x;
        return a;
    }

    long sqrt(long z){
        long i = 0;
        while (i*i < z) i++;
        return i;
    }

    long triangle(long z) {
        long triangular = 0;
        for (long i = 1; i <= z; i++) {
            triangular += i;
        }
        return triangular;
    }

    long factorial(long z) {
        long fac = 1;
        for (long i = 1; i <= z; i++) {
            fac *= i;
        }
        return fac;
    }
}
