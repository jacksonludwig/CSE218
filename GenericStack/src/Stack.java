
public class Stack<T> { // step 1

    private T[] data; // step 2
    private int top;
    private int size;

    public Stack() {
        top = -1;
        size = 100;
        data = (T[]) new Object[100]; // step 3
    }

    public Stack(int n) {
        top = -1;
        size = n;
        data = (T[]) new Object[n];
    }

    public boolean push(T newNode) {
        GenericInterface node = (GenericInterface) newNode; // 4b
        if (top == size - 1) {
            return false;  // ** overflow error **
        } else {
            top = top + 1;
            data[top] = (T) node.deepCopy(); // 4c
            return true;  // push operation successful
        }
    }

    public T pop() {
        int topLocation;
        if (top == -1) {
            return null;  // ** underflow error **
        } else {
            topLocation = top;
            top = top - 1;
            return data[topLocation];
        }
    }

    public void showAll() {
        for (int i = top; i >= 0; i--) {
            System.out.println(data[i].toString());
        }
    }
}
