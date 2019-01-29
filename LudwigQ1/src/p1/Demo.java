package p1;

import javax.swing.JOptionPane;

public class Demo {
    
    public static void main(String[] args) {
        int size; double total = 0;
        boolean peasEntered = false;
        double[] price;
        String[] name;
        
        size = Integer.parseInt(JOptionPane.showInputDialog("Please Enter the Amount Of Items To Buy: "));
        price = new double[size];
        name = new String[size];
 
        for(int i = 0; i < size; i++) {
            name[i] = JOptionPane.showInputDialog("Please Enter Item's Name: ");
            if(name[i].equalsIgnoreCase("Peas"))
                peasEntered = true;
            price[i] = Double.parseDouble(JOptionPane.showInputDialog("Please Enter Item's Price: "));
            total += price[i];
        }
        
        for(int i = size - 1; i >= 0; i--) {
            System.out.println(name[i] + " ($" + price[i] + ")");
        }
        
        if(peasEntered) {
            total /= size;
            JOptionPane.showMessageDialog(null, "The average price is: " + String.format("%.2f", total));
        }
    }
}
