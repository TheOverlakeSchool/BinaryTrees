public class IntTreeClient {
	public static void main(String[] args) {
		IntTreeNode root = new IntTreeNode(
				17,
				new IntTreeNode(
						41,
						new IntTreeNode(29),
						new IntTreeNode(6)
				),
				new IntTreeNode(
						9,
						new IntTreeNode(81),
						new IntTreeNode(40)
				)
		);
		IntTree tree = new IntTree(root);
		tree.print();
		System.out.println(tree.contains(81));
		System.out.println(tree.contains(7));
		tree.printSideways();
	}
}
