/**
 * @author giuliano ranauro
 * Date: 08/10/2021 15:59
 * Ide: Intellij
 * JDK: 1.8
 * @version 1.0
 */
package DataStructures.UnionFind;

public class Tester {
    public static void main(String[] args) {
        int n = 6;      //size
        UF uf = new UF(n);

        int[] array = new int[6];

        for(int i = 0; i<5; i++){
            array[i] = i+1;
            System.out.println(i+1);
        }

        for(int i = 0; i<5; i++){
            int p = array[i];
            int q = array[i+1];
            i++;
            if (uf.find(p) == uf.find(q)) continue;
            uf.union(p, q);
            System.out.println(p + " " + q);
        }
        System.out.println(uf.count() + " components");
    }
}
