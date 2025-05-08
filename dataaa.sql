-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: javaweb31
-- ------------------------------------------------------
-- Server version	8.0.39
CREATE DATABASE IF NOT EXISTS javaweb31;
USE javaweb31;
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
-- Table structure for table `tbl_category`
--

DROP TABLE IF EXISTS `tbl_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_by` int DEFAULT NULL,
  `update_by` int DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `description` varchar(45) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_category_create_user_idx` (`create_by`),
  KEY `fk_category_update_user_idx` (`update_by`),
  CONSTRAINT `fk_category_create_user` FOREIGN KEY (`create_by`) REFERENCES `tbl_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_category_update_user` FOREIGN KEY (`update_by`) REFERENCES `tbl_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_category`
--

LOCK TABLES `tbl_category` WRITE;
/*!40000 ALTER TABLE `tbl_category` DISABLE KEYS */;
INSERT INTO `tbl_category` VALUES (1,'son',1,1,'2024-10-13 00:00:00','2006-02-12 00:00:00',0,'33333'),(2,'son1',1,1,'2024-10-13 00:00:00',NULL,1,'hhjh 222'),(3,'son2',1,1,'2024-10-13 00:00:00',NULL,1,'hhjh444'),(4,'son3',1,1,'2024-10-13 00:00:00','2024-10-23 00:00:00',1,'okee111');
/*!40000 ALTER TABLE `tbl_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_contact`
--

DROP TABLE IF EXISTS `tbl_contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_contact` (
  `id` int NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) COLLATE utf8mb4_bin DEFAULT NULL,
  `lastname` varchar(45) COLLATE utf8mb4_bin DEFAULT NULL,
  `mobile` varchar(45) COLLATE utf8mb4_bin DEFAULT NULL,
  `email` varchar(45) COLLATE utf8mb4_bin DEFAULT NULL,
  `address` varchar(45) COLLATE utf8mb4_bin DEFAULT NULL,
  `request_type` varchar(45) COLLATE utf8mb4_bin DEFAULT NULL,
  `message` varchar(45) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_by` int DEFAULT NULL,
  `update_by` int DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_contact`
--

LOCK TABLES `tbl_contact` WRITE;
/*!40000 ALTER TABLE `tbl_contact` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_contact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_product`
--

DROP TABLE IF EXISTS `tbl_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `avatar` varchar(45) COLLATE utf8mb4_bin DEFAULT NULL,
  `price` decimal(15,2) DEFAULT NULL,
  `sale_price` decimal(15,2) DEFAULT NULL,
  `create_by` int DEFAULT NULL,
  `update_by` int DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `is_hot` tinyint DEFAULT NULL,
  `short_description` varchar(45) COLLATE utf8mb4_bin DEFAULT NULL,
  `detail_description` longtext COLLATE utf8mb4_bin,
  `seo` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `name` varchar(45) COLLATE utf8mb4_bin DEFAULT NULL,
  `category_id` int DEFAULT NULL,
  KEY `fk_category_update_user_idx` (`update_by`),
  KEY `fk_product_create_user_idx` (`create_by`),
  KEY `fk_product_category_idx` (`id`),
  KEY `fk_product_category_idx1` (`category_id`),
  CONSTRAINT `fk_product_category` FOREIGN KEY (`category_id`) REFERENCES `tbl_category` (`id`),
  CONSTRAINT `fk_product_create_user` FOREIGN KEY (`create_by`) REFERENCES `tbl_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_product_update_user` FOREIGN KEY (`update_by`) REFERENCES `tbl_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_product`
--

LOCK TABLES `tbl_product` WRITE;
/*!40000 ALTER TABLE `tbl_product` DISABLE KEYS */;
INSERT INTO `tbl_product` VALUES (1,'Product/Avatar/Screenshot_2.png',2222222.00,2.00,1,1,'2024-10-28 00:00:00',NULL,0,0,'','',NULL,'cá chà bặc',NULL),(3,'Product/Avatar/Screenshot (149).png',200001.00,9.00,1,1,'2024-10-23 00:00:00',NULL,1,0,'','',NULL,'ddddd',NULL),(4,'Product/Avatar/Screenshot_2.png',0.00,0.00,1,1,'2024-10-28 00:00:00',NULL,1,0,'','',NULL,'cá cac',NULL),(12,NULL,0.00,0.00,1,1,'2024-10-31 00:00:00',NULL,0,0,'','',NULL,'ddddd',2),(13,NULL,0.00,0.00,1,1,'2024-10-30 00:00:00',NULL,1,0,'','',NULL,'ddddd',2),(14,'Product/Avatar/Screenshot_2.png',0.00,0.00,1,1,'2024-10-30 00:00:00',NULL,1,0,'lanwgs','dg',NULL,'adadad',1),(15,'Product/Avatar/Screenshot_1.png',9052004.00,10000.00,1,1,'2024-12-24 00:00:00',NULL,1,0,'','',NULL,'ca cha bac',2);
/*!40000 ALTER TABLE `tbl_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_product_image`
--

DROP TABLE IF EXISTS `tbl_product_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_product_image` (
  `id` int NOT NULL AUTO_INCREMENT,
  `product_id` int DEFAULT NULL,
  `title` varchar(45) COLLATE utf8mb4_bin DEFAULT NULL,
  `path` varchar(45) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_by` int DEFAULT NULL,
  `update_by` int DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_product_img_product_idx` (`product_id`),
  CONSTRAINT `fk_product_img_product` FOREIGN KEY (`product_id`) REFERENCES `tbl_product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_product_image`
--

LOCK TABLES `tbl_product_image` WRITE;
/*!40000 ALTER TABLE `tbl_product_image` DISABLE KEYS */;
INSERT INTO `tbl_product_image` VALUES (1,3,'Screenshot (149).png','Product/Image/Screenshot (149).png',NULL,NULL,1,'2024-10-23 15:22:25',NULL),(2,3,'Screenshot (149).png','Product/Image/Screenshot (149).png',NULL,NULL,1,'2024-10-23 15:22:25',NULL),(3,3,'Screenshot (149).png','Product/Image/Screenshot (149).png',NULL,NULL,1,'2024-10-23 15:22:26',NULL),(4,3,'Screenshot (149).png','Product/Image/Screenshot (149).png',NULL,NULL,1,'2024-10-23 15:22:26',NULL),(5,4,'Screenshot (149).png','Product/Image/Screenshot (149).png',NULL,NULL,1,'2024-10-27 18:59:52',NULL),(6,4,'Screenshot (149).png','Product/Image/Screenshot (149).png',NULL,NULL,1,'2024-10-27 18:59:52',NULL),(7,14,'Screenshot (149).png','Product/Image/Screenshot (149).png',NULL,NULL,1,'2024-10-30 19:02:12',NULL),(8,14,'Screenshot_2.png','Product/Image/Screenshot_2.png',NULL,NULL,1,'2024-10-30 19:02:12',NULL),(9,14,'Screenshot (149).png','Product/Image/Screenshot (149).png',NULL,NULL,1,'2024-10-30 19:02:12',NULL),(10,14,'Screenshot_2.png','Product/Image/Screenshot_2.png',NULL,NULL,1,'2024-10-30 19:02:12',NULL),(11,15,'Screenshot (149).png','Product/Image/Screenshot (149).png',NULL,NULL,1,'2024-12-24 23:09:36',NULL),(12,15,'Screenshot_2.png','Product/Image/Screenshot_2.png',NULL,NULL,1,'2024-12-24 23:09:37',NULL),(13,15,'Screenshot_2.png','Product/Image/Screenshot_2.png',NULL,NULL,1,'2024-12-24 23:09:37',NULL),(14,15,'Screenshot_1.png','Product/Image/Screenshot_1.png',NULL,NULL,1,'2024-12-24 23:09:37',NULL),(15,15,'Screenshot (149).png','Product/Image/Screenshot (149).png',NULL,NULL,1,'2024-12-24 23:09:37',NULL);
/*!40000 ALTER TABLE `tbl_product_image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_role`
--

DROP TABLE IF EXISTS `tbl_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_by` int DEFAULT NULL,
  `update_by` int DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `description` varchar(45) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_role`
--

LOCK TABLES `tbl_role` WRITE;
/*!40000 ALTER TABLE `tbl_role` DISABLE KEYS */;
INSERT INTO `tbl_role` VALUES (1,'ADMIN',NULL,NULL,NULL,NULL,NULL,NULL),(2,'GUST',NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tbl_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_sale_oder`
--

DROP TABLE IF EXISTS `tbl_sale_oder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_sale_oder` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `code` varchar(45) COLLATE utf8mb4_bin DEFAULT NULL,
  `total` decimal(15,2) DEFAULT NULL,
  `ct_name` varchar(45) COLLATE utf8mb4_bin DEFAULT NULL,
  `ct_mobile` varchar(45) COLLATE utf8mb4_bin DEFAULT NULL,
  `ct_email` varchar(45) COLLATE utf8mb4_bin DEFAULT NULL,
  `ct_adress` varchar(45) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_by` int DEFAULT NULL,
  `update_by` int DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `tbl_user_sale_oder_idx` (`user_id`),
  CONSTRAINT `tbl_user_sale_oder` FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_sale_oder`
--

LOCK TABLES `tbl_sale_oder` WRITE;
/*!40000 ALTER TABLE `tbl_sale_oder` DISABLE KEYS */;
INSERT INTO `tbl_sale_oder` VALUES (8,4,'09981739263256739',9241996.00,'sonkk','0998','@','a',NULL,NULL,NULL,NULL,1),(9,4,'08891739263693960',18683984.00,'sơn đậm sâu','0889','@','d',NULL,NULL,NULL,NULL,1);
/*!40000 ALTER TABLE `tbl_sale_oder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_sale_oder_product`
--

DROP TABLE IF EXISTS `tbl_sale_oder_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_sale_oder_product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `sale_oder_id` int NOT NULL,
  `product_name` varchar(45) COLLATE utf8mb4_bin DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `create_by` int DEFAULT NULL,
  `update_by` int DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `description` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `product_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_sale_oder_product_p_idx` (`product_id`),
  KEY `fk_sale_oder_product_s_idx` (`sale_oder_id`),
  KEY `fk_sale_oder_product_create_idx` (`create_by`),
  KEY `fk_sale_oder_product_update_idx` (`update_by`),
  CONSTRAINT `fk_sale_oder_product_create` FOREIGN KEY (`create_by`) REFERENCES `tbl_sale_oder` (`id`),
  CONSTRAINT `fk_sale_oder_product_p` FOREIGN KEY (`product_id`) REFERENCES `tbl_product` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_sale_oder_product_s` FOREIGN KEY (`sale_oder_id`) REFERENCES `tbl_sale_oder` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_sale_oder_product_update` FOREIGN KEY (`update_by`) REFERENCES `tbl_sale_oder` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_sale_oder_product`
--

LOCK TABLES `tbl_sale_oder_product` WRITE;
/*!40000 ALTER TABLE `tbl_sale_oder_product` DISABLE KEYS */;
INSERT INTO `tbl_sale_oder_product` VALUES (5,8,'ca cha bac',1,NULL,NULL,NULL,NULL,1,NULL,15),(6,9,'ddddd',3,NULL,NULL,NULL,NULL,1,NULL,3),(7,9,'ca cha bac',2,NULL,NULL,NULL,NULL,1,NULL,15);
/*!40000 ALTER TABLE `tbl_sale_oder_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_user`
--

DROP TABLE IF EXISTS `tbl_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(222) COLLATE utf8mb4_bin DEFAULT NULL,
  `password` varchar(222) COLLATE utf8mb4_bin DEFAULT NULL,
  `mobile` varchar(45) COLLATE utf8mb4_bin DEFAULT NULL,
  `email` varchar(45) COLLATE utf8mb4_bin DEFAULT NULL,
  `address` varchar(45) COLLATE utf8mb4_bin DEFAULT NULL,
  `avatar` varchar(45) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_by` int DEFAULT NULL,
  `update_by` int DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `description` varchar(45) COLLATE utf8mb4_bin DEFAULT NULL,
  `name` varchar(45) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_user`
--

LOCK TABLES `tbl_user` WRITE;
/*!40000 ALTER TABLE `tbl_user` DISABLE KEYS */;
INSERT INTO `tbl_user` VALUES (1,'doan ngoc son','$2a$04$vWLSSqCoA.Mv7ZFioCXhXe7kfLiAfB0ipl3NvGLKU6IXwBZF8Ajdu','0889576839','luodai@gmail.comm','','',1,1,NULL,NULL,1,NULL,'doanngocson'),(2,'ADMIN','$2a$04$vWLSSqCoA.Mv7ZFioCXhXe7kfLiAfB0ipl3NvGLKU6IXwBZF8Ajdu',NULL,NULL,NULL,NULL,2,2,NULL,NULL,1,NULL,'son'),(3,'DoanVanNgoc','$2a$04$vWLSSqCoA.Mv7ZFioCXhXe7kfLiAfB0ipl3NvGLKU6IXwBZF8Ajdu',NULL,NULL,NULL,NULL,3,3,NULL,NULL,1,NULL,'nonson'),(4,'gust','$2a$04$vWLSSqCoA.Mv7ZFioCXhXe7kfLiAfB0ipl3NvGLKU6IXwBZF8Ajdu',NULL,NULL,NULL,NULL,4,4,NULL,NULL,1,NULL,'oke');
/*!40000 ALTER TABLE `tbl_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_user_role`
--

DROP TABLE IF EXISTS `tbl_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbl_user_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `role_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_user_role`
--

LOCK TABLES `tbl_user_role` WRITE;
/*!40000 ALTER TABLE `tbl_user_role` DISABLE KEYS */;
INSERT INTO `tbl_user_role` VALUES (1,1,1),(2,4,2),(3,2,1),(4,3,1);
/*!40000 ALTER TABLE `tbl_user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-03-08 17:35:46
