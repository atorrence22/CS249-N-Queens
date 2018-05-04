/**
 * Created by Austin on 5/1/2017.
 */


public class HashSet<S> implements ISet<String> {

    int count = 0;    //for keeping track of size of set
    int maxSize;
    int[] hList;
    String[] strList;

    public HashSet(int hSize) {
        this.maxSize = hSize;
        this.hList = new int[hSize];
        this.strList = new String[hSize];
    }


    public void add(String element) {
        int hashed = hashThis(element);
        if (hList[hashed] == 0) {
            hList[hashed] = element.hashCode();
            strList[hashed] = (String) element;
        } else {
            while (true) {
                int newIndex = doubleHashThis(element).hashCode() & maxSize;
                if (hList[newIndex] == 0) {
                    hList[newIndex] = doubleHashThis(element).hashCode();
                    strList[newIndex] = element;
                    break;
                }
            }
        }
    }


    public boolean has(String element) {
        //int hCode = hashThis(element);
        for(int i = 0; i < hList.length; i++){
            if(element.equals(strList[i])){
                return true;
            }
        }
        return false;
    }

    public int size(BinarySearchTree tree) { //getter method for getting size
        return tree.count;
    }

    public int hashThis(Object K){ //helper method for getting hashcode and % by size of array
        int x = K.hashCode(); //use built in for hash code
        int value = Math.floorMod(x, hList.length); //get % size of array
        return value; //return the position where it should go
    }

    public Object[] getInternalArray() { //getter method to return the list of objects
        return strList;
    }

    public String doubleHashThis(Object element) { //helper method for double hashing
        return Integer.toString(element.hashCode() & 0x7FFFFFFF, 36).substring(0, 3);
    }
}
