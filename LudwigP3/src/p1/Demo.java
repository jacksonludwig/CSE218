package p1;

public class Demo {

    public static void main(String[] args) {
        SinglyLinkedList boston = new SinglyLinkedList();
        Listing l1 = new Listing("Bill", "1st Avenue", "123 4567");
        Listing l2 = new Listing("Al", "2nd Avenue", "456 3232");
        Listing l3 = new Listing("Mike", "3rd Avenue", "333 3333");
        boston.insert(l1);  // test insert
        boston.insert(l2);
        boston.insert(l3);
        boston.showAll();
        l3 = boston.fetch("Mike"); // test fetch of Mike
        System.out.println(l3.toString());
        boston.delete("Al");  // test delete of Al
        boston.showAll();
        boston.update("Mike", l2); // test update of Mike to Al
        boston.showAll();
        System.exit(0);
    }
}
