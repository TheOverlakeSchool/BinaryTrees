import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class BinarySearchTree<T extends Comparable<T>> {

    private TreeNode<T> overallRoot;
    private Comparator<T> comparator;

    public BinarySearchTree(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public BinarySearchTree() {
        this(null);
    }

    public String toString() {
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        print(overallRoot, sj);
        return sj.toString();
    }

    private void print(TreeNode<T> root, StringJoiner sj) {
        if (root != null) {
            print(root.left, sj);
            sj.add(root.value.toString());
            print(root.right, sj);
        }
    }

    public boolean contains(T value) {
        return contains(overallRoot, value);
    }

    private boolean contains(TreeNode<T> root, T value) {
        return root != null && (root.value.equals(value) || (compare(root, value) > 0 ? contains(root.left, value) : contains(root.right, value)));
    }

    private int compare(TreeNode<T> root, T value) {
        return comparator == null ? root.value.compareTo(value) : comparator.compare(root.value, value);
    }

    public void add(T value) {
        overallRoot = add(overallRoot, value);
    }

    private TreeNode<T> add(TreeNode<T> root, T value) {
        if (root == null) {
            root = new TreeNode<T>(value);
        } else {
            if (compare(root, value) > 0) {
                root.left = add(root.left, value);
            } else if(compare(root, value) < 0) {
                root.right = add(root.right, value);
            }
        }
        return root;
    }

    public T getMin() {
        if (overallRoot == null) {
            throw new NoSuchElementException();
        }
        return getMin(overallRoot);
    }

    private T getMin(TreeNode<T> root) {
        return root.left == null ? root.value : getMin(root.left);
    }

    public void remove(T value) {
        overallRoot = remove(overallRoot, value);
    }

    private TreeNode<T> remove(TreeNode<T> root, T value) {
        if (root != null) {
            if (compare(root, value) < 0) {
                root.right = remove(root.right, value);
            } else if (compare(root, value) > 0) {
                root.left = remove(root.left, value);
            } else {
                if (root.left == null && root.right == null) {
                    root = null;
                } else if (root.left != null && root.right == null) {
                    root = root.left;
                } else if (root.left == null && root.right != null) {
                    root = root.right;
                } else {
                    T min = getMin(root.right);
                    remove(min);
                    root.value = min;
                }
            }

        }
        return root;
    }

    private class TreeNode<T> {
        public T value;
        public TreeNode<T> left;
        public TreeNode<T> right;

        public TreeNode(T value) {
            this(value, null, null);
        }

        public TreeNode(T value, TreeNode<T> left, TreeNode<T> right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

    }
}

