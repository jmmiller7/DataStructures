package auction;

public class StackUnderflowException extends RuntimeException {

	private static final long serialVersionUID = -1748291843791479111L;

	public StackUnderflowException() {
		super();
	}

	public StackUnderflowException(String message) {
		super(message);
	}
}
