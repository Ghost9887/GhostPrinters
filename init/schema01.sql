CREATE TABLE printers (
  id SERIAL PRIMARY KEY NOT NULL,
  brand VARCHAR(255) NOT NULL,
  model VARCHAR(255) NOT NULL,
  type VARCHAR(255) NOT NULL
);

CREATE TABLE toners (
  id SERIAL PRIMARY KEY NOT NULL,
  brand VARCHAR(255) NOT NULL,
  model VARCHAR(255) NOT NULL,
  size INT NOT NULL,
  type VARCHAR(255) NOT NULL
);

INSERT INTO printers(brand, model, type)
VALUES ('HP', 'MF255', 'Laser'),
      ('Cannon', 'TS232', 'Multifunction'),
      ('Brother', 'FD31', 'Ink'),
      ('Konica', 'CZ250i', 'Ink'),
      ('Epson', 'EK55', 'Laser');

INSERT INTO toners (brand, model, size, type)
VALUES ('Brother', 'TN-1030', '2000', 'Laser'),
       ('HP', '11S', '1000', 'Ink'),
       ('HP', '285A', '1500', 'Laser');
