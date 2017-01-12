
public class LinkedListTester {
	
	//Tests the getLastData() method.
	//Returns whether the operation succeeded or not.
	private static boolean testGetLastData() {
		LinkedList<String> ll = new LinkedList<String>();
		if(ll.getLastData() != null) return false;
		String data = "g;awuophuwzekl;nhjAW:eh";
		ll.addEnd(data);
		return ll.getLastData().equals(data);
	}
	
	//Tests the getSecondLastData() method.
	//Returns whether the operation succeeded or not.
	private static boolean testGetSecondLastData() {
		LinkedList<String> ll = new LinkedList<String>();
		if(ll.getSecondLastData() != null) return false;
		String data = "wetopuwopaeyuweaopy";
		ll.addEnd(data);
		if(ll.getSecondLastData() != null) return false;
		String data2 = "2306972q9y78@#(*&^(!*@#^UHY(Q@^*BEwehyo2uy";
		ll.addEnd(data2);
		return ll.getSecondLastData().equals(data);
	}
	public static void main(String[] args) {
		System.out.println("Testing getLastData() returned " + testGetLastData());
		System.out.println("Testing getSecondLastData() returned " + testGetSecondLastData());
	}

}
