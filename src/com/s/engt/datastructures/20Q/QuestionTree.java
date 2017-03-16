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
		//Check for null and read a line from the Scanner
		if(input == null) return null;
		String questionType = input.nextLine();
		String line = input.nextLine();
		if(questionType == null || line == null) return null;
		QuestionNode<String> root = new QuestionNode<String>(line, null, null);
		if(questionType.equals("Q:")) {
			//This node has children (it's a question), find them
			root.setLeft(readHelper(input));
			root.setRight(readHelper(input));
		}
		return root;
	}
}
