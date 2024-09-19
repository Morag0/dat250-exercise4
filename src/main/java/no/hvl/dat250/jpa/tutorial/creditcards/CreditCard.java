package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;

@Entity
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer number;
    private Integer balance;
    private Integer creditLimit;

    @ManyToOne
    private Customer owner;

    @ManyToOne
    private Pincode pincode;

    @ManyToOne
    private Bank bank;


    public Integer getNumber() {
        // TODO: implement method!
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getBalance() {
        // TODO: implement method!
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getCreditLimit() {
        // TODO: implement method!
        return creditLimit;
    }

    public void setCreditLimit(Integer creditLimit) {
        this.creditLimit = creditLimit;
    }

    public Pincode getPincode() {
        // TODO: implement method!
        return pincode;
    }

    public void setPincode(Pincode pincode) {
        this.pincode = pincode;
    }

    public Bank getOwningBank() {
        // TODO: implement method!
        return bank;
    }

    public void setOwningBank(Bank bank) {
        this.bank = bank;
    }
    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Customer getOwner(){
        return owner;
    }

    public void setOwner(Customer owner){
        this.owner = owner;
    }
}
