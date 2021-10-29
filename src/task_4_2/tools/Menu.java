package task_4_2.tools;

import task_4_2.exceptions.WrongCommandException;
import task_4_2.exceptions.WrongValueSumException;

import java.math.BigInteger;
import java.util.Scanner;

public class Menu {

    private static final Scanner scanner = new Scanner(System.in);

    public static enum Commands {
        GET_BALANCE(1, "to check balance, input 1"),
        PUT_MONEY(2, "to put money, input 2"),
        GET_MONEY(3, "to get money, input 3"),
        EXIT(4, "for exit, input 4"),
        WRONG_CMD(-1, "wrong command");

        private int num;
        private String message;

        Commands(int num, String message) {
            this.num = num;
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public static Commands cmdByNumber(int num) {
            for (Commands cmd : values()) {
                if (cmd.num == num) return cmd;
            }
            return WRONG_CMD;
        }
    }

    public static Commands showMenu() throws WrongCommandException {

        System.out.println("********************************************");

        for (Commands cmd :
                Commands.values()) {
            if (!cmd.equals(Commands.WRONG_CMD))
                System.out.println(cmd.getMessage());
        }

        if (scanner.hasNextInt()) {
            Commands cmd = Commands.cmdByNumber(scanner.nextInt());
            if (cmd.equals(Commands.WRONG_CMD))
                throw ViewMessage.wrongCommandException();

            return cmd;
        }

        throw ViewMessage.wrongCommandException();

    }

    public static BigInteger inputMoney() throws WrongValueSumException {

        System.out.println("input sum:");

        if (scanner.hasNextBigInteger()) {
            return scanner.nextBigInteger();
        }

        throw ViewMessage.wrongValueSumException();
    }


    public static void inputPin() {
        System.out.println("Hello, input your pin:");
    }

    public static void showUnblocked() {
        System.out.println("Terminal is unblocked");
    }

    public static void showBalance(BigInteger balance) {
        System.out.println("Your terminal has " + balance + " money");
    }

    public static void showGetMoney(BigInteger money, BigInteger balance) {
        System.out.println("You get " + money + ", your account has " + balance);
    }

    public static void showPutMoney(BigInteger money, BigInteger balance) {
        System.out.println("You put " + money + ", your account has " + balance);
    }

    public static void showExit() {
        System.out.println("Thank you for your visiting!!!");
    }

}
