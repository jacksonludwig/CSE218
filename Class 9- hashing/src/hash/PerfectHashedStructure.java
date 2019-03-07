/*  Name:
    Grade:
 */
package hash;

public class PerfectHashedStructure {

    Listing data[];
    int size;
    int minKey;

    public PerfectHashedStructure(String min, String max) {
        minKey = Integer.parseInt(min);
        int maxKey = Integer.parseInt(max);
        size = maxKey - minKey + 1;
        data = new Listing[size];
    }
}
