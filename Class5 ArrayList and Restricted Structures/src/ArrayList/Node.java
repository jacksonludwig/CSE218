package ArrayList;


import javax.swing.JOptionPane;

public class Node {

    private String name;  // key field
    private String address;
    private String number;

    public Node(String n, String a, String num) {
        name = n;
        address = a;
        number = num;
    }

    public String toString() {
        return ("Name is " + name
                + "\nAddress is " + address
                + "\nNumber is " + number + "\n");
    }

    public Node deepCopy() {
        Node clone = new Node(name, address, number);
        return clone;
    }

    public int compareTo(String targetKey) {
        return (name.compareTo(targetKey));
    }

    public void setAddress(String a) // coded to demonstrate encapsulation
    {
        address = a;
    }

    public void inputNode() {
        name = JOptionPane.showInputDialog("Enter a name");
        address = JOptionPane.showInputDialog("Enter an address");
        number = JOptionPane.showInputDialog("Enter a number");
    }
}
