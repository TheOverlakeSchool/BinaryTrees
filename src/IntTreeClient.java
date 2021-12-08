public class IntTreeClient {
	public static void main(String[] args) {
//		IntTreeNode root = new IntTreeNode(
//				55,
//				new IntTreeNode(
//						29,
//						new IntTreeNode(-3),
//						new IntTreeNode(42)
//				),
//				new IntTreeNode(
//						87,
//						new IntTreeNode(60),
//						new IntTreeNode(91)
//				)
//		);
		IntSearchTree tree = new IntSearchTree();
		tree.add(55);
		tree.add(29);
		tree.add(87);
		tree.add(-3);
		tree.add(42);
		tree.add(60);
		tree.add(91);

		tree.print();
		System.out.println(tree.contains(91));
		System.out.println(tree.contains(7));
		tree.printSideways();
	}
}
