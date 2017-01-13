
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
	
	//Tests the getData() method.
	//Returns whether the operation succeeded or not.
	private static boolean testGetData() {
		LinkedList<String> ll = new LinkedList<String>();
		try {
			ll.getData(-1);
			return false;
		} catch(IndexOutOfBoundsException e) {}
		
		String data = "^(QYOEHsdygw36#w36A%^30AEGH#^3690Y*Q23yY#(#";
		ll.addEnd(data);
		if(!ll.getData(0).equals(data)) return false;
		
		try {
			ll.getData(1);
			return false;
		} catch(IndexOutOfBoundsException e) {}
		
		String data2 = "#W^DGSw3yehs#yuwrwejhD#^*(";
		ll.addEnd(data2);
		if(!ll.getData(1).equals(data2)) return false;
		
		return true;
	}
	public static void main(String[] args) {
		System.out.println("Testing getLastData() returned " + testGetLastData());
		System.out.println("Testing getSecondLastData() returned " + testGetSecondLastData());
	}

}
