package imperfectHash;

public class CollisionAlgorithmsNBTemplate {

    public static void main(String[] args) {
        int N = 19;
        int pk = 5058;
        int ip = pk % N;
        int offset = pk / N; // Linear Quotient collision technique
        if(offset % N == 0) { // necessary fix for algorithm
            offset = 9967;
        }
        System.out.println("home ip = " + ip + ", pass 1 offset = " + offset
                + "\nip from N-1 passes through the collision algorithm");
        for (int p = 1; p <= N - 1; p++) {
            ip = (ip + offset) % N;
            System.out.println(ip);
        }
    }

}
