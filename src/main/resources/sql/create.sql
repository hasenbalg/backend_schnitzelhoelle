CREATE TABLE Schnitzel (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name varchar(255) NOT NULL,
    createdAt TIMESTAMP DEFAULT NOW()
);