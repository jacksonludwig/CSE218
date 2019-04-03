package p1;

public class Demo {

    private static long count = 0;

    public static void main(String[] args) {
//        System.out.println(factorial(11));
//        System.out.println(exponent(2, 16));
//        System.out.println(fibonacci(3));
//        System.out.println(sumOfFirstNInts(3));
        hanoi(3, 1, 2, 3);
    }

    public static long factorial(int n) {
        count++;
        System.out.println("Recursion invoked " + count + " times.");
        // if it's the base case, return known result
        if (n == 0) {
            return 1;
        }
        // calculate the reduced problem recursively (rp)
        long rp = factorial(n - 1);
        // use rp to calculate the solution
        long gs = n * rp;
        return gs;
    }

    public static int exponent(double x, int n) {
        count++;
        System.out.println("Recursion invoked " + count + " times.");
        // if it's the base case, return known result
        if (n == 0) {
            return 1;
        }
        // calculate the reduced problem recursively (rp)
        double rp = exponent(x, n - 1);
        // use rp to calculate the solution
        double gs = x * rp;
        return (int) gs;
    }

    public static int fibonacci(int n) {
        count++;
        System.out.println("Recursion invoked " + count + " times.");
        // if it's the base case, return known result
        if (n == 1 || n == 2) {
            return 1;
        }
        // calculate the reduced problem(s) recursively (rp)
        int rp1 = fibonacci(n - 1);
        int rp2 = fibonacci(n - 2);
        // use rp to calculate the solution
        int gs = rp1 + rp2;
        return gs;
    }

    public static int sumOfFirstNInts(int n) {
        count++;
        System.out.println("Recursion invoked " + count + " times.");
        // if it's the base case, return known result
        if (n == 1) {
            return 1;
        }
        // calculate the reduced problem(s) recursively (rp)
        int rp = (sumOfFirstNInts(n - 1));
        // use rp to calculate the solution
        int gs = n + rp;
        return gs;
    }

    public static void hanoi(int numRings, int from, int to, int extra) {
//        count++;
//        System.out.println("Recursion invoked " + count + " times.");
        // if it's the base case, return known result
        if (numRings == 1) {
            System.out.println("move one ring from tower " + from + " to tower " + to);
            return;
        }
        // calculate the reduced problem(s) recursively (rp)
        hanoi(numRings - 1, from, extra, to); // rp1
        System.out.println("move one ring from tower " + from + " to tower " + to);
        hanoi(numRings - 1, extra, to, from); // rp2
    }

    // fibo dynamic 
    public static int fiboDynamic(int n) {
        count++;
        System.out.println("Recursion invoked " + count + " times.");
        // if it's the base case, return known result
        if (n == 1 || n == 2) {
            return 1;
        }
        // calculate the reduced problem(s) recursively (rp)
        int rp1 = fibonacci(n - 1);
        int rp2 = fibonacci(n - 2);
        // dynamic part
        if (values[n - 1] != 0) {
            rp1 = values[n - 1];
        } else {
            rp1 = fib(n - 1);
            values[n - 1] = rp1;
        } // end dynamic
        // use rp to calculate the solution
        int gs = rp1 + rp2;
        return gs;
    }
}
