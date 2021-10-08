/**
 * @author giuliano ranauro
 * Date: 08/10/2021 15:42
 * Ide: Intellij
 * JDK: 1.8
 * @version 1.0
 */
package DataStructures.UnionFind;

public class UF {
    private int[] parent;
    private byte[] rank;
    private int count;

    public UF(int size){
        if (size<=0) throw new IllegalArgumentException("Cannot create a negative size structure");

        count = size;
        parent = new int[size]; //creo un array di grandezza specifica
        rank = new byte[size];

        for (int i = 0; i<size ;i++){   //inizializzo gli array
            parent[i] = i;
            rank[i] = 0;
        }
    }
    public int find(int p){

        while (p != parent[p]){ //finchè il numero da trovare è diverso da se stesso (?) , quindi finchè non lo trovo...
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public void union(int p, int q){
        int rootP = this.find(p);
        int rootQ = this.find(q);
        if (rootP == rootQ) return;

        if      (rank[rootP] < rank[rootQ]) parent[rootP] = rootQ;
        else if (rank[rootP] > rank[rootQ]) parent[rootQ] = rootP;
        else {
            parent[rootQ] = rootP;
            rank[rootP]++;
        }
        count--;
    }

    public int count() {
        return count;
    }
}
