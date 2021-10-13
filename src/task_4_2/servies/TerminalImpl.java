package task_4_2.servies;

import com.sun.management.VMOption;
import task_4_2.entities.enums.AuthorizationStatus;
import task_4_2.exceptions.*;
import task_4_2.server.TerminalServer;
import task_4_2.tools.Menu;
import task_4_2.tools.ViewMessage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class TerminalImpl implements Terminal {

    private final TerminalServer server;
    private final PinValidator pinValidator;
    private volatile AuthorizationStatus authorizationStatus = AuthorizationStatus.AUTHORIZED_FALSE;
    private int authorizationCount;
    private volatile int timeLeft;


    public TerminalImpl(TerminalServer server, PinValidator pinValidator) {
        this.server = server;
        this.pinValidator = pinValidator;
    }

    @Override
    public BigInteger getBalance() {
        return server.getBalance();
    }

    @Override
    public BigInteger putMoney(BigInteger money) throws NonMultiplyException {
        return server.putMoney(money);
    }

    @Override
    public BigInteger getMoney(BigInteger money) throws NonMultiplyException, NotEnoughMoneyException {
        return server.getMoney(money);
    }

    public void start() {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Menu.inputPin();

        while (true) {
            try {
                if (bufferedReader.ready()) {
                    if (authorizationStatus.equals(AuthorizationStatus.AUTHORIZED_FALSE)) {
                        String symbolPin = bufferedReader.readLine();
                        if (symbolPin.length() > 1)
                            throw ViewMessage.verifyLengthException();

                        pinValidator.verifySymbolPin(symbolPin.charAt(0));
                        pinValidator.verifyPinLength();
                        authorizationStatus = server.authorization(pinValidator.getPin(true));

                        if (authorizationStatus.equals(AuthorizationStatus.AUTHORIZED_FALSE)) {
                            if (++authorizationCount >= 3) {
                                authorizationStatus = AuthorizationStatus.AUTHORIZE_ERROR;
                                authorizationCount = 0;
                            }

                            throw ViewMessage.inCorrectPin();
                        } else if (authorizationStatus.equals(AuthorizationStatus.AUTHORIZE_ERROR)) {
                            authorizationStatus = AuthorizationStatus.AUTHORIZE_BLOCKED;

                            new Thread(() -> {
                                timeLeft = 10;
                                while (timeLeft > 0) {
                                    try {
                                        Thread.sleep(1000);
                                    } catch (InterruptedException ignored) {
                                    }
                                    timeLeft--;
                                }
                                authorizationStatus = AuthorizationStatus.AUTHORIZED_FALSE;
                            }).start();
                            //запуск потока
                        } else if (authorizationStatus.equals(AuthorizationStatus.AUTHORIZE_BLOCKED)) {
                            throw ViewMessage.accountIsLockedException(timeLeft);
                        }


                    } else {
                        while (authorizationStatus.equals(AuthorizationStatus.AUTHORIZED_TRUE)) {
                            switch (Menu.showMenu()) {
                                case GET_BALANCE -> Menu.showBalance(getBalance());
                                case GET_MONEY -> Menu.showGetMoney(getMoney(Menu.inputMoney()), getBalance());
                                case PUT_MONEY -> Menu.showPutMoney(putMoney(Menu.inputMoney()), getBalance());
                                //Добавить статус на выход для case, авторизация = false, pin = ""
                            }
                        }
                    }
                }
            } catch (VerifySymbolException | VerifyLengthException | InCorrectPin | WrongValueSumException
                    | WrongCommandException | NonMultiplyException | NotEnoughMoneyException | AccountIsLockedException e) {
                ViewMessage.outException(e);
            } catch (VerifyLengthPinException ignored) {
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
