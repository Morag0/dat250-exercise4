package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Pincode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private Integer count;


    @OneToMany(mappedBy = "pincode", cascade = CascadeType.ALL)
    private Collection<CreditCard> creditCards;


    public Long getId() {
        return id;
    }

    public String getCode() {
        // TODO: implement method!
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getCount() {
        // TODO: implement method!
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Collection<CreditCard> getCreditCards(){
        return creditCards;
    }

    public void setCreditCard(Collection<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }
}
