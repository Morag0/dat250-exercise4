package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;
import java.util.Collection;

@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL)
    private Collection<CreditCard> ownedCards;

    public Long getId() {
        return id;
    }

    public String getName() {
        // TODO: implement method!
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<CreditCard> getOwnedCards() {
        // TODO: implement method!
        return ownedCards;
    }

    public void setOwnedCards(Collection<CreditCard> ownedCards) {
        this.ownedCards = ownedCards;
    }
}
