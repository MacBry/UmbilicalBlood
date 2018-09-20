CREATE DATABASE  IF NOT EXISTS `CRUD-Krew-Pepowiny`;
USE `CRUD-Krew-Pepowiny`;

--
-- Table structure for table `MOTHER`
--
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `MOTHER_ADRESS`;

CREATE TABLE `MOTHER_ADRESS` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `city` varchar(128) DEFAULT NULL,
  `zip_code` varchar(45) DEFAULT NULL,
  `prefix` varchar(45) DEFAULT NULL,
  `street` varchar(45) DEFAULT NULL,
  `house_number` varchar(45) DEFAULT NULL,
  `local_number` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `MOTHER`;

CREATE TABLE `MOTHER` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `surname` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `PESEL` varchar(45) DEFAULT NULL,
  `mother_adress_id` int(11) DEFAULT NULL,
  `hospital_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_MOTHER_ADRESS_idx` (`MOTHER_ADRESS_id`),
  CONSTRAINT `FK_MOTHER_ADRESS` FOREIGN KEY (`MOTHER_ADRESS_id`) REFERENCES `MOTHER_ADRESS` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  KEY `FK_HOSPITAL_idx` (`HOSPITAL_id`),
  CONSTRAINT `FK_HOSPITAL` FOREIGN KEY (`HOSPITAL_id`) REFERENCES `HOSPITAL` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;