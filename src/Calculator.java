/**
 * My calculator class that contains the calculator method. Method can be sued to make basic calculations in
 * a stream like fashion
 * Created by: Brian Espinosa
 * Due DateL 2/5/19
 * class: CISC 191
 */
import java.util.Scanner;

public class Calculator {
	public static void calculator() {
		System.out.println("Calculator is on");
		System.out.println("This calculator only uses +,-,*,/ and r (for final result. Input commands like so: +2.3 or *5.5.");
		String operation = "";
		Scanner input= new Scanner(System.in);
		double result  = 0;
		System.out.println("result = " + result);

		while (!operation.equalsIgnoreCase("r")) {
			try {
				operation = input.next();
				operation = operation.toLowerCase();
				if (operation.charAt(0) == '+') {
					result += Double.parseDouble(operation.substring(1));
					System.out.println("New Result = " + result);
				}
				else if (operation.charAt(0) == '-') {
					result -= Double.parseDouble(operation.substring(1));
					System.out.println("New Result = " + result);
				}
				else if(operation.charAt(0) == '*') {
					result *= Double.parseDouble(operation.substring(1));
					System.out.println("New Result = " + result);
				}
				else if(operation.charAt(0) == '/') {
					if ( Double.parseDouble(operation.substring(1)) == 0) {
						throw new UnknownOperatorException("0");
					}
					result = result / (Double.parseDouble(operation.substring(1)));
					System.out.println("New Result = " + result);
				}
				else if (operation.charAt(0) == 'r') {
					System.out.println("The final result is: " + result);
					System.out.println("would you like to do another calculation (y/n)");
					operation = input.next();
					if (operation.charAt(0) == 'y') {
						result = 0.0;
						System.out.println("Result = " + result);
						operation = "";
					}
					else if(operation.charAt(0) == ('n')) {
						System.out.println("goodbye!");
						return;
					}
					else {
						throw new UnknownOperatorException(Character.toString(operation.charAt(0)));
					}

				}
				else {
					throw new UnknownOperatorException(Character.toString(operation.charAt(0)));
				}
			}
			catch (Exception e) {
				if (e.getMessage().equalsIgnoreCase("0")) {
					System.out.println("Dont divide by zero you heathen.");
				}
				else if (e.getMessage().length() == 1) {
					System.out.println("\"" + e.getMessage() + "\"" + " is not an operator. Make sure to use only r(for result),+,-, /, or *"
							+ " as your operator. Ex: +2.5");
				}
				else {
					System.out.println("\"" + e.getMessage() + "\"" + " is not in the correct format. Please enter only numbers after the operator.");
				}
				System.out.println("Current result is: "+ result);
				System.out.print("Please Try again: ");
			}
		}
	}
}

