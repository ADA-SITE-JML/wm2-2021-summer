INSERT INTO actor(FIRST_NAME, LAST_NAME, BIRTH_DATE, birth_place)
VALUES ('PENELOPE','GUINESS','2006-02-15', 'USA'),
       ('SISSY','SOBIESKI','2001-02-15', 'England'),
       ('TIM','HACKMAN','1996-02-15', 'Norway'),
       ('MILLA','PECK','1806-02-15', 'USA'),
       ('AUDREY','OLIVIER','2006-02-15', 'Azerbaijan'),
       ('JUDY','DEAN','2006-02-15', 'Turkey'),
       ('BURT','DUKAKIS','2006-02-15', 'USA'),
       ('VAL','BOLGER','2006-02-15', 'Russia'),
       ('TOM','MCKELLEN','2006-02-15', 'Chinese');

INSERT INTO films(TITLE, CATEGORY, LANGUAGE, RELEASE_YEAR, DURATION)
VALUES  ('Bird Box', 'Horror', 'English', '2006-02-15', '02:31:04'),
        ('Intersellar', 'Horror', 'English', '2006-02-15', '02:31:04'),
        ('Inception', 'Horror', 'English', '2006-02-15', '02:31:04'),
        ('Labirint', 'Horror', 'English', '2006-02-15', '02:31:04'),
        ('Labirint 3', null, 'English', '2006-02-15', '02:31:04'),
        ('Vikings', 'Horror', 'English', '2006-02-15', '02:31:04');


INSERT INTO films_actors(FILM_ID, ACTOR_ID)
VALUES
       (1,1),
       (1,2),
       (1,3),
       (1,4),
       (1,5),
       (1,6),
       (2,2),
       (2,1);


