/**
 * @author Mr. Rasmussen
 */

package fracCalc;

import java.util.*;

public class FracCalc {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.println("Write your math problem here: ");
		String equation = userInput.nextLine();
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
	public static String produceAnswer(String e) {
        String frac1 = "";
        String frac2 = "";
        	
		for (int i = 0; i < e.length(); i++) {
        	char a = e.charAt(i);
        	if (a == '+' || a == '-' || a == '*') {
        		frac1 = e.substring(0, i - 1);
        		char operator = e.charAt(i);
        		frac2 = e.substring(i + 1);
        	}
        }
    	
        return frac2;
    }

	// TODO: Fill in the space below with any helper methods that you think you will
	// need

}
