package p1;

/*  Name: Jackson Ludwig
    Grade: 
 */

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

    public boolean delete(String number) {
        int pk = preProcess(number);
        int ip = hash(pk);
        if (data[ip] != null) {
            data[ip] = null;
            return true;
        }
        return false;
    }

    public boolean update(String number, Listing newNode) {
        if (!delete(number)) {
            return false;
        }
        if (insert(newNode)) {
            return true;
        }
        return false;
    }

    public void showAll() {
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {
                System.out.println(data[i]);
            }
        }
    }
}
