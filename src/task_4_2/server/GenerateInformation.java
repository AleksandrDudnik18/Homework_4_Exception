package task_4_2.server;

import task_4_2.entities.BankAccount;
import task_4_2.entities.Owner;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GenerateInformation {

    static final List<Owner> owners = generateOwners();
    private static long ownerIdCounter;
    private static long bankAccountIdCounter;

    private static List<Owner> generateOwners() {

        Owner ownerOne = new Owner(++ownerIdCounter, "Aleksandr", "Dudnik", "Aleksandrovich",
                new BankAccount(++bankAccountIdCounter, generateSettlementAccount(), generateBalance(), "5757"));

        Owner ownerTwo = new Owner(++ownerIdCounter, "Alexey", "Petrov", "Aleksandrovich",
                new BankAccount(++bankAccountIdCounter, generateSettlementAccount(), generateBalance(), "3737"));

        Owner ownerThree = new Owner(++ownerIdCounter, "Dmitriy", "Timokhin", "Andreevich",
                new BankAccount(++bankAccountIdCounter, generateSettlementAccount(), generateBalance(), "1010"));

        Owner ownerFour = new Owner(++ownerIdCounter, "Igor", "Antonov", "Valerievich",
                new BankAccount(++bankAccountIdCounter, generateSettlementAccount(), generateBalance(), "9000"));

        Owner ownerFive = new Owner(++ownerIdCounter, "Petr", "Kremnev", "Olegovych",
                new BankAccount(++bankAccountIdCounter, generateSettlementAccount(), generateBalance(), "8822"));

        return Arrays.asList(ownerOne, ownerTwo, ownerThree, ownerFour, ownerFive);

    }

    private static String generateSettlementAccount() {

        StringBuilder stringBuilder = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            stringBuilder.append(random.nextInt(9) + 1);
        }

        return stringBuilder.toString();
    }

    private static BigInteger generateBalance() {

        Random random = new Random();

        return BigInteger.valueOf(random.nextInt(100000 - 1000) + 1000);
    }

}
