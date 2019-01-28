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
  `name` varchar(255) NOT NULL,
  `id` int(11) NOT NULL,
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
-- Table structure for table `Person`
--

DROP TABLE IF EXISTS `Person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Person` (
  `person_id` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(255) NOT NULL,
  `lname` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `ssnr` varchar(255) NOT NULL,
  `uname` varchar(255) NOT NULL,
  `pwd` varchar(255) NOT NULL,
  `roleId` int(11) NOT NULL,
  PRIMARY KEY (`person_id`)
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
-- Table structure for table `expertiseprofile`
--

DROP TABLE IF EXISTS `expertiseprofile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `expertiseprofile` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `expertise_id` int(11) NOT NULL,
  `person_id` int(11) NOT NULL,
  `years_of_ex` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKb6ptrjcjn62b62iiv0hd5mehn` (`expertise_id`),
  KEY `FKf6vawqkwiih5qjnaiw8out3uj` (`person_id`),
  CONSTRAINT `FKb6ptrjcjn62b62iiv0hd5mehn` FOREIGN KEY (`expertise_id`) REFERENCES `expertise` (`id`),
  CONSTRAINT `FKf6vawqkwiih5qjnaiw8out3uj` FOREIGN KEY (`person_id`) REFERENCES `person` (`person_id`),
  CONSTRAINT `expertiseprofile_ibfk_1` FOREIGN KEY (`person_id`) REFERENCES `Person` (`person_id`),
  CONSTRAINT `expertiseprofile_ibfk_2` FOREIGN KEY (`expertise_id`) REFERENCES `Expertise` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expertiseprofile`
--

LOCK TABLES `expertiseprofile` WRITE;
/*!40000 ALTER TABLE `expertiseprofile` DISABLE KEYS */;
/*!40000 ALTER TABLE `expertiseprofile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (1),(1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
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

-- Dump completed on 2019-01-28 14:00:51
