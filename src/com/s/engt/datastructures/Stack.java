import java.util.ArrayList;

public class Stack<T> {
	private ArrayList<T> m_data;
	//Creates an empty Stack
	public Stack() {
		m_data = new ArrayList<T>();
	}
	//Pushes an element onto the stack
	public void push(T t) {
		m_data.add(t);
	}
	//Pops an element off of the stack
	public T pop() {
		return m_data.remove(m_data.size()-1);
	}
	//Peeks at the element on top of the stack. Does not alter the stack in any way
	public T peek() {
		return m_data.get(m_data.size()-1);
	}
	//Returns whether the stack is empty or not
	public boolean isEmpty() {
		return m_data.isEmpty();
	}
	//Returns the size of the stack
	public int size() {
		return m_data.size();
	}
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		System.out.println(s.isEmpty());
		s.push(5);
		System.out.println(s.isEmpty());
		s.push(3);
		System.out.println(s.peek());
		System.out.println(s.size());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.isEmpty());
	}
	static class A {
		private void t() {
			System.out.println("hello");
		}
	}
	static class B extends A {
	}
}
