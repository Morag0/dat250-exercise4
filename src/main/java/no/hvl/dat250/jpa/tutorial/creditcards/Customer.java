package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.Collection;
import jakarta.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private Collection<Address> addresses;

    @OneToMany(cascade = CascadeType.ALL)
    private Collection<CreditCard> creditCards;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Address> getAddresses() {
        return addresses;
    }

    public void setCreditCards(Collection<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    public Collection<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setAddresses(Collection<Address> addresses) {
        this.addresses = addresses;
    }
}

