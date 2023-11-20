import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class BinarySearchTree {

    private TreeNode overallRoot;

    public String toString() {
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        print(overallRoot, sj);
        return sj.toString();
    }

    private void print(TreeNode root, StringJoiner sj) {
        if (root != null) {
            print(root.left, sj);
            sj.add(root.student.toString());
            print(root.right, sj);
        }
    }

    public boolean contains(Student student) {
        return contains(overallRoot, student);
    }

    private boolean contains(TreeNode root, Student student) {
        return root != null && (root.student.equals(student) || (root.student.compareTo(student) > 0 ? contains(root.left, student) : contains(root.right, student)));
    }

    public void add(Student student) {
        overallRoot = add(overallRoot, student);
    }

    private TreeNode add(TreeNode root, Student student) {
        if (root == null) {
            root = new TreeNode(student);
        } else {
            if (root.student.compareTo(student) > 0) {
                root.left = add(root.left, student);
            } else if(root.student.compareTo(student) < 0) {
                root.right = add(root.right, student);
            }
        }
        return root;
    }

    public Student getMin() {
        if (overallRoot == null) {
            throw new NoSuchElementException();
        }
        return getMin(overallRoot);
    }

    private Student getMin(TreeNode root) {
        return root.left == null ? root.student : getMin(root.left);
    }

    public void remove(Student student) {
        overallRoot = remove(overallRoot, student);
    }

    private TreeNode remove(TreeNode root, Student student) {
        if (root != null) {
            if (root.student.compareTo(student) < 0) {
                root.right = remove(root.right, student);
            } else if (root.student.compareTo(student) > 0) {
                root.left = remove(root.left, student);
            } else {
                if (root.left == null && root.right == null) {
                    root = null;
                } else if (root.left != null && root.right == null) {
                    root = root.left;
                } else if (root.left == null && root.right != null) {
                    root = root.right;
                } else {
                    Student min = getMin(root.right);
                    remove(min);
                    root.student = min;
                }
            }

        }
        return root;
    }

    private class TreeNode {
        public Student student;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(Student student) {
            this(student, null, null);
        }

        public TreeNode(Student student, TreeNode left, TreeNode right) {
            this.student = student;
            this.left = left;
            this.right = right;
        }

    }
}

