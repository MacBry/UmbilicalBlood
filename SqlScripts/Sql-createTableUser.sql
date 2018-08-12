CREATE DATABASE  IF NOT EXISTS `CRUD-Krew-Pepowiny`;
USE `CRUD-Krew-Pepowiny`;

--
-- Table structure for table `USER`
--

DROP TABLE IF EXISTS `USER`;

CREATE TABLE `USER` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `permission` boolean NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

