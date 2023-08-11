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
-- Table structure for table `pet_member`
--

DROP TABLE IF EXISTS `pet_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pet_member` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `nickname` varchar(255) NOT NULL,
  `user_id` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `mobile_phone` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nickname` (`nickname`),
  UNIQUE KEY `user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pet_member`
--

LOCK TABLES `pet_member` WRITE;
/*!40000 ALTER TABLE `pet_member` DISABLE KEYS */;
INSERT INTO `pet_member` VALUES (1,'admin','abcd','a','1234','aaaa','010-111','121212',NULL),(4,'정승길','ㅁㅁㅁ','ㅎㅎㅎ','1234','aaaa','010-111','121212',NULL),(5,'이수호','수호천사','수호짱','1234','aaaa','010-111','121212',NULL),(6,'','','','','','','',NULL),(17,'asdasd','asdaswqe','asdasd','asdasxzcxzd','asdqwe@naver.com','asdqweasd','awqeqdsgag',NULL),(42,'asda','dzxcz','caweq','asdwq','qasdzxc','dqwawe','',NULL),(43,'hkhjgjll','gigbjgj','vggvlkjg','vhjvjgvj','vhjvhjl','vjhvjhvjh','','member'),(45,'hkhjgjllt','gigbjgjt','vggvlkjgt','vhjvjgvj','vhjvhjlt','vjhvjhvjht','','MEMBER'),(46,'홍길동','nick','user','$2a$10$kKNKbszsKGnCD3YbcUvfVuH6DpjrnWM7C8al27awzrY8gc31a9r2O\n','a@b.com',NULL,'부산','ROLE_MEMBER'),(47,'단지','강아지','단지','1234','','010000000','','ROLE_MEMBER'),(48,'qweasd','fzgdsghf','hsfdgfdsg','earasfgd','','agsaeawtr','','ROLE_MEMBER'),(49,'hsfdhfdg','hfgdhgfdh','fdghfdghdf','$2a$10$ZTs/QjrRmUiUSDiSwGbLfOAZYtNFTaOIIbF205k6sGg.NqaHXgwt6','','hgfdhdfgh','','ROLE_MEMBER'),(50,'asdasd','asdas','dasdgsdgf','$2a$10$UJ97X0MYZq8d/NDzM3utI.ApwSeAW1zDlvBWpiJtrt60uPtpcznW6','','gsdfgsdfg','','ROLE_MEMBER'),(51,'단지','1234','ekswl','$2a$10$Fb/jyeoRo4wX1uU.O6dbTexMWtHeBmC8dqAlYWH3IOIPObFV4IP6W','aa@aa1.com',NULL,NULL,'ROLE_MEMBER'),(52,'하하하하하','최용진','gktjdwls','$2a$10$PogY5GT1s8so0DLvPcpbqe9XiPGLj4DzaeJ4rQVTVPhFIwfKgK0pe','ddd@Ddd',NULL,NULL,'ROLE_MEMBER');
/*!40000 ALTER TABLE `pet_member` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-08-11 18:13:06
