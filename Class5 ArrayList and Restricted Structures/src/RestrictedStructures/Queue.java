package RestrictedStructures;

public class Queue {

    int numberOfNodes, rear, front, size;
    Node[] data;

    public Queue(int size) {
        numberOfNodes = 0;
        rear = 0;
        front = 0;
        this.size = size;
        data = new Node[size];
    }

    public boolean enqueue(Node node) {
        if (numberOfNodes == size) {
            return false;
        }
        data[rear] = node.deepCopy(); // remember to use clones to ensure encapsulation and security.
        rear = (rear + 1) % size;
        numberOfNodes++;
        return true;
    }

    public Node dequeue() {
        if (numberOfNodes == 0) {
            return null;
        }
        int f = front;
        front = (front + 1) % size;
        numberOfNodes--;
        return data[f]; // no need for clone.
    }
    
    private boolean expand() {
        Node[] temp = new Node[size * 2];
        int j = front;
        for(int i = 1; i <= size; i++) {
            data[i - 1] = temp[j];
            j = (j + 1) % size;
        } // not done: must add what was from last expand.
        rear = size;
        front = 0;
        size *= 2;
        return true;
    }
    
    public void showAll() {
        int i = front;
        for(int c = 1; c <= front; c++) {
            System.out.println(); // also didn't finish
        }
    }
}
