CREATE SCHEMA IF NOT EXISTS `GEEKSTATION` DEFAULT CHARACTER SET utf8mb4 ;
USE `GEEKSTATION` ;

-- -----------------------------------------------------
-- Table `GEEKSTATION`.`categorias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GEEKSTATION`.`categorias` (
  `id_categorias` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(80) NULL,
  `descripcion` VARCHAR(80) NULL,
  PRIMARY KEY (`id_categorias`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

-- -----------------------------------------------------
-- Table `GEEKSTATION`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GEEKSTATION`.`usuario` (
  `id_usuario` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(80) NOT NULL,
  `apellido` VARCHAR(80) NULL,
  `email` VARCHAR(80) NOT NULL,
  `password` VARCHAR(80) NOT NULL,
  `telefono` VARCHAR(80) NOT NULL,
  `delegacion` VARCHAR(45) NULL,
  `RFC` VARCHAR(13) NULL,
  PRIMARY KEY (`id_usuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `GEEKSTATION`.`pedidos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GEEKSTATION`.`pedidos` (
  `id_pedidos` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATE NOT NULL,
  `estado` VARCHAR(45) NULL,
  `total` DOUBLE NOT NULL,
  `descripcion` TEXT NULL,
  `usuario_id_usuario` INT NOT NULL,
  PRIMARY KEY (`id_pedidos`),
  INDEX `fk_pedidos_usuario1_idx` (`usuario_id_usuario` ASC) VISIBLE,
  CONSTRAINT `fk_pedidos_usuario1`
    FOREIGN KEY (`usuario_id_usuario`)
    REFERENCES `GEEKSTATION`.`usuario` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `GEEKSTATION`.`pago`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GEEKSTATION`.`pago` (
  `id_pago` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATE NOT NULL,
  `metodo_pago` VARCHAR(45) NOT NULL,
  `monto` VARCHAR(45) NULL,
  `folio_factura` VARCHAR(45) NULL,
  `pedidos_id_pedidos` INT NOT NULL,
  PRIMARY KEY (`id_pago`, `pedidos_id_pedidos`),
  INDEX `fk_pago_pedidos1_idx` (`pedidos_id_pedidos` ASC) VISIBLE,
  CONSTRAINT `fk_pago_pedidos1`
    FOREIGN KEY (`pedidos_id_pedidos`)
    REFERENCES `GEEKSTATION`.`pedidos` (`id_pedidos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `GEEKSTATION`.`productos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GEEKSTATION`.`productos` (
  `id_producto` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(80) NULL,
  `descripcion` TEXT NULL,
  `sku` VARCHAR(45) NULL,
  `marca` VARCHAR(45) NULL,
  `color` VARCHAR(45) NULL,
  `url` VARCHAR(45) NULL,
  `stock` INT NULL,
  `precio` DOUBLE NULL,
  `categorias_id_categorias` INT NOT NULL,
  PRIMARY KEY (`id_producto`, `categorias_id_categorias`),
  INDEX `fk_productos_categorias1_idx` (`categorias_id_categorias` ASC) VISIBLE,
  CONSTRAINT `fk_productos_categorias1`
    FOREIGN KEY (`categorias_id_categorias`)
    REFERENCES `GEEKSTATION`.`categorias` (`id_categorias`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `GEEKSTATION`.`productos_has_pedidos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `GEEKSTATION`.`productos_has_pedidos` (
  `productos_id_producto` INT NOT NULL,
  `productos_categorias_id_categorias` INT NOT NULL,
  `pedidos_id_pedidos` INT NOT NULL,
  PRIMARY KEY (`productos_id_producto`, `productos_categorias_id_categorias`, `pedidos_id_pedidos`),
  INDEX `fk_productos_has_pedidos_pedidos1_idx` (`pedidos_id_pedidos` ASC) VISIBLE,
  INDEX `fk_productos_has_pedidos_productos1_idx` (`productos_id_producto` ASC, `productos_categorias_id_categorias` ASC) VISIBLE,
  CONSTRAINT `fk_productos_has_pedidos_productos1`
    FOREIGN KEY (`productos_id_producto` , `productos_categorias_id_categorias`)
    REFERENCES `GEEKSTATION`.`productos` (`id_producto` , `categorias_id_categorias`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_productos_has_pedidos_pedidos1`
    FOREIGN KEY (`pedidos_id_pedidos`)
    REFERENCES `GEEKSTATION`.`pedidos` (`id_pedidos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


 -- Insertar usuarios
INSERT INTO usuario (nombre, apellido, email, password, telefono, delegacion, RFC ) 
VALUES 
('Ana', 'Ortiz', 'anaortizl@gmail.com', 'adminadmin', '5573892234', 'Benito Juarez', 'KJCD900914H2A'),
('Maria Fernanda', 'Lopez', 'mlopezmartinez@gmail.com', 'securepass123', '5551234567', 'Cuernavaca', 'LOMA921203XJ2'),
('Juan Carlos', 'Ramirez', 'jcramirezhernandez@gmail.com', 'mypassword2024', '3337894561', 'Guadalajara', 'RAHC880315KI9'),
('Ana Isabel', 'Perez', 'anaperezsantos@gmail.com', 'qwerty7890', '2295671234', 'Veracruz', 'PESA970521ZK5'),
('Roberto', 'Gonzalez', 'rgonzalezmorales@gmail.com', 'helloWorld01', '9984567890', 'Cancun', 'GOMO860730LZ7');


 
 -- Insertar categorías
INSERT INTO categorias (nombre, descripcion)
VALUES
('Laptops', 'Laptops para trabajo y juegos'),
('Computadoras', 'Computadoras de escritorio'),
('Tablets', 'Tablets ligeras y versátiles'),
('Smartphones', 'Teléfonos inteligentes'),
('Smartwatch', 'Relojes inteligentes'),
('Audífonos', 'Audífonos de calidad'),
('Cables', 'Cables y accesorios tecnológicos'),
('Webcam', 'Cámaras web para videoconferencias'),
('Teclados', 'Teclados mecánicos y de membrana'),
('Mouse', 'Dispositivos de entrada para computadora'),
('VR', 'Gafas de realidad virtual');

-- INSERTAR PRODUCTOS
INSERT INTO productos (nombre, descripcion, sku, marca, color, url, stock, precio, categorias_id_categorias) 
VALUES
('Acer Aspire 3', 'Laptop Acer Aspire 3 ideal para trabajo y estudio', '37592', 'ACER', 'gris', 'geekstore.com/acer-aspire-3', 400, 8700, 1),
('Acer Chromebook Spin 713', 'Chromebook Acer Spin 713 con pantalla táctil y convertible', '81461', 'ACER', 'gris', 'geekstore.com/acer-chromebook-spin-713', 380, 14000, 1),
('All In One HP Intel Celeron-N100', 'Computadora todo en uno HP con procesador Intel Celeron', '63084', 'HP', 'gris', 'geekstore.com/all-in-one-hp-celeron-n100', 200, 6899, 2),
('Amazon Fire HD 10', 'Tablet Amazon Fire HD 10 con pantalla de 10 pulgadas', '29715', 'Amazon', 'gris', 'geekstore.com/amazon-fire-hd-10', 550, 4500, 3),
('ASUS VivoBook 5', 'Laptop ASUS VivoBook 5 para trabajo y entretenimiento', '63184', 'ASUS', 'gris', 'geekstore.com/asus-vivobook-5', 300, 8600, 1),
('Audífonos Alámbricos JBLC50HIWHT', 'Audífonos JBL con cable para sonido nítido', '95217', 'JBL', 'negro', 'geekstore.com/audifonos-jbl', 400, 69.30, 6),
('Cable HDMI 10K 8K 4K 2 Metros', 'Cable HDMI 10K 8K 4K de 2 metros de longitud', '14376', 'STEREN', 'negro', 'geekstore.com/cable-hdmi-ultra', 350, 249, 7),
('Cámara Web HD 1080P', 'Cámara web HD 1080P para videoconferencias', '52804', 'STEREN', 'negro', 'geekstore.com/camara-web-hd', 300, 206, 8),
('Corsair K100 RBG', 'Teclado mecánico Corsair K100 con retroiluminación RGB', '16937', 'Corsair', 'negro', 'geekstore.com/corsair-k100', 330, 220, 9),
('Dell Inspiron 14', 'Laptop Dell Inspiron 14 con pantalla de 14 pulgadas', '71528', 'DELL', 'gris', 'geekstore.com/dell-inspiron-14', 450, 15500, 1),
('Dell Inspiron 15', 'Laptop Dell Inspiron 15 ideal para productividad', '31694', 'DELL', 'gris', 'geekstore.com/dell-inspiron-15', 450, 10999, 1),
('Dell OPTIPLEX 3070', 'Computadora de escritorio Dell Optiplex 3070', '83295', 'DELL', 'gris', 'geekstore.com/dell-optiplex-3070', 400, 5799, 2),
('Dell OPTIPLEX i5 8GB SSD', 'Computadora de escritorio Dell Optiplex i5 con 8GB de RAM y SSD', '41617', 'DELL', 'gris', 'geekstore.com/dell-optiplex-i5', 300, 8899, 2),
('Dell Optiplex i5-420', 'Computadora de escritorio Dell Optiplex con procesador i5', '95321', 'DELL', 'gris', 'geekstore.com/dell-optiplex-i5-420', 290, 8399, 2),
('Dell OPTIPLEX SFF 3080', 'Computadora de escritorio Dell Optiplex SFF 3080', '68417', 'DELL', 'gris', 'geekstore.com/dell-optiplex-sff', 335, 5799, 2),
('Garmin Forerunner 165', 'Reloj deportivo Garmin Forerunner 165 con GPS y monitoreo de ritmo cardíaco', '37059', 'Garmin', 'negro', 'geekstore.com/garmin-forerunner-165', 654, 2899, 5),
('Google Pixel 8', 'Smartphone Google Pixel 8 con cámara avanzada', '19468', 'Google', 'gris', 'geekstore.com/google-pixel-8', 120, 19000, 4),
('HP 800 G2 SFF-Core i5', 'Computadora HP 800 G2 con procesador Core i5', '27651', 'HP', 'gris', 'geekstore.com/hp-800-g2', 460, 5999, 2),
('HP i5 G420', 'Computadora HP i5 G420 con procesador Intel i5', '48131', 'HP', 'gris', 'geekstore.com/hp-g420', 550, 6799, 2),
('HP i5 USFF 4 GB RAM', 'Computadora HP USFF con procesador i5 y 4GB de RAM', '72596', 'HP', 'gris', 'geekstore.com/hp-usff', 670, 4299, 2),
('HP Pavilion x360', 'Laptop HP Pavilion x360 con pantalla táctil', '10674', 'HP', 'gris', 'geekstore.com/hp-pavilion-x360', 300, 10999, 1),
('HP Victus 15', 'Laptop para juegos', '94382', 'HP', 'gris', 'geekstore.com/hp-victus-15', 250, 17000, 1),
('Huawei Band 9', 'Pulsera inteligente', '52710', 'Huawei', 'negro', 'geekstore.com/huawei-band-9', 600, 609, 5),
('Infinix Note 40 pro', 'Smartphone con cámara avanzada', '69843', 'Infinix', 'gris', 'geekstore.com/infinix-note-40', 345, 4500, 4),
('iPad Pro 11 M2', 'Tablet con procesador avanzado', '10367', 'Apple', 'gris', 'geekstore.com/ipad-pro-11', 250, 20999, 3),
('iPhone 15 Pro', 'Smartphone con cámara avanzada', '35948', 'Apple', 'gris', 'geekstore.com/iphone-15-pro', 250, 28000, 4),
('Lenovo IdeaPad 3', 'Laptop para tareas diarias', '76211', 'Lenovo', 'gris', 'geekstore.com/lenovo-ideapad-3', 546, 9990, 1),
('Lenovo sff m710S', 'Computadora de escritorio i5', '94853', 'Lenovo', 'gris', 'geekstore.com/lenovo-m710s', 765, 5799, 2),
('Lenovo Tab P11 Pro', 'Tablet de alta resolución', '21617', 'Lenovo', 'gris', 'geekstore.com/lenovo-tab-p11', 876, 9500, 3),
('Lenovo Tiny M720Q', 'Computadora compacta', '57384', 'Lenovo', 'gris', 'geekstore.com/lenovo-m720q', 345, 7499, 2),
('Lenovo WORKSTATION P520', 'Estación de trabajo profesional', '62091', 'Lenovo', 'gris', 'geekstore.com/lenovo-workstation-p520', 654, 11399, 2),
('MacBook Air M1', 'Laptop con chip M1', '13748', 'Apple', 'gris', 'geekstore.com/macbook-air-m1', 234, 17990, 3),
('Motorola Edge 40', 'Smartphone con pantalla curva', '19561', 'Motorola', 'gris', 'geekstore.com/motorola-edge-40', 654, 15990, 4),
('Motorola Edge 50', 'Smartphone con cámaras avanzadas', '24735', 'Motorola', 'gris', 'geekstore.com/motorola-edge-50', 765, 7500, 4),
('Mouse inalámbrico Logitech', 'Mouse inalámbrico preciso', '86912', 'Logitech', 'gris', 'geekstore.com/mouse-logitech', 987, 58, 5),
('Mouse inalámbrico vertical', 'Mouse vertical ergonómico', '45379', 'STEREN', 'gris', 'geekstore.com/mouse-vertical', 345, 125, 5),
('Oppo Reno 11 5G', 'Smartphone con cámaras avanzadas', '42608', 'OPPO', 'gris', 'geekstore.com/oppo-reno-11', 654, 7000, 4),
('PC Lenovo sff m79', 'Computadora de escritorio AMD A8', '35879', 'Lenovo', 'gris', 'geekstore.com/lenovo-sff-m79', 743, 6899, 2),
('Pico 4 VR', 'Gafas de realidad virtual', '61134', 'Pico', 'gris', 'geekstore.com/pico-4-vr', 375, 7999, 10),
('Samsung Galaxy S23', 'Smartphone con pantalla AMOLED', '79251', 'Samsung', 'gris', 'geekstore.com/samsung-galaxy-s23', 583, 22500, 4),
('Samsung Galaxy Tab S9', 'Tablet con pantalla AMOLED', '41836', 'Samsung', 'gris', 'geekstore.com/samsung-galaxy-tab-s9', 843, 19000, 3),
('Sony MDR-ZX110', 'Audífonos con sonido claro', '15972', 'Sony', 'gris', 'geekstore.com/sony-mdr-zx110', 930, 344, 6),
('Teclado Inalámbrico Xukinroy', 'Teclado ultradelgado', '68394', 'Xukinroy', 'gris', 'geekstore.com/teclado-xukinroy', 753, 185, 9),
('UGREEN Cable USB C', 'Cable USB C de calidad', '15712', 'UGREEN', 'gris', 'geekstore.com/ugreen-usb-c', 865, 184, 7),
('Xiaomi 13 Lite', 'Smartphone con cámara de 50 MP', '32948', 'Xiaomi', 'gris', 'geekstore.com/xiaomi-13-lite', 532, 12500, 4),
('Xiaomi 9', 'Smartwatch con funciones avanzadas', '76501', 'Xiaomi', 'gris', 'geekstore.com/xiaomi-9', 765, 760, 5),
('Xiaomi Audífonos Buds 6 Play', 'Audífonos con sonido estéreo', '83174', 'Xiaomi', 'gris', 'geekstore.com/audifonos-xiaomi-buds-6', 765, 389, 6),
('Xiaomi Pad 6', 'Tablet de alta resolución', '21649', 'Xiaomi', 'gris', 'geekstore.com/xiaomi-pad-6', 876, 8000, 3),
('Xiaomi Poco F6 Pro', 'Smartphone 5G de alto rendimiento', '19785', 'Xiaomi', 'gris', 'geekstore.com/xiaomi-poco-f6', 654, 9500, 4),
('Xiaomi Redmi Note 13 pro+', 'Smartphone con cámara de 108 MP', '6234', 'Xiaomi', 'gris', 'geekstore.com/xiaomi-redmi-note-13', 543, 6900, 4),
('Zaklu porta gafas VR', 'Porta gafas VR seguro', '58179', 'Zaklu', 'gris', 'geekstore.com/zaklu-gafas-vr', 876, 309, 10);


INSERT INTO pedidos (fecha, estado, total, descripcion, usuario_id_usuario)
VALUES 
('2024-12-15', 'completado', 15000, 'Pedido de laptops y accesorios', 1),
('2024-12-15', 'en proceso', 8000, 'Pedido de computadoras y audífonos', 2),
('2024-12-14', 'cancelado', 4500, 'Pedido de tablets', 3),
('2024-12-13', 'completado', 12000, 'Pedido de productos varios', 4),
('2024-12-12', 'pendiente', 3000, 'Pedido de cables y webcams', 5);


INSERT INTO pago (fecha, metodo_pago, monto, folio_factura, pedidos_id_pedidos) VALUES
('2024-12-15', 'Tarjeta de crédito', 15000, 'FAC001', 1),
('2024-12-16', 'Transferencia bancaria', 4500, 'FAC002', 2),
('2024-12-17', 'PayPal', 6900, 'FAC003', 3),
('2024-12-18', 'Efectivo', 12500, 'FAC004', 4),
('2024-12-19', 'Tarjeta de débito', 8000, 'FAC005', 5);





