package p1;

public class Program6Template {

    public static void main(String[] args) {
        BinaryTree bTree = new BinaryTree();
        Listing l;
        Listing listing1 = new Listing("Ann", "1st Avenue", "111 1111");
        Listing listing2 = new Listing("Bill", "2nd Avenue", "222 2222");
        Listing listing3 = new Listing("Carol", "3rd Avenue", "333 3333");
        Listing listing4 = new Listing("Mike", "4th Avenue", "444 4444");
        Listing listing5 = new Listing("Pat", "5th Avenue", "555 5555");
        Listing listing6 = new Listing("Sally", "6th Avenue", "666 6666");
        Listing listing7 = new Listing("Vick", "7th Avenue", "888 8888");
        Listing listing8 = new Listing("Will", "8th Avenue", "999 9999");
        Listing listing9 = new Listing("Xray", "9th Avenue", "101 0101");
        Listing listing10 = new Listing("Zeek", "10th Avenue", "121 2121");
        // insert and fetch nodes
        bTree.insert(listing9);
        bTree.insert(listing7);
        bTree.insert(listing10);
        bTree.insert(listing2);
        bTree.insert(listing8);
        bTree.insert(listing1);
        bTree.insert(listing4);
        bTree.insert(listing3);
        bTree.insert(listing6);
        bTree.insert(listing5);

        System.out.println(bTree.fetch("Mike"));
        bTree.showAllLNR();
        System.exit(0);
    }
}
