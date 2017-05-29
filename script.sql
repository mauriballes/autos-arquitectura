-- Crear Usuario para acceder a la BD
CREATE USER 'auto'@'localhost'
IDENTIFIED BY 'auto';
GRANT ALL PRIVILEGES ON *.* TO 'auto'@'localhost';
FLUSH PRIVILEGES;

-- Crear BD
CREATE DATABASE imcruz;
USE imcruz;

-- Crear Tabla
-- DROP TABLE marcas;
CREATE TABLE marcas (
	id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

-- DROP TABLE autos;
CREATE TABLE autos (
	id INT NOT NULL AUTO_INCREMENT,
    modelo VARCHAR(255) NOT NULL,
    ano INT NOT NULL,
    precio FLOAT NOT NULL,
    marca_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (marca_id) REFERENCES marcas(id)
		ON UPDATE CASCADE
        ON DELETE CASCADE
);

-- Poblada
INSERT INTO imcruz.marcas(nombre) VALUES 
("Toyota"),
("Nissan"),
("Honda"),
("Bugatti");

INSERT INTO imcruz.autos(modelo, ano, precio, marca_id) VALUES
("Land Cruisser", 2017, 45000.00, 1),
("Corolla", 2016, 23700.00, 1),
("350z", 2017, 35000.00, 2),
("PathFinder", 2017, 48000.00, 2),
("Civic", 2014, 35100.00, 3),
("Crv", 2017, 23700.00, 3),
("Veyron", 2017, 1800000.00, 4);