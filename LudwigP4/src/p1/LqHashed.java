package p1;

public class LqHashed {

    private int N;
    private int n = 0;			// the number of nodes in the structure
    private int nodeWidth = 0;
    private int defaultQuotient = 9967;  	// the default 4k+3 prime
    private static final double loadingFactor = 0.75;
    private StudentListing deleted;		// the dummy node, v2
    private StudentListing[] data; 	// the primary storage array
    private double pLoadingFactor = 0;
    private int nDummies = 0;
    private int nAccesses = 0;
    private int nOperations = 0;

    public LqHashed(int length, int nodeWidth) {
        int pct = (int) ((1.0 / loadingFactor - 1) * 100.0);
        N = fourKPlus3(length, pct);
        data = new StudentListing[N];
        deleted = new StudentListing("", "", "");
        this.nodeWidth = nodeWidth;
    }

    public boolean insert(StudentListing newStudentListing) {
        boolean hit = false;
        int pass, q, offset, ip;
        int pk = stringToInt(newStudentListing.getKey());  // preprocess the key
        if (pLoadingFactor >= loadingFactor) {
            if (!expand(N)) {
                return false;
            }
        }
        if ((((double) n) / N) >= loadingFactor) {
            if (!expand(fourKPlus3(2 * N, 33))) {
                return false;
            }
        }
        pass = 0;
        q = pk / N;
        offset = q;
        ip = pk % N;
        if (q % N == 0) { // fix for collision algorithm
            offset = defaultQuotient;
        }
        while (pass < N) {
            nAccesses++;
            if (data[ip] == null || data[ip] == deleted) {
                hit = true;
                break;
            }
            ip = (ip + offset) % N;
            pass = pass + 1;
        }
        if (hit == true) // insert the node
        {
            if (data[ip] == deleted) {
                nDummies--;
            }
            data[ip] = newStudentListing.deepCopy();
            n++;
            pLoadingFactor = (n + nDummies) / ((double) N); // PLF = (n + nd) /((double) N)
            nOperations++;
            outputInfo();
            return true;
        }
        return false;
    }

    public StudentListing fetch(String targetKey) {
        boolean noError;
        boolean hit = false;
        int pass, q, offset, ip;
        int pk = stringToInt(targetKey);  // preprocess the key
        pass = 0;
        q = pk / N;
        offset = q;
        ip = pk % N;
        if (q % N == 0) {
            offset = defaultQuotient;
        }
        while (pass < N) {
            nAccesses++;
            if (data[ip] == null) //node not in structure
            {
                break;
            }
            if (data[ip].compareTo(targetKey) == 0) //node found
            {
                hit = true;
                break;
            }
            ip = (ip + offset) % N;  //collision occurred
            pass = pass + 1;
        }
        if (hit == true) //return a deep copy of the node
        {
            nOperations++;
            outputInfo();
            return data[ip].deepCopy();
        } else {
            return null;
        }
    }

    public boolean delete(String targetKey) {
        boolean noError;
        boolean hit = false;
        int pass, q, offset, ip;
        int pk = stringToInt(targetKey);  // preprocess the key
        pass = 0;
        q = pk / N;
        offset = q;
        ip = pk % N;
        if (q % N == 0) {
            offset = defaultQuotient;
        }
        while (pass < N) {
            nAccesses++;
            if (data[ip] == null) //node not in structure
            {
                break;
            }
            if (data[ip].compareTo(targetKey) == 0) // node found
            {
                hit = true;
                break;
            }
            ip = (ip + offset) % N;  //collision occurred
            pass = pass + 1;
        }
        if (hit == true) //delete the node
        {
            nOperations++;
            data[ip] = deleted;
            nDummies++;
            n--;
            outputInfo();
            return noError = true;
        } else {
            return noError = false;
        }
    }

    public boolean update(String targetKey, StudentListing newStudentListing) {
        if (delete(targetKey) == false) {
            return false;
        } else if (insert(newStudentListing) == false) {
            return false;
        }
        return true;
    }

    public void showAll() {
        for (int i = 0; i < N; i++) {
            if (data[i] != null && data[i] != deleted) {
                System.out.println(data[i].toString());
            }
        }
    }

    public static int fourKPlus3(int n, int pct) // from Figure 5.16
    {
        boolean fkp3 = false;
        boolean aPrime = false;
        int prime, highDivisor, d;
        double pctd = pct;
        prime = (int) (n * (1.0 + (pctd / 100.0)));  // guess the prime pct percent larger than n
        if (prime % 2 == 0) //if even make the prime guess odd
        {
            prime = prime + 1;
        }
        while (fkp3 == false) // not a 4k+3 prime
        {
            while (aPrime == false) // not a prime
            {
                highDivisor = (int) (Math.sqrt(prime) + 0.5);
                for (d = highDivisor; d > 1; d--) {
                    if (prime % d == 0) {
                        break;
                    }
                }
                if (d != 1) // prime not found
                {
                    prime = prime + 2;
                } else {
                    aPrime = true;
                }
            }// end of the prime search loop
            if ((prime - 3) % 4 == 0) {
                fkp3 = true;
            } else {
                prime = prime + 2;
                aPrime = false;
            }
        }// end of 4k+3 prime search loop
        return prime;
    }

    public static int stringToInt(String aKey) // from Figure 5.18
    {
        int pseudoKey = 0;
        int n = 1;
        int cn = 0;
        char c[] = aKey.toCharArray();
        int grouping = 0;
        while (cn < aKey.length()) // there is still more character in the key
        {
            grouping = grouping << 8;      // pack next four characters in i
            grouping = grouping + c[cn];
            cn = cn + 1;
            if (n == 4 || cn == aKey.length()) // 4 characters are processed or no more characters
            {
                pseudoKey = pseudoKey + grouping;
                n = 0;
                grouping = 0;
            }
            n = n + 1;
        }
        return Math.abs(pseudoKey);
    }

    private boolean expand(int newSize) { // size needs to be set because it is used to fix node not in structure problem
        StudentListing[] temp = data;
        data = new StudentListing[newSize];
        if (data == null) {
            data = temp;
            return false;
        }

        int nOld = N;
        N = newSize;

        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != null && temp[i] != deleted) { // won't insert dummies or nulls
                insert(temp[i]);
            }
        }

        nDummies = 0;
        if (newSize == nOld) {
            System.out.println("The dummy nodes were eliminated; The new pseudo loading factor is: " + (String.format("%.2f", (((double) n) / N))));
        } else {
            System.out.println("Primary storage area was expanded. The array size is now: " + N);
        }
        return true;
    }

    private void outputInfo() {
        System.out.println("Search Length: " + String.format("%.2f", nAccesses / (double) nOperations));
        System.out.println("Current Loading Factor: " + String.format("%.2f", (((double) n) / N)));
        System.out.println("Current Pseudo Loading Factor: " + String.format("%.2f", (n + nDummies) / ((double) N)));
        System.out.println("Current Density: " + String.format("%.2f", 1 / (1 + 4 / (nodeWidth * ((double) n) / N))));
        System.out.println();
    }
}
