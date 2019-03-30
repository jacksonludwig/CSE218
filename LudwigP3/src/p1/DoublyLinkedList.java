package p1;

public class DoublyLinkedList {

    private Node h;  // list header

    public DoublyLinkedList() {
        h = new Node();  // dummy node
        h.l = null;
        h.next = null;
        h.back = null;
    }

    public boolean insert(StudentListing newListing) {
        Node q = h;
        Node p = h.next;
        Node n = new Node();
        if (n == null) {
            return false;
        }
        if (h.next == null) {
            n.l = newListing.deepCopy();
            n.next = h.next;
            h.next = n;
            return true;
        }
        while (p != null && (p.l.compareTo(newListing.getKey()) < 0)) {
            if (q != null) {
                p.back = q;
            }
            q = p;
            p = p.next;
        }
        n.l = newListing.deepCopy();
        n.next = p;
        n.back = q;
        q.next = n;
        return true;
    }

    public StudentListing fetch(String targetKey) {
        Node q = h;
        Node p = h.next;
        if (p.l.compareTo(targetKey) == 0) {
            return h.next.l;
        }
        while (p != null && (p.l.compareTo(targetKey) < 0)) {
            q = p;
            p = p.next;
        }
        if (p != null && (p.l.compareTo(targetKey) == 0)) { // a hit
            return p.l.deepCopy();
        }
        return null;
    }

    public boolean delete(String targetKey) {
        Node q = h;
        Node p = h.next;
        if (p.l.compareTo(targetKey) == 0) {
            h.next = p.next;
            return true;
        }
        while (p != null && (p.l.compareTo(targetKey) < 0)) {
            q = p;
            p = p.next;
        }
        if (p != null && (p.l.compareTo(targetKey) == 0)) { // a hit
            if (p.next == null) {
                q.next = p.next;
            } else {
                p.next.back = q;
                q.next = p.next;
            }
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

    public void showAllBackward() {
        Node p = h.next;
        while (p != null) 
        {
            if (p.next == null) {
                break;
            }
            p = p.next;
        }
        while (p != null) {
            if (p.l != null) {
                System.out.println(p.l);
            }
            p = p.back;
        }
    }

    public class Node {

        private StudentListing l;
        private Node next;
        private Node back;

        public Node() {
        }
    }
}

