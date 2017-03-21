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
	
	//Asks the user a series of yes/no questions until the object is guessed correctly or the computer fails
	//If the computer fails, add the new object to the tree, along with a new question to distinguish the object from the others
	public void askQuestions() {
		QuestionNode<String> curNode = m_root; //The current node
		QuestionNode<String> curNodeParent = null; //The parent of the current node
		boolean lastCorrect = false; //If the answer to the last question asked is yes
		while(curNode != null) {
			if(curNode.isLeaf()) {
				//We've reached an answer node
				if(yesTo("Would your object happen to be " + curNode.getData())) {
					System.out.println("Great, I got it right!");
				} else {
					System.out.println("What is the name of your object? ");
					String newObjectName = console.nextLine().trim();
					System.out.println("Please give me a yes/no question that distinguishes between your object and mine-->");
					String question = console.nextLine().trim();
					boolean answer = yesTo("And what is the answer for your object?");
					//Create a question node and add curNode and a node representing the new object to it
					QuestionNode<String> newObjectNode = new QuestionNode<String>(newObjectName, null, null);
					QuestionNode<String> questionNode;
					if(answer) {
						questionNode = new QuestionNode<String>(question, newObjectNode, curNode);
					} else {
						questionNode = new QuestionNode<String>(question, curNode, newObjectNode);
					}
					//Add questionNode to curNodeParent
					if(curNodeParent == null) { //curNode is the root node
						m_root = questionNode; //Replace the root node with questionNode
					} else {
						if(lastCorrect) {
							curNodeParent.setLeft(questionNode);
						} else {
							curNodeParent.setRight(questionNode);
						}
					}
				}
				return;
			} else {
				curNodeParent = curNode;
				lastCorrect = yesTo(curNode.getData());
				if(lastCorrect) {
					curNode = curNode.getLeft();
				} else {
					curNode = curNode.getRight();
				}
			}
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
			if(node.isLeaf()) {
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
