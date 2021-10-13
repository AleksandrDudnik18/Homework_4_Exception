package task_4_2.entities;

import java.math.BigInteger;
import java.util.Objects;

public class BankAccount {

    private long id;
    private String settlementAccount;  //20 цифр из которого состоит расчетный счет
    private BigInteger balanceAccount;  //баланс счета
    private String pin;

    public BankAccount(long id, String settlementAccount, BigInteger balanceAccount, String pin) {
        this.id = id;
        this.settlementAccount = settlementAccount;
        this.balanceAccount = balanceAccount;
        this.pin = pin;
    }

    public long getId() {
        return id;
    }

    public String getSettlementAccount() {
        return settlementAccount;
    }

    public BigInteger getBalanceAccount() {
        return balanceAccount;
    }

    public String getPin() {
        return pin;
    }

    public void setBalanceAccount(BigInteger balanceAccount) {
        this.balanceAccount = balanceAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return id == that.id &&
                balanceAccount == that.balanceAccount &&
                Objects.equals(settlementAccount, that.settlementAccount) &&
                Objects.equals(pin, that.pin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, settlementAccount, balanceAccount, pin);
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", settlementAccount='" + settlementAccount + '\'' +
                ", balanceAccount=" + balanceAccount +
                ", pin='" + pin + '\'' +
                '}';
    }
}
