package p1;

import javax.swing.JOptionPane;

public class StudentListing {

    private String name;  // key field
    private String gpa;
    private String number;

    public StudentListing() {
        name = " ";
        gpa = " ";
        number = " ";
    }

    public StudentListing(String n, String a, String num) {
        name = n;
        gpa = a;
        number = num;
    }

    public String toString() {
        return ("Name is " + name
                + "\nGpa is " + gpa
                + "\nNumber is " + number + "\n");
    }

    public StudentListing deepCopy() {
        StudentListing clone = new StudentListing(name, gpa, number);
        return clone;
    }

    public int compareTo(String targetKey) {
        return (name.compareTo(targetKey));
    }

    public void setGpa(String a) // coded to demonstrate encapsulation
    {
        gpa = a;
    }

    public void inputStudent() {
        name = JOptionPane.showInputDialog("Enter a name");
        gpa = JOptionPane.showInputDialog("Enter a gpa");
        number = JOptionPane.showInputDialog("Enter a number");
    }
}
