CREATE DATABASE  IF NOT EXISTS `FairGrounds` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `FairGrounds`;
-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: FairGrounds
-- ------------------------------------------------------
-- Server version	5.7.20

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
-- Table structure for table `AVAILABILITY`
--

DROP TABLE IF EXISTS `AVAILABILITY`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `AVAILABILITY` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fromDate` date NOT NULL,
  `toDate` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `AVAILABILITY`
--

LOCK TABLES `AVAILABILITY` WRITE;
/*!40000 ALTER TABLE `AVAILABILITY` DISABLE KEYS */;
/*!40000 ALTER TABLE `AVAILABILITY` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `EXPERTISE`
--

DROP TABLE IF EXISTS `EXPERTISE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `EXPERTISE` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `EXPERTISE`
--

LOCK TABLES `EXPERTISE` WRITE;
/*!40000 ALTER TABLE `EXPERTISE` DISABLE KEYS */;
/*!40000 ALTER TABLE `EXPERTISE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `EXPERTISEPROFILE`
--

DROP TABLE IF EXISTS `EXPERTISEPROFILE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `EXPERTISEPROFILE` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `personId` bigint(20) NOT NULL,
  `expertiseId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `personId` (`personId`),
  KEY `expertiseId` (`expertiseId`),
  CONSTRAINT `expertiseprofile_ibfk_1` FOREIGN KEY (`personId`) REFERENCES `Person` (`ssnr`),
  CONSTRAINT `expertiseprofile_ibfk_2` FOREIGN KEY (`expertiseId`) REFERENCES `Expertise` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `EXPERTISEPROFILE`
--

LOCK TABLES `EXPERTISEPROFILE` WRITE;
/*!40000 ALTER TABLE `EXPERTISEPROFILE` DISABLE KEYS */;
/*!40000 ALTER TABLE `EXPERTISEPROFILE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Person`
--

DROP TABLE IF EXISTS `Person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Person` (
  `fname` varchar(255) NOT NULL,
  `lname` varchar(255) NOT NULL,
  `ssnr` bigint(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  `uname` varchar(255) NOT NULL,
  `pwd` varchar(255) NOT NULL,
  `roleId` int(11) NOT NULL,
  PRIMARY KEY (`ssnr`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Person`
--

LOCK TABLES `Person` WRITE;
/*!40000 ALTER TABLE `Person` DISABLE KEYS */;
/*!40000 ALTER TABLE `Person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'FairGrounds'
--

--
-- Dumping routines for database 'FairGrounds'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-25 14:42:30
