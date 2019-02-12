
public class UnknownOperatorException extends Exception {
	public UnknownOperatorException() {
		super("Unknown operator, please try again");
	}
	public UnknownOperatorException(String operator) {
		super(operator);
	}
}
