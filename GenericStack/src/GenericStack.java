
public class GenericStack {

    public static void main(String[] args) {
        Stack<Listing> list = new Stack<>(10);
        Listing l1 = new Listing("1", "1", "1");
        Listing l2 = new Listing("2", "2", "2");
        list.push(l1);
        list.push(l2);
        
        System.out.println(list.pop());
        System.out.println(list.pop());
        System.out.println(list.pop());
    }

}
