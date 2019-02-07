package p1;

// MUST BE CHANGED: SHOULD BE GPA; NO GETS OR SETS -- ADD EXPAND TO DATA STRUCT CLASS
// e.g.: private boolean expand (fix utilities and studentlisting)...
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

        while (true) {
            int menuChoice = Integer.parseInt(JOptionPane.showInputDialog("Enter: \n1 to insert a new students's information,\n"
                    + "2 to fetch and output a student's information\n"
                    + "3 to delete a student's information\n"
                    + "4 to update a student's information\n"
                    + "5 to output all of the student information in sorted order, and\n"
                    + "6 to exit the program."));
            switch (menuChoice) {
                case 1:
                    student = new StudentListing();
                    student.inputStudent();
                    listings.insert(student);
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
                        JOptionPane.showMessageDialog(null, "Student deleted from database");
                    } else {
                        JOptionPane.showMessageDialog(null, "Student not found");
                    }
                    break;
                case 4:
                    student = new StudentListing();
                    student.inputStudent();
                    if (listings.update(JOptionPane.showInputDialog("Enter a student name to replace: "), student)) {
                        JOptionPane.showMessageDialog(null, "Student information updated");
                    } else {
                        JOptionPane.showMessageDialog(null, "Student not found");
                    }
                    break;
                case 5:
                    listings.showAll();
                    JOptionPane.showMessageDialog(null, "All students printed to console");
                    break;
                case 6:
                    System.exit(0);
            }
        }

    }

}
