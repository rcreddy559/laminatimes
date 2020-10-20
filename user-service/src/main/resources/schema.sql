DROP TABLE IF EXISTS TBL_USER;

CREATE TABLE TBL_USER (
   id INT AUTO_INCREMENT  PRIMARY KEY,
   first_name VARCHAR(250) NOT NULL,
   last_name VARCHAR(250) NOT NULL,
   email VARCHAR(250) DEFAULT NULL,
   date_of_birth VARCHAR(250) DEFAULT NULL,
   address VARCHAR(250) DEFAULT NULL,
   phone_number VARCHAR(250) DEFAULT NULL,
   user_name VARCHAR(250) DEFAULT NULL,
   password VARCHAR(250) DEFAULT NULL,
   active INT DEFAULT 0,
   gender VARCHAR(250) DEFAULT NULL,
   role INT DEFAULT 3
);

INSERT INTO TBL_USER (first_name, last_name, email, date_of_birth, address, phone_number, user_name, password, active, gender, role)
            VALUES ('ravi', 'reddy', 'demo@example.com', '1981-08-12', 'india', '15783022000', 'rcreddy', 'test', 0, 'M', 1);

INSERT INTO TBL_USER (first_name, last_name, email, date_of_birth, address, phone_number, user_name, password, active, gender, role)
        VALUES ('sravan', 'palakala', 'palakala@example.com', '1981-08-12', 'india', '15783022000', 'palakala', 'test', 0, 'M', 2);

INSERT INTO TBL_USER (first_name, last_name, email, date_of_birth, address, phone_number, user_name, password, active, gender, role)
        VALUES ('Divija', 'Ravichandra', 'divija@example.com', '1981-08-12', 'india', '15783022000', 'palakala', 'test', 0, 'F', 3);

INSERT INTO TBL_USER (first_name, last_name, email, date_of_birth, address, phone_number, user_name, password, active, gender, role)
        VALUES ('Shobha', 'Ravichandra', 'shoba@example.com', '1981-08-12', 'india', '15783022000', 'palakala', 'test', 0, 'F', 3);