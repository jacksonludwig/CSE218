package p1;

import javax.swing.JOptionPane;

public class StudentListing implements GenericInterface{

    private String name;
    private String gpa;
    private String id;

    public StudentListing() {
        name = " ";
        gpa = " ";
        id = " ";
    }

    public StudentListing(String n, String a, String num) {
        name = n;
        gpa = a;
        id = num;
    }

    public String toString() {
        return ("Name is " + name
                + "\nGpa is " + gpa
                + "\nId is " + id + "\n");
    }

    public StudentListing deepCopy() {
        StudentListing clone = new StudentListing(name, gpa, id);
        return clone;
    }

    public int compareTo(String targetKey) {
        return (name.compareTo(targetKey));
    }

    public void inputStudent() {
        name = JOptionPane.showInputDialog("Enter a name");
        gpa = JOptionPane.showInputDialog("Enter a gpa");
        id = JOptionPane.showInputDialog("Enter an id");
    }
}
