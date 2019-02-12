package ArrayList;


import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ArrayListsEncapsulation {

    public static void main(String[] args) {
        ArrayList<Node> t = new ArrayList<Node>();
        // Node aNode = new Node("", "", "");

        for (int i = 0; i < 3; i++) {
            Node aNode = new Node("", "", "");
            aNode.inputNode();
            t.add(aNode);
        }

        JOptionPane.showMessageDialog(null, "Show Output?");
        for (int i = 0; i < 3; i++) {
            System.out.println(t.get(i));
        }

    }
}
