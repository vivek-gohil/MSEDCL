DROP DATABASE customer_db;
CREATE DATABASE customer_db;
USE customer_db;
CREATE TABLE customer_details(
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    mobile_number VARCHAR(15) NOT NULL,
    created_at DATE NOT NULL,
    created_by VARCHAR(50) NOT NULL,
    updated_at DATE,
    updated_by VARCHAR(50)
);

SELECT * FROM customer_details;

CREATE DATABASE account_db;

USE account_db;

CREATE TABLE account_details(
    account_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT NOT NULL,
    account_type VARCHAR(20) NOT NULL,
    balance DOUBLE NOT NULL,
    created_at DATE NOT NULL,
    created_by VARCHAR(50) NOT NULL,
    updated_at DATE,
    updated_by VARCHAR(50)
);

CREATE DATABASE transaction_db;

USE transaction_db;

CREATE TABLE transaction_details(
    transaction_id INT AUTO_INCREMENT PRIMARY KEY,
    account_id INT NOT NULL,
    transaction_type VARCHAR(20) NOT NULL,
    amount DOUBLE NOT NULL,
    transaction_date DATE NOT NULL,
    created_at DATE NOT NULL,
    created_by VARCHAR(50) NOT NULL,
    updated_at DATE,
    updated_by VARCHAR(50)
);
