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
-- Temporary view structure for view `combined_reply`
--

DROP TABLE IF EXISTS `combined_reply`;
/*!50001 DROP VIEW IF EXISTS `combined_reply`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `combined_reply` AS SELECT 
 1 AS `source`,
 1 AS `comment_id`,
 1 AS `board_id`,
 1 AS `user_id`,
 1 AS `nickname`,
 1 AS `contents`,
 1 AS `registration_date`,
 1 AS `updatedate`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `combined_boards`
--

DROP TABLE IF EXISTS `combined_boards`;
/*!50001 DROP VIEW IF EXISTS `combined_boards`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `combined_boards` AS SELECT 
 1 AS `source`,
 1 AS `id`,
 1 AS `user_id`,
 1 AS `nickname`,
 1 AS `title`,
 1 AS `content`,
 1 AS `regdate`,
 1 AS `updatedate`,
 1 AS `deletedate`,
 1 AS `imagefile`,
 1 AS `views`,
 1 AS `likes`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `combined_reply`
--

/*!50001 DROP VIEW IF EXISTS `combined_reply`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `combined_reply` AS select 'pet_free_reply' AS `source`,`pet_free_reply`.`comment_id` AS `comment_id`,`pet_free_reply`.`free_board_id` AS `board_id`,`pet_free_reply`.`user_id` AS `user_id`,`pet_free_reply`.`nickname` AS `nickname`,`pet_free_reply`.`contents` AS `contents`,`pet_free_reply`.`registration_date` AS `registration_date`,`pet_free_reply`.`updatedate` AS `updatedate` from `pet_free_reply` union all select 'pet_honey_reply' AS `source`,`pet_honey_reply`.`comment_id` AS `comment_id`,`pet_honey_reply`.`honey_board_id` AS `board_id`,`pet_honey_reply`.`user_id` AS `user_id`,`pet_honey_reply`.`nickname` AS `nickname`,`pet_honey_reply`.`contents` AS `contents`,`pet_honey_reply`.`registration_date` AS `registration_date`,`pet_honey_reply`.`updatedate` AS `updatedate` from `pet_honey_reply` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `combined_boards`
--

/*!50001 DROP VIEW IF EXISTS `combined_boards`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `combined_boards` AS select 'pet_free_board' AS `source`,`pet_free_board`.`free_board_id` AS `id`,`pet_free_board`.`user_id` AS `user_id`,`pet_free_board`.`nickname` AS `nickname`,`pet_free_board`.`title` AS `title`,`pet_free_board`.`content` AS `content`,`pet_free_board`.`regdate` AS `regdate`,`pet_free_board`.`updatedate` AS `updatedate`,`pet_free_board`.`deletedate` AS `deletedate`,`pet_free_board`.`imagefile` AS `imagefile`,`pet_free_board`.`views` AS `views`,`pet_free_board`.`likes` AS `likes` from `pet_free_board` union all select 'pet_honey_board' AS `source`,`pet_honey_board`.`honey_board_id` AS `id`,`pet_honey_board`.`user_id` AS `user_id`,`pet_honey_board`.`nickname` AS `nickname`,`pet_honey_board`.`title` AS `title`,`pet_honey_board`.`content` AS `content`,`pet_honey_board`.`regdate` AS `regdate`,`pet_honey_board`.`updatedate` AS `updatedate`,`pet_honey_board`.`deletedate` AS `deletedate`,`pet_honey_board`.`imagefile` AS `imagefile`,`pet_honey_board`.`views` AS `views`,`pet_honey_board`.`likes` AS `likes` from `pet_honey_board` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-08-11 18:13:07
