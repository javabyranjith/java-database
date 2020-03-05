CREATE DATABSE employee IF NOT EXISTS;

CREATE TABLE empinfo(empid INTEGER(10) NOT NULL, 
					firstname VARCHAR(20) NOT NULL, 
					lastname VARCHAR(20), 
					dob DATE, 
					designation VARCHAR(10), 
					doj DATE, 
					CONSTRAINT PRIMARY KEY (empid));
					
CREATE TABLE empcontact(empid INTEGER NOT NULL, 
			 			doorno INTEGER NOT NULL, 
			 			street VARCHAR(20) NOT NULL, 
			 			city VARCHAR(20), 
			 			country VARCHAR(20), 
			 			pincode INTEGER, 
			 			phone BIGINT(14), 
			 			mobileno1 BIGINT(14) NOT NULL,
			 			mobileno2 BIGINT(14),
			 			CONSTRAINT FOREIGN KEY (empid) REFERENCES empinfo(empid));
			 			
CREATE TABLE empsalary(empid INTEGER NOT NULL, 
						basic DOUBLE NOT NULL, 
						hra DOUBLE, 
						allowance DOUBLE, 
						deduction DOUBLE,
						CONSTRAINT FOREIGN KEY (empid) REFERENCES empinfo(empid));
						
ALTER TABLE empinfo
MODIFY COLUMN designation VARCHAR(30);