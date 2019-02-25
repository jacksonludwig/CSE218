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
//            return false;
            expand();
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

    public void showAll() {
        int i = front;
        for (int c = 0; c < numberOfNodes; c++) {
            System.out.println(data[i]);
            i = (i + 1) % size;
        }
    }
}
