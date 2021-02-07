DROP DATABASE IF EXISTS `venidemary`;
CREATE DATABASE `venidemary`;
USE `venidemary`;

-- SET FOREIGN_KEY_CHECKS=0;
-- SET FOREIGN_KEY_CHECKS=1;

-- MySQL dump 10.13  Distrib 5.7.30, for Linux (x86_64)
--
-- Host: 192.168.1.112    Database: venidemary
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `articulo`
--

DROP TABLE IF EXISTS `articulo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `articulo` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `descripcion` varchar(400) NOT NULL,
  `imagen` varchar(100) NOT NULL,
  `stockActual` int unsigned NOT NULL,
  `stockDeseado` int unsigned NOT NULL,
  `deletionDate` datetime DEFAULT NULL,
  `isDeleted` tinyint(1) NOT NULL DEFAULT '0',
  `rubroId` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `articulo_rubro_FK` (`rubroId`),
  CONSTRAINT `articulo_rubro_FK` FOREIGN KEY (`rubroId`) REFERENCES `rubro` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_clienciudad_provincia_FKciudadciudadt */;

--
-- Dumping data for table `articulo`
--

LOCK TABLES `articulo` WRITE;
/*!40000 ALTER TABLE `articulo` DISABLE KEYS */;
/*!40000 ALTER TABLE `articulo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ciudad`
--

DROP TABLE IF EXISTS `ciudad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ciudad` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `provinciaId` int unsigned NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `codigoPostal` smallint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ciudad_provincia_FK` (`provinciaId`),
  CONSTRAINT `ciudad_provincia_FK` FOREIGN KEY (`provinciaId`) REFERENCES `provincia` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciudad`
--

LOCK TABLES `ciudad` WRITE;
/*!40000 ALTER TABLE `ciudad` DISABLE KEYS */;
/*!40000 ALTER TABLE `ciudad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compra`
--

DROP TABLE IF EXISTS `compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
-- Table structure for table `comprobantePago`
--

DROP TABLE IF EXISTS `comprobantePago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comprobantePago` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `numeroComprobante` int unsigned NOT NULL,
  `numeroFactura` varchar(100) NOT NULL,
  `nota` varchar(400) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `comprobantePago_numeroComprobante_UNIQUE` (`numeroComprobante`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comprobantePago`
--

LOCK TABLES `comprobantePago` WRITE;
/*!40000 ALTER TABLE `comprobantePago` DISABLE KEYS */;
/*!40000 ALTER TABLE `comprobantePago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contador`
--

DROP TABLE IF EXISTS `contador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
-- Table structure for table `cuentaCorrienteCliente`
--

DROP TABLE IF EXISTS `cuentaCorrienteCliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cuentaCorrienteCliente` (
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
-- Dumping data for table `cuentaCorrienteCliente`
--

LOCK TABLES `cuentaCorrienteCliente` WRITE;
/*!40000 ALTER TABLE `cuentaCorrienteCliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cuentaCorrienteCliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `descuento`
--

DROP TABLE IF EXISTS `descuento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `descuento` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `valor` decimal(3,2) NOT NULL,
  `isHabilitado` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `descuento`
--

LOCK TABLES `descuento` WRITE;
/*!40000 ALTER TABLE `descuento` DISABLE KEYS */;
/*!40000 ALTER TABLE `descuento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `direccion`
--

DROP TABLE IF EXISTS `direccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `direccion` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `ciudadId` int unsigned DEFAULT NULL,
  `calle` varchar(100) NOT NULL,
  `numero` int unsigned NOT NULL,
  `detalle` varchar(100) DEFAULT NULL,
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
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entity` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `entityTypeId` int unsigned NOT NULL,
  `creationDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deletionDate` datetime DEFAULT NULL,
  `isDeleted` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `entity_entityType_FK` (`entityTypeId`),
  CONSTRAINT `entity_entityType_FK` FOREIGN KEY (`entityTypeId`) REFERENCES `entityType` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entity`
--

LOCK TABLES `entity` WRITE;
/*!40000 ALTER TABLE `entity` DISABLE KEYS */;
/*!40000 ALTER TABLE `entity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entityType`
--

DROP TABLE IF EXISTS `entityType`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entityType` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entityType`
--

LOCK TABLES `entityType` WRITE;
/*!40000 ALTER TABLE `entityType` DISABLE KEYS */;
/*!40000 ALTER TABLE `entityType` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estadoCuentaCorriente`
--

DROP TABLE IF EXISTS `estadoCuentaCorriente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estadoCuentaCorriente` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `cantidad` int unsigned NOT NULL,
  `cuentaCorrienteClienteId` int unsigned NOT NULL,
  `articuloId` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `cuentaCorrienteCliente_cuentaCorrienteCliente_FK` (`cuentaCorrienteClienteId`),
  KEY `cuentaCorrienteCliente_articulo_FK` (`articuloId`),
  CONSTRAINT `cuentaCorrienteCliente_articulo_FK` FOREIGN KEY (`articuloId`) REFERENCES `articulo` (`id`),
  CONSTRAINT `cuentaCorrienteCliente_cuentaCorrienteCliente_FK` FOREIGN KEY (`cuentaCorrienteClienteId`) REFERENCES `cuentaCorrienteCliente` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estadoCuentaCorriente`
--

LOCK TABLES `estadoCuentaCorriente` WRITE;
/*!40000 ALTER TABLE `estadoCuentaCorriente` DISABLE KEYS */;
/*!40000 ALTER TABLE `estadoCuentaCorriente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lineaCompra`
--

DROP TABLE IF EXISTS `lineaCompra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lineaCompra` (
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
-- Dumping data for table `lineaCompra`
--

LOCK TABLES `lineaCompra` WRITE;
/*!40000 ALTER TABLE `lineaCompra` DISABLE KEYS */;
/*!40000 ALTER TABLE `lineaCompra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lineaReserva`
--

DROP TABLE IF EXISTS `lineaReserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lineaReserva` (
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
-- Dumping data for table `lineaReserva`
--

LOCK TABLES `lineaReserva` WRITE;
/*!40000 ALTER TABLE `lineaReserva` DISABLE KEYS */;
/*!40000 ALTER TABLE `lineaReserva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lineaVenta`
--

DROP TABLE IF EXISTS `lineaVenta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lineaVenta` (
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
  CONSTRAINT `lineaVenta_comprobantePago_FK` FOREIGN KEY (`comprobantePagoId`) REFERENCES `comprobantePago` (`id`),
  CONSTRAINT `lineaVenta_precio_FK` FOREIGN KEY (`precioId`) REFERENCES `precio` (`id`),
  CONSTRAINT `lineaVenta_venta_FK` FOREIGN KEY (`ventaId`) REFERENCES `venta` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lineaVenta`
--

LOCK TABLES `lineaVenta` WRITE;
/*!40000 ALTER TABLE `lineaVenta` DISABLE KEYS */;
/*!40000 ALTER TABLE `lineaVenta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lineaVentaCuentaCorriente`
--

DROP TABLE IF EXISTS `lineaVentaCuentaCorriente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lineaVentaCuentaCorriente` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `cantidad` int unsigned NOT NULL,
  `estadoCuentaCorrienteId` int unsigned NOT NULL,
  `ventaId` int unsigned NOT NULL,
  `precioId` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `lineaVentaCuentaCorriente_estadoCuentaCorriente_FK` (`estadoCuentaCorrienteId`),
  KEY `lineaVentaCuentaCorriente_venta_FK` (`ventaId`),
  KEY `lineaVentaCuentaCorriente_precio_FK` (`precioId`),
  CONSTRAINT `lineaVentaCuentaCorriente_estadoCuentaCorriente_FK` FOREIGN KEY (`estadoCuentaCorrienteId`) REFERENCES `estadoCuentaCorriente` (`id`),
  CONSTRAINT `lineaVentaCuentaCorriente_precio_FK` FOREIGN KEY (`precioId`) REFERENCES `precio` (`id`),
  CONSTRAINT `lineaVentaCuentaCorriente_venta_FK` FOREIGN KEY (`ventaId`) REFERENCES `venta` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lineaVentaCuentaCorriente`
--

LOCK TABLES `lineaVentaCuentaCorriente` WRITE;
/*!40000 ALTER TABLE `lineaVentaCuentaCorriente` DISABLE KEYS */;
/*!40000 ALTER TABLE `lineaVentaCuentaCorriente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medioPago`
--

DROP TABLE IF EXISTS `medioPago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medioPago` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medioPago`
--

LOCK TABLES `medioPago` WRITE;
/*!40000 ALTER TABLE `medioPago` DISABLE KEYS */;
/*!40000 ALTER TABLE `medioPago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notaCredito`
--

DROP TABLE IF EXISTS `notaCredito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notaCredito` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `numeroComprobante` int unsigned NOT NULL,
  `importe` decimal(12,3) NOT NULL,
  `fechaEmision` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `motivo` varchar(400) NOT NULL,
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
-- Dumping data for table `notaCredito`
--

LOCK TABLES `notaCredito` WRITE;
/*!40000 ALTER TABLE `notaCredito` DISABLE KEYS */;
/*!40000 ALTER TABLE `notaCredito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pago`
--

DROP TABLE IF EXISTS `pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
-- Table structure for table `pagoCuentaCorriente`
--

DROP TABLE IF EXISTS `pagoCuentaCorriente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pagoCuentaCorriente` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `cantidad` int unsigned NOT NULL,
  `estadoCuentaCorrienteId` int unsigned NOT NULL,
  `comprobantePagoId` int unsigned NOT NULL,
  `precioId` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `pagoCuentaCorriente_estadoCuentaCorriente_FK` (`estadoCuentaCorrienteId`),
  KEY `pagoCuentaCorriente_comprobantePago_FK` (`comprobantePagoId`),
  KEY `pagoCuentaCorriente_precio_FK` (`precioId`),
  CONSTRAINT `pagoCuentaCorriente_comprobantePago_FK` FOREIGN KEY (`comprobantePagoId`) REFERENCES `comprobantePago` (`id`),
  CONSTRAINT `pagoCuentaCorriente_estadoCuentaCorriente_FK` FOREIGN KEY (`estadoCuentaCorrienteId`) REFERENCES `estadoCuentaCorriente` (`id`),
  CONSTRAINT `pagoCuentaCorriente_precio_FK` FOREIGN KEY (`precioId`) REFERENCES `precio` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagoCuentaCorriente`
--

LOCK TABLES `pagoCuentaCorriente` WRITE;
/*!40000 ALTER TABLE `pagoCuentaCorriente` DISABLE KEYS */;
/*!40000 ALTER TABLE `pagoCuentaCorriente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagoReserva`
--

DROP TABLE IF EXISTS `pagoReserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pagoReserva` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `importe` decimal(12,3) NOT NULL,
  `fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `cantidad` int unsigned NOT NULL,
  `reservaId` int unsigned NOT NULL,
  `comprobantePagoId` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `pagoReserva_reserva_FK` (`reservaId`),
  KEY `pagoReserva_comprobantePago_FK` (`comprobantePagoId`),
  CONSTRAINT `pagoReserva_comprobantePago_FK` FOREIGN KEY (`comprobantePagoId`) REFERENCES `comprobantePago` (`id`),
  CONSTRAINT `pagoReserva_reserva_FK` FOREIGN KEY (`reservaId`) REFERENCES `reserva` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagoReserva`
--

LOCK TABLES `pagoReserva` WRITE;
/*!40000 ALTER TABLE `pagoReserva` DISABLE KEYS */;
/*!40000 ALTER TABLE `pagoReserva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permission`
--

DROP TABLE IF EXISTS `permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permission` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permission`
--

LOCK TABLES `permission` WRITE;
/*!40000 ALTER TABLE `permission` DISABLE KEYS */;
/*!40000 ALTER TABLE `permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `precio`
--

DROP TABLE IF EXISTS `precio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `precio` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `valor` decimal(12,3) NOT NULL,
  `fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `articuloId` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `precio_articulo_FK` (`articuloId`),
  CONSTRAINT `precio_articulo_FK` FOREIGN KEY (`articuloId`) REFERENCES `articulo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `precio`
--

LOCK TABLES `precio` WRITE;
/*!40000 ALTER TABLE `precio` DISABLE KEYS */;
/*!40000 ALTER TABLE `precio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proveedor` (
  `entityId` int unsigned NOT NULL AUTO_INCREMENT,
  `razonSocial` varchar(100) NOT NULL,
  `cuit` varchar(14) NOT NULL,
  `email` varchar(100) NOT NULL,
  `descripcion` varchar(400) NOT NULL,
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
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `provincia` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provincia`
--

LOCK TABLES `provincia` WRITE;
/*!40000 ALTER TABLE `provincia` DISABLE KEYS */;
/*!40000 ALTER TABLE `provincia` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Table structure for table `rLineaVentaNotaCredito`
--

DROP TABLE IF EXISTS `rLineaVentaNotaCredito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rLineaVentaNotaCredito` (
  `lineaVentaId` int unsigned NOT NULL,
  `notaCreditoId` int unsigned NOT NULL,
  PRIMARY KEY (`notaCreditoId`,`lineaVentaId`),
  KEY `rLineaVentaNotaCredito_lineaVenta_FK` (`lineaVentaId`),
  KEY `rLineaVentaNotaCredito_notaCredito_FK` (`notaCreditoId`),
  CONSTRAINT `rLineaVentaNotaCredito_lineaVenta_FK` FOREIGN KEY (`lineaVentaId`) REFERENCES `lineaVenta` (`id`),
  CONSTRAINT `rLineaVentaNotaCredito_notaCredito_FK` FOREIGN KEY (`notaCreditoId`) REFERENCES `notaCredito` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rLineaVentaNotaCredito`
--

LOCK TABLES `rLineaVentaNotaCredito` WRITE;
/*!40000 ALTER TABLE `rLineaVentaNotaCredito` DISABLE KEYS */;
/*!40000 ALTER TABLE `rLineaVentaNotaCredito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rPermissionRole`
--

DROP TABLE IF EXISTS `rPermissionRole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rPermissionRole` (
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
-- Dumping data for table `rPermissionRole`
--

LOCK TABLES `rPermissionRole` WRITE;
/*!40000 ALTER TABLE `rPermissionRole` DISABLE KEYS */;
/*!40000 ALTER TABLE `rPermissionRole` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserva`
--

DROP TABLE IF EXISTS `reserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reserva` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `fechaCreacion` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `apellido` varchar(100) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `email` varchar(100) NOT NULL,
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
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rubro`
--

DROP TABLE IF EXISTS `rubro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rubro` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rubro`
--

LOCK TABLES `rubro` WRITE;
/*!40000 ALTER TABLE `rubro` DISABLE KEYS */;
/*!40000 ALTER TABLE `rubro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `telefono`
--

DROP TABLE IF EXISTS `telefono`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `telefono` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `caracteristica` varchar(10) NOT NULL,
  `numero` varchar(20) NOT NULL,
  `entityId` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
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
-- Table structure for table `telefonoProveedor`
--

DROP TABLE IF EXISTS `telefonoProveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `telefonoProveedor` (
  `telefonoId` int unsigned NOT NULL,
  `caracteristica` varchar(10) NOT NULL,
  `numero` varchar(20) NOT NULL,
  PRIMARY KEY (`telefonoId`),
  CONSTRAINT `telefonoProveedor_telefono_FK` FOREIGN KEY (`telefonoId`) REFERENCES `telefono` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `telefonoProveedor`
--

LOCK TABLES `telefonoProveedor` WRITE;
/*!40000 ALTER TABLE `telefonoProveedor` DISABLE KEYS */;
/*!40000 ALTER TABLE `telefonoProveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipoEntrega`
--

DROP TABLE IF EXISTS `tipoEntrega`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipoEntrega` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipoEntrega`
--

LOCK TABLES `tipoEntrega` WRITE;
/*!40000 ALTER TABLE `tipoEntrega` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipoEntrega` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `entityId` int unsigned NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
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
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `venta` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `numeroComprobante` int unsigned NOT NULL,
  `isEntregada` tinyint(1) NOT NULL DEFAULT '0',
  `nota` varchar(400) NOT NULL,
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
  CONSTRAINT `venta_medioPago_FK` FOREIGN KEY (`medioPagoId`) REFERENCES `medioPago` (`id`),
  CONSTRAINT `venta_tipoEntrega_FK` FOREIGN KEY (`tipoEntregaId`) REFERENCES `tipoEntrega` (`id`),
  CONSTRAINT `venta_usuario_FK` FOREIGN KEY (`usuarioEntityId`) REFERENCES `usuario` (`entityId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

LOCK TABLES `venta` WRITE;
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
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

-- Dump completed on 2020-07-27 21:11:48
