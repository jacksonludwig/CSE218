package p1;

import javax.swing.JOptionPane;

public class Demo {

    public static void main(String[] args) {
        int size = Integer.parseInt(JOptionPane.showInputDialog("Enter the Maximum size of the data set: "));
        int initialStudentAmount = Integer.parseInt(JOptionPane.showInputDialog("Enter the initial number of students: "));

        StudentListing student;
        UOAUtilities listings = new UOAUtilities(size);

        for (int i = 0; i < initialStudentAmount; i++) {
            student = new StudentListing();
            student.inputStudent();
            listings.insert(student);
        }

        int menuChoice = Integer.parseInt(JOptionPane.showInputDialog("Enter: \n1 to insert a new students's information,\n"
                + "2 to fetch and output a student's information\n"
                + "3 to delete a student's information\n"
                + "4 to update a student's information\n"
                + "5 to output all of the student information in sorted order, and\n"
                + "6 to exit the program."));

        switch (menuChoice) {
            case 1:

        }

    }

}
