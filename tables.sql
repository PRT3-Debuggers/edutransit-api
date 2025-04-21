USE prt3debuggers;

/*Ethan*/
CREATE TABLE user(
	user_id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    email_address VARCHAR(255),
    password VARCHAR (255),
    
    PRIMARY KEY(user_id)
);

CREATE TABLE parent(
	user_id INT NOT NULL,
    parent_id INT NOT NULL AUTO_INCREMENT,
    
    PRIMARY KEY(parent_id),
    FOREIGN KEY(user_id) REFERENCES user(user_id)
);

/*  Ross Barth */
CREATE TABLE driver (                               
    driver_id INT NOT NULL AUTO_INCREMENT,
    user_id INT NOT NULL , 
	criminal_record VARCHAR(255), 
    max_passengers VARCHAR(255),
    available_seats VARCHAR(255),

    PRIMARY KEY (driver_id),
    FOREIGN KEY (user_id) REFERENCES user(user_id)
);

CREATE TABLE chat(
	chat_id INT NOT NULL AUTO_INCREMENT,
    parent_id INT NOT NULL,
    driver_id INT NOT NULL,
    date_created DATETIME NOT NULL,
    
    PRIMARY KEY(chat_id),
    FOREIGN KEY(parent_id) REFERENCES parent(parent_id),
    FOREIGN KEY(driver_id) REFERENCES driver(driver_id)
);

CREATE TABLE message(
	message_id INT NOT NULL AUTO_INCREMENT,
    user_id INT NOT NULL,
    date_sent DATETIME NOT NULL,
    content TEXT,
    
    PRIMARY KEY(message_id),
    FOREIGN KEY(user_id) REFERENCES user(user_id)
);

CREATE TABLE chatmessage(
	chat_id INT NOT NULL,
	message_id INT NOT NULL,
    
    PRIMARY KEY(chat_id,message_id),
    FOREIGN KEY(chat_id) REFERENCES chat(chat_id),
    FOREIGN KEY(message_id) REFERENCES message(message_id)
);

CREATE TABLE school (
    school_id INT NOT NULL AUTO_INCREMENT,
    school_name VARCHAR(255),
    school_address VARCHAR(255),
    
    PRIMARY KEY(school_id)
);

/*Zimkhitha Jantjies*/
CREATE TABLE language (
	language_id INT NOT NULL AUTO_INCREMENT,
	language_name VARCHAR(50) NOT NULL,                
    code VARCHAR(3) NOT NULL,
    
    PRIMARY KEY(language_id)
);

/*Zimkhitha Jantjies*/
CREATE TABLE driverlanguage (
    driver_id INT NOT NULL,
    language_id INT NOT NULL, 

    PRIMARY KEY (driver_id, language_id),
    FOREIGN KEY (driver_id) REFERENCES driver(driver_id),
    FOREIGN KEY (language_id) REFERENCES language(language_id)
);

/* Ross Barth */
CREATE TABLE driverschool (                         
    driver_id INT NOT NULL,
    school_id INT NOT NULL,

    PRIMARY KEY (driver_id,school_id),
    FOREIGN KEY (school_id) REFERENCES school(school_id),
    FOREIGN KEY (driver_id) REFERENCES driver(driver_id)
);

/*Bonga Velem*/
CREATE TABLE profileimage (                     
   image_id INT NOT NULL AUTO_INCREMENT,
   image_url VARCHAR(2048) NOT NULL,
  PRIMARY KEY (image_id)
);

/*Casey Nolte*/
CREATE TABLE vehicle (
    vehicle_id INT AUTO_INCREMENT,
    vehicle_model VARCHAR(255) NOT NULL,
    vehicle_type VARCHAR(255) NOT NULL,
    
    PRIMARY KEY (vehicle_id)
);

CREATE TABLE drivervehicle (
	driver_id INT NOT NULL,
    vehicle_id INT NOT NULL,
    
    PRIMARY KEY (driver_id,vehicle_id),
    FOREIGN KEY (driver_id) REFERENCES driver(driver_id),
    FOREIGN KEY (vehicle_id) REFERENCES vehicle(vehicle_id)
);
