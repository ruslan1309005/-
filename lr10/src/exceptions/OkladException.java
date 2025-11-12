package exceptions;

public class OkladException extends Exception {
	private final double amount;

	public OkladException(double amount) {
		super("Отрицательный оклад: " + amount);
		this.amount = amount;
	}

	public OkladException(String message, double amount) {
		super(message);
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}
}


