CREATE DATABASE  IF NOT EXISTS `Projecto_Libreria` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `Projecto_Libreria`;
-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: clinica_kvbe_2021_01
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `tb_boleta`
--

DROP TABLE IF EXISTS `tb_boleta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_boleta` (
  `num_bol` int NOT NULL AUTO_INCREMENT,
  `cod_cli` int DEFAULT NULL,
  `cod_usu` int DEFAULT NULL,
  `fec_emi_bol` date DEFAULT NULL,
  `monto_bol` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`num_bol`),
  KEY `fk4` (`cod_usu`),
  KEY `fk5` (`cod_cli`),
  CONSTRAINT `fk4` FOREIGN KEY (`cod_usu`) REFERENCES `tb_usuario` (`cod_usu`),
  CONSTRAINT `fk5` FOREIGN KEY (`cod_cli`) REFERENCES `tb_cliente` (`cod_cli`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_boleta`
--



--
-- Table structure for table `tb_cliente`
--

DROP TABLE IF EXISTS `tb_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_cliente` (
  `cod_cli` int NOT NULL AUTO_INCREMENT,
  `nom_cli` varchar(30) DEFAULT NULL,
  `pat_cli` varchar(30) DEFAULT NULL,
  `mat_cli` varchar(30) DEFAULT NULL,
  `sex_cli` varchar(15) DEFAULT NULL,
  `dni_cli` int DEFAULT NULL,
  `fec_nac_cli` date DEFAULT NULL,
  `cel_cli` int DEFAULT NULL,
  `dir_cli` varchar(50) DEFAULT NULL,
  `cod_dis` int DEFAULT NULL,
  PRIMARY KEY (`cod_cli`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_cliente`
--

LOCK TABLES `tb_cliente` WRITE;
/*!40000 ALTER TABLE `tb_cliente` DISABLE KEYS */;
INSERT INTO `tb_cliente` VALUES (1,'Luis','Mora','Ayala','Masculino',40770863,'2010-12-24',9916018,'',1265);
/*!40000 ALTER TABLE `tb_cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_enlace`
--

DROP TABLE IF EXISTS `tb_enlace`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_enlace` (
  `idenlace` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  `ruta` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idenlace`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_enlace`
--


--
-- Table structure for table `tb_laboratorio`
--

DROP TABLE IF EXISTS `tb_autor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_autor` (
  `cod_aut` int NOT NULL AUTO_INCREMENT,
  `nom_aut` varchar(50) DEFAULT NULL,
  `dir_aut` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`cod_aut`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_laboratorio`
--

LOCK TABLES `tb_autor` WRITE;
/*!40000 ALTER TABLE `tb_autor` DISABLE KEYS */;
INSERT INTO `tb_autor` VALUES (1,'RICARDO PALMA','Paucartambo 626, Puente Piedra 15116 - Campo Fe'),(2,'JOSE MARIA ARGUEDAS','N.A');
/*!40000 ALTER TABLE `tb_autor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_medicamento`
--

DROP TABLE IF EXISTS `tb_obra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_obra` (
  `cod_obr` int NOT NULL AUTO_INCREMENT,
  `nom_obr` varchar(50) DEFAULT NULL,
  `des_obr` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `sto_obr` int DEFAULT NULL,
  `pre_obr` double DEFAULT NULL,
  `fec_publi_obr` date DEFAULT NULL,
  `cod_tipo` int DEFAULT NULL,
  `cod_aut` int DEFAULT NULL,
  PRIMARY KEY (`cod_obr`),
  KEY `fk_01` (`cod_tipo`),
  KEY `fk_02` (`cod_aut`),
  CONSTRAINT `fk_01` FOREIGN KEY (`cod_tipo`) REFERENCES `tb_tipo_obra` (`cod_tipo`),
  CONSTRAINT `fk_02` FOREIGN KEY (`cod_aut`) REFERENCES `tb_autor` (`cod_aut`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_medicamento`
--

LOCK TABLES `tb_obra` WRITE;
/*!40000 ALTER TABLE `tb_obra` DISABLE KEYS */;
INSERT INTO `tb_obra` VALUES (1,'Yawar Fiesta','Pertenece a la corriente del indigenismo. Ambientada en el pueblo de Puquio, relata la realización de una corrida de toros al estilo andino en el marco de una celebración denominada yawar punchay.',10,20.5,'1941-01-01',4,2);
/*!40000 ALTER TABLE `tb_obra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_medicamento_has_boleta`
--

DROP TABLE IF EXISTS `tb_tipo_obra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_tipo_obra` (
  `cod_tipo` int NOT NULL AUTO_INCREMENT,
  `nom_tipo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cod_tipo`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tipo_medicamento`
--

LOCK TABLES `tb_tipo_obra` WRITE;
/*!40000 ALTER TABLE `tb_tipo_obra` DISABLE KEYS */;
INSERT INTO `tb_tipo_obra` VALUES (1,'Romántica'),(2,'Clasica o Griega'),(3,'Fantástica'),(4,'Novela'),(5,'Poesía'),(6,'Comtemporánea o Moderna'),(7,'Antigua');
/*!40000 ALTER TABLE `tb_tipo_obra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_usuario`
--






-- DROP TABLE IF EXISTS `tb_medicamento_has_boleta`;
-- /*!40101 SET @saved_cs_client     = @@character_set_client */;
-- /*!50503 SET character_set_client = utf8mb4 */;
/*
CREATE TABLE `tb_medicamento_has_boleta` (
  `num_bol` int NOT NULL,
  `cod_med` int NOT NULL,
  `pre` double DEFAULT NULL,
  KEY `fk6` (`num_bol`),
  KEY `fk7` (`cod_med`),
  CONSTRAINT `fk6` FOREIGN KEY (`num_bol`) REFERENCES `tb_boleta` (`num_bol`),
  CONSTRAINT `fk7` FOREIGN KEY (`cod_med`) REFERENCES `tb_medicamento` (`cod_med`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;*/
-- /*!40101 SET character_set_client = @saved_cs_client */;


--
-- Dumping data for table `tb_medicamento_has_boleta`
--

-- LOCK TABLES `tb_medicamento_has_boleta` WRITE;
-- /*!40000 ALTER TABLE `tb_medicamento_has_boleta` DISABLE KEYS */;
-- INSERT INTO `tb_medicamento_has_boleta` VALUES (8,1,555),(10,1,555),(10,2,5),(11,2,500),(12,2,500),(13,2,555),(14,2,500);
-- /*!40000 ALTER TABLE `tb_medicamento_has_boleta` ENABLE KEYS */;
-- UNLOCK TABLES;

--
-- Table structure for table `tb_rol`
--

DROP TABLE IF EXISTS `tb_rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_rol` (
  `idrol` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idrol`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_rol`
--

LOCK TABLES `tb_rol` WRITE;
/*!40000 ALTER TABLE `tb_rol` DISABLE KEYS */;
INSERT INTO `tb_rol` VALUES (1,'ADMIN'),(2,'CAJA'),(3,'CONTABILIDAD');
/*!40000 ALTER TABLE `tb_rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_rol_enlace`
--

-- DROP TABLE IF EXISTS `tb_rol_enlace`;
-- /*!40101 SET @saved_cs_client     = @@character_set_client */;
-- /*!50503 SET character_set_client = utf8mb4 */;
/*CREATE TABLE `tb_rol_enlace` (
  `idrol` int NOT NULL,
  `idenlace` int NOT NULL,
  PRIMARY KEY (`idrol`,`idenlace`),
  KEY `fk25` (`idenlace`),
  CONSTRAINT `fk24` FOREIGN KEY (`idrol`) REFERENCES `tb_rol` (`idrol`),
  CONSTRAINT `fk25` FOREIGN KEY (`idenlace`) REFERENCES `tb_enlace` (`idenlace`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;*/
-- /*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_rol_enlace`
--

-- LOCK TABLES `tb_rol_enlace` WRITE;
-- /*!40000 ALTER TABLE `tb_rol_enlace` DISABLE KEYS */;
-- INSERT INTO `tb_rol_enlace` VALUES (1,1),(2,1),(1,2),(3,2),(1,3),(1,4),(1,5),(2,5);
-- /*!40000 ALTER TABLE `tb_rol_enlace` ENABLE KEYS */;
-- UNLOCK TABLES;

--
-- Table structure for table `tb_tipo_medicamento`
--

DROP TABLE IF EXISTS `tb_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_usuario` (
  `cod_usu` int NOT NULL,
  `login` varchar(45) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  `idrol` int DEFAULT NULL,
  PRIMARY KEY (`cod_usu`),
  KEY `fk23` (`idrol`),
  CONSTRAINT `fk23` FOREIGN KEY (`idrol`) REFERENCES `tb_rol` (`idrol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_usuario`
--

LOCK TABLES `tb_usuario` WRITE;
/*!40000 ALTER TABLE `tb_usuario` DISABLE KEYS */;
INSERT INTO `tb_usuario` VALUES (1,'ana','$2a$10$5wk49Mztlv9sAstTjIH9zu9Ek6NjE90x88ZXKnlC0d.lsRg7NGDWi',1),(2,'maria','$2a$10$3V7umgGE4x0A/wzOi7D9VuGN9BNdQ6qs4xwCxbe2QSNiTpzAEwzFa',2),(3,'alicia','$2a$10$h/axUWXNZLAXdakQjOyiI.5UmhYqAekJsM8XYOCL0A8Rbv3jVA2wG',3);
/*!40000 ALTER TABLE `tb_usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-20 15:38:37
