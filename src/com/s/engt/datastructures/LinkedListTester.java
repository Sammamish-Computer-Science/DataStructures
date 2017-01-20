import java.util.Random;
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
	
	//Tests the delete() method.
	private static boolean testDelete() {
		LinkedList<String> ll = new LinkedList<String>();
		
		String data = randString();
		ll.addEnd(data);
		
		String data2 = randString();
		ll.addEnd(data2);
		
		String data3 = randString();
		ll.addEnd(data3);
		
		if(!ll.delete(1).equals(data2)) return false;
		if(!ll.delete(0).equals(data)) return false;
		if(!ll.delete(0).equals(data3)) return false;
		return true;
	}
	
	//Tests the deleteEnd() method.
	private static boolean testDeleteEnd() {
		LinkedList<String> ll = new LinkedList<String>();
		String datas[] = new String[(new Random()).nextInt(Byte.MAX_VALUE)];
		for(int i = 0; i < datas.length; i++) {
			datas[i] = randString();
			ll.addEnd(datas[i]);
		}
		for(int i = datas.length; i > 0; i--) {
			if(!ll.deleteEnd().equals(datas[i-1])) return false;
		}
		return true;
	}
	//Tests the getSize() method.
	private static boolean testGetSize() {
		LinkedList<String> ll = new LinkedList<String>();
		if(ll.getSize() != 0) return false;
		ll.addEnd(randString());
		if(ll.getSize() != 1) return false;
		ll.delete(0);
		if(ll.getSize() != 0) return false;
		return true;
	}
	public static void main(String[] args) {
		System.out.println("Testing getLastData() returned " + testGetLastData());
		System.out.println("Testing getSecondLastData() returned " + testGetSecondLastData());
		System.out.println("Testing getData() returned " + testGetData());
		System.out.println("Testing add() returned " + testAdd());
		System.out.println("Testing addEnd() returned " + testAddEnd());
		System.out.println("Testing delete() returned " + testDelete());
		System.out.println("Testing deleteEnd() returned " + testDeleteEnd());
		System.out.println("Testing getSize() returned " + testGetSize());
	}

}
