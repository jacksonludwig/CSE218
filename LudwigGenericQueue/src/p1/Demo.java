package p1;

import javax.swing.JOptionPane;

public class Demo {

    public static void main(String[] args) {
        Queue<StudentListing> list = new Queue<>(3);
        for (int i = 0; i < 3; i++) {
            StudentListing student = new StudentListing();
            student.inputStudent();
            list.enqueue(student);
        }
        JOptionPane.showMessageDialog(null, "" + list.dequeue() + "\n" + list.dequeue() + "\n" + list.dequeue());
        JOptionPane.showMessageDialog(null, "The Queue is now empty");
    }

}
