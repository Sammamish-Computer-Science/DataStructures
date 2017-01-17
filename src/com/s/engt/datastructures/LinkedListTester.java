
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
	
	//Tests the add() method.
	private static boolean testAdd() {
		LinkedList<String> ll = new LinkedList<String>();
		
		try {
			String data0 = "awgheawywashasdhwAehaseh";
			ll.add(data0, -1);
			return false;
		} catch(IndexOutOfBoundsException e) {}
		
		String data = "236p2oqy8ugoqwehjAW:ehj";
		ll.add(data, 0);
		if(!ll.getData(0).equals(data)) return false;
		
		String data2 = "sw9a4y8uawehwjaseh";
		ll.add(data2, 0);
		if(!ll.getData(0).equals(data2)) return false;
		
		String data3 = "73wew34shasheawehawehawehwaehawehq236q23yhwawgW@#^47aW$&";
		ll.add(data3, 2);
		if(!ll.getData(2).equals(data3)) return false;
		
		try {
			String data4 = "q263989g87sdguioawsshdseh";
			ll.add(data4, 4);
			return false;
		} catch(IndexOutOfBoundsException e) {}
		
		return true;
	}
	
	//Tests the addEnd() method.
	private static boolean testAddEnd() {
		LinkedList<String> ll = new LinkedList<String>();
		String data = "1239-67#(^W7sdghksdjl;#^QW(8w3yehsjklhjSLdhj";
		ll.addEnd(data);
		if(!ll.getLastData().equals(data)) return false;
		String data2 = "239068EGojseh#^()Q*";
		ll.addEnd(data2);
		if(!ll.getLastData().equals(data2)) return false;
		return true;
	}
	public static void main(String[] args) {
		System.out.println("Testing getLastData() returned " + testGetLastData());
		System.out.println("Testing getSecondLastData() returned " + testGetSecondLastData());
		System.out.println("Testing getData() returned " + testGetData());
		System.out.println("Testing add() returned " + testAdd());
		System.out.println("Testing addEnd() returned " + testAddEnd());
	}

}
