package RestrictedStructures;

public class Demo {

    public static void main(String[] args) {
        Queue q = new Queue(1);
        Node n1 = new Node("1","1","1");
        Node n2 = new Node("2","2","2");
        Node n3 = new Node("3","3","3");
        Node n4 = new Node("4","4","4");
        Node n5 = new Node("5","5","5");
        Node n6 = new Node("6","6","6");
        q.enqueue(n1);
        q.enqueue(n2);
        q.enqueue(n3);
        q.enqueue(n4);
        q.enqueue(n5);
        q.enqueue(n6);
        q.showAll();
    }

}
