
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

INSERT INTO `contador` VALUES 
	(1,'COMPROBANTE_VENTA',1),
    (2,'COMPROBANTE_PAGO',1);

INSERT INTO `descuento` VALUES 
	(1,0.00,1),
    (2,0.05,1),
    (3,0.1,0),
    (4,0.15,0),
    (5,0.2,0);

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
    (1,'Genérico'),
    (2,'Librería'),
    (3,'Marroquinería'),
    (4,'Juguetería'),
    (5,'Mercería'),
    (6,'Regalería');

INSERT INTO `usuario` VALUES
    (1,'Admin','$2a$10$YNEtwYCuwJTvM.eahcbg0erBKMEkDITuHb5.JtWYYQHP6dxa.bVTK','some@mail.jp',1,'Admin',''),
    (2,'empleado','$2y$10$JMk0pfWw.KS5Y6XfRom0HO1WK.hXPbeJyYM9WX7CmRYanRefVKbuC','empleado@mail.jp',2,'empleado',''),
    (3,'usuario','$2y$10$HrGxwEleiVpg/lu4yznZGeRIF7NkqLyKNndEsazll9bp8eAvAWfIG','usuario@mail.com',3,'usuario','');

INSERT INTO `articulo` VALUES
	(1,'Cuadernillo Asamblea','rayado/cuadriculado por 80  hojas',null,10,8,null,0,2),
	(2,'Cuadernillo Triunfante','rayado/cuadriculado 120 hojas/tapa dura',null,10,8,null,0,2),
	(3,'Cuaderno Rivadavia','tapa dura A3 por  50 hojas/araña colores surtidos',null,10,8,null,0,2),
	(4,'Cuaderno Éxito','tapa dura A3 por  50 hojas/araña colores surtidos',null,10,8,null,0,2),
	(5,'Cuaderno ABC Rivadavia','tapa dura por 50 hojas',null,10,8,null,0,2),
	(6,'Cuaderno ABC Triunfante','tapa dura por 50 hojas',null,10,8,null,0,2),
	(7,'Cuaderno de Caligrafia Asamblea','tapa flexible  por 24 hojas',null,10,8,null,0,2),
	(8,'Block de dibujo Triunfante de color','por 20 hojas surtidas',null,10,8,null,0,2),
	(9,'Block de dibujo Luma hojas blancas','por 20 hojas lisas',null,10,8,null,0,2),
	(10,'Block de dibujo Miguel Angel hojas blancas','por 20 hojas lisas',null,10,8,null,0,2),
	(11,'Bolso Aquarella Rosa','código 2024-matelaseado',null,10,8,null,0,3),
	(12,'Bolso Aquarella tornasolado','código 2118-matelaseado',null,10,8,null,0,3),
	(13,'Mochila LSD-con brillos','código  91,26015',null,10,8,null,0,3),
	(14,'Mochila LSD-Uniker','código 91,26208',null,10,8,null,0,3),
	(15,'Mochila LSD-Street Wear','código 91,22807',null,10,8,null,0,3),
	(16,'Mochila LSD-CRB','código 91,26739',null,10,8,null,0,3),
	(17,'Mochila LSD-Influencer','código 10,1151-con lentejuelas',null,10,8,null,0,3),
	(18,'Cartuchera Cresko','código-CK077-modelo plateado con estrellas',null,10,8,null,0,3),
	(19,'CartucheraTrendy','código-50127 rosa',null,10,8,null,0,3),
	(20,'Cartuchera Footy','código -F12021-Doble cierre',null,10,8,null,0,3),
	(21,'Cartuchera Back-up Fun','código-51615-con lentejuelas',null,10,8,null,0,3),
	(22,'San Remo-Camión de Bomberos','código-132639',null,10,8,null,0,4),
	(23,'Duravit-Set Constructor','código-set número 2',null,10,8,null,0,4),
	(24,'My Home-Litle Chef Dream','código-3214 microwave oven',null,10,8,null,0,4),
	(25,'Poppi-20 cm','código-28066W',null,10,8,null,0,4),
	(26,'Diy-Creative Hat','código 847-set de gorra mas fibrones para pintar',null,10,8,null,0,4),
	(27,'Maped Creativ','código-1877 -masa dough',null,10,8,null,0,4),
	(28,'Bontus-juego de mesa','código 103-Abrecabezas ',null,10,8,null,0,4),
	(29,'Helicoptero 3D light','código 2588-mísica/luz/sonido',null,10,8,null,0,4),
	(30,'Industrias Asgard- Escudo','código -980910',null,10,8,null,0,4),
	(31,'Uniesco-Súper Lámina para colorear y colgar','código 5503-Viaje por el mundo',null,10,8,null,0,4),
	(32,'Hilo Drima','código 00287-gris plata',null,10,8,null,0,5),
	(33,'Lentejuelas ','paquete de color individual',null,10,8,null,0,5),
	(34,'Cierre diente de perro','colores varios-70 cm',null,10,8,null,0,5),
	(35,'Cierre desmontable plástico','colores varios-40 cm',null,10,8,null,0,5),
	(36,'Elástico de 1 cm ','blanco/negro-por metro',null,10,8,null,0,5),
	(37,'Cinta de raso ','4 cm por metro',null,10,8,null,0,5),
	(38,'Cinta de falletina','4 cm por metro',null,10,8,null,0,5),
	(39,'Set de hilos','por paquete',null,10,8,null,0,5),
	(40,'Hilo Sisal de colores','por ovillo individual',null,10,8,null,0,5),
	(41,'Hilo de algodón ','por ovillo blanco',null,10,8,null,0,5);
    
INSERT INTO `precio` VALUES
	(1,180,'2021-08-27',1),
	(2,830,'2021-08-27',2),
	(3,410,'2021-08-27',3),
	(4,330,'2021-08-27',4),
	(5,410,'2021-08-27',5),
	(6,310,'2021-08-27',6),
	(7,210,'2021-08-27',7),
	(8,200,'2021-08-27',8),
	(9,150,'2021-08-27',9),
	(10,180,'2021-08-27',10),
	(11,2000,'2021-08-27',11),
	(12,2150,'2021-08-27',12),
	(13,1800,'2021-08-27',13),
	(14,3590,'2021-08-27',14),
	(15,2950,'2021-08-27',15),
	(16,3700,'2021-08-27',16),
	(17,2420,'2021-08-27',17),
	(18,1920,'2021-08-27',18),
	(19,950,'2021-08-27',19),
	(20,1700,'2021-08-27',20),
	(21,1500,'2021-08-27',21),
	(22,6390,'2021-08-27',22),
	(23,2500,'2021-08-27',23),
	(24,4400,'2021-08-27',24),
	(25,2590,'2021-08-27',25),
	(26,3490,'2021-08-27',26),
	(27,1200,'2021-08-27',27),
	(28,1110,'2021-08-27',28),
	(29,2200,'2021-08-27',29),
	(30,2399,'2021-08-27',30),
	(31,790,'2021-08-27',31),
	(32,90,'2021-08-27',32),
	(33,70,'2021-08-27',33),
	(34,150,'2021-08-27',34),
	(35,60,'2021-08-27',35),
	(36,20,'2021-08-27',36),
	(37,40,'2021-08-27',37),
	(38,35,'2021-08-27',38),
	(39,150,'2021-08-27',39),
	(40,320,'2021-08-27',40),
	(41,80,'2021-08-27',41);

/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
