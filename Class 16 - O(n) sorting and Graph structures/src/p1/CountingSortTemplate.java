package p1;

import java.util.Arrays;

public class CountingSortTemplate {

    public static void main(String[] args) {
        int[] a = {-1, 2, 5, 3, 0, 2, 3, 0, 3}; // algorithm does not use element 0
        int max = 5; // called k
        System.out.println("A: " + Arrays.toString(a));

        System.out.println("B: " + Arrays.toString(countingSort(a, max)));
    }

    public static int[] countingSort(int[] a, int max) {
        int[] b = new int[a.length]; // sorted array
        int[] c = new int[max + 1];

        for (int j = 1; j <= a.length - 1; j++) {
            c[a[j]] = c[a[j]] + 1;
        }
        System.out.println("C: " + Arrays.toString(c));
        
        for (int i = 1; i <= max; i++) {
            c[i] = c[i] + c[i - 1];
        }
        System.out.println("C: " + Arrays.toString(c));
        
        for (int j = a.length - 1; j >= 1; j--) {
            b[c[a[j]]] = a[j];
            c[a[j]] = c[a[j]] - 1;
        }
        System.out.println("C: " + Arrays.toString(c));
        
        return b;
    }
}
