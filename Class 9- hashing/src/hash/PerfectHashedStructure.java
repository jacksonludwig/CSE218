/*  Name: Jackson Ludwig
    Grade: 
 */

// add delete, update, showall

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

    private int preProcess(String key) {
        int pseudoKey = Integer.parseInt(key);
        pseudoKey = pseudoKey - minKey;
        return pseudoKey;
    }

    private int hash(int pk) {
        int ip = pk;
        return ip;
    }

    public boolean insert(Listing newNode) {
        int pk = preProcess(newNode.getKey());
        int ip = hash(pk);
        if (ip >= 0 && ip < data.length) {
            data[ip] = newNode.clone();
            return true;
        }
        return false;
    }

    public Listing fetch(String number) {
        int pk = preProcess(number);
        int ip = hash(pk);
        if (ip >= 0 && ip < data.length && data[ip] != null) {
            return data[ip].clone();
        }
        return null;
    }
}
