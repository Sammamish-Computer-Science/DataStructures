import LinkedList.Head;
import LinkedList.Node;

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
	
	//Adds data t at the specified index. Automatically shifts other nodes to the right if needed.
	//Throws IndexOutOfBoundsException if the index is out of bounds (index < 0 || index > size).
	public void add(T t, int index) {
		if(index == 0) {
			add(null, t, true);
			return;
		}
		Node<T> c = get(index - 1);
		add(c, t, false);
	}
	
	//Adds a node immediately after the node c, holding the data t. After adding, the current node m_cur will now point to the added node.
	//If addHead is true, adds to the beginning and does not read the value of c.
	private void add(Node<T> c, T t, boolean addHead) {
		Node<T> newnode;
		if(addHead) {
			newnode = new Node<T>(m_head.m_next, t);
			m_head.m_next = newnode;
		} else {
			newnode = new Node<T>(c.m_next, t);
			c.m_next = newnode;
		}
		m_cur = newnode;
		m_size++;
	}
	
	//Utility method to add a node to the end of this list.
	public void addEnd(T t) {
		Node<T> last = getLast();
		add(last, t, last == null);
	}
	
	//Deletes the node del and returns the data it held. After deleting, the current node m_cur will now point to prev.
	//If delHead is true, deletes the node after head and does not read the value of prev.
	private T delete(Node<T> prev, Node<T> del, boolean delHead) {
		if(m_size < 1) {
			System.err.println("Cannot delete from an empty Linked List!");
			return null;
		}
		if(delHead) {
			m_head.m_next = del.m_next;
		} else {
			prev.m_next = del.m_next;
		}
		del.m_next = null; //Make sure that the deleted node doesn't point to part of the LinkedList anymore.
		m_size--;
		m_cur = prev;
		T data = del.m_data;
		del = null;
		return data;
	}
	
	public T deleteEnd() {
		Node<T> secondLast = getSecondLast();
		if(secondLast == null) return delete(secondLast, secondLast, true);
		return delete(secondLast, secondLast.m_next, false);
	}
	
	//Finds the last node in this list.
	private Node<T> getLast() {
		Node<T> cur;
		for(cur = m_head.m_next; cur != null && cur.m_next != null; cur = cur.m_next) {
		}
		return cur;
	}
	
	//Finds the second to last node in this list.
	private Node<T> getSecondLast() {
		if(m_size < 2) return null;
		Node<T> cur;
		for(cur = m_head.m_next; cur.m_next.m_next != null; cur = cur.m_next) {
		}
		return cur;
	}
	//Gets the n-th node in the list (zero-based).
	private Node<T> get(int index) {
		if(index < 0 || index > m_size-1) throw new IndexOutOfBoundsException("LinkedList index out of bounds!");
		Node<T> cur = m_head.m_next;
		for(int i = 0; i < index; i++, cur = cur.m_next);
		return cur;
	}
	
	//Gets the data of the n-th node in the list (zero-based).
	public T getData(int index) {
		return get(index).m_data;
	}
		
	//Finds the data of the last node in this list.
	public T getLastData() {
		Node<T> last = getLast();
		if(last != null) return last.m_data;
		return null;
	}
	
	//Finds the data of the second to last node in this list.
	public T getSecondLastData() {
		Node<T> secondlast = getSecondLast();
		if(secondlast != null) return secondlast.m_data;
		return null;
	}

	//Finds the size of the LinkedList.
	public int getSize() {
		return m_size;
	}
}
