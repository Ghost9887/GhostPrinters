CREATE TABLE printers (
  id SERIAL PRIMARY KEY NOT NULL,
  brand VARCHAR(255) NOT NULL,
  model VARCHAR(255) NOT NULL,
  type VARCHAR(255) NOT NULL,
  amount INT NOT NULL
);

CREATE TABLE toners (
  id SERIAL PRIMARY KEY NOT NULL,
  brand VARCHAR(255) NOT NULL,
  model VARCHAR(255) NOT NULL,
  size INT NOT NULL,
  type VARCHAR(255) NOT NULL,
  stock INT NOT NULL
);

INSERT INTO printers(brand, model, type, amount)
VALUES ('HP', 'MF255', 'laser', 2),
      ('Cannon', 'TS232', 'multi', 5),
      ('Brother', 'FD31', 'ink', 1),
      ('Konica', 'CZ250i', 'ink', 2),
      ('Epson', 'EK55', 'laser', 1);

INSERT INTO toners (brand, model, size, type, stock)
VALUES ('Brother', 'TN-1030', 2000, 'laser', 3),
       ('HP', '11S', 1000, 'ink', 4),
       ('HP', '285A', 1500, 'laser', 3);
