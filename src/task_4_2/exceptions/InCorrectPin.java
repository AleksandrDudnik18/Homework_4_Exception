package task_4_2.exceptions;

public class InCorrectPin extends Exception {
    public InCorrectPin(String inCorrectPin) {
        super(inCorrectPin);
    }
}
