package p1;

public class Queue<T> {

    private int numberOfNodes, rear, front, size;
    private T[] data;
    private static final int DEFAULT_AMOUNT = 100;

    public Queue() {
        numberOfNodes = 0;
        rear = 0;
        front = 0;
        size = DEFAULT_AMOUNT;
        data = (T[]) new Object[size];
    }

    public Queue(int size) {
        numberOfNodes = 0;
        rear = 0;
        front = 0;
        this.size = size;
        data = (T[]) new Object[size];
    }

    public boolean enqueue(T student) {
        if (isFull()) {
            if (!expand()) {
                return false;
            }
        }
        GenericInterface node = (GenericInterface) student;
        data[rear] = (T) node.deepCopy();
        rear = (rear + 1) % size;
        numberOfNodes++;
        return true;
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        int f = front;
        front = (front + 1) % size;
        numberOfNodes--;
        return data[f];
    }

    private boolean expand() {
        T[] temp = (T[]) new Object[size * 2];
        for (int i = 0; i < numberOfNodes; i++) {
            temp[i] = data[front];
            front = (front + 1) % size;
        }
        rear = numberOfNodes;
        front = 0;
        size *= 2;
        data = temp;
        return true;
    }

    public boolean initialize() {
        data = (T[]) new Object[DEFAULT_AMOUNT];
        if (data == null) {
            return false;
        }
        size = DEFAULT_AMOUNT;
        numberOfNodes = 0;
        front = 0;
        rear = 0;
        return true;
    }

    public boolean isEmpty() {
        if (numberOfNodes == 0) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if (numberOfNodes == size) {
            return true;
        }
        return false;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }
        GenericInterface node = (GenericInterface) data[front];
        return (T) node.deepCopy();
    }

    public void showAll() {
        int i = front;
        for (int c = 0; c < numberOfNodes; c++) {
            System.out.println(data[i]);
            i = (i + 1) % size;
        }
    }
}
