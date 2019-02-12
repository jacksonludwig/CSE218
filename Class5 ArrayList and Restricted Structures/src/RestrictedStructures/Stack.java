package RestrictedStructures;

public class Stack {

    int size, top;
    Node[] data;

    public Stack(int size) {
        this.size = size;
        data = new Node[size];
        top = -1;
    }

    public boolean push(Node newNode) {
        if (top == size - 1) {
            return false;
        } else {
            data[top + 1] = newNode.deepCopy(); // push clone
            return true;
        }
    }

    public Node pop() {
        if (top == -1) {
            return null;
        } else {
            return data[top--]; // pop shallow copy/original
        }
    }

    public Node peek() {
        if (top == -1) {
            return null;
        } else {
            return data[top].deepCopy(); // this is a pop without deletion; returns clone and doesn't change top.
        }
    }
}
