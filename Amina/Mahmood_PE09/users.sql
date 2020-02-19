DROP DATABASE IF EXISTS travel2;

CREATE DATABASE travel2;

USE travel2;

DROP TABLE IF EXISTS users;

CREATE TABLE users(
	userName varchar(25) NOT NULL,
    password varchar(25) NOT NULL,
	name varchar(25) NOT NULL,
    access varchar(25) NOT NULL
);

INSERT INTO users (userName, password, name, access) VALUES("SakuraAmy", "CrazyMeme10", "Amina", "general");

INSERT INTO users (UserName, password, name, access) VALUES("AdamBrodackGamer", "GamerSpace100", "Adam", "editor");

INSERT INTO users (UserName, password, name, access) VALUES("CoolProfessor", "TeethFlosser", "Floeser", "admin");

