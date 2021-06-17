CREATE DATABASE `pet_manager`;
USE `pet_manager`;

CREATE TABLE `owners` (
  `OwnerId` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) DEFAULT NULL,
  `Gender` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`OwnerId`)
);

CREATE TABLE `pets` (
  `PetId` int NOT NULL AUTO_INCREMENT,
  `PetName` varchar(255) DEFAULT NULL,
  `Type` ENUM ('cat', 'dog', 'bird', 'hamster', 'reptile', 'other'),
  `OwnerId` int NOT NULL,
  `Birthday` date NOT NULL,
  PRIMARY KEY (`PetId`),
  KEY `ownerid_fk` (`OwnerId`),
	CONSTRAINT `ownerid_fk` FOREIGN KEY (`OwnerId`) REFERENCES `owners` (`OwnerId`)
);
