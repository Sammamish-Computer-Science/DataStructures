import java.util.Scanner;

public class Tester {

	//Simple utility method to read from stdin.
	private void readFromInput() {
		Scanner s = new Scanner(System.in);
		while(true) {
			System.out.println("Enter expression to evaluate: ");
			String expr = s.nextLine();
			if(expr.equals("")) break;
			infixEval(expr);
		}
		s.close();
	}
	//Converts and evaluates an infix expression.
	private static void infixEval(String expr) {
		String postfix = InfixConvert.convertToPostfix(expr);
		System.out.println("Postfix: " + postfix);
		System.out.println("Evaluated expression: " + PostfixEval.eval(postfix));
	}
	public static void main(String[] args) {
		//readFromInput();
		String testExprs[] = {
			"1+1", "(1+1)", "(1+1", "1+1)", "1/0", "4*(4+2)", "(4+8)*(6-5)/((3-2)*(2+2))"	
		};
		for(String expr : testExprs) {
			System.out.println("Infix: " + expr);
			infixEval(expr);
			System.out.println();
		}
	}
}
