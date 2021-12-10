import java.util.NoSuchElementException;

public class IntSearchTree {
	private IntTreeNode overallRoot;

	IntSearchTree() {

	}

	IntSearchTree(IntTreeNode root) {
		this.overallRoot = root;
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

	public boolean contains(int value) {
		return contains(overallRoot, value);
	}

	private boolean contains(IntTreeNode root, int value) {
		if (root == null) {
			return false;
		} else if (root.data == value) {
			return true;
		} else if (root.data < value) {
			return contains(root.right, value);
		} else {
			return contains(root.left, value);
		}
	}

	public void printSideways() {
		printSideways(overallRoot, "");
	}

	private void printSideways(IntTreeNode root, String indent) {
		if (root != null) {
			printSideways(root.right, indent + "\t");
			System.out.println(indent + root.data);
			printSideways(root.left, indent + "\t");
		}
	}

	public void add(int value) {
		overallRoot = add(overallRoot, value);
	}

	private IntTreeNode add(IntTreeNode root, int value) {
		if (root == null) {
			root = new IntTreeNode(value);
		} else if (root.data > value) {
			root.left = add(root.left, value);
		} else {
			root.right = add(root.right, value);
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
		if (root.left == null) {
			return root.data;
		} else {
			return getMin(root.left);
		}
	}

	private static class IntTreeNode {
		public int data;
		public IntTreeNode left;
		public IntTreeNode right;

		IntTreeNode(int data) {
			this(data, null, null);
		}

		IntTreeNode(int data, IntTreeNode left, IntTreeNode right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
}
