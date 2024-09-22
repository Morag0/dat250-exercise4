Questions:

1. We are using h2 database, which is a fast, opensource Java SQL database. The database runs when we run the java application and the EntityManagerFactory is created. Hibernate is generating the necessary SQL to create tables etc.
2. CREATE TABLE Customer(
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255),
    PRIMARY KEY (id)
)
3. In CreditCardsMain.java i have created a connection to port 8082 that will show the h2 web console. Here you can use the URL "jdbc:h2:file:./DB", the username "sa" and leave the password blank. This will let you run queries that lets you inspect the tables created. You need to set Thread.sleep(0); to a higher value then 0 to interact with the console



Hand in Report:
I had some issues with running Main.java, i resolved it by changing the config to use SDK 21 instead of SDK 17. I also had to add the different classes to persistence.xml to get CreditCardsMain.java to run.

You can find all the code i created in the classes under src/main/java/no.hvl.dat250.jpa.tutorial/creditcards.

I inspected the databasetables and what tables where created by making a connection to the h2 web console in CreditCardsMain.java. I also made Hibernate show how it created the tables by setting <property name="hibernate.show_sql" value=""/> from false to true. You can find a screenshot named createdTables.png

Currently i dont pass CreditCardsMainTest, and i am unsure as to why this is, and i did not manage to fix it before handing in this assignment. When i added the connection part so that i could inspect the database on the webconsole i got additional errors, but it didnt work before adding it either.