
import java.util.Arrays;
import java.util.Random;
import javax.swing.JOptionPane;

public class SortingTemplate {

    public static void main(String[] args) {
        int size = Integer.parseInt(JOptionPane.showInputDialog("How Many Items to"
                + " sort," + " n = ?"));
        int[] data = new int[size];

        randomValues(data);

        System.out.println("****** Unsorted *******");
        System.out.println(Arrays.toString(data));
        System.out.println("*********************");

        // System.out.println(partition(data, 0, data.length - 1));
        quickSort(data, 0, data.length - 1);

        System.out.println("****** Sorted ******");
        System.out.println(Arrays.toString(data));
        System.out.println();
    }

    public static void quickSort(int[] data, int left, int right) {
        if (left < right) {
            int q = randomizedPartition(data, left, right); // index of where we placed the number in its final resting spot. outlier fix as well.
            quickSort(data, left, q - 1); // sorts left side, q is something in its final place
            quickSort(data, q + 1, right); // sorts right side
        }
    }

    public static int partition(int[] data, int left, int right) {
        int x = data[right];
        int i = left - 1;

        for (int j = left; j <= right - 1; j++) {
            if (data[j] <= x) {
                i++;
                swap(data, i, j);
            }
        }

        swap(data, i + 1, right);
        return i + 1;
    }

    private static int randomizedPartition(int[] data, int left, int right) { // fix for outlier where array is already sorted
        Random random = new Random();
        int randomIndex = random.nextInt(right - left) + left;
        swap(data, randomIndex, right);
        int q = partition(data, left, right);
        return q;
    }

    public static void randomValues(int[] data) // random numbers from 0 to 999, no duplicates
    {
        System.out.println("in");
        Random rn = new Random();
        int r = -1;
        boolean duplicate;
        data[0] = rn.nextInt(data.length);
        System.out.println(data[0]);
        for (int index = 1; index < data.length; index++) {
            duplicate = true;
            while (duplicate == true) // r is a duplicate value
            {
                r = rn.nextInt(data.length);
                duplicate = false;
                for (int j = 0; j < index; j++) // check all the set elements for a duplicate
                {
                    if (data[j] == r) // a duplicate found
                    {
                        duplicate = true;
                        break;
                    }// end if	
                }// end for 
                if (duplicate == false) {
                    data[index] = r;
                }
            }
        }
    }

    public static void swap(int[] data, int i1, int i2) {
        int temp = data[i1];
        data[i1] = data[i2];
        data[i2] = temp;
    }
}
