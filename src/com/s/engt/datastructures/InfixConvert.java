package com.s.engt.datastructures;

//A class for converting Infix to Postfix.
public class InfixConvert {
	private static int getOpNum(char a) {
		return (a == '*' || a == '/') ? 1 : 0;
	}
	//Utility function for determine which operator has higher precedence.
	private static char highestPrecedence(char a, char b) {
		int aNum = getOpNum(a);
		int bNum = getOpNum(b);
		if(aNum > bNum) return a;
		return b;
	}
	//Converts Infix to Postfix.
	//Returns the postfix expression.
	public static String convertToPostfix(String expr) {
		String postfix = "";
		Stack<Character> operatorStack = new Stack<Character>();
		boolean operatorLast = false; //If the last character was an operator.
		char[] chararr = expr.toCharArray();
		for(char c : chararr) {
			switch(c) {
			case '(': //Open parenthesis.
				operatorStack.push(c);
				break;
			case ')': //Closed parenthesis.
				//Pop until a ( is found.
				//Pop until an operator with lower precedence is found.
				char op = '\0';
				while(true) {
					if(operatorStack.isEmpty()) break;
					op = operatorStack.pop();
					if(op == '(') break;
					postfix += " " + op;
				}
				break;
			case '/': //Division.
				//Pop until an operator with lower precedence is found.
				char op2 = '\0';
				while(true) {
					if(operatorStack.isEmpty()) break;
					op2 = operatorStack.peek();
					if(op2 != '*' && op2 != '/') break;
					op2 = operatorStack.pop();
					if(op2 != '(')
						postfix += " " + op2;
				}
			case '*': //Multiplication.
			case '+': //Addition.
			case '-': //Subtraction.
				if(!operatorLast) { //If the last character wasn't an operator, this character must be.
					operatorLast = true;
					postfix += " "; //Add a space to separate the numbers.
					//Pop from the stack if the current operator is of a lower precedence.
					if(!operatorStack.isEmpty() && highestPrecedence(operatorStack.peek(), c) != c) { //Check if the higher operator is not at the head of the stack - this checks for equality as well.
						postfix += operatorStack.pop() + " ";
					}
					operatorStack.push(c);
					break;
				}
				//If there has already been an operator, assume that the character c is the sign of a number.
			default: //Number.
				operatorLast = false;
				postfix += c;
			}
		}
		//Add operators to output.
		while(!operatorStack.isEmpty()) {
			char c = operatorStack.pop();
			if(c != '(')
				postfix += c;
		}
		return postfix;
	}
}
