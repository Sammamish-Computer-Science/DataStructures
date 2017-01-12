
public class LinkedListTester {
	
	//Tests the getLastData() method.
	//Returns whether the operation succeeds or not.
	private static boolean testGetLastData() {
		LinkedList<String> ll = new LinkedList<String>();
		if(ll.getLastData() != null) return false;
		String data = "g;awuophuwzekl;nhjAW:eh";
		ll.addEnd(data);
		return ll.getLastData().equals(data);
	}
	public static void main(String[] args) {
		System.out.println("Testing getLastData() returned " + testGetLastData());
		
	}

}
