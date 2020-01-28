/**
 * @author Mr. Rasmussen
 */

package fracCalc;

import java.util.*;

public class FracCalc {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		String equation = "";
		while (!equation.equals("quit")) {
			System.out.println("Write your math problem here or type quit to be done: ");
			equation = userInput.nextLine();
			String answer = produceAnswer(equation);
			System.out.println(answer);
		}
		userInput.close();
	}

	// ** IMPORTANT ** DO NOT DELETE THIS FUNCTION. This function will be used to
	// test your code
	// This function takes a String 'input' and produces the result
	//
	// input is a fraction string that needs to be evaluated. For your program, this
	// will be the user input.
	// e.g. input ==> "1/2 + 3/4"
	//
	// The function should return the result of the fraction after it has been
	// calculated
	// e.g. return ==> "1_1/4"
	public static String produceAnswer(String e) {
		String solution = "";
		String fraction1 = processFraction1(e);
		String fraction2 = processFraction2(e);
		String operator = processOperator(e);

		solution = splitFractions(fraction1, fraction2, operator);
		return solution;
	}

	public static String processFraction1(String e) {
		String frac1 = "";

		for (int i = 0; i < e.length(); i++) {
			char a = e.charAt(i);
			if (a == '+' || a == '-' || a == '*') {
				frac1 = e.substring(0, i - 1);
			}
		}
		
		return frac1;
	}

	public static String processFraction2(String e) {
		String frac2 = "";

		for (int i = 0; i < e.length(); i++) {
			char a = e.charAt(i);
			if (a == '+' || a == '-' || a == '*') {

				frac2 = e.substring(i + 2);
			}
		}
		
		return frac2;
	}

	public static String processOperator(String e) {
		String operator = "/";

		for (int i = 0; i < e.length(); i++) {
			char a = e.charAt(i);
			if (a == '+' || a == '-' || a == '*') {

				operator = e.substring(i, i + 1);

			}

		}

		return operator;
	}

	public static String splitFractions(String f1, String f2, String op) {
		int whole1 = 0;
		int numerator1 = 0;
		int denominator1 = 0;
		String operator = op;
		String answer = "";

		if (f1.contains("_")) {
			whole1 = Integer.parseInt(f1.substring(0, f1.indexOf("_")));
			numerator1 = Integer.parseInt(f1.substring(f1.indexOf("_") + 1, f1.indexOf("/")));
			denominator1 = Integer.parseInt(f1.substring(f1.indexOf("/") + 1));
			numerator1 = (whole1 * denominator1) + numerator1;
		}

		else if (f1.contains("/")) {
			numerator1 = Integer.parseInt(f1.substring(0, f1.indexOf("/")));
			denominator1 = Integer.parseInt(f1.substring(f1.indexOf("/") + 1));
			
		} 
		
		
		else {
			whole1 = Integer.parseInt(f1.substring(0));
			numerator1 = whole1;
			denominator1 = 1;
		}

		int whole2 = 0;
		int numerator2 = 0;
		int denominator2 = 0;
		if (f2.contains("_")) {
			whole2 = Integer.parseInt(f2.substring(0, f2.indexOf("_")));
			numerator2 = Integer.parseInt(f2.substring(f2.indexOf("_") + 1, f2.indexOf("/")));
			denominator2 = Integer.parseInt(f2.substring(f2.indexOf("/") + 1));
			numerator2 = (whole2 * denominator2) + numerator2;
		} 
		else if (f2.contains("/")) {

			numerator2 = Integer.parseInt(f2.substring(0, f2.indexOf("/")));
			denominator2 = Integer.parseInt(f2.substring(f2.indexOf("/") + 1));
			
		} 

		 else {
			whole2 = Integer.parseInt(f2.substring(0));
			numerator2 = whole2;
			denominator2 = 1;
		}

		
		answer = doMath(numerator1, numerator2, denominator1, denominator2, operator);
		return answer;

	}

	public static String doMath(int n1, int n2, int d1, int d2, String op) {

		String answer = "";

		if (op.equals("+")) {
			answer = addFrac(n1, n2, d1, d2);
		} else if (op.equals("-")) {
			answer = subFrac(n1, n2, d1, d2);
		}

		else if (op.equals("*")) {
			answer = multFrac(n1, n2, d1, d2);
		} else if (op.equals("/")) {
			answer = divFrac(n1, n2, d1, d2);
		}
		return answer;
	}

	public static String addFrac(int n1, int n2, int d1, int d2) {
		String answer = "";
		int numerator = (n1 * d2) + (n2 * d1);
		int denominator = (d1 * d2);
		if (n1 == 0) {
			answer = n2 + "/" + d2;
		} else if (n2 == 0) {
			answer = n1 + "/" + d1;
		} else {
			answer = numerator + "/" + denominator;
		}
		return answer;
	}

	public static String subFrac(int n1, int n2, int d1, int d2) {
		n2 = -1 * n2;
		String answer = "";
		int numerator = (n1 * d2) + (n2 * d2);
		int denominator = (d1 * d2);
		if (n1 == 0) {
			answer = n2 + "/" + d2;
		} else if (n2 == 0) {
			answer = n1 + "/" + d1;
		} else {
			answer = numerator + "/" + denominator;
		}
		return answer;
	}

	public static String multFrac(int n1, int n2, int d1, int d2) {
		int numerator = n1 * n2;
		int denominator = d1 * d2;
		String answer = numerator + "/" + denominator;
		return answer;
	}

	public static String divFrac(int n1, int n2, int d1, int d2) {
		int a = n2;
		int b = d2;
		d2 = a;
		n2 = b;
		int numerator = n1 * n2;
		int denominator = d1 * d2;
		String answer = numerator + "/" + denominator;
		return answer;
	}

	// TODO: Fill in the space below with any helper methods that you think you will
	// need

}