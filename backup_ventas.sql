-- MySQL dump 10.13  Distrib 5.6.20, for Win64 (x86_64)
--
-- Host: localhost    Database: ventas
-- ------------------------------------------------------
-- Server version	5.6.20

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
-- Table structure for table `alimento`
--

DROP TABLE IF EXISTS `alimento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alimento` (
  `idalimento` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_alimento` varchar(45) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `calorias` int(11) DEFAULT NULL,
  `proteinas` int(11) DEFAULT NULL,
  `vitaminas` int(11) DEFAULT NULL,
  `minerales` int(11) DEFAULT NULL,
  `estado` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`idalimento`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alimento`
--

LOCK TABLES `alimento` WRITE;
/*!40000 ALTER TABLE `alimento` DISABLE KEYS */;
INSERT INTO `alimento` VALUES (1,'banana con yogurt ',150,1100,10,10,10,'ACTIVO'),(2,'pan integral',150,100,100,100,10,'INACTIVO'),(3,'pure de manzana',150,100,200,100,10,'ACTIVO'),(4,'ARROZ CON SALSA BLANCA',250,1500,400,100,400,'ACTIVO'),(5,'pera en rodajas acompañado de jugo de naranja',100,300,120,100,200,'ACTIVO'),(6,'durazno en alnivar',122,200,200,200,230,'ACTIVO'),(7,'guiso de arroz',300,1200,100,300,150,'ACTIVO'),(8,'Mermelada de durazno',100,300,10,20,100,'ACTIVO'),(9,'jugo',100,88,9,9,9,'INACTIVO'),(10,'minalesa',100,400,100,100,100,'INACTIVO'),(11,'kkl',1,1,1,1,1,'INACTIVO'),(12,'pan blanco tostado',150,300,50,50,100,'ACTIVO'),(13,'cereal de trigo sin gluten',120,300,100,200,150,'ACTIVO'),(14,'pan integral',150,100,80,80,200,'ACTIVO'),(15,'sandwich de pollo',200,1200,1000,200,100,'ACTIVO'),(16,'sandwich de verduras',200,800,500,800,50,'ACTIVO'),(17,'sandwich bagete',200,1500,600,1000,200,'ACTIVO'),(18,'cafe con leche acompañado con pan felipe',200,1200,300,200,400,'ACTIVO'),(19,'tostada de pan integral con aceite y tomate',200,100,150,120,200,'ACTIVO'),(20,'yogurt con cereal',200,1000,200,100,300,'ACTIVO'),(21,'mermelada de guayaba con pan blanco',200,1200,300,400,150,'ACTIVO'),(22,'gatellas de avena caseras ',60,250,70,80,170,'ACTIVO'),(23,'zumo de naranja',200,1000,160,120,60,'ACTIVO'),(24,'paella de pollo',300,300,70,200,90,'ACTIVO'),(25,'gelatina',250,100,120,130,200,'ACTIVO'),(26,'crema de calabazin',189,100,130,120,60,'ACTIVO'),(27,'pure de verduras',350,150,90,400,190,'ACTIVO'),(28,'albóndigas de ternera',300,120,130,80,150,'ACTIVO'),(29,'filete de merluza ',250,90,340,90,200,'ACTIVO');
/*!40000 ALTER TABLE `alimento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categorias` (
  `idcategorias` int(11) NOT NULL AUTO_INCREMENT,
  `categoria` varchar(60) DEFAULT NULL,
  `estado` varchar(15) NOT NULL,
  PRIMARY KEY (`idcategorias`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias`
--

LOCK TABLES `categorias` WRITE;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
INSERT INTO `categorias` VALUES (1,'MUEBLESs','INACTIVO'),(2,'MUEBLES','ACTIVO'),(3,'AAA','INACTIVO'),(4,'PINTURAS','ACTIVO'),(5,'TIRANTES','ACTIVO'),(6,'SERVICIOS','ACTIVO');
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comidas`
--

DROP TABLE IF EXISTS `comidas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comidas` (
  `idcomida` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(45) DEFAULT NULL,
  `observacion` varchar(1000) DEFAULT NULL,
  `periodo` varchar(50) DEFAULT NULL,
  `dias` varchar(45) DEFAULT NULL,
  `caloriastotales` int(11) DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  `idalimento` int(11) NOT NULL,
  PRIMARY KEY (`idcomida`),
  KEY `fk_comidas_alimento1_idx` (`idalimento`),
  CONSTRAINT `fk_comidas_alimento1` FOREIGN KEY (`idalimento`) REFERENCES `alimento` (`idalimento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comidas`
--

LOCK TABLES `comidas` WRITE;
/*!40000 ALTER TABLE `comidas` DISABLE KEYS */;
INSERT INTO `comidas` VALUES (4,'ADULTO ','','DESAYUNO','LUNES',7820,'ACTIVO',18),(5,'ADULTO ','','M MAÑANA','LUNES',7820,'ACTIVO',25),(6,'ADULTO ','','ALMUERZO','LUNES',7820,'ACTIVO',28),(7,'ADULTO ','','MERIENDA','LUNES',7820,'ACTIVO',6),(8,'ADULTO ','','CENA','LUNES',7820,'ACTIVO',1),(9,'ADULTO ','','DESAYUNO','MARTES',7820,'ACTIVO',26),(10,'ADULTO ','','M MAÑANA','MARTES',7820,'ACTIVO',26),(11,'ADULTO ','','ALMUERZO','MARTES',7820,'ACTIVO',7),(12,'ADULTO ','','MERIENDA','MARTES',7820,'ACTIVO',3),(13,'ADULTO ','','CENA','MARTES',7820,'ACTIVO',16),(14,'ADULTO ','','DESAYUNO','MIERCOLES',7820,'ACTIVO',20),(15,'ADULTO ','','M MAÑANA','MIERCOLES',7820,'ACTIVO',25),(16,'ADULTO ','','ALMUERZO','MIERCOLES',7820,'ACTIVO',24),(17,'ADULTO ','','MERIENDA','MIERCOLES',7820,'ACTIVO',5),(18,'ADULTO ','','CENA','MIERCOLES',7820,'ACTIVO',1),(19,'NIÑO','','DESAYUNO','LUNES',220,'ACTIVO',28),(20,'NIÑO','','DESAYUNO','LUNES',220,'ACTIVO',25);
/*!40000 ALTER TABLE `comidas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consulta`
--

DROP TABLE IF EXISTS `consulta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `consulta` (
  `idconsulta` int(11) NOT NULL,
  `observacion` varchar(1000) DEFAULT NULL,
  `peso_inicial` double DEFAULT NULL,
  `altura` double DEFAULT NULL,
  KEY `fk_consulta_reserva1_idx` (`idconsulta`),
  CONSTRAINT `fk_consulta_reserva1` FOREIGN KEY (`idconsulta`) REFERENCES `reserva` (`idreserva`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consulta`
--

LOCK TABLES `consulta` WRITE;
/*!40000 ALTER TABLE `consulta` DISABLE KEYS */;
INSERT INTO `consulta` VALUES (34,'A',33,3),(35,'a',3,3),(36,'NADA ',85,1.68),(37,'NADA ',68,1.75),(38,NULL,NULL,NULL),(39,'A',3,3),(40,NULL,NULL,NULL),(41,'AAa',2,22),(42,'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaadsssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssfffffffff\nfsddddddg',2,2),(43,NULL,NULL,NULL),(44,'el paciente debe bajar de peso',80,160),(46,NULL,NULL,NULL),(47,NULL,NULL,NULL),(48,'revision de paciente',85,170);
/*!40000 ALTER TABLE `consulta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_venta`
--

DROP TABLE IF EXISTS `detalle_venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalle_venta` (
  `iddetalle` int(11) NOT NULL AUTO_INCREMENT,
  `idventa` int(11) NOT NULL,
  `idservicios` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio` bigint(20) NOT NULL,
  `sub_total` bigint(20) NOT NULL,
  PRIMARY KEY (`iddetalle`),
  KEY `fk_detalle_venta_venta1_idx` (`idventa`),
  KEY `fk_detalle_venta_servicios1_idx` (`idservicios`),
  CONSTRAINT `fk_detalle_venta_servicios` FOREIGN KEY (`idservicios`) REFERENCES `productos` (`idservicios`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idventa` FOREIGN KEY (`idventa`) REFERENCES `venta` (`idventa`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_venta`
--

LOCK TABLES `detalle_venta` WRITE;
/*!40000 ALTER TABLE `detalle_venta` DISABLE KEYS */;
INSERT INTO `detalle_venta` VALUES (1,2,9,1,150000,150000),(2,2,9,1,150000,150000),(3,3,9,1,150000,150000),(4,3,12,1,35000,35000),(5,3,11,1,150000,150000),(6,3,9,1,150000,150000),(7,3,13,2,50000,100000),(8,5,11,1,150000,150000),(9,5,9,1,150000,150000),(10,5,13,2,50000,100000),(11,6,12,1,35000,35000),(12,7,9,1,150000,150000),(13,7,13,1,50000,50000),(14,7,11,1,150000,150000),(15,8,9,1,150000,150000),(16,8,13,1,50000,50000),(17,8,11,1,150000,150000),(18,9,11,1,150000,150000),(19,9,9,2,150000,300000),(20,10,11,1,150000,150000),(21,10,13,10,50000,500000),(22,12,14,10,30000,300000),(23,12,14,10,30000,300000),(24,14,14,10,30000,300000),(25,14,9,1,150000,150000),(26,14,14,100,30000,3000000),(27,16,9,1,150000,150000),(28,16,14,100,30000,3000000),(29,17,9,1,150000,150000),(30,18,9,1,150000,150000),(31,19,9,1,150000,150000),(32,20,11,12,150000,1800000),(33,21,11,1,150000,150000),(34,21,14,1,30000,30000),(35,22,12,1,35000,35000),(36,23,14,1,30000,30000),(37,23,13,1,50000,50000),(38,23,9,12,150000,1800000),(39,24,11,1,150000,150000),(40,24,12,1,35000,35000),(41,24,9,1,150000,150000),(42,25,13,1,50000,50000),(43,25,12,4,35000,140000),(44,26,11,1,150000,150000),(45,26,15,1,30000,30000),(46,26,13,1,50000,50000),(47,26,14,1,30000,30000),(48,27,14,1,30000,30000),(49,27,9,11,150000,1650000),(50,28,14,1,30000,30000),(51,28,12,2,35000,70000),(52,28,13,1,50000,50000),(53,28,12,1,35000,35000),(54,28,11,1,150000,150000),(55,28,9,1,150000,150000),(56,28,13,1,50000,50000),(57,28,13,1,50000,50000),(58,28,11,1,150000,150000),(59,28,9,1,150000,150000),(60,28,13,1,50000,50000),(61,28,14,3,30000,90000),(62,30,13,1,50000,50000),(63,30,12,1,35000,35000),(64,30,11,1,150000,150000),(65,30,9,1,150000,150000),(66,30,13,1,50000,50000),(67,30,13,1,50000,50000),(68,30,11,1,150000,150000),(69,30,9,1,150000,150000),(70,30,13,1,50000,50000),(71,30,14,3,30000,90000);
/*!40000 ALTER TABLE `detalle_venta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dieta`
--

DROP TABLE IF EXISTS `dieta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dieta` (
  `iddieta` int(11) NOT NULL AUTO_INCREMENT,
  `idusuarios` int(11) NOT NULL,
  `idpaciente` int(11) NOT NULL,
  `comentario` varchar(500) DEFAULT NULL,
  `fecha_registro` date DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  `idcomida` int(11) NOT NULL,
  PRIMARY KEY (`iddieta`),
  KEY `fk_dieta_usuarios1_idx` (`idusuarios`),
  KEY `fk_dieta_paciente1_idx` (`idpaciente`),
  KEY `fk_dieta_comidas1_idx` (`idcomida`),
  CONSTRAINT `fk_dieta_comidas1` FOREIGN KEY (`idcomida`) REFERENCES `comidas` (`idcomida`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_dieta_paciente1` FOREIGN KEY (`idpaciente`) REFERENCES `paciente` (`idpaciente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_dieta_usuarios1` FOREIGN KEY (`idusuarios`) REFERENCES `usuarios` (`idusuarios`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dieta`
--

LOCK TABLES `dieta` WRITE;
/*!40000 ALTER TABLE `dieta` DISABLE KEYS */;
INSERT INTO `dieta` VALUES (1,2,13,'realizar actividad fisica una hora al dia para mejores resultados','2020-02-27','ACTIVO',18),(2,2,13,'realizar actividad fisica una hora al dia para mejores resultados','2020-02-27','ACTIVO',17),(3,2,13,'realizar actividad fisica una hora al dia para mejores resultados','2020-02-27','ACTIVO',16),(4,2,13,'realizar actividad fisica una hora al dia para mejores resultados','2020-02-27','ACTIVO',15),(5,2,13,'realizar actividad fisica una hora al dia para mejores resultados','2020-02-27','ACTIVO',14),(6,2,13,'realizar actividad fisica una hora al dia para mejores resultados','2020-02-27','ACTIVO',13),(7,2,13,'realizar actividad fisica una hora al dia para mejores resultados','2020-02-27','ACTIVO',12),(8,2,13,'realizar actividad fisica una hora al dia para mejores resultados','2020-02-27','ACTIVO',11),(9,2,13,'realizar actividad fisica una hora al dia para mejores resultados','2020-02-27','ACTIVO',10),(10,2,13,'realizar actividad fisica una hora al dia para mejores resultados','2020-02-27','ACTIVO',9),(11,2,13,'realizar actividad fisica una hora al dia para mejores resultados','2020-02-27','ACTIVO',8),(12,2,13,'realizar actividad fisica una hora al dia para mejores resultados','2020-02-27','ACTIVO',7),(13,2,13,'realizar actividad fisica una hora al dia para mejores resultados','2020-02-27','ACTIVO',6),(14,2,13,'realizar actividad fisica una hora al dia para mejores resultados','2020-02-27','ACTIVO',5),(15,2,13,'realizar actividad fisica una hora al dia para mejores resultados','2020-02-27','ACTIVO',4),(16,2,1,'','2020-12-20','ACTIVO',18),(17,2,1,'','2020-12-20','ACTIVO',17),(18,2,1,'','2020-12-20','ACTIVO',16),(19,2,1,'','2020-12-20','ACTIVO',15),(20,2,1,'','2020-12-20','ACTIVO',14),(21,2,1,'','2020-12-20','ACTIVO',13),(22,2,1,'','2020-12-20','ACTIVO',12),(23,2,1,'','2020-12-20','ACTIVO',11),(24,2,1,'','2020-12-20','ACTIVO',10),(25,2,1,'','2020-12-20','ACTIVO',9),(26,2,1,'','2020-12-20','ACTIVO',8),(27,2,1,'','2020-12-20','ACTIVO',7),(28,2,1,'','2020-12-20','ACTIVO',6),(29,2,1,'','2020-12-20','ACTIVO',5),(30,2,1,'','2020-12-20','ACTIVO',4),(31,2,17,'','2020-12-21','ACTIVO',18),(32,2,17,'','2020-12-21','ACTIVO',17),(33,2,17,'','2020-12-21','ACTIVO',16),(34,2,17,'','2020-12-21','ACTIVO',15),(35,2,17,'','2020-12-21','ACTIVO',14),(36,2,17,'','2020-12-21','ACTIVO',13),(37,2,17,'','2020-12-21','ACTIVO',12),(38,2,17,'','2020-12-21','ACTIVO',11),(39,2,17,'','2020-12-21','ACTIVO',10),(40,2,17,'','2020-12-21','ACTIVO',9),(41,2,17,'','2020-12-21','ACTIVO',8),(42,2,17,'','2020-12-21','ACTIVO',7),(43,2,17,'','2020-12-21','ACTIVO',6),(44,2,17,'','2020-12-21','ACTIVO',5),(45,2,17,'','2020-12-21','ACTIVO',4),(46,2,17,'','2020-12-21','ACTIVO',18),(47,2,17,'','2020-12-21','ACTIVO',17),(48,2,17,'','2020-12-21','ACTIVO',16),(49,2,17,'','2020-12-21','ACTIVO',15),(50,2,17,'','2020-12-21','ACTIVO',14),(51,2,17,'','2020-12-21','ACTIVO',13),(52,2,17,'','2020-12-21','ACTIVO',12),(53,2,17,'','2020-12-21','ACTIVO',11),(54,2,17,'','2020-12-21','ACTIVO',10),(55,2,17,'','2020-12-21','ACTIVO',9),(56,2,17,'','2020-12-21','ACTIVO',8),(57,2,17,'','2020-12-21','ACTIVO',7),(58,2,17,'','2020-12-21','ACTIVO',6),(59,2,17,'','2020-12-21','ACTIVO',5),(60,2,17,'','2020-12-21','ACTIVO',4),(61,2,16,'','2020-12-21','ACTIVO',18),(62,2,16,'','2020-12-21','ACTIVO',17),(63,2,16,'','2020-12-21','ACTIVO',16),(64,2,16,'','2020-12-21','ACTIVO',15),(65,2,16,'','2020-12-21','ACTIVO',14),(66,2,16,'','2020-12-21','ACTIVO',13),(67,2,16,'','2020-12-21','ACTIVO',12),(68,2,16,'','2020-12-21','ACTIVO',11),(69,2,16,'','2020-12-21','ACTIVO',10),(70,2,16,'','2020-12-21','ACTIVO',9),(71,2,16,'','2020-12-21','ACTIVO',8),(72,2,16,'','2020-12-21','ACTIVO',7),(73,2,16,'','2020-12-21','ACTIVO',6),(74,2,16,'','2020-12-21','ACTIVO',5),(75,2,16,'','2020-12-21','ACTIVO',4),(76,2,17,'','2020-12-21','ACTIVO',18),(77,2,17,'','2020-12-21','ACTIVO',17),(78,2,17,'','2020-12-21','ACTIVO',16),(79,2,17,'','2020-12-21','ACTIVO',15),(80,2,17,'','2020-12-21','ACTIVO',14),(81,2,17,'','2020-12-21','ACTIVO',13),(82,2,17,'','2020-12-21','ACTIVO',12),(83,2,17,'','2020-12-21','ACTIVO',11),(84,2,17,'','2020-12-21','ACTIVO',10),(85,2,17,'','2020-12-21','ACTIVO',9),(86,2,17,'','2020-12-21','ACTIVO',8),(87,2,17,'','2020-12-21','ACTIVO',7),(88,2,17,'','2020-12-21','ACTIVO',6),(89,2,17,'','2020-12-21','ACTIVO',5),(90,2,17,'','2020-12-21','ACTIVO',4);
/*!40000 ALTER TABLE `dieta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `factura`
--

DROP TABLE IF EXISTS `factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `factura` (
  `nrofactura` int(11) NOT NULL,
  `monto` bigint(20) DEFAULT NULL,
  `efectivo` bigint(20) DEFAULT NULL,
  `vuelto` bigint(20) DEFAULT NULL,
  `idventa` int(11) NOT NULL,
  PRIMARY KEY (`nrofactura`),
  KEY `fk_factura_venta1_idx` (`idventa`),
  CONSTRAINT `fk_factura_venta1` FOREIGN KEY (`idventa`) REFERENCES `venta` (`idventa`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `factura`
--

LOCK TABLES `factura` WRITE;
/*!40000 ALTER TABLE `factura` DISABLE KEYS */;
INSERT INTO `factura` VALUES (1,300000,300000,0,2),(2,185000,200000,15000,3),(3,400000,40000,-360000,5),(4,35000,40000,5000,6),(5,350000,350000,0,7),(6,350000,400000,50000,8),(7,450000,500000,50000,9),(8,150000,100000,-50000,10),(9,300000,300000,0,12),(10,300000,300000,0,14),(11,3150000,4000000,850000,16),(14,150000,152000,2000,19),(15,1800000,2000000,200000,20),(16,180000,200000,20000,21),(17,35000,40000,5000,22),(18,1880000,2000000,120000,23),(19,335000,350000,15000,24),(20,190000,200000,10000,25),(21,260000,300000,40000,26),(22,1680000,1700000,20000,27),(23,100000,100000,0,28),(24,925000,950000,25000,30);
/*!40000 ALTER TABLE `factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movimiento_caja`
--

DROP TABLE IF EXISTS `movimiento_caja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movimiento_caja` (
  `idmovimiento` int(11) NOT NULL AUTO_INCREMENT,
  `idusuarios` int(11) NOT NULL,
  `num_Caja` varchar(45) DEFAULT NULL,
  `fecha_apertura` date NOT NULL,
  `fecha_cierre` date DEFAULT NULL,
  `monto_apertura` bigint(20) NOT NULL,
  `monto_cierre` bigint(20) DEFAULT NULL,
  `estado` varchar(45) NOT NULL,
  PRIMARY KEY (`idmovimiento`),
  KEY `fk_movimiento_caja_usuarios1_idx` (`idusuarios`),
  CONSTRAINT `fk_movimiento_caja_usuarios1` FOREIGN KEY (`idusuarios`) REFERENCES `usuarios` (`idusuarios`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movimiento_caja`
--

LOCK TABLES `movimiento_caja` WRITE;
/*!40000 ALTER TABLE `movimiento_caja` DISABLE KEYS */;
INSERT INTO `movimiento_caja` VALUES (67,24,'1','2021-12-27','2021-12-30',100000,1020000,'CERRADO'),(68,24,'3','2021-12-30','2021-12-30',100000,100000,'CERRADO'),(69,24,'1','2021-12-30','2021-12-30',200000,0,'CERRADO'),(70,24,'1','2021-12-30','2021-12-30',100000,0,'CERRADO'),(71,24,'1','2021-12-30','2021-12-30',100000,550000,'CERRADO'),(72,24,'1','2022-01-02','2022-01-02',100000,250000,'CERRADO'),(73,24,'1','2022-01-02','2022-01-02',100000,0,'ACTIVO'),(74,26,'1','2022-01-04','2022-01-04',100000,0,'ACTIVO');
/*!40000 ALTER TABLE `movimiento_caja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paciente`
--

DROP TABLE IF EXISTS `paciente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paciente` (
  `idpaciente` int(11) NOT NULL,
  `fechanac` date DEFAULT NULL,
  `estado` varchar(45) NOT NULL,
  PRIMARY KEY (`idpaciente`),
  KEY `fk_paciente_persona_idx` (`idpaciente`),
  CONSTRAINT `fk_paciente_persona` FOREIGN KEY (`idpaciente`) REFERENCES `persona` (`idpersona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paciente`
--

LOCK TABLES `paciente` WRITE;
/*!40000 ALTER TABLE `paciente` DISABLE KEYS */;
INSERT INTO `paciente` VALUES (25,NULL,'ACTIVO');
/*!40000 ALTER TABLE `paciente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persona` (
  `idpersona` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `numDocumento` varchar(45) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `genero` varchar(45) DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idpersona`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (24,'JOSE','AYALA','4419747','0699','CALLE','MASCULINO	','ACTIVO'),(25,'jose','ayala','4419747','0982568965','calle san roque','MASCULINO	','ACTIVO'),(26,'prueba','prueba','448548','0985554878','','MASCULINO	','ACTIVO');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productos` (
  `idservicios` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_producto` varchar(45) NOT NULL,
  `descripcion` varchar(150) DEFAULT NULL,
  `precio_unitario` bigint(20) NOT NULL,
  `precio_mayor` bigint(20) NOT NULL,
  `precio_costo` bigint(20) DEFAULT NULL,
  `stock` double NOT NULL,
  `cod_barra` varchar(45) DEFAULT NULL,
  `estado` varchar(45) NOT NULL,
  `idcategorias` int(11) NOT NULL,
  `pulgadas` double DEFAULT NULL,
  PRIMARY KEY (`idservicios`),
  KEY `fk_productos_categorias1_idx` (`idcategorias`),
  CONSTRAINT `fk_productos_categorias1` FOREIGN KEY (`idcategorias`) REFERENCES `categorias` (`idcategorias`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (9,'MESA','MESA 1X3 METROS',150000,130000,90000,6,'09839324','ACTIVO',2,0),(10,'SILLA','SILLA PEQUEÑA',50000,40000,30000,10,'0393949494','INACTIVO',1,NULL),(11,'MESA REDONDA','MESA PARA PATIO REDONDO',150000,130000,100000,3,'090898980','ACTIVO',2,0),(12,'PINTURA AL ACEITE','PINTURA AL ACEITE AMANECER DE 1 LTS',35000,30000,25000,5,'090898909','ACTIVO',4,0),(13,'SILLA','SILLA DE MADERA PARA JARDIN',50000,45000,30000,1,'98848383','ACTIVO',2,0),(14,'TIRANTE 2X5','TIRANTE',30000,28000,20000,10,NULL,'ACTIVO',5,200),(15,'FLETE','FLETE DE PRODUCTOS',30000,30000,30000,10,NULL,'ACTIVO',6,0),(16,'ADFA','AFAS',333,333,333,3333,NULL,'INACTIVO',6,333);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserva`
--

DROP TABLE IF EXISTS `reserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reserva` (
  `idreserva` int(11) NOT NULL AUTO_INCREMENT,
  `idusuarios` int(11) NOT NULL,
  `idpaciente` int(11) NOT NULL,
  `fechaconsulta` date DEFAULT NULL,
  `horaconsulta` varchar(10) DEFAULT NULL,
  `tipo_consulta` varchar(45) DEFAULT NULL,
  `motivo_consulta` varchar(200) DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  `num_turno` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idreserva`),
  KEY `fk_reserva_usuarios1_idx` (`idusuarios`),
  KEY `fk_reserva_paciente2_idx` (`idpaciente`),
  CONSTRAINT `fk_reserva_paciente2` FOREIGN KEY (`idpaciente`) REFERENCES `paciente` (`idpaciente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_reserva_usuarios1` FOREIGN KEY (`idusuarios`) REFERENCES `usuarios` (`idusuarios`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserva`
--

LOCK TABLES `reserva` WRITE;
/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
INSERT INTO `reserva` VALUES (12,15,13,'2020-02-28','8:30','sobrepeso',NULL,'ATENDIDO','5'),(13,14,17,'2020-02-28','8:00','revision',NULL,'ATENDIDO','9'),(14,9,16,'2020-12-04','MAÑANA','prueba',NULL,'ATENDIDO','1'),(15,9,7,'2020-02-02','8:00','nnnn',NULL,'INACTIVO','4'),(16,9,7,'2020-02-02','8:00','nnnn',NULL,'INACTIVO','2'),(17,6,17,'2020-03-12','8:00','lñk',NULL,'INACTIVO','4'),(18,4,17,'2020-10-26','8:00','CONSULTA',NULL,'INACTIVO','7'),(19,4,1,'2020-10-16','8:00','AFA',NULL,'INACTIVO','8'),(20,2,1,'2020-10-04','8:00','A',NULL,'INACTIVO','6'),(21,4,1,'2020-10-04','MAÑANA','awd',NULL,'INACTIVO','7'),(22,9,3,'2020-11-03','MAÑANA','a',NULL,'INACTIVO','8'),(23,5,7,'2020-11-03','MAÑANA','NORMAL',NULL,'INACTIVO','3'),(24,2,3,'2020-11-04','MAÑANA','a',NULL,'INACTIVO','2'),(25,2,3,'2020-11-06','8:00','a',NULL,'INACTIVO','1'),(26,9,7,'2020-11-13','MAÑANA','no se',NULL,'INACTIVO','0019'),(27,2,17,'2020-10-11','MAÑANA','aaaa',NULL,'INACTIVO','0020'),(28,2,13,'2020-10-03','MAÑANA','332',NULL,'INACTIVO','0021'),(29,9,7,'2020-12-31','TARDE','Ac',NULL,'ACTIVO','0022'),(30,9,1,'2020-12-03','MAÑANA','prueba',NULL,'INACTIVO','0019'),(31,5,1,'2020-12-03','MAÑANA','prueba',NULL,'INACTIVO','0019'),(32,9,16,'2020-12-31','TARDE','a',NULL,'INACTIVO','0019'),(33,9,1,'2020-12-31','TARDE','a',NULL,'INACTIVO','0019'),(34,9,1,'2020-12-05','MAÑANA','a',NULL,'ATENDIDO','0023'),(35,2,17,'2020-12-05','MAÑANA','eaa',NULL,'ATENDIDO','0024'),(36,6,3,'2020-12-03','MAÑANA','asdfg',NULL,'ATENDIDO','0025'),(37,2,13,'2020-12-31','TARDE','asdfgh',NULL,'ATENDIDO','0026'),(38,9,3,'2020-12-05','MAÑANA','a',NULL,'INACTIVO','0027'),(39,5,1,'2020-12-05','MAÑANA','asde',NULL,'ATENDIDO',''),(40,5,1,'2020-12-04','MAÑANA','A',NULL,'INACTIVO','0029'),(41,2,17,'2020-12-04','MAÑANA','A',NULL,'ATENDIDO','0030'),(42,2,16,'2020-12-06','MAÑANA','prueba',NULL,'ATENDIDO','0031'),(43,22,1,'2020-12-20','MAÑANA','chequeo',NULL,'INACTIVO','0032'),(44,9,17,'2020-12-15','MAÑANA','chequeo',NULL,'ATENDIDO','0033'),(46,20,16,'2020-12-20','MAÑANA','j',NULL,'INACTIVO','0034'),(47,6,17,'2020-12-21','MAÑANA','revision',NULL,'INACTIVO','0035'),(48,6,17,'2020-12-21','MAÑANA','revision',NULL,'ATENDIDO','0036');
/*!40000 ALTER TABLE `reserva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicios`
--

DROP TABLE IF EXISTS `servicios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `servicios` (
  `idservicios` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_servicio` varchar(45) NOT NULL,
  `precio` bigint(20) NOT NULL,
  `unidad` varchar(45) NOT NULL,
  `stock` double NOT NULL,
  `estado` varchar(45) NOT NULL,
  PRIMARY KEY (`idservicios`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicios`
--

LOCK TABLES `servicios` WRITE;
/*!40000 ALTER TABLE `servicios` DISABLE KEYS */;
INSERT INTO `servicios` VALUES (1,'CONSULTA',150000,'UNI',186,'ACTIVO'),(2,'DIETA',200000,'UNI',156,'ACTIVO'),(3,'REVISION',100000,'UNI',175,'ACTIVO'),(4,'CAMBIO DE DIETA',150000,'UNI',176,'ACTIVO'),(5,'PRUEBA',100000,'UNI',195,'ACTIVO'),(6,'SDFTGYU',456777,'KG',4,'INACTIVO'),(7,'NOSE',200000,'UNI',111,'INACTIVO'),(8,'MASAJE REDUCTOR',150000,'UNI',195,'ACTIVO');
/*!40000 ALTER TABLE `servicios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `idusuarios` int(11) NOT NULL,
  `acceso` varchar(45) DEFAULT NULL,
  `login` varchar(15) DEFAULT NULL,
  `password` varchar(15) DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idusuarios`),
  CONSTRAINT `fk_usuarios_persona1` FOREIGN KEY (`idusuarios`) REFERENCES `persona` (`idpersona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (24,'ADMINISTRADOR','admin','admin','ACTIVO'),(26,'RECEPCIONISTA','prueba','prueba','ACTIVO');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `venta` (
  `idventa` int(11) NOT NULL AUTO_INCREMENT,
  `idusuarios` int(11) NOT NULL,
  `idpaciente` int(11) NOT NULL,
  `total` bigint(20) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `nro_factura` varchar(45) DEFAULT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  `idmovimiento` int(11) NOT NULL,
  PRIMARY KEY (`idventa`),
  KEY `fk_venta_usuarios1_idx` (`idusuarios`),
  KEY `fk_venta_paciente1_idx` (`idpaciente`),
  KEY `fk_venta_movimiento_caja1_idx` (`idmovimiento`),
  CONSTRAINT `fk_venta_movimiento_caja1` FOREIGN KEY (`idmovimiento`) REFERENCES `movimiento_caja` (`idmovimiento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_venta_paciente1` FOREIGN KEY (`idpaciente`) REFERENCES `paciente` (`idpaciente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_venta_usuarios1` FOREIGN KEY (`idusuarios`) REFERENCES `usuarios` (`idusuarios`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

LOCK TABLES `venta` WRITE;
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
INSERT INTO `venta` VALUES (2,24,25,300000,'2021-12-30','0000001','CONTADO','FINALIZADO',67),(3,24,25,185000,'2021-12-30','0000002','CONTADO','FINALIZADO',67),(5,24,25,400000,'2021-12-30','0000003','CONTADO','FINALIZADO',67),(6,24,25,35000,'2021-12-30','0000004','CONTADO','FINALIZADO',67),(7,24,25,350000,'2021-12-30','0000005','CONTADO','FINALIZADO',69),(8,24,25,350000,'2021-12-30','0000006','CONTADO','FINALIZADO',70),(9,24,25,450000,'2021-12-30','0000007','CONTADO','FINALIZADO',71),(10,24,25,150000,'2022-01-02','0000008','CONTADO','FINALIZADO',72),(12,24,25,300000,'2022-01-02','0000009','CONTADO','FINALIZADO',73),(14,24,25,300000,'2022-01-02','0000010','CONTADO','FINALIZADO',73),(16,24,25,3150000,'2022-01-02','0000011','CONTADO','FINALIZADO',73),(17,24,25,150000,'2022-01-02','0000012','CONTADO','FINALIZADO',73),(18,24,25,150000,'2022-01-02','0000013','CONTADO','FINALIZADO',73),(19,24,25,150000,'2022-01-02','0000014','CONTADO','FINALIZADO',73),(20,24,25,1800000,'2022-01-02','0000015','CONTADO','FINALIZADO',73),(21,24,25,180000,'2022-01-02','0000016','CONTADO','FINALIZADO',73),(22,24,25,35000,'2022-01-03','0000017','CONTADO','FINALIZADO',73),(23,24,25,1880000,'2022-01-03','0000018','CONTADO','FINALIZADO',73),(24,24,25,335000,'2022-01-03','0000019','CONTADO','FINALIZADO',73),(25,24,25,190000,'2022-01-03','0000020','CONTADO','FINALIZADO',73),(26,24,25,260000,'2022-01-03','0000021','CONTADO','FINALIZADO',73),(27,24,25,1680000,'2022-01-03','0000022','CONTADO','FINALIZADO',73),(28,26,25,100000,'2022-01-04','0000023','CONTADO','FINALIZADO',74),(30,26,25,925000,'2022-01-04','0000024','CONTADO','FINALIZADO',74);
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-04 13:58:22
