/**
 * @author Mr. Rasmussen
 */

package fracCalc;

import java.util.*;

public class FracCalc {

	//main method takes user input and gets equation
	public static void main(String[] args) {
		System.out.println("Welcome to my fraction calculator!");
		Scanner userInput = new Scanner(System.in);
		String equation = "";
		while (!equation.equals("quit")) {
			System.out.println("Write your math problem here or type quit to be done: ");
			equation = userInput.nextLine();
			
		}
		userInput.close();
		String answer = produceAnswer(equation);
		System.out.println(answer);
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
	
	//the method that calls the methods that get the answer
	public static String produceAnswer(String e) {
		String solution = "";
		String fraction1 = processFraction1(e);
		String fraction2 = processFraction2(e);
		String operator = processOperator(e);

		solution = splitFractions(fraction1, fraction2, operator);
		return solution;
	}

	// method that gets the first of the two fractions inputed and returns it to produce answer
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

	// method that gets the second of the two fractions inputed and returns it to produce answer
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

	// method that gets the operator inputed and returns it to produce answer
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

	// method that splits the fractions into whole, numerator and denominator and passes them into the math methods
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
		} else if (f2.contains("/")) {

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

	// method that calls either the add subtract multiply or divide methods based on the operator found in process operator 
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
	
	// method that if called adds fractions 
	public static String addFrac(int n1, int n2, int d1, int d2) {
		String answer = "";
		int numerator = (n1 * d2) + (n2 * d1); // these two lines make the denominators equal so we can add them
		int denominator = (d1 * d2);
		int commonDivide = reduceFrac(numerator, denominator); //gets reduced fraction from reduce method
		numerator /= commonDivide;
		denominator /= commonDivide;
		int whole = 0;

		while (numerator >= denominator) { //figures out whole or if there is one
			whole++;
			numerator -= denominator;
		}

		if (whole > 0 || whole < 0) {
			answer += whole + "_";
		}
		if (numerator != 0) {
			answer += numerator + "/" + denominator;
		}
		return answer;
	}

	
	// method that if called subtracts fractions 
	public static String subFrac(int n1, int n2, int d1, int d2) {
		n2 = -1 * n2;
		String answer = "";
		int numerator = (n1 * d2) + (n2 * d2); // these two lines make the denominators equal so we can sub them
		int denominator = (d1 * d2);
		int commonDivide = reduceFrac(numerator, denominator);
		numerator /= commonDivide;
		denominator /= commonDivide;
		int whole = 0;

		while (numerator >= denominator) { // figures out if there is a whole
			whole++;
			numerator -= denominator;
		}

		if (whole > 0 || whole < 0) {
			answer += whole + "_";
		}
				
		if (numerator != 0) {
			answer += numerator + "/" + denominator;
		}
		return answer;
	}

	// multiply fractions method!
	public static String multFrac(int n1, int n2, int d1, int d2) {
		String answer = "";
		int numerator = n1 * n2;
		int denominator = d1 * d2;
		int commonDivide = reduceFrac(numerator, denominator); // gets comon divisor from reduce method
		numerator /= commonDivide;
		denominator /= commonDivide;
		int whole = 0; // finds the whole
		if (numerator == 0) {
			answer = "0";
			
		}
		else if (denominator == 0) {
			answer = "0";
		}
		while (numerator >= denominator) {
			whole++;
			numerator -= denominator;
		}

		if (whole > 0 || whole < 0) {
			answer += whole + "_";
		}
		if (numerator != 0) {
			answer += numerator + "/" + denominator;
		}
		return answer;

	}

	// Divides fractions method!
	public static String divFrac(int n1, int n2, int d1, int d2) {
		String answer = "";
		int a = n2;
		int b = d2;
		d2 = a; // switch 2nd numerator and denominator to multiply by recoprical 
		n2 = b;
		int numerator = n1 * n2;
		int denominator = d1 * d2;
		int commonDivide = reduceFrac(numerator, denominator); // gets common divisor
		numerator /= commonDivide;
		denominator /= commonDivide;
		int whole = 0;

		while (numerator >= denominator) {
			whole++;
			numerator -= denominator;
		}

		if (whole > 0) {
			answer += whole + "_";
		}
		if (numerator != 0) {
			answer += numerator + "/" + denominator;
		}
		return answer;
	}

	// REDUCE method, that really finds the common divisor and returns it to the other methods to reduce with
	public static int reduceFrac(int num, int denom) {
		int posNum = Math.abs(num);
		int posDenom = Math.abs(denom);
		int smaller = Math.min(posNum, posDenom); // finds the smallest of the two numbers
		int divisor = 1;

		for (int i = 1; i <= smaller; i++) { // loops until it finds the greatest common divisor 
			if (num % i == 0 && denom % i == 0) {
				divisor = i;
			}
		} 
		return divisor;

	}
}

// TODO: Fill in the space below with any helper methods that you think you will
// need

