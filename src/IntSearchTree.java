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
		add(overallRoot, value);
	}

	private void add(IntTreeNode root, int value) {
		if (root == null) {
			root = new IntTreeNode(value);
		} else if (root.data > value) {
			add(root.left, value);
		} else {
			add(root.right, value);
		}
	}
}
