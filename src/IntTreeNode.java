public class IntTreeNode {
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
