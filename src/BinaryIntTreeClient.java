import java.util.Objects;

public class BinaryIntTreeClient {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(new Student("alice", 12, 17));
        tree.add(new Student("Bob", 11, 16));
        tree.add(new Student("Claire", 10, 15));
        System.out.println(tree);
    }
}
