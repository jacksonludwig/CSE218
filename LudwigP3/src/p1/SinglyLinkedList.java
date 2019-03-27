package p1;

public class SinglyLinkedList {

    private Node h;  // list header

    public SinglyLinkedList() {
        h = new Node();  // dummy node
        h.l = null;
        h.next = null;
    }

    public boolean insert(StudentListing newListing) {
        Node q = h;
        Node p = h.next;
        if (p == null) {
            Node n = new Node();
            n.l = newListing.deepCopy();
            n.next = h.next;
            h.next = n;
            n.l = newListing.deepCopy();
            return true;
        }
        while (p != null && (p.l.compareTo(newListing.getKey()) < 0)) {
            q = p;
            p = p.next;
        }
        if (p != null) {
            Node n = new Node();
            n.l = newListing.deepCopy();
            n.next = p;
            q.next = n;
            return true;
        }
        return false;
    }

    public StudentListing fetch(String targetKey) {
        Node p = h.next;
        while (p != null && !(p.l.compareTo(targetKey) == 0)) {
            p = p.next;
        }
        if (p != null) {
            return p.l.deepCopy();
        } else {
            return null;
        }
    }

    public boolean delete(String targetKey) {
        Node q = h;
        Node p = h.next;
        while (p != null && !(p.l.compareTo(targetKey) == 0)) {
            q = p;
            p = p.next;
        }
        if (p != null && !(p.l.compareTo(targetKey) == 0)) { // a hit
            q.next = p.next;
            return true;
        } else {
            return false;
        }
    }

    public boolean update(String targetKey, StudentListing newListing) {
        if (delete(targetKey) == false) {
            return false;
        } else if (insert(newListing) == false) {
            return false;
        }
        return true;
    }

    public void showAll() {
        Node p = h.next;
        while (p != null) //continue to traverse the list
        {
            System.out.println(p.l.toString());
            p = p.next;
        }
    }

    public class Node {

        private StudentListing l;
        private Node next;

        public Node() {
        }
    }// end of inner class Node
}//end SinglyLinkedList outer class

