DROP DATABASE IF EXISTS travel2;
CREATE DATABASE travel2;
USE travel2;

DROP TABLE IF EXISTS users;

CREATE TABLE users(
	UserName varchar(50) NOT NULL,
    Password varchar(50) NOT NULL,
	Name varchar(50) NOT NULL,
    Access varchar(50) NOT NULL
);

INSERT INTO users (UserName, Password, Name, Access) VALUES ("AdminUserName", "AdminPassword", "Administrator", "admin");
INSERT INTO users (UserName, Password, Name, Access) VALUES ("EditorUserName", "EditorPassword", "Editor", "editor");
INSERT INTO users (UserName, Password, Name, Access) VALUES ("EdwardRiley", "emr9018", "Edward", "general");