import java.util.UUID;

public class LinkedListTester {
	
	//Generates a random string
	private static String randString() {
		return UUID.randomUUID().toString();
	}
	
	//Tests the getLastData() method.
	//Returns whether the operation succeeded or not.
	private static boolean testGetLastData() {
		LinkedList<String> ll = new LinkedList<String>();
		if(ll.getLastData() != null) return false;
		String data = randString();
		ll.addEnd(data);
		return ll.getLastData().equals(data);
	}
	
	//Tests the getSecondLastData() method.
	//Returns whether the operation succeeded or not.
	private static boolean testGetSecondLastData() {
		LinkedList<String> ll = new LinkedList<String>();
		if(ll.getSecondLastData() != null) return false;
		String data = randString();
		ll.addEnd(data);
		if(ll.getSecondLastData() != null) return false;
		String data2 = randString();
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
		
		String data = randString();
		ll.addEnd(data);
		if(!ll.getData(0).equals(data)) return false;
		
		try {
			ll.getData(1);
			return false;
		} catch(IndexOutOfBoundsException e) {}
		
		String data2 = randString();
		ll.addEnd(data2);
		if(!ll.getData(1).equals(data2)) return false;
		
		return true;
	}
	
	//Tests the add() method.
	private static boolean testAdd() {
		LinkedList<String> ll = new LinkedList<String>();
		
		try {
			String data0 = randString();
			ll.add(data0, -1);
			return false;
		} catch(IndexOutOfBoundsException e) {}
		
		String data = randString();
		ll.add(data, 0);
		if(!ll.getData(0).equals(data)) return false;
		
		String data2 = randString();
		ll.add(data2, 0);
		if(!ll.getData(0).equals(data2)) return false;
		
		String data3 = randString();
		ll.add(data3, 2);
		if(!ll.getData(2).equals(data3)) return false;
		
		try {
			String data4 = randString();
			ll.add(data4, 4);
			return false;
		} catch(IndexOutOfBoundsException e) {}
		
		return true;
	}
	
	//Tests the addEnd() method.
	private static boolean testAddEnd() {
		LinkedList<String> ll = new LinkedList<String>();
		String data = randString();
		ll.addEnd(data);
		if(!ll.getLastData().equals(data)) return false;
		String data2 = randString();
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
