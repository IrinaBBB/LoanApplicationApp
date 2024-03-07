CREATE SCHEMA IF NOT EXISTS loan_app;

CREATE TABLE IF NOT EXISTS loan_app.Laanesoeknad
(
    id                INT AUTO_INCREMENT PRIMARY KEY,
    lanebelop         DOUBLE,
    behov             VARCHAR(255),
    lopetid           INT,
    avdragsfriPeriode INT,
    type              ENUM ('annuitet', 'serie'),
    status            ENUM ('motatt', 'ukjent', 'behandles', 'godkjent')
);

CREATE TABLE IF NOT EXISTS loan_app.Laanetaker
(
    id             INT AUTO_INCREMENT PRIMARY KEY,
    foedselsnummer BIGINT,
    navn           VARCHAR(255),
    foedselsdato   DATE
);


CREATE TABLE IF NOT EXISTS loan_app.Laanesoeknad_Laanetaker
(
    laanesoeknad_id INT,
    laanetaker_id   INT,
    PRIMARY KEY (laanesoeknad_id, laanetaker_id),
    FOREIGN KEY (laanesoeknad_id) REFERENCES loan_app.Laanesoeknad (id),
    FOREIGN KEY (laanetaker_id) REFERENCES loan_app.Laanetaker (id)
);

INSERT INTO loan_app.Laanesoeknad (lanebelop, behov, lopetid, avdragsfriPeriode, type, status)
VALUES (100000, 'Boligkjøp', 10, 2, 'annuitet', 'godkjent'),
       (50000, 'Bilreparasjon', 5, 1, 'serie', 'behandles'),
       (150000, 'Oppussing', 15, 3, 'annuitet', 'motatt');

-- Seed data for Laanetaker table
INSERT INTO loan_app.Laanetaker (foedselsnummer, navn, foedselsdato)
VALUES (12345678901, 'Ole Hansen', '1990-05-15'),
       (23456789012, 'Mette Olsen', '1985-10-20'),
       (34567890123, 'Lars Pedersen', '1992-03-25'),
       (45678901234, 'Ingrid Johansen', '1988-07-12'),
       (56789012345, 'Per Andersen', '1995-01-30'),
       (67890123456, 'Line Nielsen', '1993-09-05');


-- Seed data for the junction table
INSERT INTO loan_app.Laanesoeknad_Laanetaker (laanesoeknad_id, laanetaker_id)
VALUES (1, 1), -- Ole Hansen applies for Laanesoeknad 1
       (1, 2), -- Mette Olsen applies for Laanesoeknad 1
       (2, 3), -- Lars Pedersen applies for Laanesoeknad 2
       (2, 4), -- Ingrid Johansen applies for Laanesoeknad 2
       (3, 5), -- Per Andersen applies for Laanesoeknad 3
       (3, 6); -- Line Nielsen applies for Laanesoeknad 3