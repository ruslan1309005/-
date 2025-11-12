package org.example.exceptions;

public class OkladException extends Exception {
    private final double amount;

    public OkladException(double amount) {
        super("Отрицательный оклад: " + amount);
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}


