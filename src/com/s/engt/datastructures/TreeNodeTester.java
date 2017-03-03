
public class TreeNodeTester {

	private static boolean checkLeft(TreeNode<String> root, TreeNode<String> expected) {
		boolean leftCorrect;
		TreeNode<String> rootLeft = root.getLeft();
		if(rootLeft == null) {
			leftCorrect = expected == null;
		} else {
			leftCorrect = rootLeft.equals(expected);
		}
		if(!leftCorrect) {
			System.err.println("Root's left attribute is wrong!");
		}
		return leftCorrect;
	}
	private static boolean checkRight(TreeNode<String> root, TreeNode<String> expected) {
		boolean rightCorrect;
		TreeNode<String> rootRight = root.getRight();
		if(rootRight == null) {
			rightCorrect = expected == null;
		} else {
			rightCorrect = rootRight.equals(expected);
		}
		if(!rightCorrect) {
			System.err.println("Root's right attribute is wrong!");
		}
		return rightCorrect;
	}
	private static boolean checkData(TreeNode<String> root, String expected) {
		boolean dataCorrect;
		String rootData = root.getData();
		if(rootData == null) {
			dataCorrect = expected == null;
		} else {
			dataCorrect = rootData.equals(expected);
		}
		if(!dataCorrect) {
			System.err.println("Root's data attribute is wrong!");
		}
		return dataCorrect;
	}
	public static void main(String[] args) {
		TreeNode<String> root = new TreeNode<String>("Root", null, null);
		checkLeft(root, null);
		checkRight(root, null);
		checkData(root, "Root");
		
		/*
		 * Tree:
		 *          Root
		 *         /    \
		 *        Left  Right
		 *       /      /   \
		 *      A      C     D
		 *       \            \
		 *        B            E
		 */
		TreeNode<String> left = new TreeNode<String>("Left", new TreeNode<String>("A", null, new TreeNode<String>("B", null, null)), null);
		root.setLeft(left);
		
		TreeNode<String> right = new TreeNode<String>("Right", new TreeNode<String>("C", null, null), new TreeNode<String>("D", null, new TreeNode<String>("E", null, null)));
		root.setRight(right);
		
		checkLeft(root, left);
		checkRight(root, right);
		
		root.processTreePreOrder();
		System.out.println();
		root.processTreeInOrder();
		System.out.println();
		root.processTreePostOrder();
	}
	
}
