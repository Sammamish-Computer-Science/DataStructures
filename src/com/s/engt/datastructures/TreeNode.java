
public class TreeNode<T> {
	private T m_data;
	private TreeNode<T> m_left;
	private TreeNode<T> m_right;
	public TreeNode(T data, TreeNode<T> left, TreeNode<T> right) {
		m_data = data;
		m_left = left;
		m_right = right;
	}
}
