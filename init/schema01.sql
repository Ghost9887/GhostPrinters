CREATE TABLE printers (
  id SERIAL PRIMARY KEY NOT NULL,
  name VARCHAR(255) NOT NULL
);

INSERT INTO printers(name)
VALUES ('HP'),
      ('Cannon'),
      ('Brother'),
      ('Konica');
