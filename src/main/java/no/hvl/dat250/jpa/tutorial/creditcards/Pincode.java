package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;

import java.util.*;

@Entity
public class Pincode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private Integer count;


    @OneToMany(mappedBy = "pincode", cascade = CascadeType.ALL)
    private Set<CreditCard> creditCards = new HashSet<>();


    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Set<CreditCard> getCreditCards(){
        return creditCards;
    }

    public void setCreditCard(Set<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }
}
