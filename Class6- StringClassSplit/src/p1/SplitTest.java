package p1;

public class SplitTest {

    public static void main(String[] args) {
        String s = "Hey    There's     some    spaces    in here! bonus: 10";
        String[] tokens = s.split(" +"); // " +" means split if there's one or more spaces.
        for (int i = 0; i < tokens.length; i++) {
            System.out.println(tokens[i]);
        }
    }

}
