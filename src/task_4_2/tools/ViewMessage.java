package task_4_2.tools;

import task_4_2.exceptions.*;

public class ViewMessage {

    private static final String accountIsLockedMessage = " sec until the terminal is unblocked, waiting";
    private static final String verifySymbolMessage = "incorrect symbol, input number";
    private static final String verifyLengthMessage = "length more then one symbol, input only one symbol";
    private static final String inCorrectPinMessage = "wrong pin, input new pin";
    private static final String verifyLengthPinMessage = "pin must have 4 symbols";
    private static final String wrongValueSumMessage = "input wrong value";
    private static final String wrongCommandException = "wrong command";
    private static final String nonMultiplyMessage = "value of money not multiply 100";
    private static final String notEnoughMoneyException = "not enough money";
    private static final String negativeValueException = "input negative value";

    public static void outException(Exception exception) {

        System.err.println(exception.getMessage());

//        JOptionPane.showMessageDialog(null, exception.getMessage());

    }

    public static AccountIsLockedException accountIsLockedException(int leftTime) {

        return new AccountIsLockedException(accountIsLockedMessage, leftTime);
    }

    public static VerifySymbolException verifySymbolException() {
        return new VerifySymbolException(verifySymbolMessage);
    }

    public static VerifyLengthException verifyLengthException() {
        return new VerifyLengthException(verifyLengthMessage);
    }

    public static InCorrectPin inCorrectPin() {
        return new InCorrectPin(inCorrectPinMessage);
    }

    public static VerifyLengthPinException verifyLengthPinException() {
        return new VerifyLengthPinException(verifyLengthPinMessage);
    }

    public static WrongValueSumException wrongValueSumException() {
        return new WrongValueSumException(wrongValueSumMessage);
    }

    public static WrongCommandException wrongCommandException() {
        return new WrongCommandException(wrongCommandException);
    }

    public static NonMultiplyException nonMultiplyException() {
        return new NonMultiplyException(nonMultiplyMessage);
    }

    public static NotEnoughMoneyException notEnoughMoneyException() {
        return new NotEnoughMoneyException(notEnoughMoneyException);
    }

    public static NegativeValueException negativeValueException() {
        return new NegativeValueException(negativeValueException);
    }

}
