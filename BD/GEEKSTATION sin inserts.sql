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
