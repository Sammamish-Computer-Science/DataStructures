
public class TreeNode<T> {
	private T m_data;
	private TreeNode<T> m_left;
	private TreeNode<T> m_right;
	public TreeNode(T data, TreeNode<T> left, TreeNode<T> right) {
		setData(data);
		setLeft(left);
		setRight(right);
	}
	public void setLeft(TreeNode<T> left) {
		m_left = left;
	}
	public void setRight(TreeNode<T> right) {
		m_right = right;
	}
	public void setData(T data) {
		m_data = data;
	}
	public TreeNode<T> getLeft() {
		return m_left;
	}
	public TreeNode<T> getRight() {
		return m_right;
	}
	public T getData() {
		return m_data;
	}
	public void processTreePreOrder() {
		processNode();
		if(m_left != null)
			m_left.processTreePreOrder();
		if(m_right != null)
			m_right.processTreePreOrder();
	}
	public void processTreeInOrder() {
		if(m_left != null)
			m_left.processTreeInOrder();
		processNode();
		if(m_right != null)
			m_right.processTreeInOrder();
	}
	public void processTreePostOrder() {
		if(m_left != null)
			m_left.processTreePostOrder();
		if(m_right != null)
			m_right.processTreePostOrder();
		processNode();
	}
	public void processNode() {
		System.out.print(m_data + " ");
	}
}
