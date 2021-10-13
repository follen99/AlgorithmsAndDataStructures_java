package DataStructures.Maps.HashTable;

/**
 * Implementazione della hash table,
 * Questa implementazione è veramente molto semplice, è stata ispirata dal video: https://www.youtube.com/watch?v=SdqN_s-0ZYY&ab_channel=STMEducationPlanet
 * */
public class HashTableArray<T> {
    private Entry[] arrayHash;
    private int size;

    public HashTableArray(int size){
        this.size = size;
        arrayHash = new Entry[size];

        //inizializzo l'array
        for (int i = 0; i<size; i++)
            arrayHash[i] = new Entry();
    }

    int getHash(int key){
        return key % size;
    }

    public void put(int key, Object value){
        int hashIndex = this.getHash(key);      // calcolo l'hash mappato sulla size
        Entry arrayVal = arrayHash[hashIndex];  //salvo il primo elemento della linked list nell'indice dell'array

        Entry newItem = new Entry(key, value); //il nuovo oggetto

        newItem.next = arrayVal.next;
        arrayVal.next = newItem;
    }

    public T get(int key){
        T value = null;

        int hashIndex = this.getHash(key);
        Entry arrayValue = arrayHash[hashIndex];

        while (arrayValue != null) {
            if (arrayValue.key == key){
                value = (T) arrayValue.value;
            break;
            }
            arrayValue = arrayValue.next;       //scorro la lista
        }

        return value;
    }

    public T remove(int key){
        T valToRemove = null;

        int hashIndex = this.getHash(key);
        Entry curr = arrayHash[hashIndex];

        if (curr.value == null && curr.next == null) //se l'elemento non esiste
            return null;

        while (arrayHash!= null) {
            if (curr.next.key == key) {
                valToRemove = (T) curr.next.value;
                if (curr.next.next != null) {
                    curr.next = curr.next.next;
                } else curr.next = null;
                break;
            }
            curr = curr.next;
        }
        return valToRemove;
    }
}
