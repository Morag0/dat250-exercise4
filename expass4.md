Questions:

1. We are using h2 database, which is a fast, opensource Java SQL database. The database runs when we run the java application and the EntityManagerFactory is created. Hibernate is generating the necessary SQL to create tables etc.
2. CREATE TABLE Customer(
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255),
    PRIMARY KEY (id)
)
3. You can find the schema at 