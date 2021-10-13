package DataStructures.Maps.HashTable;

public class Tester {
    public static void main(String[] args) {
        HashTableArray<String> hm = new HashTableArray<>(10);


        hm.put(10, "peppe");
        hm.put(100, "luigi");
        hm.put(1000, "antonello");

        //10, 100 e 1000 mappano tutti sulla stessa posizione: 0

        hm.remove(10);

        System.out.println(hm.get(10));
        System.out.println(hm.get(100));
        System.out.println(hm.get(1000));

    }
}


