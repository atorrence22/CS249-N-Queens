/**
 * Created by Austin on 5/1/2017.
 */

import java.lang.Math;
import java.util.NoSuchElementException;

/* notes:
 "" + key turns into a string
hashmap is an array of lists

 */


public class HashMap<K, E> implements IMap<K, E> {

    int sizeCount = 0; //instance variable for size
    Object[] hList;    //instance variable for object array

    private class MapPair implements IMapPair<K, E> //nested MapPair class for handling keys and elements
    {
        public K key;
        public E element;
        public MapPair next;

        public MapPair(K key, E element) {
            this.key = key;
            this.element = element;
        }


        public K getKey() { //the next methods are to be able to use .key, .element, and .next
            return key;
        }

        public E getElement() {
            return element;
        }

        public MapPair next() {
            return next;
        }

        public String toString(){
            String toStr = key + ": " + element; //not sure how to fix the double brackets
            return toStr;
        }
    }

    public HashMap(int hSize) { //constructor with desired size
        hList = new Object[hSize];
    }

    public void put(K key, E element) {
        MapPair pair = new MapPair(key, element);
        int hashed = hashThis(key); //helper method to get hash code then % by size
        if (hList[hashed] == null){ //if there's nothing there just put it in
            hList[hashed] = pair; //puts into list
            sizeCount++; //increases the count for the size
        }else {
            MapPair cur = (MapPair) hList[hashed];
            while (cur != null){
                if (cur.key.equals(key)){
                    pair.next = cur.next; //set the next of pair to next of current
                    hList[hashed] = pair;
                    sizeCount++; //increases count for the size
                    return;
                }else {
                    pair.next = cur.next;
                    return;
                }
            }
            cur = cur.next; //set current to next of current
        }

    }

    public Object get(Object key) throws NoSuchElementException{
        int hashed = hashThis(key); //used helper method for hash code
        MapPair hCode = (MapPair) hList[hashed];
        if(hCode == null){ //if hCode is null then throw no such element
            throw new NoSuchElementException();
        }else{
            MapPair codeTemp = hCode;
            while (codeTemp != null){ //traverse through until you find the object you're looking for
                if (codeTemp.key.equals(key)){
                    return codeTemp.getElement();
                }
                codeTemp = codeTemp.next;
            }
        }
        //throw new NoSuchElementException();
        return null;
    }

    public int hashThis(Object K){ //helper method for getting hashcode and % by size of array
        int x = K.hashCode(); //use built in for hash code
        int value = Math.floorMod(x, hList.length); //get % size of array
        return value; //return the position where it should go
    }

    public int size() { //just returns the size of the array
        return sizeCount;
    }

    public Object[] getInternalArray() { //just returns the list of objects
        return hList;
    }

    public String toString(){
        String emptStr = "";
        for (int i = 0; i < hList.length; i++){
            if (hList[i] == null){

            }
            else {
                emptStr = hList[i].toString();
            }
        }
        return emptStr;
    }
}
