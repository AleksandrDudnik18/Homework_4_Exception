package task_4_2.exceptions;

public class AccountIsLockedException extends Exception {

    private final int LEFT_TIME;

    public AccountIsLockedException(String message, int leftTime) {
        super(leftTime + message);
        this.LEFT_TIME = leftTime;
    }

    public int getLEFT_TIME() {
        return LEFT_TIME;
    }


}
