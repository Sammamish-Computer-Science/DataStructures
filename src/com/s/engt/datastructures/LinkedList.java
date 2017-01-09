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
	
	//Adds a node immediately after the node c, holding the data t. After adding, the current node m_cur will now point to the added node.
	//If addHead is true, adds to the beginning and does not read c.
	public void add(Node<T> c, T t, boolean addHead) {
		Node<T> newnode;
		if(addHead) {
			newnode = new Node<T>(m_head.m_next, t);
		} else {
			newnode = new Node<T>(m_cur.m_next, t);
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
	public T delete(Node<T> prev, Node<T> del, boolean delHead) {
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
	
	//Finds the second to last node in this list.
	public Node<T> getSecondLast() {
		Node<T> cur;
		for(cur = m_head.m_next; cur != null && cur.m_next != null && cur.m_next.m_next != null; cur = cur.m_next) {
		}
		return cur;
	}
	
	//Finds the last node in this list.
	public Node<T> getLast() {
		Node<T> cur;
		for(cur = m_head.m_next; cur.m_next != null; cur = cur.m_next) {
		}
		return cur;
	}
	
	public static void main(String[] args) {
		LinkedList<String> ll = new LinkedList<String>();
		ll.add(null, "Hello, ", true);
		System.out.println("Data: " + ll.m_head.m_next.m_data);
		System.out.println("Size: " + ll.m_size);
		ll.add(ll.m_head.m_next.m_next, "World", false);
		System.out.println("Data: " + ll.m_head.m_next.m_next.m_data);
		System.out.println("Size: " + ll.m_size);
		System.out.println("Deleted Data: " + ll.delete(ll.m_head.m_next, ll.m_head.m_next.m_next, false));
		System.out.println("Size: " + ll.m_size);
		System.out.println("Deleted Data: " + ll.delete(ll.m_head.m_next, ll.m_head.m_next, true));
		System.out.println("Size: " + ll.m_size);
		System.out.println("Deleted Data: " + ll.delete(ll.m_head.m_next, ll.m_head.m_next, true));
		System.out.println("Size: " + ll.m_size);
	}
}
