package exceptions;

public class NegativeAmountException extends RuntimeException {
    public NegativeAmountException(String errorMessage) {
        super(errorMessage);
    }
}
