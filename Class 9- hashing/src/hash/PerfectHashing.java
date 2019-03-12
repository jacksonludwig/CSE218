package hash;

import javax.swing.*;

public class PerfectHashing {

    public static void main(String[] args) { // Item number is the key field
        Listing l = new Listing("106", "T Shirt"); // Item number and Name
        System.out.println(l);

        // declare the data structure object, ds
        String low = JOptionPane.showInputDialog("Min Key: ");
        String high = JOptionPane.showInputDialog("Max Key: ");
        PerfectHashedStructure ds = new PerfectHashedStructure(low, high);
        
        ds.insert(l);
        System.out.println(ds.fetch("106"));
    }
}
