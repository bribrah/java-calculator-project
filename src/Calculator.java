/**
 * My calculator class that contains the calculator method. Method can be sued to make basic calulations in
 * a stream like fashion
 * Created by: Brian Espinosa
 * Due DateL 2/5/19
 * class: CISC 191
 */
import java.util.Scanner;

public class Calculator {
	public static void calculator() {
		System.out.println("Calculator is on");
		String operation = "";
		Scanner input= new Scanner(System.in);
		double result  = 0;
		System.out.println("result = " + result);

		while (!operation.equalsIgnoreCase("r")) {
			try {
				operation = input.next();
				operation.toLowerCase();
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
					}
					else if(operation.charAt(0) == ('n')) {
						System.out.println("goodbye!");
						return;
					}
					else {
						throw new UnknownOperatorException;
					}

				}
				else {
					//throw UnknownOperatorException;
				}
			}
			catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}

