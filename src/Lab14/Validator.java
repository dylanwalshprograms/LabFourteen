package Lab14;

import java.util.Scanner;

public class Validator {
	
	public static String getString(Scanner scnr, String prompt) {
		System.out.print(prompt);
		return scnr.nextLine();
	}
	
	public static String getStringMatchingRegex(Scanner scnr, String prompt, String regex) {
		boolean isValid = false;
		String input;
		do {
			input = getString(scnr, prompt).toLowerCase();
			
			if (input.matches(regex)) {
				isValid = true;
			} else {
				System.out.println("Input must match the appropriate format.");
				isValid = false;
			}
			
		} while (!isValid);
		return input;
	}
	
	public static boolean getYesOrNo(Scanner scnr, String prompt) {
		System.out.print(prompt);
		String input = scnr.nextLine().toLowerCase();
		boolean isValid = input.equals("yes") || input.equals("y")|| input.equals("no")|| input.equals("n");
		while (!isValid) { // keep looping as long as they enter something invalid
			System.out.println("Oops. Please enter yes or no.");
			System.out.print(prompt);
			input = scnr.nextLine().toLowerCase();
			isValid = input.equals("yes") || input.equals("y")|| input.equals("no")|| input.equals("n");
		}
		return input.startsWith("y");
	}

}
