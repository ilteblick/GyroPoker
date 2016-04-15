-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: gyropokerdb
-- ------------------------------------------------------
-- Server version	5.5.46-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `idAccount` int(11) NOT NULL AUTO_INCREMENT,
  `A_Name` varchar(45) NOT NULL,
  `A_Surename` varchar(45) NOT NULL,
  `A_Email` varchar(45) NOT NULL,
  `A_address` varchar(100) NOT NULL,
  `A_phone` varchar(45) NOT NULL,
  `Country_idCountry` int(11) NOT NULL,
  `A_balance` decimal(65,2) NOT NULL,
  `A_PlayMoney_balance` decimal(65,2) NOT NULL,
  PRIMARY KEY (`idAccount`),
  UNIQUE KEY `idAccount_UNIQUE` (`idAccount`),
  UNIQUE KEY `A_Email_UNIQUE` (`A_Email`),
  KEY `fk_Account_Country_idx` (`Country_idCountry`),
  CONSTRAINT `fk_Account_Country` FOREIGN KEY (`Country_idCountry`) REFERENCES `country` (`idCountry`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `city` (
  `idCity` int(11) NOT NULL AUTO_INCREMENT,
  `C_City_Name` varchar(45) NOT NULL,
  `Country_idCountry` int(11) NOT NULL,
  PRIMARY KEY (`idCity`),
  KEY `fk_City_Country1_idx` (`Country_idCountry`),
  CONSTRAINT `fk_City_Country1` FOREIGN KEY (`Country_idCountry`) REFERENCES `country` (`idCountry`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,'Minsk',1),(2,'Brest',1),(3,'Moskow',2),(4,'St. Petersburg',2),(5,'Warsaw',3),(6,'Gdansk',3);
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `country` (
  `idCountry` int(11) NOT NULL AUTO_INCREMENT,
  `C_Country_Name` varchar(45) NOT NULL,
  PRIMARY KEY (`idCountry`),
  UNIQUE KEY `idCountry_UNIQUE` (`idCountry`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES (1,'Belarus'),(2,'Russia'),(3,'Poland');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `operation`
--

DROP TABLE IF EXISTS `operation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `operation` (
  `id_Account` int(11) NOT NULL,
  `id_Operation_type` int(11) NOT NULL,
  `O_Summ` decimal(65,2) NOT NULL,
  `O_Date` date NOT NULL,
  PRIMARY KEY (`id_Account`,`id_Operation_type`),
  KEY `fk_Account_has_Operation_type_Operation_type1_idx` (`id_Operation_type`),
  KEY `fk_Account_has_Operation_type_Account1_idx` (`id_Account`),
  CONSTRAINT `fk_Account_has_Operation_type_Account1` FOREIGN KEY (`id_Account`) REFERENCES `account` (`idAccount`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Account_has_Operation_type_Operation_type1` FOREIGN KEY (`id_Operation_type`) REFERENCES `operation_type` (`idOperation_type`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operation`
--

LOCK TABLES `operation` WRITE;
/*!40000 ALTER TABLE `operation` DISABLE KEYS */;
/*!40000 ALTER TABLE `operation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `operation_type`
--

DROP TABLE IF EXISTS `operation_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `operation_type` (
  `idOperation_type` int(11) NOT NULL AUTO_INCREMENT,
  `OT_type` varchar(45) NOT NULL,
  PRIMARY KEY (`idOperation_type`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operation_type`
--

LOCK TABLES `operation_type` WRITE;
/*!40000 ALTER TABLE `operation_type` DISABLE KEYS */;
INSERT INTO `operation_type` VALUES (1,'Deposit'),(2,'Withdraw');
/*!40000 ALTER TABLE `operation_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phone_prefix`
--

DROP TABLE IF EXISTS `phone_prefix`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `phone_prefix` (
  `idPhone_Prefix` int(11) NOT NULL AUTO_INCREMENT,
  `P_prefix` varchar(5) NOT NULL,
  `Country_idCountry` int(11) NOT NULL,
  PRIMARY KEY (`idPhone_Prefix`),
  KEY `fk_Phone_Prefix_Country1_idx` (`Country_idCountry`),
  CONSTRAINT `fk_Phone_Prefix_Country1` FOREIGN KEY (`Country_idCountry`) REFERENCES `country` (`idCountry`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phone_prefix`
--

LOCK TABLES `phone_prefix` WRITE;
/*!40000 ALTER TABLE `phone_prefix` DISABLE KEYS */;
INSERT INTO `phone_prefix` VALUES (1,'+375',1),(2,'+7',2),(3,'+48',3);
/*!40000 ALTER TABLE `phone_prefix` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'gyropokerdb'
--

--
-- Dumping routines for database 'gyropokerdb'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-02 18:08:33
