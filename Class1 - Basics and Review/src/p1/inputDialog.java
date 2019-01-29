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
    }
}
