package tech.reliab.course.nametchenkolab.bank.exceptions;

public class AtmNotEnoughMoneyException extends Exception {
    public AtmNotEnoughMoneyException(String message) {
        super(message);
    }
}
