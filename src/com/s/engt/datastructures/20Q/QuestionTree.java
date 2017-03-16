import java.io.PrintStream;
import java.util.Scanner;

public class QuestionTree {
	private QuestionNode<String> m_root;
	private Scanner console;
	
	//Constructs a question tree with one leaf node representing the object "computer"
	public QuestionTree() {
		m_root = new QuestionNode<String>("Computer", null, null);
		console = new Scanner(System.in);
	}
	
	// post: asks the user a question, forcing an answer of "y " or "n"; 
	//		returns true if the answer was yes, returns false otherwise 
	public boolean yesTo(String prompt) { 
		for (;;) { 
			System.out.print(prompt + " (y/n)? "); 
			String response = console.nextLine().trim().toLowerCase(); 
			if (response.equals("y")) 
				return true; 
			else if (response.equals("n")) 
				return false; 
			else 
				System.out.println("Please answer y or n."); 
		} 
	}
	
	//Replaces the current tree with a new tree using the information in the file read by the Scanner input
	public void read(Scanner input) {
		m_root = readHelper(input);
	}
	//Recursively reads the input and create a tree (preorder)
	private QuestionNode<String> readHelper(Scanner input) {
		//Read a line from the Scanner
		String questionType = input.nextLine();
		String line = input.nextLine();
		QuestionNode<String> root = new QuestionNode<String>(line, null, null);
		if(questionType.equals("Q:")) {
			//This node has children (it's a question), find them
			root.setLeft(readHelper(input));
			root.setRight(readHelper(input));
		}
		return root;
	}
	//Writes this tree to a file.
	public void write(PrintStream input) {
		m_root.processTreePreOrder(new TreeWriter(input));
	}
	//This interface contains one method, processNode, that will be called when the nodes are being processed while a traversal is being performed.
	public interface ProcessNode {
		public void processNode(QuestionNode<?> node);
	}
	//This class reads the data from each node and writes it to a file
	private class TreeWriter implements ProcessNode {
		private PrintStream m_input;
		private TreeWriter(PrintStream input) {
			m_input = input;
		}
		@Override
		public void processNode(QuestionNode<?> node) {
			if(node.getLeft() == null && node.getRight() == null) {
				//This is an answer node (a leaf)
				m_input.println("A:");
			} else {
				//This is a question node (it has children)
				m_input.println("Q:");
			}
			m_input.println(node.getData());
		}
	}
}
