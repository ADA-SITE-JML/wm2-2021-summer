
INSERT INTO USERS VALUES ('elvina', '$2a$08$Um9sTv4ho3oD7nK0nOAnO.3OfzwnV8z7CaZ/Pc6h6iaXy7C7Ikkuu', true),
                         ('aydan', '$2a$08$Qz0hS9FnFMVzCS2GGuw99uIk8VZLoCAzVWg81Qf5NzC6frS6m9K8K', true),
                         ('gunel', '$2a$08$9JbaHYDYOVzTInvz6d6i7O1Ut76vHBdJXCrZ/7xgD5YpAFQwK0lGS', true),
                         ('rashad', '$2a$08$SiHP4B5DI1XR31kxQU88.uIlgmxYM6gOxPFNu4fBmnpAz0uwNlb7a', true),
                         ('ali', '$2a$08$5XrznPknfIB9lyXua5tx2ejpulJJ.5o4RZA5BCcHIDPWZbSEyfXdy', true);

INSERT INTO AUTHORITIES values ('elvina', 'ROLE_ADMIN'),
                               ('aydan', 'ROLE_USER'),
                               ('gunel', 'ROLE_USER'),
                               ('rashad', 'ROLE_USER'),
                               ('ali', 'ROLE_USER');


INSERT INTO actor(FIRST_NAME, LAST_NAME, BIRTH_DATE, BIRTH_PLACE)
VALUES ('SANDRA','BULLOCK','1964-04-26', 'USA'),
       ('TREVANTE','RHODES','1990-02-10', 'USA'),
       ('JOHN','MALKOVICH','1953-02-09', 'USA'),
       ('DANIELLE','MACDONALD','1991-05-19', 'Australia'),
       ('SARAH','PAULSON','1974-12-17', 'USA'),
       ('ANNE','HATHAWAY','1982-11-12', 'USA'),
       ('JESSICA','CHASTAIN','1972-03-24', 'USA'),
       ('CHETIN','TEKINDOR','1945-07-16', 'Turkey'),
       ('MURAT','YILDIRIM','1979-04-13', 'Turkey'),
       ('ALI','ATAY','1976-04-20', 'Turkey'),
       ('MIRZAAGHA','ALIYEV','1983-10-25', 'Azerbaijan'),
       ('LEYLA','BADIRBEYLI','1920-01-08', 'Azerbaijan'),
       ('ALAKBAR','HUSEYNZADE','1887-10-03', 'Azerbaijan'),
       ('LEONARDO','DICAPRIO','1974-11-11', 'USA'),
       ('CILLIAN','MURPHY','1976-05-25', 'Ireland'),
       ('ZULEYKA','SILVER','1991-08-02', 'Mexico'),
       ('ASA','BUTTERFIELD','1997-01-04', 'United Kingdom'),
       ('ERICK','AVARI','1952-04-13', 'India'),
       ('GRAHAM','GREENE','1952-06-22', 'Canada'),
       ('THOMAS','KRETSCHMANN','1962-09-08', 'Germany');


INSERT INTO films(TITLE, PRODUCER, CATEGORY, LANGUAGE, RELEASE_DATE, DURATION)
VALUES  ('BIRD BOX', 'Dylan Clark', 'Horror', 'English', '2018-11-12', 124),
        ('INTERSTELLAR', 'Emma Thomas', 'Science Fiction', 'English', '2014-09-26', 121),
        ('AYLA', 'Caglar Ercan', 'War', 'Turkish', '2017-10-27', 123),
        ('ARSHIN MAL ALAN', 'Rza Tahmasib', 'Comedy', 'Azerbaijani', '1917-01-03', 96),
        ('INCEPTION', ' Emma Thomas', 'Science Fiction', 'English', '2010-07-08', 162),
        ('IN TIME', 'Andrew Niccol', 'Science Fiction', 'English', '2011-10-20', 109),
        ('THE BOY IN THE STRIPED PYJAMAS', 'David Heyman', 'Novel', 'English', '2008-09-12', 94),
        ('HACHIKO', 'Richard Gere', 'Drama', 'English', '2009-06-08', 93),
        ('THE GREEN MILE', 'Frank Darabont','Drama', 'English', '1999-12-10', 195),
        ('THE PIANIST', 'Roman Polanski','War', 'German', '2002-05-24', 170);


INSERT INTO films_actors(FILM_ID, ACTOR_ID)
VALUES
       (1,1),
       (1,2),
       (1,3),
       (1,4),
       (1,5),
       (2,6),
       (2,7),
       (3,8),
       (3,9),
       (3,10),
       (4,11),
       (4,12),
       (4,18),
       (5,14),
       (5,18),
       (6,15),
       (6,16),
       (7,17),
       (8,18),
       (9,18),
       (10,20);


