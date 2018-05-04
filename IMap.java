// This represents a simplified map interface to be implemented as a hash map
// for CS249.
public interface IMap<K,E> {

    ////////////////////////////////////////////////////////////////////////////
    // Public interface

    // Constructor
    // Ensure you have a constructor that takes an integer for the expected
    // number of items to be added to the Map.  The size of your intenral array
    // and load metrics will be based on this expdected size.
    // IMap(int expected_size);

    // creates a key element pair and adds it into the hash array.
    void put(K key, E element);

    // retrives an element from the hash array based on the key.
    // throws a NoSuchElementException if no such key exists.
    E get(K key);

    // Returns the number of elements in this list.
    int size();

    // Returns this list in string form, surrounded by [] brackets and with each
    // items separated by a comma and space.  For example:
    // [First, Second, Third, Fourth]
    String toString();

    ////////////////////////////////////////////////////////////////////////////
    // Private interface
    //
    // Normally, everything past this point would be private.  For the sake of
    // testing in CS249, however, all of these must be provided as public.

    // These objects represent a mapping from a key to a key to an element.
    // Multiple objects hashed into the same buckets must also be linked through
    // these pair objects.
    public interface IMapPair<K,E>
    {
      // Retrives the key for this pair.
      K getKey();

      // Retrives the element corresponding to the key.
      E getElement();

      // This should return the next pair with a hash collision.
      IMapPair next();

      // returns this pair as a combination between keys and elements in the
      // folowing form:
      // Key: Element
      // where Key and Element are determined based on the toString of those
      // parts.
      String toString();

    }

    // Retrives the internal pair array used for this Map.  This should be
    // sized based on the capacity passed to the constructor.
    // Note: This returns an Object[] array as creating an array using the
    // generic placeholder types K and E is not supported by java.  None the
    // less, this array must be populated with IMapPair<K,E> objects.
    Object[] getInternalArray();


}
