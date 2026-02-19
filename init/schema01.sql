CREATE TABLE printers (
  id SERIAL PRIMARY KEY NOT NULL,
  brand VARCHAR(255) NOT NULL,
  model VARCHAR(255) NOT NULL,
  type VARCHAR(255) NOT NULL,
  stock INT NOT NULL
);

CREATE TABLE toners (
  id SERIAL PRIMARY KEY NOT NULL,
  brand VARCHAR(255) NOT NULL,
  model VARCHAR(255) NOT NULL,
  size INT NOT NULL,
  type VARCHAR(255) NOT NULL,
  stock INT NOT NULL
);

INSERT INTO printers(brand, model, type, stock)
VALUES ('HP', 'MF255', 'Laser', 2),
      ('Cannon', 'TS232', 'Multifunction', 5),
      ('Brother', 'FD31', 'Ink', 1),
      ('Konica', 'CZ250i', 'Ink', 2),
      ('Epson', 'EK55', 'Laser', 1);

INSERT INTO toners (brand, model, size, type, stock)
VALUES ('Brother', 'TN-1030', 2000, 'Laser', 3),
       ('HP', '11S', 1000, 'Ink', 4),
       ('HP', '285A', 1500, 'Laser', 3);
