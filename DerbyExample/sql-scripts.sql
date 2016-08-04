connect 'jdbc:derby:/jbr/library;create=true';

CREATE TABLE users ( 
user_id INTEGER NOT NULL CONSTRAINT EMP_NO_PK PRIMARY KEY,
first_name VARCHAR(30) NOT NULL,
last_name VARCHAR(30) NOT NULL,
email VARCHAR(40),
phone INTEGER
);

INSERT INTO users VALUES(1,'Ranjith','Sekar','ranjith@gmail.com',96000);
INSERT INTO users VALUES(2,'Manoj','Kumar','manoj@gmail.com',88000);
INSERT INTO users VALUES(3,'Sachin','Tendulkar','sachin@gmail.com',77000);

CREATE TABLE books(
  book_id VARCHAR(30),
  book_name VARCHAR(30),
  authors VARCHAR(30),
  publisher VARCHAR(30),
  price INTEGER
);

INSERT INTO books VALUES('b100','Computer Science','John','TATA',400);
INSERT INTO books VALUES('b200','Mathematics','David','Oreilly',300);
INSERT INTO books VALUES('b300','Java Complete Reference','Jonathan','PSB',600);