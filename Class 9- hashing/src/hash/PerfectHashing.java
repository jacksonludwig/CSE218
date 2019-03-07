package hash;

import javax.swing.*;

public class PerfectHashing {

    public static void main(String[] args) { // Item number is the key field
        Listing l = new Listing("-92", "T Shirt"); // Item number and Name
        System.out.println(l);

        // declare the data structure object, ds
        String low = JOptionPane.showInputDialog("");
        String high = JOptionPane.showInputDialog("");
        PerfectHashedStructure ds = new PerfectHashedStructure();

    }
}
