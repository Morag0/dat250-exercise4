package no.hvl.dat250.jpa.tutorial.creditcards.driver;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import no.hvl.dat250.jpa.tutorial.creditcards.*;

import java.util.Arrays;

public class CreditCardsMain {

  static final String PERSISTENCE_UNIT_NAME = "jpa-tutorial";

  public static void main(String[] args) {
    try (EntityManagerFactory factory = Persistence.createEntityManagerFactory(
        PERSISTENCE_UNIT_NAME); EntityManager em = factory.createEntityManager()) {
      em.getTransaction().begin();
      createObjects(em);
      em.getTransaction().commit();
    }

  }

  private static void createObjects(EntityManager em) {
    // TODO: Create object world as shown in the README.md.
    // Create customer
    Customer customer = new Customer();
    customer.setName("Max Mustermann");

    // Create address
    Address address = new Address();
    address.setStreet("Inndalsveien");
    address.setNumber(28);
    customer.setAddresses(Arrays.asList(address));

    // Create bank (must persist the bank first before assigning it to credit cards)
    Bank bank = new Bank();
    bank.setName("Pengebank");

    // Persist the bank first
    em.persist(bank);

    // Create pincode (must persist pincode before assigning it to credit cards)
    Pincode pincode = new Pincode();
    pincode.setCode("123");
    pincode.setCount(1);

    // Persist the pincode first
    em.persist(pincode);

    // Create first credit card
    CreditCard firstCard = new CreditCard();
    firstCard.setNumber(12345);
    firstCard.setBalance(-5000);
    firstCard.setCreditLimit(-10000);
    firstCard.setOwningBank(bank); // Reference the saved bank
    firstCard.setPincode(pincode); // Reference the saved pincode

    // Create second credit card
    CreditCard secondCard = new CreditCard();
    secondCard.setNumber(123);
    secondCard.setBalance(1);
    secondCard.setCreditLimit(2000);
    secondCard.setOwningBank(bank); // Reference the saved bank
    secondCard.setPincode(pincode); // Reference the saved pincode

    // Assign credit cards to customer
    customer.setCreditCards(Arrays.asList(firstCard, secondCard));

    // Persist the customer and all related entities
    em.persist(customer);
  }
}
