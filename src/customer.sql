
CREATE DATABASE customer;
USE customer;

CREATE TABLE Customer (
    customer_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_last_name VARCHAR(50),
    customer_first_name VARCHAR(50),
    customer_phone VARCHAR(20)
);

INSERT INTO Customer (customer_last_name, customer_first_name, customer_phone)
VALUES
('Chenda', 'Sovisal', '092888999'),
('Kom', 'Lina', '092000999'),
('Chan', 'Seyha', '092777666');
