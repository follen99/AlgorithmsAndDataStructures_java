package DataStructures.Maps.HashTable;

public class Entry {
    protected int key;
    protected Object value;
    protected Entry next;

    public Entry(int key, Object value){
        this.key = key;
        this.value = value;
        this.next = null;
    }

    public Entry(){
        this.next = null;
        this.value = null;
    }
}
