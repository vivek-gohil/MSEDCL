DROP DATABASE msedcldb;
CREATE DATABASE msedcldb;

USE msedcldb;

CREATE TABLE employee_details(
	employee_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
	last_name VARCHAR(50) NOT NULL,
    salary DOUBLE NOT NULL
);

INSERT INTO employee_details(first_name,last_name,salary) 
VALUES('Badrinath','F',200000);
INSERT INTO employee_details(first_name,last_name,salary) 
VALUES('Rajendra','B',500000);

SELECT * FROM employee_details;




commit;

CREATE TABLE login_details(
	login_id INT AUTO_INCREMENT PRIMARY KEY,
    password VARCHAR(50) NOT NULL,
    invalid_login_count INT NOT NULL,
    login_status VARCHAR(50) NOT NULL
);

INSERT INTO login_details(password,invalid_login_count,login_status)
VALUES('ABC',0,'ACTIVE');
INSERT INTO login_details(password,invalid_login_count,login_status)
VALUES('PQR',0,'ACTIVE');
INSERT INTO login_details(password,invalid_login_count,login_status)
VALUES('MNO',0,'ACTIVE');

SELECT * FROM login_details;
DROP TABLE account_details;
CREATE TABLE account_details(
	account_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    balance DOUBLE NOT NULL,
    account_type VARCHAR(50) NOT NULL,
    minimum_balance DOUBLE, -- from saving account
    overdraft_balance DOUBLE -- from current account 
);

SELECT * FROM account_details;
SELECT * FROM current_account_details;
SELECT * FROM savings_account_details;
SELECT * FROM account_seq;


CREATE TABLE address_details(
	address_id INT AUTO_INCREMENT PRIMARY KEY,
	city VARCHAR(50) NOT NULL,
	pin VARCHAR(10) NOT NULL,
    user_id INT NOT NULL,
    CONSTRAINT user_id_fk FOREIGN KEY(user_id) REFERENCES user_details(user_id) 
);

CREATE TABLE user_details(
	user_id INT AUTO_INCREMENT PRIMARY KEY,
	user_name VARCHAR(50) NOT NULL
);


INSERT INTO address_details(city,pin) 
VALUES('Pune','400013');
INSERT INTO address_details(city,pin) 
VALUES('Mumbai','400012');



INSERT INTO user_details(user_name,address_id)
VALUES('laxman',1);
INSERT INTO user_details(user_name,address_id)
VALUES('vinod',2);


SELECT * FROM address_details;
SELECT * FROM user_details;

SELECT u.user_name,a.city FROM address_details a JOIN user_details u
ON a.address_id = u.address_id WHERE u.user_name = 'vinod';


DROP TABLE address_details;
DROP TABLE user_details;
SELECT * FROM address_details;
SELECT * FROM user_details;






