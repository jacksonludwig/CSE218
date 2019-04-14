package p1;

import javax.swing.JOptionPane;

public class Demo {

    private static long count = 0;
    private static long[] savedValues = new long[99];

    public static void main(String[] args) {
        while (true) {
            int menuChoice = Integer.parseInt(JOptionPane.showInputDialog("Enter 1 to calculate a value from the "
                    + "Fibonacci sequence,\n"
                    + "or 0 to quit"));
            switch (menuChoice) {
                case 1:
                    int num = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of the Fibonacci sequence to calculate: "));
                    // dynamic calculation
                    JOptionPane.showMessageDialog(null, "Dynamic Calculation:\n"
                            + "Term number " + num + " is equivalent to: " + fibonacciDynamic(num)
                            + "\nNumber of recursive calls was: " + count);
                    reset();
                    // non-dynamic calculation
                    JOptionPane.showMessageDialog(null, "Non-Dynamic Calculation:\n"
                            + "Term number " + num + " is equivalent to: " + fibonacci(num)
                            + "\nNumber of recursive calls was: " + count);
                    reset();
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }

    public static long fibonacci(int n) {
        count++;
        if (n == 1 || n == 2) {
            return 1;
        }

        long rp1 = fibonacci(n - 1);
        long rp2 = fibonacci(n - 2);

        long gs = rp1 + rp2;
        return gs;
    }

    public static long fibonacciDynamic(int n) {
        count++;
        if (n == 1 || n == 2) {
            return 1;
        }

        long rp1;
        long rp2;

        if (savedValues[n - 1] != 0) {
            rp1 = savedValues[n - 1];
        } else {
            rp1 = fibonacciDynamic(n - 1);
            savedValues[n - 1] = rp1;
        }

        if (savedValues[n - 2] != 0) {
            rp2 = savedValues[n - 2];
        } else {
            rp2 = fibonacciDynamic(n - 2);
            savedValues[n - 2] = rp2;
        }

        long gs = rp1 + rp2;
        return gs;
    }

    private static void reset() {
        count = 0;
        for (int i = 0; i < savedValues.length; i++) {
            savedValues[i] = 0;
        }
    }

}
