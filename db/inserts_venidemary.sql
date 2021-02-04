INSERT INTO rubro (`nombre`) VALUES
("PAPELERIA"),
("CARTERAS"),
("LIBRERIA");

INSERT INTO `provincia` (`nombre`) VALUES
("SANTA FE"), 
("BUENOS AIRES"), 
("CORDOBA"), 
("ENTRE RIOS");

INSERT INTO `ciudad` (`provinciaId`, `nombre`, `codigoPostal`) VALUES
(1, "ROSARIO", 2000), 
(1, "SAN LORENZO", 2200),
(1, "FUNES", 2004),
(1, "ROLDAN", 2009),
(2, "CABA", 1000),
(2, "LA PLATA", 1400),
(3, "CORDOBA", 2000),
(3, "LA FALDA", 2000),
(4, "VICTORIA", 2000),
(4, "PARANA", 2000);

INSERT INTO `entitytype` (`nombre`) VALUES
("Usuario"),
("Cliente"); 

INSERT INTO `entity` (`entityTypeId`) VALUES
(1),
(1),
(1),
(2),
(2),
(2);


INSERT INTO `direccion` (`ciudadId`, `calle`, `numero`, `detalle`, `entityId`) VALUES
(1, "Uriburu", 2456, "Es un kiosko", 4), 
(1, "Uriburu", 2424, "Es una libreria", 4), 
(1, "Zeballos", 1341, "Vivo en la UTN", 1), 
(2, "Rivadavia", 333, "Viva Perón", 2), 
(3, "San Martin", 123, "Nada", 3), 
(4, "Belgrano", 777, "Info adicional", 6), 
(5, "Independencia", 987, "Info adicional", 5);

INSERT INTO `role` (`name`) VALUES
("Administrador"),
("Empleado"),
("Cliente");

INSERT INTO `usuario` (`entityId`, `nombre`, `password`, `email`, `roleId`) VALUES
(4, "Maria", "12345", "maria@gmail.com", 3),
(1, "Pepe El Jefe", "12345", "pepeadmin@gmail.com", 1),
(2, "Juana Empleada", "12345", "juana@gmail.com", 2),
(3, "Martin Empleado", "12345", "martin@gmail.com", 2),
(5, "Federico Cliente1", "12345", "cliente1@gmail.com", 3),
(6, "Roberto Cliente2", "12345", "cliente2@gmail.com", 3);

INSERT INTO `articulo` (`nombre`, `descripcion`, `imagen`, `stockActual`, `stockDeseado`, `isDeleted`, `rubroId`) VALUES
("Regla", "Regla", "Regla", 30, 20, 0, 8),
("Lapiz", "Lapiz", "Lapiz", 25, 20, 0, 8),
("Goma", "Goma", "Goma", 30, 20, 0, 3);

SELECT * FROM rubro;
SELECT * FROM provincia;
SELECT * FROM ciudad;
SELECT * FROM entitytype;
SELECT * FROM entity inner join entitytype where entity.entityTypeId= entityType.id;
SELECT * FROM direccion;
SELECT * FROM role;
SELECT * FROM USUARIO u inner join entity e 
on u.entityId = e.id
inner join role r
on u.roleId = r.id
inner join entitytype et
on e.entityTypeId = et.id;

select * from articulo;