package task_4_2.entities;

import java.util.Objects;

public class Owner {

    private long id;
    private String name;
    private String surname;
    private String patronymic;
    private BankAccount bankAccount;

    public Owner(long id, String name, String surname, String patronymic, BankAccount bankAccount) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.bankAccount = bankAccount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owner owner = (Owner) o;
        return id == owner.id &&
                Objects.equals(name, owner.name) &&
                Objects.equals(surname, owner.surname) &&
                Objects.equals(patronymic, owner.patronymic) &&
                Objects.equals(bankAccount, owner.bankAccount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, patronymic, bankAccount);
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", bankAccount=" + bankAccount +
                '}';
    }
}