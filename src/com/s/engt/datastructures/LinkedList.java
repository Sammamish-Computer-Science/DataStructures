/*
 * An implementation of a LinkedList, where T is the type of data held.
 */
public class LinkedList<T> {
	/*
	 * A single node in the LinkedList.
	 */
	private class Node<T> {
		private Node<T> m_next;
		private T m_data;
		private Node(Node<T> next, T data) {
			m_next = next;
			m_data = data;
		}
	}
	private class Head {
		private Node<T> m_next;
		private Head(Node<T> next) {
			m_next = next;
		}
	}
	
	private Head m_head; //"Pointer" to head of the LinkedList.
	private Node<T> m_cur; //"Pointer" to the current node.
	private int m_size;
	
	//A constructor to create an empty LinkedList.
	public LinkedList() {
		m_cur = null;
		m_head = new Head(m_cur);
		m_size = 0;
	}
	
	public static void main(String[] args) {
	}
}
