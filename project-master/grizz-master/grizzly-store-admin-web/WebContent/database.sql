SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `grizzlystore` ;
CREATE SCHEMA IF NOT EXISTS `grizzlystore` DEFAULT CHARACTER SET utf8 ;
USE `grizzlystore` ;

-- -----------------------------------------------------
-- Table `grizzlystore`.`product`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `grizzlystore`.`product` (
  `name` VARCHAR(225) NOT NULL ,
  `category` VARCHAR(225) NOT NULL ,
  `discription` VARCHAR(225) NOT NULL ,
  `price` INT(225) NOT NULL ,
  `photo` MEDIUMBLOB NULL DEFAULT NULL ,
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `productcol` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `grizzlystore`.`user`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `grizzlystore`.`user` (
  `username` VARCHAR(225) NOT NULL ,
  `password` VARCHAR(225) NOT NULL ,
  PRIMARY KEY (`username`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `grizzlystore`.`vendor`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `grizzlystore`.`vendor` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(225) NOT NULL ,
  `password` VARCHAR(225) NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;

USE `grizzlystore` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
