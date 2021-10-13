package task_4_2.exceptions;

public class WrongCommandException extends Exception{
    public WrongCommandException(String wrongCommandException) {
        super(wrongCommandException);
    }
}
