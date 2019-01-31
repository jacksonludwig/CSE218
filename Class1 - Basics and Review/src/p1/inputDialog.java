package p1;

import javax.swing.JOptionPane;

public class inputDialog {
    public static void main(String[] args) {
        String s = JOptionPane.showInputDialog("Enter your age:");
        int age = Integer.parseInt(s);
        
        age++;
        JOptionPane.showMessageDialog(null, "Age is " + age);
        
        Listing listing = new Listing();
        
        System.out.println(listing);
        
        Listing[] listings;
        listings = new Listing[3];
        
        for(int i = 0; i < 3; i++) {
            listings[i] = new Listing(i);
            System.out.println(listings[i]);
        }
        
        Listing tom = listings[2].clone();
        System.out.println(tom);
        
        
    }
}
