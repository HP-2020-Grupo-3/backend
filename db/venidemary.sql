
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
CREATE TABLE `articulo` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `descripcion` varchar(400) COLLATE utf8mb4_unicode_ci NOT NULL,
  `imagen` varchar(100) COLLATE utf8mb4_unicode_ci NULL,
  `stockActual` int unsigned NOT NULL,
  `stockDeseado` int unsigned NOT NULL,
  `deletionDate` datetime DEFAULT NULL,
  `isDeleted` tinyint(1) NOT NULL DEFAULT '0',
  `rubroId` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `articulo_rubro_FK` (`rubroId`),
  CONSTRAINT `articulo_rubro_FK` FOREIGN KEY (`rubroId`) REFERENCES `rubro` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Table structure for table `ciudad`
--

DROP TABLE IF EXISTS `ciudad`;
CREATE TABLE `ciudad` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `provinciaId` int unsigned NOT NULL,
  `nombre` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `codigoPostal` smallint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ciudad_provincia_FK` (`provinciaId`),
  CONSTRAINT `ciudad_provincia_FK` FOREIGN KEY (`provinciaId`) REFERENCES `provincia` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Table structure for table `compra`
--

DROP TABLE IF EXISTS `compra`;
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

--
-- Table structure for table `comprobantePago`
--

DROP TABLE IF EXISTS `comprobantePago`;
CREATE TABLE `comprobantePago` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `numeroComprobante` int unsigned NOT NULL,
  `numeroFactura` varchar(100) NULL,
  `nota` varchar(400) NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `comprobantePago_numeroComprobante_UNIQUE` (`numeroComprobante`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Table structure for table `contador`
--

DROP TABLE IF EXISTS `contador`;
CREATE TABLE `contador` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `valor` int unsigned NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Table structure for table `cuentaCorrienteCliente`
--

DROP TABLE IF EXISTS `cuentaCorrienteCliente`;
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

--
-- Table structure for table `descuento`
--

DROP TABLE IF EXISTS `descuento`;
CREATE TABLE `descuento` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `valor` decimal(3,2) NOT NULL,
  `isHabilitado` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Table structure for table `direccion`
--

DROP TABLE IF EXISTS `direccion`;
CREATE TABLE `direccion` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `ciudadId` int unsigned DEFAULT NULL,
  `calle` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `numero` int unsigned NOT NULL,
  `detalle` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `entityId` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `direccion_ciudad_FK` (`ciudadId`),
  KEY `direccion_entity_fk` (`entityId`),
  CONSTRAINT `direccion_ciudad_FK` FOREIGN KEY (`ciudadId`) REFERENCES `ciudad` (`id`),
  CONSTRAINT `direccion_entity_FK` FOREIGN KEY (`entityId`) REFERENCES `entity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Table structure for table `entity`
--

DROP TABLE IF EXISTS `entity`;
CREATE TABLE `entity` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `entityTypeId` int unsigned NOT NULL,
  `creationDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deletionDate` datetime DEFAULT NULL,
  `isDeleted` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `entity_entityType_FK` (`entityTypeId`),
  CONSTRAINT `entity_entityType_FK` FOREIGN KEY (`entityTypeId`) REFERENCES `entityType` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Table structure for table `entityType`
--

DROP TABLE IF EXISTS `entityType`;
CREATE TABLE `entityType` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Table structure for table `estadoCuentaCorriente`
--

DROP TABLE IF EXISTS `estadoCuentaCorriente`;
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

--
-- Table structure for table `lineaCompra`
--

DROP TABLE IF EXISTS `lineaCompra`;
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

--
-- Table structure for table `lineaReserva`
--

DROP TABLE IF EXISTS `lineaReserva`;
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

--
-- Table structure for table `lineaVenta`
--

DROP TABLE IF EXISTS `lineaVenta`;
CREATE TABLE `lineaVenta` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `cantidad` int unsigned NOT NULL,
  `articuloId` int unsigned NOT NULL,
  `precioId` int unsigned NOT NULL,
  `ventaId` int unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `lineaVenta_articulo_FK` (`articuloId`),
  KEY `lineaVenta_precio_FK` (`precioId`),
  KEY `lineaVenta_venta_FK` (`ventaId`),
  CONSTRAINT `lineaVenta_articulo_FK` FOREIGN KEY (`articuloId`) REFERENCES `articulo` (`id`),
  CONSTRAINT `lineaVenta_precio_FK` FOREIGN KEY (`precioId`) REFERENCES `precio` (`id`),
  CONSTRAINT `lineaVenta_venta_FK` FOREIGN KEY (`ventaId`) REFERENCES `venta` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Table structure for table `lineaVentaCuentaCorriente`
--

DROP TABLE IF EXISTS `lineaVentaCuentaCorriente`;
CREATE TABLE `lineaVentaCuentaCorriente` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `cantidad` int unsigned NOT NULL,
  `estadoCuentaCorrienteId` int unsigned NOT NULL,
  `ventaId` int unsigned NOT NULL,
  `precioId` int unsigned NULL,
  `isPago` tinyint(1) NULL,
  PRIMARY KEY (`id`),
  KEY `lineaVentaCuentaCorriente_estadoCuentaCorriente_FK` (`estadoCuentaCorrienteId`),
  KEY `lineaVentaCuentaCorriente_venta_FK` (`ventaId`),
  KEY `lineaVentaCuentaCorriente_precio_FK` (`precioId`),
  CONSTRAINT `lineaVentaCuentaCorriente_estadoCuentaCorriente_FK` FOREIGN KEY (`estadoCuentaCorrienteId`) REFERENCES `estadoCuentaCorriente` (`id`),
  CONSTRAINT `lineaVentaCuentaCorriente_precio_FK` FOREIGN KEY (`precioId`) REFERENCES `precio` (`id`),
  CONSTRAINT `lineaVentaCuentaCorriente_venta_FK` FOREIGN KEY (`ventaId`) REFERENCES `venta` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Table structure for table `medioPago`
--

DROP TABLE IF EXISTS `medioPago`;
CREATE TABLE `medioPago` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Table structure for table `notaCredito`
--

DROP TABLE IF EXISTS `notaCredito`;
CREATE TABLE `notaCredito` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `numeroComprobante` int unsigned NOT NULL,
  `importe` decimal(12,3) NOT NULL,
  `fechaEmision` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `motivo` varchar(400) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ventaIdGenerada` int unsigned NOT NULL,
  `ventaIdUsada` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `notaCredito_venta_generada_FK` (`ventaIdGenerada`),
  KEY `notaCredito_venta_usada_FK` (`ventaIdUsada`),
  CONSTRAINT `notaCredito_venta_generada_FK` FOREIGN KEY (`ventaIdGenerada`) REFERENCES `venta` (`id`),
  CONSTRAINT `notaCredito_venta_usada_FK` FOREIGN KEY (`ventaIdUsada`) REFERENCES `venta` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Table structure for table `pago`
--

DROP TABLE IF EXISTS `pago`;
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

--
-- Table structure for table `pagoCuentaCorriente`
--

DROP TABLE IF EXISTS `pagoCuentaCorriente`;
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

--
-- Table structure for table `pagoReserva`
--

DROP TABLE IF EXISTS `pagoReserva`;
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

--
-- Table structure for table `permission`
--

DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Table structure for table `precio`
--

DROP TABLE IF EXISTS `precio`;
CREATE TABLE `precio` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `valor` decimal(12,3) NOT NULL,
  `fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `articuloId` int unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `precio_articulo_FK` (`articuloId`),
  CONSTRAINT `precio_articulo_FK` FOREIGN KEY (`articuloId`) REFERENCES `articulo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
CREATE TABLE `proveedor` (
  `entityId` int unsigned NOT NULL AUTO_INCREMENT,
  `razonSocial` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `cuit` varchar(14) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `descripcion` varchar(400) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`entityId`),
  CONSTRAINT `proveedor_entity_FK` FOREIGN KEY (`entityId`) REFERENCES `entity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Table structure for table `provincia`
--

DROP TABLE IF EXISTS `provincia`;
CREATE TABLE `provincia` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Table structure for table `rLineaVentaNotaCredito`
--

DROP TABLE IF EXISTS `rLineaVentaNotaCredito`;
CREATE TABLE `rLineaVentaNotaCredito` (
  `lineaVentaId` int unsigned NOT NULL,
  `notaCreditoId` int unsigned NOT NULL,
  PRIMARY KEY (`notaCreditoId`,`lineaVentaId`),
  KEY `rLineaVentaNotaCredito_lineaVenta_FK` (`lineaVentaId`),
  KEY `rLineaVentaNotaCredito_notaCredito_FK` (`notaCreditoId`),
  CONSTRAINT `rLineaVentaNotaCredito_lineaVenta_FK` FOREIGN KEY (`lineaVentaId`) REFERENCES `lineaVenta` (`id`),
  CONSTRAINT `rLineaVentaNotaCredito_notaCredito_FK` FOREIGN KEY (`notaCreditoId`) REFERENCES `notaCredito` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Table structure for table `rPermissionRole`
--

DROP TABLE IF EXISTS `rPermissionRole`;
CREATE TABLE `rPermissionRole` (
  `permissionId` int unsigned NOT NULL,
  `roleId` int unsigned NOT NULL,
  PRIMARY KEY (`roleId`,`permissionId`),
  KEY `rPermissionRole_permission_FK` (`permissionId`),
  KEY `rPermissionRole_role_FK` (`roleId`),
  CONSTRAINT `rPermissionRole_permission_FK` FOREIGN KEY (`permissionId`) REFERENCES `permission` (`id`),
  CONSTRAINT `rPermissionRole_role_FK` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Table structure for table `reserva`
--

DROP TABLE IF EXISTS `reserva`;
CREATE TABLE `reserva` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `fechaCreacion` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `apellido` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nombre` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `telefono` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `fechaVencimiento` datetime NOT NULL,
  `importeSena` decimal(12,3) NOT NULL,
  `isEntregada` tinyint(1) NOT NULL DEFAULT '0',
  `ventaId` int unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `reserva_venta_FK` (`ventaId`),
  CONSTRAINT `reserva_venta_FK` FOREIGN KEY (`ventaId`) REFERENCES `venta` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Table structure for table `rubro`
--

DROP TABLE IF EXISTS `rubro`;
CREATE TABLE `rubro` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Table structure for table `telefono`
--

DROP TABLE IF EXISTS `telefono`;
CREATE TABLE `telefono` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `caracteristica` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `numero` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `entityId` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `entity_telefono_FK` (`entityId`),
  CONSTRAINT `entity_telefono_FK` FOREIGN KEY (`entityId`) REFERENCES `entity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Table structure for table `telefonoProveedor`
--

DROP TABLE IF EXISTS `telefonoProveedor`;
CREATE TABLE `telefonoProveedor` (
  `telefonoId` int unsigned NOT NULL,
  `caracteristica` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `numero` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`telefonoId`),
  CONSTRAINT `telefonoProveedor_telefono_FK` FOREIGN KEY (`telefonoId`) REFERENCES `telefono` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Table structure for table `tipoEntrega`
--

DROP TABLE IF EXISTS `tipoEntrega`;
CREATE TABLE `tipoEntrega` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `entityId` int unsigned NOT NULL,
  `nombre` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `roleId` int unsigned NOT NULL,
  `username` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `apellido` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`entityId`),
  KEY `usuario_role_FK` (`roleId`),
  CONSTRAINT `usuario_usuario_entity_FK` FOREIGN KEY (`entityId`) REFERENCES `entity` (`id`),
  CONSTRAINT `usuario_usuario_role_FK` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
CREATE TABLE `venta` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `numeroComprobante` int unsigned NOT NULL,
  `isEntregada` tinyint(1) NOT NULL DEFAULT '0',
  `nota` varchar(400) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `tipoEntregaId` int unsigned NOT NULL,
  `descuentoId` int unsigned NOT NULL,
  `medioPagoId` int unsigned NOT NULL,
  `comprobantePagoId` int unsigned DEFAULT NULL,
  `usuarioEntityId` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `venta_tipoEntrega_FK` (`tipoEntregaId`),
  KEY `venta_descuento_FK` (`descuentoId`),
  KEY `venta_medioPago_FK` (`medioPagoId`),
  KEY `lineaVenta_comprobantePago_FK` (`comprobantePagoId`),
  KEY `venta_usuario_FK` (`usuarioEntityId`),
  CONSTRAINT `venta_descuento_FK` FOREIGN KEY (`descuentoId`) REFERENCES `descuento` (`id`),
  CONSTRAINT `venta_medioPago_FK` FOREIGN KEY (`medioPagoId`) REFERENCES `medioPago` (`id`),
  CONSTRAINT `venta_tipoEntrega_FK` FOREIGN KEY (`tipoEntregaId`) REFERENCES `tipoEntrega` (`id`),
  CONSTRAINT `lineaVenta_comprobantePago_FK` FOREIGN KEY (`comprobantePagoId`) REFERENCES `comprobantePago` (`id`),
  CONSTRAINT `venta_usuario_FK` FOREIGN KEY (`usuarioEntityId`) REFERENCES `usuario` (`entityId`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
