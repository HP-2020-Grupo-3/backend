
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

INSERT INTO `contador` VALUES 
	(1,'COMPROBANTE_VENTA',1),
    (2,'COMPROBANTE_PAGO',1);

INSERT INTO `descuento` VALUES (1,0.00,1);

INSERT INTO `entityType` VALUES (1,'usuario');

INSERT INTO `entity` VALUES 
    (1,1,'2020-08-17 20:31:15',NULL,0),
    (2,1,'2020-10-08 00:17:41',NULL,0),
    (3,1,'2020-10-08 00:17:41',NULL,0);

INSERT INTO `medioPago` VALUES 
    (1,'Efectivo'),
    (2,'Tarjeta de Debito'),
    (3,'Tarjeta de Credito'),
    (4,'MercadoPago'),
    (5,'Cuenta Corriente');

INSERT INTO `permission` VALUES 
    (1,'access_site');

INSERT INTO `provincia` VALUES
    (1,'Santa Fe'),
    (2,'Cordoba'),
    (3,'Corrientes');

INSERT INTO `rPermissionRole` VALUES 
    (1,1);

INSERT INTO `role` VALUES
    (1,'ADMIN'),
    (2,'EMPLOYEE'),
    (3,'USER');

INSERT INTO `tipoEntrega` VALUES
    (1,'Presencial');

INSERT INTO `rubro` VALUES
    (1,'Genérico');

INSERT INTO `usuario` VALUES
    (1,'Admin','$2a$10$YNEtwYCuwJTvM.eahcbg0erBKMEkDITuHb5.JtWYYQHP6dxa.bVTK','some@mail.jp',1,'Admin',''),
    (2,'empleado','$2y$10$JMk0pfWw.KS5Y6XfRom0HO1WK.hXPbeJyYM9WX7CmRYanRefVKbuC','empleado@mail.jp',2,'empleado',''),
    (3,'usuario','$2y$10$HrGxwEleiVpg/lu4yznZGeRIF7NkqLyKNndEsazll9bp8eAvAWfIG','usuario@mail.com',3,'usuario','');

/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
