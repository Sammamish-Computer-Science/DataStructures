
public class QuestionTree {
	private QuestionNode<String> m_root;
	
	//Constructs a question tree with one leaf node representing the object "computer"
	public QuestionTree() {
		m_root = new QuestionNode<String>("Computer", null, null);
	}
}
