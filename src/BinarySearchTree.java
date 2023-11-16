import java.util.NoSuchElementException;

public class BinarySearchTree {

    private IntTreeNode overallRoot;

    public BinarySearchTree() {
        IntTreeNode left = new IntTreeNode(29, null, new IntTreeNode(42, new IntTreeNode(36), null));
        IntTreeNode right = new IntTreeNode(87, new IntTreeNode(60, null, new IntTreeNode(73)), new IntTreeNode(91));
        overallRoot = new IntTreeNode(55, left, right);
    }

    public void print() {
        print(overallRoot);
    }

    private void print(IntTreeNode root) {
        if (root != null) {
            print(root.left);
            System.out.print(root.data + " ");
            print(root.right);
        }
    }

    public boolean contains(int i) {
        return contains(overallRoot, i);
    }

    private boolean contains(IntTreeNode root, int i) {
        return root != null && (root.data == i || (root.data > i ? contains(root.left, i) : contains(root.right, i)));
    }

    public void printSideways() {
        printSideways(overallRoot, 0);
    }

    private void printSideways(IntTreeNode root, int indent) {
        if (root != null) {
            printSideways(root.right, indent + 1);
            for (int i = 0; i < indent * 4; i++) {
                System.out.print(" ");
            }
            System.out.println(root.data);
            printSideways(root.left, indent + 1);
        }
    }

    public void add(int value) {
        overallRoot = add(overallRoot, value);
    }

    private IntTreeNode add(IntTreeNode root, int value) {
        if (root == null) {
            root = new IntTreeNode(value);
        } else {
            if (root.data > value) {
                root.left = add(root.left, value);
            } else if(root.data < value) {
                root.right = add(root.right, value);
            }
        }
        return root;
    }

    public int getMin() {
        if (overallRoot == null) {
            throw new NoSuchElementException();
        }
        return getMin(overallRoot);
    }

    private int getMin(IntTreeNode root) {
        return root.left == null ? root.data : getMin(root.left);
    }

    public void remove(int value) {
        overallRoot = remove(overallRoot, value);
    }

    private IntTreeNode remove(IntTreeNode root, int value) {
        if (root != null) {
            if (root.data < value) {
                root.right = remove(root.right, value);
            } else if (root.data > value) {
                root.left = remove(root.left, value);
            } else {
                if (root.left == null && root.right == null) {
                    root = null;
                } else if (root.left != null && root.right == null) {
                    root = root.left;
                } else if (root.left == null && root.right != null) {
                    root = root.right;
                } else {
                    int min = getMin(root.right);
                    remove(min);
                    root.data = min;
                }
            }

        }
        return root;
    }

    private class IntTreeNode {
        public int data;
        public IntTreeNode left;
        public IntTreeNode right;

        public IntTreeNode(int data) {
            this(data, null, null);
        }

        public IntTreeNode(int data, IntTreeNode left, IntTreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

    }
}

