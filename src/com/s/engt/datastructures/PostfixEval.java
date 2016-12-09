package com.s.engt.datastructures;

import java.util.Scanner;

public class PostfixEval {
	public static double eval(String expr) {
		double total = 0;
		char[] chararr = expr.toCharArray();
		Stack<Double> numStack = new Stack<Double>();
		String numStr = ""; //A string that will be converted to a Double once a space or operator is encountered.
		for(char c : chararr) {
			if(c != '+' && c != '-' && c != '*' && c != '/' && c != ' ') { //If c is not an operator.
				numStr += c;
			} else {
				if(!numStr.equals("")) {
					//Convert numStr to Double and push to stack.
					numStack.push(Double.parseDouble(numStr));
					numStr = ""; //Reset numstr.
				}
				//Perform the correct operation depending on the operator.
				switch(c) {
				case '+': //Addition.
					total = numStack.pop() + numStack.pop();
					numStack.push(total);
					break;
				case '-': //Subtraction.
					double a = numStack.pop();
					double b = numStack.pop();
					total = b - a;
					numStack.push(total);
					break;
				case '*': //Multiplication.
					total = numStack.pop() * numStack.pop();
					numStack.push(total);
					break;
				case '/': //Division.
					double denominator = numStack.pop();
					double numerator = numStack.pop();
					if(denominator == 0) {
						System.err.println("Error: Divide by zero!");
						return Double.NaN;
					}
					total = numerator / denominator;
					numStack.push(total);
					break;
				}
			}
		}
		return total;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(true) {
			System.out.println("Enter expression to evaluate: ");
			String expr = s.nextLine();
			if(expr.equals("")) break;
			String postfix = InfixConvert.convertToPostfix(expr);
			System.out.println("Postfix: " + postfix);
			System.out.println("Evaluated expression: " + PostfixEval.eval(postfix));
		}
		s.close();
	}

}
