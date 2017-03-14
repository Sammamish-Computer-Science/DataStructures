
public class QuestionNode<T> {
	private T m_data;
	private QuestionNode<T> m_left;
	private QuestionNode<T> m_right;
	public QuestionNode(T data, QuestionNode<T> left, QuestionNode<T> right) {
		setData(data);
		setLeft(left);
		setRight(right);
	}
	public void setLeft(QuestionNode<T> left) {
		m_left = left;
	}
	public void setRight(QuestionNode<T> right) {
		m_right = right;
	}
	public void setData(T data) {
		m_data = data;
	}
	public QuestionNode<T> getLeft() {
		return m_left;
	}
	public QuestionNode<T> getRight() {
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
