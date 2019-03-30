package p1;

import javax.swing.JOptionPane;

public class Demo {

    public static void main(String[] args) {
        StudentListing student;
        DoublyLinkedList listings = new DoublyLinkedList();
        while (true) {
            int menuChoice = Integer.parseInt(JOptionPane.showInputDialog("Enter: \n1 to insert a new students's information,\n"
                    + "2 to fetch and output a student's information,\n"
                    + "3 to delete a student's information,\n"
                    + "4 to update a student's information,\n"
                    + "5 to output all of the student information in sorted order,\n"
                    + "6 to output all of the student information in reverse sorted order, and\n"
                    + "7 to exit the program."));
            switch (menuChoice) {
                case 1:
                    student = new StudentListing();
                    student.inputStudent();
                    if(listings.insert(student)) {
                        JOptionPane.showMessageDialog(null, "Operation Complete");
                    } else {
                        JOptionPane.showMessageDialog(null, "Operation Failed");
                    }
                    break;
                case 2:
                    student = listings.fetch(JOptionPane.showInputDialog("Enter a student name to search for: "));
                    if (student == null) {
                        JOptionPane.showMessageDialog(null, "Student not found");
                    } else {
                        JOptionPane.showMessageDialog(null, student);
                    }
                    break;
                case 3:
                    if (listings.delete(JOptionPane.showInputDialog("Enter a student name to delete: "))) {
                        JOptionPane.showMessageDialog(null, "Operation Complete");
                    } else {
                        JOptionPane.showMessageDialog(null, "Student not found");
                    }
                    break;
                case 4:
                    student = new StudentListing();
                    student.inputStudent();
                    if (listings.update(JOptionPane.showInputDialog("Enter a student name to replace: "), student)) {
                        JOptionPane.showMessageDialog(null, "Operation Complete");
                    } else {
                        JOptionPane.showMessageDialog(null, "Student not found");
                    }
                    break;
                case 5:
                    listings.showAll();
                    JOptionPane.showMessageDialog(null, "All students printed to console");
                    break;
                case 6:
                    listings.showAllBackward();
                    JOptionPane.showMessageDialog(null, "All students printed to console");
                    break;
                case 7:
                    System.exit(0);
            }
        }

    }

}
