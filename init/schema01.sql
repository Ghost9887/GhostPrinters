CREATE TABLE printers (
  id SERIAL PRIMARY KEY NOT NULL,
  name VARCHAR(255) NOT NULL
);

CREATE TABLE toners (
  id SERIAL PRIMARY KEY NOT NULL,
  name VARCHAR(255) NOT NULL,
  size INT NOT NULL
);

INSERT INTO printers(name)
VALUES ('HP'),
      ('Cannon'),
      ('Brother'),
      ('Konica'),
      ('Epson');

INSERT INTO toners (name, size)
VALUES ('TN-1030', '2000'),
       ('11S', '1000'),
       ('285A', '1500');
