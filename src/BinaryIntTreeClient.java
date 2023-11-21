import java.util.Objects;

public class BinaryIntTreeClient {
    public static void main(String[] args) {
        BinarySearchTree<Student> tree = new BinarySearchTree<>();
        tree.add(new Student("alice", 12, 17));
        tree.add(new Student("Bob", 11, 16));
        tree.add(new Student("Claire", 10, 15));
        BinarySearchTree<Integer> tree2 = new BinarySearchTree<>();
        BinarySearchTree<String> tree3 = new BinarySearchTree<>();

        tree2.add(7);
        tree3.add("Hello");
        tree3.add("World");
        System.out.println(tree);
        System.out.println(tree2);
        System.out.println(tree3);
    }
}
