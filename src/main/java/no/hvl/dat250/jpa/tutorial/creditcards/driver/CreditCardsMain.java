package no.hvl.dat250.jpa.tutorial.creditcards.driver;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import no.hvl.dat250.jpa.tutorial.creditcards.*;
import org.h2.tools.Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class CreditCardsMain {

  static final String PERSISTENCE_UNIT_NAME = "jpa-tutorial";

  public static void main(String[] args) {
    Server h2Server = null;
    EntityManagerFactory factory = null;
    EntityManager em = null;

    try {
      // Start H2 connection for schema creation
      Connection conn = DriverManager.getConnection(
              "jdbc:h2:file:./DB;INIT=CREATE SCHEMA IF NOT EXISTS baeldung",
              "sa",
              "");
      conn.close();

      // Start H2 web console
      h2Server = Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8082").start();
      System.out.println("H2 web console started at http://localhost:8082");

      // Create the EntityManagerFactory and EntityManager
      factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
      em = factory.createEntityManager();

      // Begin transaction and create objects
      em.getTransaction().begin();
      createObjects(em);
      em.getTransaction().commit();

      // Keep the program alive to access the console
      Thread.sleep(600000);  // Sleep for 10 minutes (adjust as necessary)

    } catch (SQLException | InterruptedException e) {
      e.printStackTrace();
    } finally {
      // Close EntityManager and EntityManagerFactory
      if (em != null) {
        em.close();
      }
      if (factory != null) {
        factory.close();
      }

      // Stop the H2 web server if it was started
      if (h2Server != null) {
        h2Server.stop();
        System.out.println("H2 web console stopped.");
      }
    }
  }

  private static void createObjects(EntityManager em) {
    // TODO: Create object world as shown in the README.md.
    Customer owner = new Customer();
    owner.setName("Max Mustermann");
    em.persist(owner);

    Address address = new Address();
    address.setStreet("Inndalsveien");
    address.setNumber(28);
    em.persist(address);

    CreditCard card1 = new CreditCard();
    card1.setNumber(12345);
    card1.setBalance(-5000);
    card1.setCreditLimit(-10000);
    em.persist(card1);

    CreditCard card2 = new CreditCard();
    card2.setNumber(123);
    card2.setBalance(1);
    card2.setCreditLimit(2000);
    em.persist(card2);

    Pincode pin = new Pincode();
    pin.setCode("123");
    pin.setCount(1);
    em.persist(pin);

    Bank bank = new Bank();
    bank.setName("Pengebank");
    em.persist(bank);

    card1.setPincode(pin);
    card1.setOwningBank(bank);
    card2.setPincode(pin);
    card2.setOwningBank(bank);

    bank.getOwnedCards().add(card1);
    bank.getOwnedCards().add(card2);

    owner.getAddresses().add(address);
    owner.getCreditCards().add(card1);
    owner.getCreditCards().add(card2);

    address.getOwners().add(owner);
  }
}
