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
-- Table structure for table `pet_free_board`
--

DROP TABLE IF EXISTS `pet_free_board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pet_free_board` (
  `free_board_id` int NOT NULL AUTO_INCREMENT,
  `user_id` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `content` varchar(255) NOT NULL,
  `regdate` datetime(6) DEFAULT NULL,
  `updatedate` datetime(6) DEFAULT NULL,
  `deletedate` datetime(6) DEFAULT NULL,
  `imagefile` varchar(255) DEFAULT NULL,
  `views` int DEFAULT '0',
  `likes` int NOT NULL,
  PRIMARY KEY (`free_board_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `pet_free_board_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `pet_member` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pet_free_board`
--

LOCK TABLES `pet_free_board` WRITE;
/*!40000 ALTER TABLE `pet_free_board` DISABLE KEYS */;
INSERT INTO `pet_free_board` VALUES (1,'ekswl','1234','나는 단지','단지는 미니핀',NULL,NULL,NULL,NULL,0,0),(3,'ekswl','1234','그래그래그래','미니피이이',NULL,NULL,NULL,'HoneyImage미니언즈.jpg',0,2),(4,'gktjdwls','최용진','그래그래그래','수정일',NULL,'2023-08-11 06:42:23.467000',NULL,'HoneyImage미니언즈.jpg',0,0);
/*!40000 ALTER TABLE `pet_free_board` ENABLE KEYS */;
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
