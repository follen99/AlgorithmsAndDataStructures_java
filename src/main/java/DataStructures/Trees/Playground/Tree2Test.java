package DataStructures.Trees.Playground;

public class Tree2Test {
    public static void main(String[] args) {
        Tree2 tree = new Tree2();
        tree.add(6);
        tree.add(4);
        tree.add(8);
        tree.add(3);
        tree.add(5);
        tree.add(2);
        tree.add(1);

        tree.delete(4);

        tree.printAll();

        System.out.println(tree.findRecursive(50));

    }
}
