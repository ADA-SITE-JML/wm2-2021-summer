-- noinspection SqlNoDataSourceInspectionForFile

-- CUSTOMERS
INSERT INTO CUSTOMERS(NAME, SURNAME, AGE) VALUES ('Jon', 'Snow', 24);
INSERT INTO CUSTOMERS(NAME, SURNAME, AGE) VALUES ('Joffrey', 'Baratheon', 18);
INSERT INTO CUSTOMERS(NAME, SURNAME, AGE) VALUES ('Tyrion', 'Lannister', 24);


-- CARS
INSERT INTO CARS(MAKE, MODEL, YEAR, RENTER_CUST_ID) VALUES ('Honda', 'Civic', 2005, 1);
INSERT INTO CARS(MAKE, MODEL, YEAR, RENTER_CUST_ID) VALUES ('Chevrolet', 'Camaro', 2020, 1);
INSERT INTO CARS(MAKE, MODEL, YEAR, RENTER_CUST_ID) VALUES ('Tesla', 'Roadster', 2020, 2);
INSERT INTO CARS(MAKE, MODEL, YEAR) VALUES ('Toyota', 'Prado', 2015);


-- RENTS
INSERT INTO RENTS(CUST_ID, CAR_ID) VALUES (1, 1);
INSERT INTO RENTS(CUST_ID, CAR_ID) VALUES (1, 2);
INSERT INTO RENTS(CUST_ID, CAR_ID) VALUES (2, 3);

-- USERS
INSERT INTO USERS(EMAIL, NAME, PASSWORD) VALUES ('nuray@mail.com', 'Nuray Leysanli', 'b40d03386fb8fd7dc6ca9c6f8d680dfc58d60fd6ea72c63f573cc5bfbb09695746a849c91517c235cdfeaca4e734208f184bc08aae06797748988e95928f80b1');
