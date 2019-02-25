package queue;

public class Queue {

    private int numberOfStudentListings, rear, front, size;
    private StudentListing[] data;
    private static final int DEFAULT_AMOUNT = 100;

    public Queue() {
        numberOfStudentListings = 0;
        rear = 0;
        front = 0;
        size = DEFAULT_AMOUNT;
        data = new StudentListing[size];
    }

    public Queue(int size) {
        numberOfStudentListings = 0;
        rear = 0;
        front = 0;
        this.size = size;
        data = new StudentListing[size];
    }

    public boolean enqueue(StudentListing student) {
        if (isFull()) {
            if (!expand()) {
                return false;
            }
        }
        data[rear] = student.deepCopy();
        rear = (rear + 1) % size;
        numberOfStudentListings++;
        return true;
    }

    public StudentListing dequeue() {
        if (isEmpty()) {
            return null;
        }
        int f = front;
        front = (front + 1) % size;
        numberOfStudentListings--;
        return data[f];
    }

    private boolean expand() {
        StudentListing[] temp = new StudentListing[size * 2];
        for (int i = 0; i < numberOfStudentListings; i++) {
            temp[i] = data[front];
            front = (front + 1) % size;
        }
        rear = numberOfStudentListings;
        front = 0;
        size *= 2;
        data = temp;
        return true;
    }

    public boolean initialize() {
        data = new StudentListing[DEFAULT_AMOUNT];
        if (data == null) {
            return false;
        }
        size = DEFAULT_AMOUNT;
        numberOfStudentListings = 0;
        front = 0;
        rear = 0;
        return true;
    }

    public boolean isEmpty() {
        if (numberOfStudentListings == 0) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if (numberOfStudentListings == size) {
            return true;
        }
        return false;
    }

    public StudentListing peek() {
        if (isEmpty()) {
            return null;
        }
        return data[front].deepCopy();
    }

    public void showAll() {
        int i = front;
        for (int c = 0; c < numberOfStudentListings; c++) {
            System.out.println(data[i]);
            i = (i + 1) % size;
        }
    }
}
