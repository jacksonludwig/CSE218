package genericsPractice;

import java.awt.Color;
import java.util.Arrays;

public class Demo {

    public static void main(String[] args) {
        String s1 = "Test";
        Color c1 = Color.BLUE;
        output(s1, c1, 8);
        output(s1, s1, 7);
        output(c1, c1, 6);
        output("Jack", 1.296, 5);

        String output = outputGeneric(s1, c1, 3);
        System.out.println(output);
        System.out.println();

        String[] strings = {"Jack", "Sam", "Chris"};
        Double[] doubles = {1.5, 2.5, 3.2, 4.5, 12.54};

        Double[] returnDouble = outputGenericArray(strings, doubles);
        for (Double i : doubles) {
            System.out.print(i + " ");
        }
    }

    public static <T1, T2> void output(T1 param1, T2 param2, int c) {
        System.out.println(param1);
        System.out.println(param2);
        System.out.println(c);
    }

    public static <T1, T2> T1 outputGeneric(T1 param1, T2 param2, int c) {
        return param1;
    }

    public static <T1, T2> T2[] outputGenericArray(T1[] param1, T2[] param2) {
        T1[] x;
        x = param1; // can assign variables, arrays, etc of generics just the same as normal. But can't do this (declare new):
        //  T1[] x2 = new T1[param1.length]; // given error is "generic array creation." Use array's COPYOF method instead.
        T1[] y;
        y = Arrays.copyOf(param1, param1.length); // check this later
        y[0] = null;
        System.out.println(y[0]);

        for (T1 param : param1) {
            System.out.println(param);
        }
        return param2;
    }
}
