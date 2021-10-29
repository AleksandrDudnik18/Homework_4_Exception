package task_4_2.servies;

import task_4_2.exceptions.NegativeValueException;
import task_4_2.exceptions.NonMultiplyException;
import task_4_2.exceptions.NotEnoughMoneyException;

import java.math.BigInteger;

public interface Terminal {

    /**
     *
     * @return current account balance of visitor
     */
    BigInteger getBalance();

    /**
     *
     * @return deposit money into an account
     */
    BigInteger putMoney(BigInteger money) throws NonMultiplyException, NegativeValueException;

    /**
     *
     * @return withdraw money from the account
     */
    BigInteger getMoney(BigInteger money) throws NonMultiplyException, NotEnoughMoneyException, NegativeValueException;

}
