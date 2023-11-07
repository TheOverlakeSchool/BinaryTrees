public class BinaryIntTree {

    private IntTreeNode overallRoot;

    public BinaryIntTree() {
        IntTreeNode left = new IntTreeNode(41, new IntTreeNode(29), new IntTreeNode(6));
        IntTreeNode right = new IntTreeNode(9, new IntTreeNode(81), new IntTreeNode(40));
        overallRoot = new IntTreeNode(17, left, right);
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
        return root != null && (root.data == i || contains(root.left, i) || contains(root.right, i));
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

