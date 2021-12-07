public class IntTree {
	private IntTreeNode overallRoot;

	IntTree(IntTreeNode root) {
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
		return root != null && (root.data == value || contains(root.left, value) || contains(root.right, value));
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
}
