package p1;

import javax.swing.JOptionPane;

public class Demo {

    public static void main(String[] args) {
        Listing[] listings = new Listing[3];

        for (int i = 0; i < listings.length; i++) {
            listings[i] = new Listing(JOptionPane.showInputDialog("Please Enter Person " + (i + 1) + "'s Name"), 
                    Integer.parseInt(JOptionPane.showInputDialog("Please Enter Person " + (i + 1) + "'s Age")));
        }
        
        for (int i = listings.length - 1; i >= 0; i--) {
            System.out.println(listings[i]);
        }
    }
}
