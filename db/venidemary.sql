-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: venidemary
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
-- Table structure for table `articulo`
--

DROP TABLE IF EXISTS `articulo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `articulo` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `descripcion` varchar(400) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `imagen` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `stockActual` int unsigned NOT NULL,
  `stockDeseado` int unsigned NOT NULL,
  `deletionDate` datetime DEFAULT NULL,
  `isDeleted` tinyint(1) NOT NULL DEFAULT '0',
  `rubroId` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `articulo_rubro_FK` (`rubroId`),
  CONSTRAINT `articulo_rubro_FK` FOREIGN KEY (`rubroId`) REFERENCES `rubro` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `articulo`
--

LOCK TABLES `articulo` WRITE;
/*!40000 ALTER TABLE `articulo` DISABLE KEYS */;
INSERT INTO `articulo` VALUES (1,'Regla','Regla','Regla',30,20,NULL,0,8),(2,'Lapiz','Lapiz','Lapiz',25,20,NULL,0,8),(3,'Cartuchera','Cartuchera tipo canopla','imagen cartuchera',25,30,NULL,0,13),(4,'test','test','borrar',30,20,'2021-02-12 02:39:34',1,3),(5,'borrar','Regla2','Regla',30,25,NULL,0,1),(6,'tete','tete','tete',370,677,'2021-02-12 03:03:04',1,13),(7,'test','d','d',10,20,NULL,0,8),(8,'prueba','dede','dede',10,20,'2021-02-25 04:18:00',1,11);
/*!40000 ALTER TABLE `articulo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ciudad`
--

DROP TABLE IF EXISTS `ciudad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ciudad` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `provinciaId` int unsigned NOT NULL,
  `nombre` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `codigoPostal` smallint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ciudad_provincia_FK` (`provinciaId`),
  CONSTRAINT `ciudad_provincia_FK` FOREIGN KEY (`provinciaId`) REFERENCES `provincia` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciudad`
--

LOCK TABLES `ciudad` WRITE;
/*!40000 ALTER TABLE `ciudad` DISABLE KEYS */;
INSERT INTO `ciudad` VALUES (1,1,'ROSARIO',2000),(2,1,'SAN LORENZO',2200),(3,1,'FUNES',2004),(4,1,'ROLDAN',2009),(5,2,'CABA',1000),(6,2,'LA PLATA',1400),(7,3,'CORDOBA',2000),(8,3,'LA FALDA',2000),(9,4,'VICTORIA',2000),(10,4,'PARANA',2000);
/*!40000 ALTER TABLE `ciudad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compra`
--

DROP TABLE IF EXISTS `compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compra` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `numeroComprobante` int unsigned NOT NULL,
  `fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `entityId` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `compra_numeroComprobante_UNIQUE` (`numeroComprobante`),
  KEY `compra_entity_FK` (`entityId`),
  CONSTRAINT `compra_entity_FK` FOREIGN KEY (`entityId`) REFERENCES `entity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra`
--

LOCK TABLES `compra` WRITE;
/*!40000 ALTER TABLE `compra` DISABLE KEYS */;
/*!40000 ALTER TABLE `compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comprobantepago`
--

DROP TABLE IF EXISTS `comprobantepago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comprobantepago` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `numeroComprobante` int unsigned NOT NULL,
  `numeroFactura` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `nota` varchar(400) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `comprobantePago_numeroComprobante_UNIQUE` (`numeroComprobante`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comprobantepago`
--

LOCK TABLES `comprobantepago` WRITE;
/*!40000 ALTER TABLE `comprobantepago` DISABLE KEYS */;
INSERT INTO `comprobantepago` VALUES (1,'2021-02-10 00:00:00',1,'1','Nota 1'),(2,'2021-02-10 00:00:00',2,'2','Nota 2'),(3,'2021-02-10 00:00:00',3,'3','Nota 3'),(7,'2021-02-10 00:00:00',4,'4','Nota 4'),(8,'2021-02-10 00:00:00',5,'5','Nota 5'),(9,'2021-02-10 00:00:00',6,'6','Nota 6');
/*!40000 ALTER TABLE `comprobantepago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contador`
--

DROP TABLE IF EXISTS `contador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contador` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `valor` int unsigned NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contador`
--

LOCK TABLES `contador` WRITE;
/*!40000 ALTER TABLE `contador` DISABLE KEYS */;
/*!40000 ALTER TABLE `contador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuentacorrientecliente`
--

DROP TABLE IF EXISTS `cuentacorrientecliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cuentacorrientecliente` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `fechaCreacion` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `isAprobada` tinyint(1) NOT NULL DEFAULT '0',
  `isDeleted` tinyint(1) NOT NULL DEFAULT '0',
  `fechaDeletion` datetime DEFAULT NULL,
  `usuarioEntityId` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `cuentaCorrienteCliente_usuario_FK` (`usuarioEntityId`),
  CONSTRAINT `cuentaCorrienteCliente_usuario_FK` FOREIGN KEY (`usuarioEntityId`) REFERENCES `usuario` (`entityId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuentacorrientecliente`
--

LOCK TABLES `cuentacorrientecliente` WRITE;
/*!40000 ALTER TABLE `cuentacorrientecliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cuentacorrientecliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `descuento`
--

DROP TABLE IF EXISTS `descuento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `descuento` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `valor` decimal(3,2) NOT NULL,
  `isHabilitado` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `descuento`
--

LOCK TABLES `descuento` WRITE;
/*!40000 ALTER TABLE `descuento` DISABLE KEYS */;
INSERT INTO `descuento` VALUES (7,0.00,1),(8,1.00,1),(9,2.00,0);
/*!40000 ALTER TABLE `descuento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `direccion`
--

DROP TABLE IF EXISTS `direccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `direccion` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `ciudadId` int unsigned DEFAULT NULL,
  `calle` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `numero` int unsigned NOT NULL,
  `detalle` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `entityId` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `direccion_ciudad_FK` (`ciudadId`),
  KEY `direccion_entity_fk` (`entityId`),
  CONSTRAINT `direccion_ciudad_FK` FOREIGN KEY (`ciudadId`) REFERENCES `ciudad` (`id`),
  CONSTRAINT `direccion_entity_FK` FOREIGN KEY (`entityId`) REFERENCES `entity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `direccion`
--

LOCK TABLES `direccion` WRITE;
/*!40000 ALTER TABLE `direccion` DISABLE KEYS */;
/*!40000 ALTER TABLE `direccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entity`
--

DROP TABLE IF EXISTS `entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `entity` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `entityTypeId` int unsigned NOT NULL,
  `creationDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deletionDate` datetime DEFAULT NULL,
  `isDeleted` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `entity_entityType_FK` (`entityTypeId`),
  CONSTRAINT `entity_entityType_FK` FOREIGN KEY (`entityTypeId`) REFERENCES `entitytype` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entity`
--

LOCK TABLES `entity` WRITE;
/*!40000 ALTER TABLE `entity` DISABLE KEYS */;
INSERT INTO `entity` VALUES (1,1,'2020-08-17 20:31:15',NULL,0),(3,1,'2020-10-08 00:17:41',NULL,0),(4,1,'2020-10-08 00:17:41',NULL,0),(5,1,'2021-02-24 01:51:50','2021-02-24 20:59:20',1),(6,1,'2021-02-24 01:53:58',NULL,0),(7,1,'2021-02-24 01:55:34',NULL,0),(8,1,'2021-02-24 01:57:59','2021-02-24 05:45:03',1),(9,1,'2021-02-24 02:24:01',NULL,0),(10,1,'2021-02-24 02:29:25','2021-02-24 21:24:55',1),(13,1,'2021-02-24 18:25:23',NULL,0),(14,1,'2021-02-25 00:54:17','2021-02-25 03:54:38',1),(15,1,'2021-02-25 01:19:09','2021-02-25 04:19:45',1),(16,1,'2021-02-25 17:27:03',NULL,0),(17,1,'2021-02-25 17:30:49','2021-02-25 22:07:49',1);
/*!40000 ALTER TABLE `entity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entitytype`
--

DROP TABLE IF EXISTS `entitytype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `entitytype` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entitytype`
--

LOCK TABLES `entitytype` WRITE;
/*!40000 ALTER TABLE `entitytype` DISABLE KEYS */;
INSERT INTO `entitytype` VALUES (1,'usuario');
/*!40000 ALTER TABLE `entitytype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estadocuentacorriente`
--

DROP TABLE IF EXISTS `estadocuentacorriente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estadocuentacorriente` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `cantidad` int unsigned NOT NULL,
  `cuentaCorrienteClienteId` int unsigned NOT NULL,
  `articuloId` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `cuentaCorrienteCliente_cuentaCorrienteCliente_FK` (`cuentaCorrienteClienteId`),
  KEY `cuentaCorrienteCliente_articulo_FK` (`articuloId`),
  CONSTRAINT `cuentaCorrienteCliente_articulo_FK` FOREIGN KEY (`articuloId`) REFERENCES `articulo` (`id`),
  CONSTRAINT `cuentaCorrienteCliente_cuentaCorrienteCliente_FK` FOREIGN KEY (`cuentaCorrienteClienteId`) REFERENCES `cuentacorrientecliente` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estadocuentacorriente`
--

LOCK TABLES `estadocuentacorriente` WRITE;
/*!40000 ALTER TABLE `estadocuentacorriente` DISABLE KEYS */;
/*!40000 ALTER TABLE `estadocuentacorriente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lineacompra`
--

DROP TABLE IF EXISTS `lineacompra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lineacompra` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `cantidadEntregada` int unsigned NOT NULL,
  `precio` decimal(12,3) NOT NULL,
  `compraId` int unsigned NOT NULL,
  `articuloId` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `lineaCompra_compra_FK` (`compraId`),
  KEY `lineaCompra_articulo_FK` (`articuloId`),
  CONSTRAINT `lineaCompra_articulo_FK` FOREIGN KEY (`articuloId`) REFERENCES `articulo` (`id`),
  CONSTRAINT `lineaCompra_compra_FK` FOREIGN KEY (`compraId`) REFERENCES `compra` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lineacompra`
--

LOCK TABLES `lineacompra` WRITE;
/*!40000 ALTER TABLE `lineacompra` DISABLE KEYS */;
/*!40000 ALTER TABLE `lineacompra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lineareserva`
--

DROP TABLE IF EXISTS `lineareserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lineareserva` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `cantidad` int unsigned NOT NULL,
  `precioId` int unsigned NOT NULL,
  `articuloId` int unsigned NOT NULL,
  `reservaId` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `lineaReserva_precio_FK` (`precioId`),
  KEY `lineaReserva_articulo_FK` (`articuloId`),
  KEY `lineaReserva_reserva_FK` (`reservaId`),
  CONSTRAINT `lineaReserva_articulo_FK` FOREIGN KEY (`articuloId`) REFERENCES `articulo` (`id`),
  CONSTRAINT `lineaReserva_precio_FK` FOREIGN KEY (`precioId`) REFERENCES `precio` (`id`),
  CONSTRAINT `lineaReserva_reserva_FK` FOREIGN KEY (`reservaId`) REFERENCES `reserva` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lineareserva`
--

LOCK TABLES `lineareserva` WRITE;
/*!40000 ALTER TABLE `lineareserva` DISABLE KEYS */;
/*!40000 ALTER TABLE `lineareserva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lineaventa`
--

DROP TABLE IF EXISTS `lineaventa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lineaventa` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `cantidad` int unsigned NOT NULL,
  `isPago` tinyint(1) NOT NULL DEFAULT '0',
  `articuloId` int unsigned NOT NULL,
  `precioId` int unsigned NOT NULL,
  `comprobantePagoId` int unsigned NOT NULL,
  `ventaId` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `lineaVenta_articulo_FK` (`articuloId`),
  KEY `lineaVenta_precio_FK` (`precioId`),
  KEY `lineaVenta_comprobantePago_FK` (`comprobantePagoId`),
  KEY `lineaVenta_venta_FK` (`ventaId`),
  CONSTRAINT `lineaVenta_articulo_FK` FOREIGN KEY (`articuloId`) REFERENCES `articulo` (`id`),
  CONSTRAINT `lineaVenta_comprobantePago_FK` FOREIGN KEY (`comprobantePagoId`) REFERENCES `comprobantepago` (`id`),
  CONSTRAINT `lineaVenta_precio_FK` FOREIGN KEY (`precioId`) REFERENCES `precio` (`id`),
  CONSTRAINT `lineaVenta_venta_FK` FOREIGN KEY (`ventaId`) REFERENCES `venta` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lineaventa`
--

LOCK TABLES `lineaventa` WRITE;
/*!40000 ALTER TABLE `lineaventa` DISABLE KEYS */;
INSERT INTO `lineaventa` VALUES (1,3,1,1,6,1,1),(2,2,1,2,7,2,1),(3,6,1,3,3,3,2),(4,5,1,1,6,7,2),(5,3,1,2,7,8,3),(6,1,1,3,3,9,3);
/*!40000 ALTER TABLE `lineaventa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lineaventacuentacorriente`
--

DROP TABLE IF EXISTS `lineaventacuentacorriente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lineaventacuentacorriente` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `cantidad` int unsigned NOT NULL,
  `estadoCuentaCorrienteId` int unsigned NOT NULL,
  `ventaId` int unsigned NOT NULL,
  `precioId` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `lineaVentaCuentaCorriente_estadoCuentaCorriente_FK` (`estadoCuentaCorrienteId`),
  KEY `lineaVentaCuentaCorriente_venta_FK` (`ventaId`),
  KEY `lineaVentaCuentaCorriente_precio_FK` (`precioId`),
  CONSTRAINT `lineaVentaCuentaCorriente_estadoCuentaCorriente_FK` FOREIGN KEY (`estadoCuentaCorrienteId`) REFERENCES `estadocuentacorriente` (`id`),
  CONSTRAINT `lineaVentaCuentaCorriente_precio_FK` FOREIGN KEY (`precioId`) REFERENCES `precio` (`id`),
  CONSTRAINT `lineaVentaCuentaCorriente_venta_FK` FOREIGN KEY (`ventaId`) REFERENCES `venta` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lineaventacuentacorriente`
--

LOCK TABLES `lineaventacuentacorriente` WRITE;
/*!40000 ALTER TABLE `lineaventacuentacorriente` DISABLE KEYS */;
/*!40000 ALTER TABLE `lineaventacuentacorriente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mediopago`
--

DROP TABLE IF EXISTS `mediopago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mediopago` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mediopago`
--

LOCK TABLES `mediopago` WRITE;
/*!40000 ALTER TABLE `mediopago` DISABLE KEYS */;
INSERT INTO `mediopago` VALUES (1,'Efectivo'),(2,'Cuenta Corriente'),(3,'Mercado Pago');
/*!40000 ALTER TABLE `mediopago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notacredito`
--

DROP TABLE IF EXISTS `notacredito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notacredito` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `numeroComprobante` int unsigned NOT NULL,
  `importe` decimal(12,3) NOT NULL,
  `fechaEmision` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `motivo` varchar(400) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `ventaIdGenerada` int unsigned NOT NULL,
  `ventaIdUsada` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `notaCredito_venta_generada_FK` (`ventaIdGenerada`),
  KEY `notaCredito_venta_usada_FK` (`ventaIdUsada`),
  CONSTRAINT `notaCredito_venta_generada_FK` FOREIGN KEY (`ventaIdGenerada`) REFERENCES `venta` (`id`),
  CONSTRAINT `notaCredito_venta_usada_FK` FOREIGN KEY (`ventaIdUsada`) REFERENCES `venta` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notacredito`
--

LOCK TABLES `notacredito` WRITE;
/*!40000 ALTER TABLE `notacredito` DISABLE KEYS */;
/*!40000 ALTER TABLE `notacredito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pago`
--

DROP TABLE IF EXISTS `pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pago` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `valor` decimal(12,3) NOT NULL,
  `numeroComprobante` int unsigned NOT NULL,
  `fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `entityId` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `pago_numeroComprobante_UNIQUE` (`numeroComprobante`),
  KEY `pago_entity_FK` (`entityId`),
  CONSTRAINT `pago_entity_FK` FOREIGN KEY (`entityId`) REFERENCES `entity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pago`
--

LOCK TABLES `pago` WRITE;
/*!40000 ALTER TABLE `pago` DISABLE KEYS */;
/*!40000 ALTER TABLE `pago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagocuentacorriente`
--

DROP TABLE IF EXISTS `pagocuentacorriente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pagocuentacorriente` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `cantidad` int unsigned NOT NULL,
  `estadoCuentaCorrienteId` int unsigned NOT NULL,
  `comprobantePagoId` int unsigned NOT NULL,
  `precioId` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `pagoCuentaCorriente_estadoCuentaCorriente_FK` (`estadoCuentaCorrienteId`),
  KEY `pagoCuentaCorriente_comprobantePago_FK` (`comprobantePagoId`),
  KEY `pagoCuentaCorriente_precio_FK` (`precioId`),
  CONSTRAINT `pagoCuentaCorriente_comprobantePago_FK` FOREIGN KEY (`comprobantePagoId`) REFERENCES `comprobantepago` (`id`),
  CONSTRAINT `pagoCuentaCorriente_estadoCuentaCorriente_FK` FOREIGN KEY (`estadoCuentaCorrienteId`) REFERENCES `estadocuentacorriente` (`id`),
  CONSTRAINT `pagoCuentaCorriente_precio_FK` FOREIGN KEY (`precioId`) REFERENCES `precio` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagocuentacorriente`
--

LOCK TABLES `pagocuentacorriente` WRITE;
/*!40000 ALTER TABLE `pagocuentacorriente` DISABLE KEYS */;
/*!40000 ALTER TABLE `pagocuentacorriente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagoreserva`
--

DROP TABLE IF EXISTS `pagoreserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pagoreserva` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `importe` decimal(12,3) NOT NULL,
  `fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `cantidad` int unsigned NOT NULL,
  `reservaId` int unsigned NOT NULL,
  `comprobantePagoId` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `pagoReserva_reserva_FK` (`reservaId`),
  KEY `pagoReserva_comprobantePago_FK` (`comprobantePagoId`),
  CONSTRAINT `pagoReserva_comprobantePago_FK` FOREIGN KEY (`comprobantePagoId`) REFERENCES `comprobantepago` (`id`),
  CONSTRAINT `pagoReserva_reserva_FK` FOREIGN KEY (`reservaId`) REFERENCES `reserva` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagoreserva`
--

LOCK TABLES `pagoreserva` WRITE;
/*!40000 ALTER TABLE `pagoreserva` DISABLE KEYS */;
/*!40000 ALTER TABLE `pagoreserva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permission`
--

DROP TABLE IF EXISTS `permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permission` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permission`
--

LOCK TABLES `permission` WRITE;
/*!40000 ALTER TABLE `permission` DISABLE KEYS */;
INSERT INTO `permission` VALUES (1,'access_site'),(2,'somename');
/*!40000 ALTER TABLE `permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `precio`
--

DROP TABLE IF EXISTS `precio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `precio` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `valor` decimal(12,3) NOT NULL,
  `fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `articuloId` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `precio_articulo_FK` (`articuloId`),
  CONSTRAINT `precio_articulo_FK` FOREIGN KEY (`articuloId`) REFERENCES `articulo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `precio`
--

LOCK TABLES `precio` WRITE;
/*!40000 ALTER TABLE `precio` DISABLE KEYS */;
INSERT INTO `precio` VALUES (1,100.000,'2020-10-10 00:00:00',1),(2,250.000,'2020-10-10 00:00:00',2),(3,33.000,'2020-10-10 00:00:00',3),(4,150.990,'2020-11-11 00:00:00',1),(5,200.000,'2020-10-10 00:00:00',4),(6,165.500,'2020-12-12 00:00:00',1),(7,315.000,'2020-11-11 00:00:00',2),(10,250.000,'2020-11-11 00:00:00',4);
/*!40000 ALTER TABLE `precio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedor` (
  `entityId` int unsigned NOT NULL AUTO_INCREMENT,
  `razonSocial` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `cuit` varchar(14) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `descripcion` varchar(400) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`entityId`),
  CONSTRAINT `proveedor_entity_FK` FOREIGN KEY (`entityId`) REFERENCES `entity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `provincia`
--

DROP TABLE IF EXISTS `provincia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `provincia` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provincia`
--

LOCK TABLES `provincia` WRITE;
/*!40000 ALTER TABLE `provincia` DISABLE KEYS */;
INSERT INTO `provincia` VALUES (1,'Santa Fe'),(2,'Cordoba'),(3,'Corrientes'),(4,'SANTA FE'),(5,'BUENOS AIRES'),(6,'CORDOBA'),(7,'ENTRE RIOS');
/*!40000 ALTER TABLE `provincia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserva`
--

DROP TABLE IF EXISTS `reserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reserva` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `fechaCreacion` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `apellido` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `nombre` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `telefono` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `fechaVencimiento` datetime NOT NULL,
  `importeSena` decimal(12,3) NOT NULL,
  `isEntregada` tinyint(1) NOT NULL DEFAULT '0',
  `ventaId` int unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `reserva_venta_FK` (`ventaId`),
  CONSTRAINT `reserva_venta_FK` FOREIGN KEY (`ventaId`) REFERENCES `venta` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserva`
--

LOCK TABLES `reserva` WRITE;
/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
/*!40000 ALTER TABLE `reserva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rlineaventanotacredito`
--

DROP TABLE IF EXISTS `rlineaventanotacredito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rlineaventanotacredito` (
  `lineaVentaId` int unsigned NOT NULL,
  `notaCreditoId` int unsigned NOT NULL,
  PRIMARY KEY (`notaCreditoId`,`lineaVentaId`),
  KEY `rLineaVentaNotaCredito_lineaVenta_FK` (`lineaVentaId`),
  KEY `rLineaVentaNotaCredito_notaCredito_FK` (`notaCreditoId`),
  CONSTRAINT `rLineaVentaNotaCredito_lineaVenta_FK` FOREIGN KEY (`lineaVentaId`) REFERENCES `lineaventa` (`id`),
  CONSTRAINT `rLineaVentaNotaCredito_notaCredito_FK` FOREIGN KEY (`notaCreditoId`) REFERENCES `notacredito` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rlineaventanotacredito`
--

LOCK TABLES `rlineaventanotacredito` WRITE;
/*!40000 ALTER TABLE `rlineaventanotacredito` DISABLE KEYS */;
/*!40000 ALTER TABLE `rlineaventanotacredito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ADMIN'),(2,'EMPLOYEE'),(3,'USER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rpermissionrole`
--

DROP TABLE IF EXISTS `rpermissionrole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rpermissionrole` (
  `permissionId` int unsigned NOT NULL,
  `roleId` int unsigned NOT NULL,
  PRIMARY KEY (`roleId`,`permissionId`),
  KEY `rPermissionRole_permission_FK` (`permissionId`),
  KEY `rPermissionRole_role_FK` (`roleId`),
  CONSTRAINT `rPermissionRole_permission_FK` FOREIGN KEY (`permissionId`) REFERENCES `permission` (`id`),
  CONSTRAINT `rPermissionRole_role_FK` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rpermissionrole`
--

LOCK TABLES `rpermissionrole` WRITE;
/*!40000 ALTER TABLE `rpermissionrole` DISABLE KEYS */;
INSERT INTO `rpermissionrole` VALUES (1,1);
/*!40000 ALTER TABLE `rpermissionrole` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rubro`
--

DROP TABLE IF EXISTS `rubro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rubro` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rubro`
--

LOCK TABLES `rubro` WRITE;
/*!40000 ALTER TABLE `rubro` DISABLE KEYS */;
INSERT INTO `rubro` VALUES (1,'GENERICO'),(2,'CARTERAS'),(3,'LIBRERIA'),(4,'test1'),(5,'test2'),(6,'test3'),(7,'test4'),(8,'test5'),(10,'TEST3'),(11,'pepegrillo'),(13,'GENERICO');
/*!40000 ALTER TABLE `rubro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `telefono`
--

DROP TABLE IF EXISTS `telefono`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `telefono` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `caracteristica` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `numero` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `entityId` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `entity_telefono_FK` (`entityId`),
  CONSTRAINT `entity_telefono_FK` FOREIGN KEY (`entityId`) REFERENCES `entity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `telefono`
--

LOCK TABLES `telefono` WRITE;
/*!40000 ALTER TABLE `telefono` DISABLE KEYS */;
/*!40000 ALTER TABLE `telefono` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `telefonoproveedor`
--

DROP TABLE IF EXISTS `telefonoproveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `telefonoproveedor` (
  `telefonoId` int unsigned NOT NULL,
  `caracteristica` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `numero` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`telefonoId`),
  CONSTRAINT `telefonoProveedor_telefono_FK` FOREIGN KEY (`telefonoId`) REFERENCES `telefono` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `telefonoproveedor`
--

LOCK TABLES `telefonoproveedor` WRITE;
/*!40000 ALTER TABLE `telefonoproveedor` DISABLE KEYS */;
/*!40000 ALTER TABLE `telefonoproveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipoentrega`
--

DROP TABLE IF EXISTS `tipoentrega`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipoentrega` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipoentrega`
--

LOCK TABLES `tipoentrega` WRITE;
/*!40000 ALTER TABLE `tipoentrega` DISABLE KEYS */;
INSERT INTO `tipoentrega` VALUES (1,'Retiro en el local'),(2,'Envío a domicilio');
/*!40000 ALTER TABLE `tipoentrega` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `entityId` int unsigned NOT NULL,
  `userName` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `nombre` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `apellido` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `roleId` int unsigned NOT NULL,
  PRIMARY KEY (`entityId`),
  KEY `usuario_role_FK` (`roleId`),
  CONSTRAINT `usuario_usuario_entity_FK` FOREIGN KEY (`entityId`) REFERENCES `entity` (`id`),
  CONSTRAINT `usuario_usuario_role_FK` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Admin','$2a$10$YNEtwYCuwJTvM.eahcbg0erBKMEkDITuHb5.JtWYYQHP6dxa.bVTK','Nombre Admin','Apellido Admin','some@mail.jp',1),(3,'empleado','$2y$10$JMk0pfWw.KS5Y6XfRom0HO1WK.hXPbeJyYM9WX7CmRYanRefVKbuC','Nombre Empleado','Apellido Empleado','empelado@mail.jp',2),(4,'usuario','$2y$10$HrGxwEleiVpg/lu4yznZGeRIF7NkqLyKNndEsazll9bp8eAvAWfIG','Nombre Usuario','Apellido Usuario','usuario@mail.com',3),(5,'test','test','soy en 5','Apellido Test','test@mail.jp',3),(6,'test2','test2','Nombre Test2','Apellido Test2','test@mail.jp',3),(7,'username7','password7','nombre7','apellido7','7@mail.jp',3),(8,'update test3','test3','Nombre Test3','Apellido Test3','test3@mail.jp',3),(9,'update test3','$2a$10$6Ft1ahZbk2hFdj2r.ztjSOS9HQaXLiPfgR156MH7gVWJgCbGaBgTG','Nombre Test3','Apellido Test3','test3@mail.jp',3),(10,'update test345','test3','Nombre Test3','Apellido Test3','test3@mail.jp',3),(13,'alta11','$2a$10$gLPP9cc/33ey/wFfZvnN3ONqqIDF0K9qM3I74IRZYsdPR0QuXy8ZO','nom11','ap11','mail11',3),(14,'pruebafinal','prruh','huhu','huhuh','uhuhuh',2),(15,'jo','jo','jo','jo','jo',2),(16,'pepe','$2a$10$xoie1ykt9/eApUeAbUUQ..hRRhQ9iI0mgHIBqeBu480w2UBaxdprS','pepe','pepe','pepe',3),(17,'jaja','$2a$10$HrVf7ElXjE6fr0kO0RNFa.sMxH/sgmMzo2en13yoaVqqKGbSKeMl6','jaja','jajaj','jajaja',1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venta` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `numeroComprobante` int unsigned NOT NULL,
  `isEntregada` tinyint(1) NOT NULL DEFAULT '0',
  `nota` varchar(400) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `tipoEntregaId` int unsigned NOT NULL,
  `descuentoId` int unsigned NOT NULL,
  `medioPagoId` int unsigned NOT NULL,
  `usuarioEntityId` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `venta_tipoEntrega_FK` (`tipoEntregaId`),
  KEY `venta_descuento_FK` (`descuentoId`),
  KEY `venta_medioPago_FK` (`medioPagoId`),
  KEY `venta_usuario_FK` (`usuarioEntityId`),
  CONSTRAINT `venta_descuento_FK` FOREIGN KEY (`descuentoId`) REFERENCES `descuento` (`id`),
  CONSTRAINT `venta_medioPago_FK` FOREIGN KEY (`medioPagoId`) REFERENCES `mediopago` (`id`),
  CONSTRAINT `venta_tipoEntrega_FK` FOREIGN KEY (`tipoEntregaId`) REFERENCES `tipoentrega` (`id`),
  CONSTRAINT `venta_usuario_FK` FOREIGN KEY (`usuarioEntityId`) REFERENCES `usuario` (`entityId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

LOCK TABLES `venta` WRITE;
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
INSERT INTO `venta` VALUES (1,'2021-02-10 00:00:00',1,1,'Venta 1',1,7,1,3),(2,'2021-02-10 00:00:00',2,1,'Venta 2 update',1,7,1,3),(3,'2021-02-10 00:00:00',3,1,'Venta 3',1,7,1,3);
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

-- Dump completed on 2021-03-01  0:00:40
