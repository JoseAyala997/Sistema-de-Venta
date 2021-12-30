-- MySQL dump 10.13  Distrib 5.6.20, for Win64 (x86_64)
--
-- Host: localhost    Database: clinica_nutricional
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
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comidas`
--

LOCK TABLES `comidas` WRITE;
/*!40000 ALTER TABLE `comidas` DISABLE KEYS */;
INSERT INTO `comidas` VALUES (4,'ADULTO ','','DESAYUNO','LUNES',7820,'ACTIVO',18),(5,'ADULTO ','','M MAÑANA','LUNES',7820,'ACTIVO',25),(6,'ADULTO ','','ALMUERZO','LUNES',7820,'ACTIVO',28),(7,'ADULTO ','','MERIENDA','LUNES',7820,'ACTIVO',6),(8,'ADULTO ','','CENA','LUNES',7820,'ACTIVO',1),(9,'ADULTO ','','DESAYUNO','MARTES',7820,'ACTIVO',26),(10,'ADULTO ','','M MAÑANA','MARTES',7820,'ACTIVO',26),(11,'ADULTO ','','ALMUERZO','MARTES',7820,'ACTIVO',7),(12,'ADULTO ','','MERIENDA','MARTES',7820,'ACTIVO',3),(13,'ADULTO ','','CENA','MARTES',7820,'ACTIVO',16),(14,'ADULTO ','','DESAYUNO','MIERCOLES',7820,'ACTIVO',20),(15,'ADULTO ','','M MAÑANA','MIERCOLES',7820,'ACTIVO',25),(16,'ADULTO ','','ALMUERZO','MIERCOLES',7820,'ACTIVO',24),(17,'ADULTO ','','MERIENDA','MIERCOLES',7820,'ACTIVO',5),(18,'ADULTO ','','CENA','MIERCOLES',7820,'ACTIVO',1);
/*!40000 ALTER TABLE `comidas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consulta`
--

DROP TABLE IF EXISTS `consulta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `consulta` (
  `idconsulta` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_consulta` date DEFAULT NULL,
  `observacion` varchar(45) DEFAULT NULL,
  `fecha_prox` date DEFAULT NULL,
  `idpaciente` int(11) NOT NULL,
  `idreserva` int(11) NOT NULL,
  `peso_inicial` int(11) DEFAULT NULL,
  `recomendaciones` varchar(400) DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  `idusuarios` int(11) NOT NULL,
  PRIMARY KEY (`idconsulta`),
  KEY `fk_consulta_paciente1_idx` (`idpaciente`),
  KEY `fk_consulta_reserva1_idx` (`idreserva`),
  KEY `fk_consulta_usuarios1_idx` (`idusuarios`),
  CONSTRAINT `fk_consulta_paciente1` FOREIGN KEY (`idpaciente`) REFERENCES `paciente` (`idpaciente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_consulta_reserva1` FOREIGN KEY (`idreserva`) REFERENCES `reserva` (`idreserva`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_consulta_usuarios1` FOREIGN KEY (`idusuarios`) REFERENCES `usuarios` (`idusuarios`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consulta`
--

LOCK TABLES `consulta` WRITE;
/*!40000 ALTER TABLE `consulta` DISABLE KEYS */;
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
  CONSTRAINT `fk_detalle_venta_servicios` FOREIGN KEY (`idservicios`) REFERENCES `servicios` (`idservicios`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `idventa` FOREIGN KEY (`idventa`) REFERENCES `venta` (`idventa`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_venta`
--

LOCK TABLES `detalle_venta` WRITE;
/*!40000 ALTER TABLE `detalle_venta` DISABLE KEYS */;
INSERT INTO `detalle_venta` VALUES (78,51,2,1,200000,200000),(79,51,1,1,150000,150000),(80,51,4,1,150000,150000),(81,52,1,1,150000,150000),(82,52,4,1,150000,150000),(83,52,3,1,100000,100000),(84,53,2,1,200000,200000),(85,54,2,1,200000,200000),(86,54,1,1,150000,150000),(87,55,1,1,150000,150000),(88,55,4,1,150000,150000),(89,56,4,1,150000,150000),(90,57,1,1,150000,150000),(91,57,2,1,200000,200000),(92,58,2,1,200000,200000),(93,58,3,1,100000,100000),(94,59,4,1,150000,150000),(95,60,2,1,200000,200000),(96,60,1,1,150000,150000);
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
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dieta`
--

LOCK TABLES `dieta` WRITE;
/*!40000 ALTER TABLE `dieta` DISABLE KEYS */;
INSERT INTO `dieta` VALUES (1,2,13,'realizar actividad fisica una hora al dia para mejores resultados','2020-02-27','ACTIVO',18),(2,2,13,'realizar actividad fisica una hora al dia para mejores resultados','2020-02-27','ACTIVO',17),(3,2,13,'realizar actividad fisica una hora al dia para mejores resultados','2020-02-27','ACTIVO',16),(4,2,13,'realizar actividad fisica una hora al dia para mejores resultados','2020-02-27','ACTIVO',15),(5,2,13,'realizar actividad fisica una hora al dia para mejores resultados','2020-02-27','ACTIVO',14),(6,2,13,'realizar actividad fisica una hora al dia para mejores resultados','2020-02-27','ACTIVO',13),(7,2,13,'realizar actividad fisica una hora al dia para mejores resultados','2020-02-27','ACTIVO',12),(8,2,13,'realizar actividad fisica una hora al dia para mejores resultados','2020-02-27','ACTIVO',11),(9,2,13,'realizar actividad fisica una hora al dia para mejores resultados','2020-02-27','ACTIVO',10),(10,2,13,'realizar actividad fisica una hora al dia para mejores resultados','2020-02-27','ACTIVO',9),(11,2,13,'realizar actividad fisica una hora al dia para mejores resultados','2020-02-27','ACTIVO',8),(12,2,13,'realizar actividad fisica una hora al dia para mejores resultados','2020-02-27','ACTIVO',7),(13,2,13,'realizar actividad fisica una hora al dia para mejores resultados','2020-02-27','ACTIVO',6),(14,2,13,'realizar actividad fisica una hora al dia para mejores resultados','2020-02-27','ACTIVO',5),(15,2,13,'realizar actividad fisica una hora al dia para mejores resultados','2020-02-27','ACTIVO',4);
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
INSERT INTO `factura` VALUES (1,500000,500000,0,51),(2,400000,400000,0,52),(4,350000,400000,50000,54),(5,350000,400000,50000,54),(6,150000,200000,50000,56),(8,300000,300000,0,58),(9,150000,200000,50000,59),(10,350000,400000,50000,60);
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
  `fecha_apertura` date NOT NULL,
  `apertura` bigint(20) NOT NULL,
  `fecha_cierre` date DEFAULT NULL,
  `cierre` bigint(20) DEFAULT NULL,
  `estado` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idmovimiento`),
  KEY `fk_movimiento_caja_usuarios1_idx` (`idusuarios`),
  CONSTRAINT `fk_movimiento_caja_usuarios1` FOREIGN KEY (`idusuarios`) REFERENCES `usuarios` (`idusuarios`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movimiento_caja`
--

LOCK TABLES `movimiento_caja` WRITE;
/*!40000 ALTER TABLE `movimiento_caja` DISABLE KEYS */;
INSERT INTO `movimiento_caja` VALUES (1,2,'2020-01-15',0,NULL,0,'ABIERTO'),(2,2,'2020-01-21',0,NULL,0,'ABIERTO'),(3,2,'2020-01-21',0,NULL,0,'ABIERTO'),(4,2,'2020-01-21',0,NULL,222220000,'CERRA'),(5,2,'2020-01-21',200000,NULL,2000000,'CERRADO'),(6,2,'2020-01-27',11112222,'2020-01-15',89988,'cerrado'),(7,2,'2020-01-27',111222333444,'2020-01-27',234,'CERRADO'),(8,2,'2020-01-27',200000,'2020-01-27',1000000,'CERRADO'),(9,2,'2020-01-28',2000000,NULL,0,'ABIERTO'),(10,2,'2020-01-28',2222,'2020-01-28',20000,'CERRADO'),(11,2,'2020-01-31',1000000,'2020-01-31',1000000,'CERRADO'),(12,2,'2020-02-23',200000,'2020-02-23',1000000,'CERRADO'),(13,2,'2020-02-23',20000,NULL,0,'ABIERTO'),(14,2,'2020-02-23',30000,'2020-02-23',500000,'CERRADO'),(15,2,'2020-02-27',20000,NULL,0,'ABIERTO');
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
INSERT INTO `paciente` VALUES (1,'0000-00-00','ACTIVO'),(3,NULL,'ACTIVO'),(7,NULL,'ACTIVO'),(13,NULL,'ACTIVO'),(16,NULL,'ACTIVO'),(17,NULL,'ACTIVO');
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
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,'julio','ayala','233444','09888','calle','MASCULINO	','ACTIVO'),(2,'jose luis','ayala','0000088','098','calle','MASCULINO	','ACTIVO'),(3,'CLIENTE ','GENERAL','xxxxxxx','xxxxxxxxxxxxxx','xxxxxxxxxxxx','MASCULINO	','ACTIVO'),(4,'CELSO','GAMARRA','345654','099999','calle','MASCULINO	','ACTIVO'),(5,'WILIAN ','ROMERO','4443324-9','0984885544','CALLE UMAITA','MASCULINO	','ACTIVO'),(6,'emanuel','torres','3880899-9','0983388','calle n','MASCULINO	','ACTIVO'),(7,'diego','britez','887878','0980980','calle','MASCULINO	','ACTIVO'),(8,'kjkl','lk','jkl','j','lkj','MASCULINO	','INACTIVO'),(9,'paola','morel','433322','09999','calle san juan','FEMENINO','ACTIVO'),(10,'lkj','ljlk','j','klj','calle','MASCULINO	','INACTIVO'),(11,'JÑ','KJKJKLJ','9999','9999','ÑKJÑLKJ','MASCULINO	','ACTIVO'),(12,'LÑK{LK','LÑK{Ñ','K{ÑL','K{Ñ','K{Ñ','MASCULINO	','INACTIVO'),(13,'Jose David','Ruiz','6542678','0983527652','villarrica','MASCULINO	','ACTIVO'),(14,'Daniel','Atlas','6727657','0984524254','Villarrica','MASCULINO	','ACTIVO'),(15,'Adriana','Gonzalez','5625465','0983726562','San Juan','FEMENINO','ACTIVO'),(16,'Juan','Britez','6537653','0982726238','San Juan','MASCULINO	','ACTIVO'),(17,'Ariel','Mendoza','4535633','0984672657','San Juan','MASCULINO	','ACTIVO');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserva`
--

LOCK TABLES `reserva` WRITE;
/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
INSERT INTO `reserva` VALUES (1,2,1,'2019-09-27','10:00','no se',NULL,'INACTIVO',NULL),(2,2,1,'2019-09-25','16:00','no se whe',NULL,'INACTIVO',NULL),(3,2,1,'2019-09-27','8:00','lllkkl',NULL,'INACTIVO',NULL),(4,2,1,'2019-09-12','8:00','prueba1',NULL,'INACTIVO',NULL),(5,2,1,'2019-11-08','8:00','ultima',NULL,'ACTIVO',NULL),(6,2,1,'2019-11-12','8:00','jkjhkj',NULL,'INACTIVO',NULL),(7,6,7,'2019-09-27','8:00','NO SE',NULL,'INACTIVO',NULL),(8,4,3,'2020-02-23','8:00','revision',NULL,'INACTIVO',NULL),(9,2,7,'2020-02-23','8:00','pa',NULL,'ACTIVO',NULL),(10,2,3,'2020-02-21','8:00','cccc',NULL,'ACTIVO',NULL),(11,2,13,'2020-02-27','8:00','revision',NULL,'ACTIVO',NULL),(12,15,13,'2020-02-28','8:30','sobrepeso',NULL,'ACTIVO',NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicios`
--

LOCK TABLES `servicios` WRITE;
/*!40000 ALTER TABLE `servicios` DISABLE KEYS */;
INSERT INTO `servicios` VALUES (1,'CONSULTA',150000,'UNI',199,'ACTIVO'),(2,'DIETA',200000,'UNI',181,'ACTIVO'),(3,'REVISION',100000,'UNI',185,'ACTIVO'),(4,'CAMBIO DE DIETA',150000,'UNI',182,'ACTIVO'),(5,'PRUEBA',100000,'UNI',200,'ACTIVO'),(6,'SDFTGYU',456777,'KG',4,'INACTIVO'),(7,'NOSE',200000,'UNI',111,'INACTIVO');
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
INSERT INTO `usuarios` VALUES (2,'ADMINISTRADOR','admin','12345','ACTIVO'),(4,'RECEPCIONISTA','celso','12345','ACTIVO'),(5,'RECEPCIONISTA','WILIAN','12345','ACTIVO'),(6,'NUTRICIONISTA','emanuel','12345','ACTIVO'),(8,'RECEPCIONISTA','kjñl','klñj','ACTIVO'),(9,'RECEPCIONISTA','paola','12345','ACTIVO'),(10,'ADMINISTRADOR','kljlk','jlk','ACTIVO'),(11,'RECEPCIONISTA','ADMIN','ADMIN','ACTIVO'),(12,'RECEPCIONISTA','LK','333','ACTIVO'),(14,'RECEPCIONISTA','admin','admin','ACTIVO'),(15,'ADMINISTRADOR','admin','admin123','ACTIVO');
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
  PRIMARY KEY (`idventa`),
  KEY `fk_venta_usuarios1_idx` (`idusuarios`),
  KEY `fk_venta_paciente1_idx` (`idpaciente`),
  CONSTRAINT `fk_venta_paciente1` FOREIGN KEY (`idpaciente`) REFERENCES `paciente` (`idpaciente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_venta_usuarios1` FOREIGN KEY (`idusuarios`) REFERENCES `usuarios` (`idusuarios`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

LOCK TABLES `venta` WRITE;
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
INSERT INTO `venta` VALUES (51,2,3,500000,'2019-12-11','0000001','CONTADO','FINALIZADO'),(52,2,3,400000,'2019-12-14','0000002','CUOTA','FINALIZADO'),(53,2,1,200000,'2020-01-08','0000003','CONTADO','FINALIZADO'),(54,2,3,350000,'2020-01-28','0000004','CONTADO','FINALIZADO'),(55,2,3,300000,'2020-02-05','0000005','CONTADO','FINALIZADO'),(56,2,3,150000,'2020-02-05','0000006','CONTADO','FINALIZADO'),(57,2,1,350000,'2020-02-06','0000007','CONTADO','FINALIZADO'),(58,2,3,300000,'2020-02-07','0000008','CONTADO','FINALIZADO'),(59,2,3,150000,'2020-02-25','0000009','CONTADO','FINALIZADO'),(60,2,13,350000,'2020-02-27','0000010','CONTADO','FINALIZADO');
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

-- Dump completed on 2020-02-27 17:01:06
