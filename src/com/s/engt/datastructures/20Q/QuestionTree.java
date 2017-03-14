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
}
