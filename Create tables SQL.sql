DROP DATABASE IF EXISTS pie_shop; 
CREATE DATABASE pie_shop;
USE pie_shop;

DROP TABLE IF EXISTS order_pies; 
DROP TABLE IF EXISTS orders; 
DROP TABLE IF EXISTS reviews; 
DROP TABLE IF EXISTS pies; 
DROP TABLE IF EXISTS customer; 


CREATE TABLE customer( 
customer_id INT NOT NULL AUTO_INCREMENT, 
first_name VARCHAR(50) NOT NULL, 
last_name VARCHAR(50) NOT NULL, 
address VARCHAR(50) NOT NULL, 
phone_number VARCHAR(50) NOT NULL, 
PRIMARY KEY (customer_id) 
); 

CREATE TABLE pies( 
pie_id INT NOT NULL AUTO_INCREMENT, 
name VARCHAR(50) NOT NULL, 
description VARCHAR(300) NOT NULL, 
gluten_free BOOLEAN, 
price DOUBLE NOT NULL, 
PRIMARY KEY (pie_id) 
); 

CREATE TABLE reviews( 
review_id INT NOT NULL AUTO_INCREMENT,
customer_id INT NOT NULL, 
text_body VARCHAR(300) NOT NULL, 
PRIMARY KEY (review_id) ,
FOREIGN KEY (customer_Id) references customer(customer_id)
); 

CREATE TABLE orders( 
order_id INT NOT NULL AUTO_INCREMENT, 
customer_id INT NOT NULL, 
order_date date NOT NULL, 
gift_note BOOLEAN, 
PRIMARY KEY (order_id),
FOREIGN KEY(customer_id) REFERENCES customer(customer_id) 
ON DELETE CASCADE
); 


CREATE TABLE order_pies( 
order_id INT NOT NULL, 
pie_id INT NOT NULL, 
PRIMARY KEY (order_id, pie_id),
FOREIGN KEY(order_id) REFERENCES orders (order_id) 
ON DELETE CASCADE, 
FOREIGN KEY (pie_id) REFERENCES pies (pie_id)
); 

 

 

 

 

 

 

 

	 