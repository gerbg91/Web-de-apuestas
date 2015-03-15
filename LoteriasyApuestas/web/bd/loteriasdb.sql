CREATE DATABASE  IF NOT EXISTS `loteriasdb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `loteriasdb`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: loteriasdb
-- ------------------------------------------------------
-- Server version	5.6.21

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
-- Table structure for table `cupon`
--

DROP TABLE IF EXISTS `cupon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cupon` (
  `id_Navidad` int(100) NOT NULL AUTO_INCREMENT,
  `numero` varchar(50) DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `historico` date DEFAULT NULL,
  `premios` float DEFAULT NULL,
  PRIMARY KEY (`id_Navidad`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cupon`
--

LOCK TABLES `cupon` WRITE;
/*!40000 ALTER TABLE `cupon` DISABLE KEYS */;
INSERT INTO `cupon` VALUES (1,'21657','CincoCifras','2015-03-13',35000),(2,'21656','CincoCifrasAnterior','2015-03-13',500),(3,'21658','CincoCifrasPosterior','2015-03-13',500),(4,'1657','CuatroCifras','2015-03-13',200),(5,'657','TresCifras','2015-03-13',20),(6,'57','DosCifras','2015-03-13',6),(7,'7','UltimaCifra','2015-03-13',1.5),(8,'2','PrimeraCifra','2015-03-13',1.5),(9,'008','Serie','2015-03-13',3000),(10,'45576','CincoCifras','2014-12-21',35000),(11,'45575','CincoCifrasAnterior','2014-12-21',500),(12,'45577','CincoCifrasPosterior','2014-12-21',500),(13,'5576','CuatroCifras','2014-12-21',200),(14,'576','TresCifras','2014-12-21',20),(15,'76','DosCifras','2014-12-21',6),(16,'6','UltimaCifra','2014-12-21',1.5),(17,'4','PrimeraCifra','2014-12-21',1.5),(18,'021','Serie','2014-12-21',3000);
/*!40000 ALTER TABLE `cupon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `navidad`
--

DROP TABLE IF EXISTS `navidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `navidad` (
  `id_Navidad` int(100) NOT NULL AUTO_INCREMENT,
  `numero` varchar(50) DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `historico` date DEFAULT NULL,
  `premios` float DEFAULT NULL,
  PRIMARY KEY (`id_Navidad`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `navidad`
--

LOCK TABLES `navidad` WRITE;
/*!40000 ALTER TABLE `navidad` DISABLE KEYS */;
INSERT INTO `navidad` VALUES (1,'21657','PrimerPremio','2014-12-21',20000),(2,'65641','SegundoPremio','2014-12-21',6250),(3,'97608','TercerPremio','2014-12-21',2500),(4,'37158','CuartoPremio','2014-12-21',1000),(5,'17438','CuartoPremio','2014-12-21',1000),(6,'07601','QuintoPremio','2014-12-21',300),(7,'27148','QuintoPremio','2014-12-21',300),(8,'00608','QuintoPremio','2014-12-21',300),(9,'99198','QuintoPremio','2014-12-21',300),(10,'78608','QuintoPremio','2014-12-21',300),(11,'10901','QuintoPremio','2014-12-21',300),(12,'11101','QuintoPremio','2014-12-21',300),(13,'32128','QuintoPremio','2014-12-21',300),(14,'34667','Pedrea','2014-12-21',5),(15,'00002','Pedrea','2014-12-21',5),(16,'90000','Pedrea','2014-12-21',5),(17,'17888','Pedrea','2014-12-21',5),(18,'08880','Pedrea','2014-12-21',5),(19,'91900','Pedrea','2014-12-21',5),(20,'12345','Pedrea','2014-12-21',5),(21,'86521','Pedrea','2014-12-21',5),(22,'09070','Pedrea','2014-12-21',5),(23,'21658','PrimerPremioAprox','2014-12-21',100),(24,'21656','PrimerPremioAprox','2014-12-21',100),(25,'65640','SegundoPremioAprox','2014-12-21',62.5),(26,'65642','SegundoPremioAprox','2014-12-21',62.5),(27,'97607','TercerPremioAprox','2014-12-21',48),(28,'97609','TercerPremioAprox','2014-12-21',48),(29,'657','PrimerPremioCentenas','2014-12-21',5),(30,'641','SegundoPremioCentenas','2014-12-21',5),(31,'608','TercerPremioCentenas','2014-12-21',5),(32,'158','CuartoPremioCentenas','2014-12-21',5),(33,'438','CuartoPremioCentenas','2014-12-21',5),(34,'57','PrimerPremioDecenas','2014-12-21',6),(35,'41','SegundoPremioDecenas','2014-12-21',5),(36,'08','TercerPremioDecenas','2014-12-21',5),(37,'7','Reintegro','2014-12-21',1);
/*!40000 ALTER TABLE `navidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nino`
--

DROP TABLE IF EXISTS `nino`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nino` (
  `id_Nino` int(100) NOT NULL AUTO_INCREMENT,
  `numero` varchar(50) DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `historico` date DEFAULT NULL,
  `premios` float DEFAULT NULL,
  PRIMARY KEY (`id_Nino`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nino`
--

LOCK TABLES `nino` WRITE;
/*!40000 ALTER TABLE `nino` DISABLE KEYS */;
INSERT INTO `nino` VALUES (1,'55487','PrimerPremio','2015-01-06',10000),(2,'43743','SegundoPremio','2015-01-06',3750),(3,'84222','TercerPremio','2015-01-06',1250),(4,'6691','TerminacionCuatroCifras','2015-01-06',175),(5,'6989','TerminacionCuatroCifras','2015-01-06',175),(6,'794','TerminacionTresCifras','2015-01-06',6),(7,'285','TerminacionTresCifras','2015-01-06',6),(8,'508','TerminacionTresCifras','2015-01-06',6),(9,'881','TerminacionTresCifras','2015-01-06',6),(10,'635','TerminacionTresCifras','2015-01-06',6),(11,'296','TerminacionTresCifras','2015-01-06',6),(12,'545','TerminacionTresCifras','2015-01-06',6),(13,'466','TerminacionTresCifras','2015-01-06',6),(14,'658','TerminacionTresCifras','2015-01-06',6),(15,'668','TerminacionTresCifras','2015-01-06',6),(16,'692','TerminacionTresCifras','2015-01-06',6),(17,'873','TerminacionTresCifras','2015-01-06',6),(18,'69','TerminacionDosCifras','2015-01-06',5),(19,'09','TerminacionDosCifras','2015-01-06',5),(20,'92','TerminacionDosCifras','2015-01-06',5),(21,'34','TerminacionDosCifras','2015-01-06',5),(22,'25','TerminacionDosCifras','2015-01-06',5),(23,'7','TerminacionUltimaCifra','2015-01-06',1),(24,'5','PrimeraCifraPrimero','2015-01-06',1),(25,'4','PrimeraCifraSegundo','2015-01-06',1);
/*!40000 ALTER TABLE `nino` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `usu` varchar(50) NOT NULL,
  `texto_encriptado` blob,
  PRIMARY KEY (`usu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES ('gerbg91','¾>øß‘í¬ï*Pâ/¬žÙ\"');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-03-15 18:16:54
