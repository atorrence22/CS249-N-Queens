// This represents a simplified set interface to be implemented as a hash set
// for CS249.
public interface ISet<E> {

    ////////////////////////////////////////////////////////////////////////////
    // Public interface

    // Constructor
    // Ensure you have a constructor that takes an integer for the expected
    // number of items to be added to the Map.  The size of your intenral array
    // and load metrics will be based on this expdected size.
    // ISet(int expected_size);

    // Adds an element into the set.  Should there be a collision with an
    // existing element, use double hashing. To perform this double hashing
    // convert your hash into a string and retrive that string's hash.
    void add(E element);

    // returns true if the provided item has already been added.
    boolean has(E element);

    // Returns the number of elements added to the set.
    int size();

    // Returns this list in string form, surrounded by [] brackets and with each
    // items separated by a comma and space.  For example:
    // [Thing, Other, Object, Entry]
    // you should output them in the order of the internal representation.
    String toString();

    ////////////////////////////////////////////////////////////////////////////
    // Private interface
    //
    // Normally, everything past this point would be private.  For the sake of
    // testing in CS249, however, all of these must be provided as public.

    // Retruns the internal array used to store the hash table.
    // Note: This returns an Object[] array as creating an array using the
    // generic placeholder type  E is not supported by java.  None the
    // less, this array must be populated with objects of class E.
    Object[] getInternalArray();

}
