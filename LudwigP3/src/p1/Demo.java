package p1;

public class Demo {

    public static void main(String[] args) {
        SinglyLinkedList boston = new SinglyLinkedList();
        StudentListing l1 = new StudentListing("Bill", "1st Avenue", "123 4567");
        StudentListing l2 = new StudentListing("Al", "2nd Avenue", "456 3232");
        StudentListing l3 = new StudentListing("Mike", "3rd Avenue", "333 3333");
        StudentListing l4 = new StudentListing("Jack", "5th Avenue", "444 4444");
//        boston.insert(l1);
//        boston.showAll();
        boston.insert(l1);  // test insert
        boston.insert(l2);
        boston.insert(l3);
        boston.insert(l4);
        boston.delete("Jack");
       boston.showAll();
       System.out.println( boston.fetch("Jack"));
//        l3 = boston.fetch("Mike"); // test fetch of Mike
//        System.out.println(l3.toString());
//        boston.delete("Al");  // test delete of Al
//        boston.showAll();
//        boston.update("Mike", l2); // test update of Mike to Al
//        boston.showAll();
//        System.exit(0);
    }
}
