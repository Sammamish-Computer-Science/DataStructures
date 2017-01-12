
public class LinkedListTester<T> {
	private LinkedList<T> m_ll;
	private LinkedListTester(LinkedList<T> ll) {
		m_ll = ll;
	}
	public static void main(String[] args) {
		LinkedListTester<String> llt = new LinkedListTester<String>(new LinkedList<String>());
		
	}

}
