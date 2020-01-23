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
		String fraction2 = processFractions(e);
        solution = splitFractions(fraction2);
        return solution;
    }
	
	public static String processFractions(String e) {
		String frac1 = "";
        String frac2 = "";
        	
		for (int i = 0; i < e.length(); i++) {
        	char a = e.charAt(i);
        	if (a == '+' || a == '-' || a == '*') {
        		frac1 = e.substring(0, i - 1);
        		char operator = e.charAt(i);
        		frac2 = e.substring(i + 2);
        	}
        }
    	
        return frac2;
	}
	
	public static String splitFractions(String f2) {
		int whole = 0;
		int numerator = 0;
		int denominator = 0;
		String output = "";
		if (f2.contains("_")) {
			whole = Integer.parseInt(f2.substring(0,f2.indexOf("_")));
			output += "whole:" + whole;
		}
		if (f2.contains("/")) {
			numerator = Integer.parseInt(f2.substring(f2.indexOf("_") + 1, f2.indexOf("/")));
			output += " numerator:" + numerator;
			denominator = Integer.parseInt(f2.substring(f2.indexOf("/") + 1));
			output += " denominator:" + denominator;
		}
		return output;
			
	}

	// TODO: Fill in the space below with any helper methods that you think you will
	// need

}
 