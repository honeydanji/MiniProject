-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: project
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `pet_board_like`
--

DROP TABLE IF EXISTS `pet_board_like`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pet_board_like` (
  `likeid` int NOT NULL AUTO_INCREMENT,
  `id` int DEFAULT NULL,
  `free_board_id` int DEFAULT NULL,
  `honey_board_id` int DEFAULT NULL,
  PRIMARY KEY (`likeid`),
  KEY `id` (`id`),
  KEY `free_board_id` (`free_board_id`),
  KEY `honey_board_id` (`honey_board_id`),
  CONSTRAINT `pet_board_like_ibfk_1` FOREIGN KEY (`id`) REFERENCES `pet_member` (`id`),
  CONSTRAINT `pet_board_like_ibfk_2` FOREIGN KEY (`free_board_id`) REFERENCES `pet_free_board` (`free_board_id`),
  CONSTRAINT `pet_board_like_ibfk_3` FOREIGN KEY (`honey_board_id`) REFERENCES `pet_honey_board` (`honey_board_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pet_board_like`
--

LOCK TABLES `pet_board_like` WRITE;
/*!40000 ALTER TABLE `pet_board_like` DISABLE KEYS */;
INSERT INTO `pet_board_like` VALUES (2,51,3,NULL),(3,52,3,NULL),(14,51,NULL,2);
/*!40000 ALTER TABLE `pet_board_like` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-08-11 18:13:07
