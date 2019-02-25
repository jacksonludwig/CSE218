package queue;

import javax.swing.JOptionPane;

public class Demo {

    public static void main(String[] args) {
        int size;
        do {
            size = Integer.parseInt(JOptionPane.showInputDialog("Enter the Initial size of the data set: "));
        } while (size <= 0);
        int initialStudentAmount = Integer.parseInt(JOptionPane.showInputDialog("Enter the initial number of students: "));

        StudentListing student;
        Queue listings = new Queue(size);

        for (int i = 0; i < initialStudentAmount; i++) {
            student = new StudentListing();
            student.inputStudent();
            listings.enqueue(student);
        }

        while (true) {
            int menuChoice = Integer.parseInt(JOptionPane.showInputDialog("Enter: \n1 to insert a new student's information,\n"
                    + "2 to fetch and delete the next student,\n"
                    + "3 to peek at the next student's information,\n"
                    + "4 to check if the data structure is full,\n"
                    + "5 to check if the data structure is empty,\n"
                    + "6 to reinitialize the data structure,\n"
                    + "7 to display all of the current students in the database, and \n"
                    + "8 to exit the program,"));
            switch (menuChoice) {
                case 1:
                    student = new StudentListing();
                    student.inputStudent();
                    if (listings.enqueue(student)) {
                        JOptionPane.showMessageDialog(null, "Operation Complete");
                    } else {
                        JOptionPane.showMessageDialog(null, "Operation Failed");
                    }
                    break;
                case 2:
                    student = listings.dequeue();
                    if (student == null) {
                        JOptionPane.showMessageDialog(null, "No Student to Dequeue");
                    } else {
                        JOptionPane.showMessageDialog(null, student);
                    }
                    break;
                case 3:
                    student = listings.peek();
                    if (student == null) {
                        JOptionPane.showMessageDialog(null, "No Student to Peek");
                    } else {
                        JOptionPane.showMessageDialog(null, student);
                    }
                    break;
                case 4:
                    if (listings.isFull()) {
                        JOptionPane.showMessageDialog(null, "The database is currently full");
                    } else {
                        JOptionPane.showMessageDialog(null, "The database is not currently full");
                    }
                    break;
                case 5:
                    if (listings.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "The database is currently empty");
                    } else {
                        JOptionPane.showMessageDialog(null, "The database is not currently empty");
                    }
                    break;
                case 6:
                    if (listings.initialize()) {
                        JOptionPane.showMessageDialog(null, "The database is has been reinitialized");
                    } else {
                        JOptionPane.showMessageDialog(null, "Operation Failed");
                    }
                    break;
                case 7:
                    listings.showAll();
                    break;
                case 8:
                    System.exit(0);
            }
        }

    }

}
