import java.util.Objects;

public class BinaryIntTreeClient {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.remove(73);
        tree.remove(29);
        tree.remove(87);
        tree.remove(55);
        tree.printSideways();
    }
}
