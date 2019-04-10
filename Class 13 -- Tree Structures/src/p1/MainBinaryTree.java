package p1;

public class MainBinaryTree {

    public static void main(String[] args) {
        BinaryTree t = new BinaryTree();
        Listing l1 = new Listing("Ann", "1st Avenue", "111 1111");
        Listing l2 = new Listing("Bill", "2nd Avenue", "222 2222");
        Listing l3 = new Listing("Carol", "3rd Avenue", "333 3333");
        Listing l4 = new Listing("Mike", "4th Avenue", "444 4444");
        Listing l5 = new Listing("Pat", "5th Avenue", "555 5555");
        Listing l6 = new Listing("Sally", "6th Avenue", "666 6666");
        Listing l7 = new Listing("Ted", "7th Avenue", "777 7777");
        Listing l8 = new Listing("Vick", "8th Avenue", "888 8888");
        Listing l9 = new Listing("Will", "9th Avenue", "999 9999");
        Listing l10 = new Listing("Zack", "11th Avenue", "101 0101");
        Listing l11 = new Listing("Zeek", "12th Avenue", "121 2121");
        // insert and fetch nodes
        t.insert(l9);
        t.insert(l7);
        t.insert(l10);
        t.insert(l2);
        t.insert(l8);
        t.insert(l1);
        t.insert(l4);
        t.insert(l3);
        t.insert(l6);
//        t.insert(l5);
//        System.out.println(t.fetch("Carol"));
//        System.out.println(t.fetch("Sally"));
//        System.out.println(t.fetch("Ted"));
//        // delete nodes
//        t.delete("Carol"); // a node with NO children
//        System.out.println(t.fetch("Carol"));
//        t.delete("Sally"); // a node with ONE child
//        System.out.println(t.fetch("Sally"));
//        t.delete("Ted"); // a node with TWO children
//        System.out.println(t.fetch("Ted"));
//        // update nodes
//        t.update("Bill", l3);
//        System.out.println(t.fetch("Carol"));
//        System.out.println(t.fetch("Bill"));
//        System.exit(0);
    }
}
