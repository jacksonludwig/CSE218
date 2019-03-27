package p1;

public class StudentListing {

    private String name;  // key field
    private String address;
    private String number;

    public StudentListing(String n, String a, String num) {
        name = n;
        address = a;
        number = num;
    }

    public String toString() {
        return ("Name is " + name
                + "\nAddress is " + address
                + "\nNumber is " + number + "\n");
    }

    public StudentListing deepCopy() {
        StudentListing clone = new StudentListing(name, address, number);
        return clone;
    }

    public int compareTo(String targetKey) {
        return (name.compareTo(targetKey));
    }

    public void setAddress(String a) // coded to demonstrate encapsulation
    {
        address = a;
    }

    public String getKey() {
        return name;
    }
}// end of class Listing

