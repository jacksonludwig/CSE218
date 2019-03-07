package hash;

public class Listing {

    private String number;  // key field
    private String name;

    public Listing(String num, String n) {
        number = num;
        name = n;
    }

    public String toString() {
        return ("Item number is " + number
                + "\nName is " + name + "\n");
    }

    public Listing deepCopy() {
        Listing clone = new Listing(number, name);
        return clone;
    }

    public String getKey() {
        return number;
    }
}// end of class Listing

