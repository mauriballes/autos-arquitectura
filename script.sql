-- Crear Usuario para acceder a la BD
CREATE USER 'auto'@'localhost'
IDENTIFIED BY 'auto';
GRANT ALL PRIVILEGES ON *.* TO 'auto'@'localhost';
FLUSH PRIVILEGES;

-- Crear BD
CREATE DATABASE imcruz;
USE imcruz;

-- Crear Tabla
CREATE TABLE marcas (
	id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE autos (
	id INT NOT NULL AUTO_INCREMENT,
    modelo VARCHAR(255) NOT NULL,
    ano INT NOT NULL,
    marca_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (marca_id) REFERENCES marcas(id)
		ON UPDATE CASCADE
        ON DELETE CASCADE
);

