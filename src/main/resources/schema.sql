-- MySQL dump 10.13  Distrib 5.7.21, for Linux (x86_64)
--
-- Host: localhost    Database: elasticsearch
-- ------------------------------------------------------
-- Server version	5.7.21-1ubuntu1

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
-- Table structure for table `profile`
--

DROP TABLE IF EXISTS `profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profile` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `first_name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `last_name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `points` mediumint(8) unsigned NOT NULL DEFAULT '0',
  `birth_date` date DEFAULT NULL,
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `version` bigint(20) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profile`
--

LOCK TABLES `profile` WRITE;
/*!40000 ALTER TABLE `profile` DISABLE KEYS */;
INSERT INTO `profile` VALUES (1,'Sophie','Potter',100,'1990-01-01','1970-01-01 00:00:00','1970-01-01 00:00:00',0),(2,'John','Smith',0,NULL,'1970-01-01 00:00:00','1970-01-01 00:00:00',0),(3,'Samantha','Blake',49,'1980-01-01','1970-01-01 00:00:00','1970-01-01 00:00:00',0),(4,'Frederick','Logan',20,'1985-02-05','1970-01-01 00:00:00','1970-01-01 00:00:00',0),(5,'Julius','Walker',1000,'1970-01-01','1970-01-01 00:00:00','1970-01-01 00:00:00',0),(6,'Lisa','Bell',80,NULL,'1970-01-01 00:00:00','1970-01-01 00:00:00',0),(7,'Hugh','Carson',0,'1995-04-08','1970-01-01 00:00:00','1970-01-01 00:00:00',0),(8,'Chriss','Stone',50,'1992-06-06','1970-01-01 00:00:00','1970-01-01 00:00:00',0),(9,'Lorene','Pierce',10,NULL,'1970-01-01 00:00:00','1970-01-01 00:00:00',0),(10,'Grace','Potter',100,'1978-05-09','1970-01-01 00:00:00','1970-01-01 00:00:00',0);
/*!40000 ALTER TABLE `profile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `profile_id` bigint(20) unsigned NOT NULL,
  `created_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_on` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `version` bigint(20) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `user_fk1` (`profile_id`),
  CONSTRAINT `user_fk1` FOREIGN KEY (`profile_id`) REFERENCES `profile` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'sophiepotter','{bcrypt}$2a$10$BudzAdPY785cCMI6S5nTvemXrP7Iu.6TtbaKSPsAYLMO8bNWRppW.','sophiepotter@example.com',1,'1970-01-01 00:00:00','1970-01-01 00:00:00',0),(2,'johnsmith','{bcrypt}$2a$10$BudzAdPY785cCMI6S5nTvemXrP7Iu.6TtbaKSPsAYLMO8bNWRppW.','johnsmith@example.com',2,'1970-01-01 00:00:00','1970-01-01 00:00:00',0),(3,'samanthablake','{bcrypt}$2a$10$BudzAdPY785cCMI6S5nTvemXrP7Iu.6TtbaKSPsAYLMO8bNWRppW.','samanthablake@example.com',3,'1970-01-01 00:00:00','1970-01-01 00:00:00',0),(4,'fredericklogan','{bcrypt}$2a$10$BudzAdPY785cCMI6S5nTvemXrP7Iu.6TtbaKSPsAYLMO8bNWRppW.','fredericklogan@example.com',4,'1970-01-01 00:00:00','1970-01-01 00:00:00',0),(5,'juliuswalker','{bcrypt}$2a$10$BudzAdPY785cCMI6S5nTvemXrP7Iu.6TtbaKSPsAYLMO8bNWRppW.','juliuswalker@example.com',5,'1970-01-01 00:00:00','1970-01-01 00:00:00',0),(6,'lisabell','{bcrypt}$2a$10$BudzAdPY785cCMI6S5nTvemXrP7Iu.6TtbaKSPsAYLMO8bNWRppW.','lisabell@example.com',6,'1970-01-01 00:00:00','1970-01-01 00:00:00',0),(7,'hughcarson','{bcrypt}$2a$10$BudzAdPY785cCMI6S5nTvemXrP7Iu.6TtbaKSPsAYLMO8bNWRppW.','hughcarson@example.com',7,'1970-01-01 00:00:00','1970-01-01 00:00:00',0),(8,'chrissstone','{bcrypt}$2a$10$BudzAdPY785cCMI6S5nTvemXrP7Iu.6TtbaKSPsAYLMO8bNWRppW.','chrissstone@example.com',8,'1970-01-01 00:00:00','1970-01-01 00:00:00',0),(9,'lorenepierce','{bcrypt}$2a$10$BudzAdPY785cCMI6S5nTvemXrP7Iu.6TtbaKSPsAYLMO8bNWRppW.','lorenepierce@example.com',9,'1970-01-01 00:00:00','1970-01-01 00:00:00',0),(10,'gracepotter','{bcrypt}$2a$10$BudzAdPY785cCMI6S5nTvemXrP7Iu.6TtbaKSPsAYLMO8bNWRppW.','gracepotter@example.com',10,'1970-01-01 00:00:00','1970-01-01 00:00:00',0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-20  6:27:09
