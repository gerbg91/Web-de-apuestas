-- MySQL dump 10.13  Distrib 5.6.23, for Win32 (x86)
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
  `id_Cupon` int(11) NOT NULL AUTO_INCREMENT,
  `numero` varchar(50) DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `historico` date DEFAULT NULL,
  `premios` float DEFAULT NULL,
  PRIMARY KEY (`id_Cupon`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cupon`
--

LOCK TABLES `cupon` WRITE;
/*!40000 ALTER TABLE `cupon` DISABLE KEYS */;
INSERT INTO `cupon` VALUES (1,'12345','CincoCifras','2015-05-05',35000),(2,'12344','CincoCifrasAnterior','2015-05-05',500),(3,'12346','CincoPosterior','2015-05-05',500),(5,'1234','CuatroCifras','2015-05-05',200),(6,'123','TresCifras','2015-05-05',20),(7,'12','DosCifras','2015-05-05',6),(8,'5','UltimaCifra','2015-05-05',1.5),(14,'1','PrimeraCifra','2015-05-05',1.5),(16,'009','Serie','2015-05-05',3000),(17,'45678','CincoCifras','2015-05-06',35000),(18,'45677','CincoCifrasAnterior','2015-05-06',500),(19,'45679','CincoPosterior','2015-05-06',500),(20,'4567','CuatroCifras','2015-05-06',200),(21,'456','TresCifras','2015-05-06',20),(22,'45','DosCifras','2015-05-06',6),(24,'4','PrimeraCifra','2015-05-06',1.5),(26,'234','Serie','2015-05-06',3000),(27,'8','UltimaCifra','2015-05-06',1.5);
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
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `navidad`
--

LOCK TABLES `navidad` WRITE;
/*!40000 ALTER TABLE `navidad` DISABLE KEYS */;
INSERT INTO `navidad` VALUES (1,'21657','PrimerPremio','2014-12-21',20000),(2,'65641','SegundoPremio','2014-12-21',6250),(4,'37158','CuartoPremio','2014-12-21',1000),(5,'17438','CuartoPremio','2014-12-21',1000),(8,'00608','QuintoPremio','2014-12-21',300),(9,'99198','QuintoPremio','2014-12-21',300),(10,'78608','QuintoPremio','2014-12-21',300),(11,'10901','QuintoPremio','2014-12-21',300),(12,'11101','QuintoPremio','2014-12-21',300),(13,'32128','QuintoPremio','2014-12-21',300),(17,'17888','Pedrea','2014-12-21',5),(19,'91900','Pedrea','2014-12-21',5),(20,'12345','Pedrea','2014-12-21',5),(23,'21658','PrimerPremioAprox','2014-12-21',100),(24,'21656','PrimerPremioAprox','2014-12-21',100),(25,'65640','SegundoPremioAprox','2014-12-21',62.5),(27,'97607','TercerPremioAprox','2014-12-21',48),(28,'97609','TercerPremioAprox','2014-12-21',48),(29,'657','PrimerPremioCentenas','2014-12-21',5),(30,'641','SegundoPremioCentenas','2014-12-21',5),(31,'608','TercerPremioCentenas','2014-12-21',5),(32,'158','CuartoPremioCentenas','2014-12-21',5),(33,'438','CuartoPremioCentenas','2014-12-21',5),(34,'57','PrimerPremioDecenas','2014-12-21',6),(35,'41','SegundoPremioDecenas','2014-12-21',5),(38,'27148','QuintoPremio','2014-12-21',300),(39,'27148','QuintoPremio','2014-12-21',300),(40,'27148','QuintoPremio','2014-12-21',300),(41,'12349','Pedrea','2014-12-21',5),(42,'12348','Pedrea','2014-12-21',5),(44,'7','Reintegro','2014-12-21',1),(45,'66666','TercerPremio','2014-12-21',2500),(46,'66','TercerPremioDecenas','2014-12-21',5);
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
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nino`
--

LOCK TABLES `nino` WRITE;
/*!40000 ALTER TABLE `nino` DISABLE KEYS */;
INSERT INTO `nino` VALUES (2,'43743','SegundoPremio','2015-01-06',3750),(3,'84222','TercerPremio','2015-01-06',1250),(4,'6691','TerminacionCuatroCifras','2015-01-06',175),(5,'6989','TerminacionCuatroCifras','2015-01-06',175),(6,'794','TerminacionTresCifras','2015-01-06',6),(8,'508','TerminacionTresCifras','2015-01-06',6),(9,'881','TerminacionTresCifras','2015-01-06',6),(10,'635','TerminacionTresCifras','2015-01-06',6),(11,'296','TerminacionTresCifras','2015-01-06',6),(12,'545','TerminacionTresCifras','2015-01-06',6),(13,'466','TerminacionTresCifras','2015-01-06',6),(14,'658','TerminacionTresCifras','2015-01-06',6),(15,'668','TerminacionTresCifras','2015-01-06',6),(16,'692','TerminacionTresCifras','2015-01-06',6),(17,'873','TerminacionTresCifras','2015-01-06',6),(18,'69','TerminacionDosCifras','2015-01-06',5),(19,'09','TerminacionDosCifras','2015-01-06',5),(21,'34','TerminacionDosCifras','2015-01-06',5),(22,'25','TerminacionDosCifras','2015-01-06',5),(23,'7','TerminacionUltimaCifra','2015-01-06',1),(24,'5','PrimeraCifraPrimero','2015-01-06',1),(25,'4','PrimeraCifraSegundo','2015-01-06',1),(26,'55687','PrimerPremio','2015-01-06',10000);
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

-- Dump completed on 2015-05-10 11:35:57
