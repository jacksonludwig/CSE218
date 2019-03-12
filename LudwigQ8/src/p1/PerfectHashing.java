package p1;

import javax.swing.*;

public class PerfectHashing {

    public static void main(String[] args) { // Item number is the key field
        Listing l = new Listing("106", "T Shirt"); // Item number and Name
//        System.out.println(l);

        // declare the data structure object, ds
        Listing a = new Listing("50", "Bob"); // Item number and Name
        Listing b = new Listing("400", "John"); // Item number and Name
        String low = JOptionPane.showInputDialog("Min Key: ");
        String high = JOptionPane.showInputDialog("Max Key: ");
        PerfectHashedStructure ds = new PerfectHashedStructure(low, high);

        ds.insert(l);
        ds.insert(a);
        ds.insert(b);
        System.out.println(ds.fetch("106"));
        System.out.println(ds.fetch("50"));
        System.out.println(ds.fetch("400"));
        
        Listing c = new Listing("430", "Replaced");
        ds.update("106", c);
        
        System.out.println(ds.fetch("106"));
        ds.showAll();
         System.out.println(ds.fetch("106")); System.out.println(ds.fetch("106")); System.out.println(ds.fetch("106")); System.out.println(ds.fetch("106"));
         
        System.out.println(ds.delete("32"));
        System.out.println(ds.delete("106"));
        System.out.println(ds.delete("50"));
        System.out.println(ds.fetch("50"));
        
        ds.insert(a);
        
        System.out.println(ds.fetch("50"));
    }
}
