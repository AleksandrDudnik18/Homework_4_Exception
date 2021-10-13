package task_4_2.servies;


import task_4_2.entities.Owner;
import task_4_2.entities.enums.AuthorizationStatus;
import task_4_2.exceptions.VerifyLengthPinException;
import task_4_2.exceptions.VerifySymbolException;
import task_4_2.tools.ViewMessage;

import javax.xml.stream.events.Characters;
import java.io.BufferedReader;

import static task_4_2.entities.enums.AuthorizationStatus.*;

public class PinValidator {

    private StringBuilder pin;


    public PinValidator() {
        this.pin = new StringBuilder();
    }

    public String getPin(boolean clear) {
        String current = pin.toString();
        if (clear)
            pin.delete(0, pin.length());

        return current;
    }

    public void verifyPinLength() throws VerifyLengthPinException {

        if (pin.length() < 4)
            throw ViewMessage.verifyLengthPinException();

    }


    public void verifySymbolPin(Character symbolPin) throws VerifySymbolException {

        if (Character.isDigit(symbolPin)) {
            pin.append(symbolPin);
        } else {
            throw ViewMessage.verifySymbolException();
        }

    }
}
