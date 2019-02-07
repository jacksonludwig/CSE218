package p1;

public class UOAUtilities {

    private int next;
    private int size;
    private StudentListing[] data;

    public UOAUtilities() {
        next = 0;
        size = 100;
        data = new StudentListing[size];
    }//end of constructor

    public UOAUtilities(int s) {
        next = 0;
        data = new StudentListing[s];
        size = s;
    }//end of constructor

    public boolean insert(StudentListing newStudentListing) {
        if (next >= size) // the structure is full
        {
            return false;
        }
        data[next] = newStudentListing.deepCopy();  // store a deep copy of the client’s node
        if (data[next] == null) {
            return false;
        }
        next = next + 1; // prepare for the next insert
        return true;
    }// end of insert method

    public StudentListing fetch(String targetKey) {
        StudentListing node;
        StudentListing temp;
        // access the node using a sequential search
        int i = 0;
        while (i < next && !(data[i].compareTo(targetKey) == 0)) {
            i++;
        }
        if (i == next) // node not found
        {
            return null;
        }
        //deep copy the node's information into the client's node
        node = data[i].deepCopy();
        // move the node up one position in the array, unless it is the first node
        if (i != 0) // bubble-up accessed node (speeds up aquisition of most likely calls by putting them higher in the array)
        {
            temp = data[i - 1];
            data[i - 1] = data[i];
            data[i] = temp;
        }
        return node;
    } // end of fetch method

    public boolean delete(String targetKey) {// access the node using a sequential search
        int i = 0;
        while (i < next && !(data[i].compareTo(targetKey) == 0)) {
            i++;
        }
        if (i == next) // node not found
        {
            return false;
        }
        //move the last node into the deleted node's position (trick to avoid shifting every piece of data up one spot)
        data[i] = data[next - 1];
        data[next - 1] = null;
        next = next - 1;
        return true; // node found and deleted
    }//end of the delete method

    public boolean update(String targetKey, StudentListing newStudentListing) {
        if (delete(targetKey) == false) // node not in the structure
        {
            return false;
        } else if (insert(newStudentListing) == false) // insufficient memory
        {
            return false;
        } else {
            return true;  // node found and updated
        }
    }// end of update method

    public void showAll() {
        for (int i = 0; i < next; i++) {
            System.out.println(data[i].toString());
        }
    }// end showAll method
}//end of class UOAUtilities

