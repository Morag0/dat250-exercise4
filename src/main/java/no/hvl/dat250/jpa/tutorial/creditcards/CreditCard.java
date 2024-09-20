package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer number;
    private Integer balance;
    private Integer creditLimit;

    @ManyToMany(mappedBy = "creditCards")
    private Set<Customer> cardOwners = new HashSet<>();


    @ManyToOne
    private Pincode pincode;

    @ManyToOne
    private Bank owningBank;


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
        return owningBank;
    }

    public void setOwningBank(Bank bank) {
        this.owningBank = owningBank;
    }


    public Set<Customer> getCardOwners() {
        return cardOwners;
    }

    public void setCardOwners(Set<Customer> cardOwners) {
        this.cardOwners = cardOwners;
    }
}
