package p1;

import java.util.Arrays;
import java.util.Random;
import javax.swing.JOptionPane;

public class HeapSortTemplate {

    public static void main(String[] args) {
        int[] data = {7, 19, 36, 17, 3, 25, 1, 2, 4}; 

//        int size = Integer.parseInt(JOptionPane.showInputDialog("How Many Items to"
//                + " sort," + " n = ?"));
//        int[] data = new int[size];

//        randomValues(data);
        System.out.println("Unsorted");
        System.out.println(Arrays.toString(data));
        System.out.println();

       // heapSort(data);
        reHeapDown(data.length, data, 0);

        //reheapDownward(data.length, data, 0);
        System.out.println("Sorted");
        System.out.println(Arrays.toString(data));
    }

    public static void heapSort(int[] data) {
        // Step 1: 
            // do nothing; remember rules
        // Step 2:
           // build initial heap using rhd
           
        // Step 3: 
    }

    public static void reHeapDown(int size, int[] data, int rootIndex) { // Gets root to be highest value in "tree". Recursive.
        if (size <= 0) { // 0 children or no nodes
            return;
        }

        if (rootIndex * 2 - 1 >= size) { // root has no children
            return;
        }

        if (rootIndex * 2 + 1 == size - 1) { // one child
            if (data[rootIndex] > data[rootIndex * 2 + 1]) { // root larger than its 1 child
                return;
            } else {
                swap(data, rootIndex, rootIndex * 2 + 1);
                return;
            }
        }

        // root has two children
        if (data[rootIndex] > data[rootIndex * 2 + 1] && data[rootIndex] > data[rootIndex * 2 + 2]) { // root is bigger than both
            return;
        } else { // root isn't bigger than both
            if (data[rootIndex * 2 + 1] > data[rootIndex * 2 + 2]) { // left child is larger than right
                swap(data, rootIndex, rootIndex * 2 + 1);
                reHeapDown(size, data, rootIndex * 2 + 1);
            } else { // right child is larger than left
                swap(data, rootIndex, rootIndex * 2 + 2);
                reHeapDown(size, data, rootIndex * 2 + 2);
            }
        }

    }

    public static void randomValues(int[] data) // random numbers from 0 to 999, no duplicates
    {
        Random rn = new Random();
        int r = -1;
        boolean duplicate;
        data[0] = rn.nextInt(data.length);

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
