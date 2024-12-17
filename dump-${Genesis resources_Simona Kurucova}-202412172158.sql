-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: genesis_resources_registration_system
-- ------------------------------------------------------
-- Server version	8.0.40

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `usersgr`
--

DROP TABLE IF EXISTS `usersgr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usersgr` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) NOT NULL,
  `Surname` varchar(100) DEFAULT NULL,
  `PersonID` varchar(100) NOT NULL,
  `Uuid` varchar(100) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `PersonID` (`PersonID`),
  UNIQUE KEY `Uuid` (`Uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usersgr`
--

LOCK TABLES `usersgr` WRITE;
/*!40000 ALTER TABLE `usersgr` DISABLE KEYS */;
INSERT INTO `usersgr` VALUES (6,'Silvia','Modifikovana','iM5sO6zXcW7v','7b772792-847b-4ac3-942c-a6ddc7c2345e'),(7,'Eva','Nova','sL4gN9dC3bXz','c27b2da8-8921-4ec6-abd3-98939f42a740'),(9,'Adam','Selky','dW9pL2eU1yNc','554bcb35-127e-4282-9e01-9c23571e5b90'),(10,'Peter','Novak','bG2zC7jR9xVp','c41efae0-2944-44bd-bafc-f71b2925fe04'),(11,'Milan','Navak','qE3lY6uT0vKd','6fa748a2-5dd4-4bdb-89aa-ad3f84eb0524'),(12,'Michal','Nevak','hM5bZ8nK4aVf','320eb7c8-feef-4994-b873-607582b93248'),(13,'Marta','Badovska','xF9hD2yJ3sWv','9b441567-9e86-4f08-ab14-55c6125cb693'),(16,'Gabriela','Bebovska','eI1oY6tQ9dKj','2a7f1375-ce11-4db9-ac5c-e73a291f1944');
/*!40000 ALTER TABLE `usersgr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'genesis_resources_registration_system'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-17 21:58:48
