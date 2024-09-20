package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.*;

import jakarta.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private Integer number;


    @ManyToMany(mappedBy = "addresses")
    private Set<Customer> owners = new HashSet<>();

    public String getStreet() {
        // TODO: implement method!
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        // TODO: implement method!
        return number;
    }


    public void setNumber(Integer number) {
        this.number = number;
    }

    public Set<Customer> getOwners() {
        // TODO: implement method!
        return owners;
    }

    public void setOwners(Set<Customer> owners) {
        this.owners = owners;
    }
}
