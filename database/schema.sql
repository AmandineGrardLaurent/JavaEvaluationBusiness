DROP DATABASE IF EXISTS training_sales_application;
CREATE DATABASE training_sales_application;
USE training_sales_application;

CREATE TABLE person(
   id_person INT AUTO_INCREMENT,
   firstname VARCHAR(50),
   lastname VARCHAR(50),
   PRIMARY KEY(id_person)
) ENGINE = InnoDB;

CREATE TABLE user_(
   id_user INT AUTO_INCREMENT,
   password VARCHAR(50),
   id_person INT NOT NULL,
   PRIMARY KEY(id_user),
   FOREIGN KEY(id_person) REFERENCES person(id_person)
) ENGINE = InnoDB;

CREATE TABLE customer(
   id_customer INT AUTO_INCREMENT,
   address VARCHAR(100),
   email VARCHAR(50),
   phone_number VARCHAR(10),
   id_person INT NOT NULL,
   PRIMARY KEY(id_customer),
   UNIQUE(id_person),
   FOREIGN KEY(id_person) REFERENCES person(id_person)
) ENGINE = InnoDB;

CREATE TABLE course(
   id_course INT AUTO_INCREMENT,
   name VARCHAR(50),
   description VARCHAR(150),
   duration_days INT,
   is_on_site BOOLEAN,
   is_online BOOLEAN,
   price DECIMAL(7,2),
   PRIMARY KEY(id_course)
) ENGINE = InnoDB;

CREATE TABLE cart(
   id_cart INT AUTO_INCREMENT,
   id_user INT NOT NULL,
   PRIMARY KEY(id_cart),
   UNIQUE(id_user),
   FOREIGN KEY(id_user) REFERENCES user_(id_user)
) ENGINE = InnoDB;

CREATE TABLE order_(
   id_order INT AUTO_INCREMENT,
   total_amount DECIMAL(7,2),
   order_date DATE,
   id_user INT NOT NULL,
   id_customer INT NOT NULL,
   PRIMARY KEY(id_order),
   FOREIGN KEY(id_user) REFERENCES user_(id_user),
   FOREIGN KEY(id_customer) REFERENCES customer(id_customer)
) ENGINE = InnoDB;

CREATE TABLE cart_course(
   id_cart_course INT AUTO_INCREMENT,
   id_course INT,
   id_cart INT,
   PRIMARY KEY(id_cart_course),
   FOREIGN KEY(id_course) REFERENCES course(id_course),
   FOREIGN KEY(id_cart) REFERENCES cart(id_cart),
   UNIQUE(id_cart, id_course)
) ENGINE = InnoDB;

CREATE TABLE order_course(
   id_order_course INT AUTO_INCREMENT,
   id_course INT,
   id_order INT,
   PRIMARY KEY(id_order_course),
   FOREIGN KEY(id_course) REFERENCES course(id_course),
   FOREIGN KEY(id_order) REFERENCES order_(id_order),
   UNIQUE(id_order, id_course)
) ENGINE = InnoDB;
