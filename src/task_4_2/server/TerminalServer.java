package task_4_2.server;

import task_4_2.entities.Owner;
import task_4_2.entities.enums.AuthorizationStatus;
import task_4_2.exceptions.InCorrectPin;
import task_4_2.exceptions.NegativeValueException;
import task_4_2.exceptions.NonMultiplyException;
import task_4_2.exceptions.NotEnoughMoneyException;
import task_4_2.servies.Terminal;
import task_4_2.tools.ViewMessage;

import java.math.BigInteger;
import java.util.Optional;
import java.util.stream.Collectors;

public class TerminalServer implements Terminal {

    private Owner currentOwner;

    public AuthorizationStatus authorization(String pin) {

        Optional<Owner> optional = GenerateInformation.owners.stream().filter(x -> x.getBankAccount().getPin().equals(pin))
                .findFirst();

        if (optional.isEmpty())
            return AuthorizationStatus.AUTHORIZED_FALSE;

        currentOwner = optional.get();

        return AuthorizationStatus.AUTHORIZED_TRUE;
    }

    public void unAuthorization() {
        currentOwner = null;
    }


    @Override
    public BigInteger getBalance() {
        return currentOwner.getBankAccount().getBalanceAccount();
    }

    @Override
    public BigInteger putMoney(BigInteger money) throws NonMultiplyException, NegativeValueException {

        if (money.compareTo(BigInteger.ZERO) < 0)
            throw ViewMessage.negativeValueException();

        if (!money.mod(new BigInteger("100")).equals(BigInteger.ZERO))
            throw ViewMessage.nonMultiplyException();

        currentOwner.getBankAccount().setBalanceAccount(
                currentOwner.getBankAccount().getBalanceAccount().add(money));

        return money;

    }

    @Override
    public BigInteger getMoney(BigInteger money) throws NonMultiplyException, NotEnoughMoneyException, NegativeValueException {
        if (money.compareTo(BigInteger.ZERO) < 0)
            throw ViewMessage.negativeValueException();

        if (!money.mod(new BigInteger("100")).equals(BigInteger.ZERO))
            throw ViewMessage.nonMultiplyException();

        if (money.compareTo(currentOwner.getBankAccount().getBalanceAccount()) > 0)
            throw ViewMessage.notEnoughMoneyException();

        currentOwner.getBankAccount().setBalanceAccount(
                currentOwner.getBankAccount().getBalanceAccount().subtract(money));

        return money;
    }
}
