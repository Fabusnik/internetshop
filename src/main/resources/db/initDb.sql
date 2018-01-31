# CREATE SCHEMA `playtox`;

DROP TABLE purchase;
DROP TABLE goods;
DROP TABLE user_roles;
DROP TABLE users;


CREATE TABLE `playtox`.`users` 
(
`id` INT NOT NULL AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL,
`password` VARCHAR(45) NOT NULL,
`registered` TIMESTAMP(0) NOT NULL,
  
PRIMARY KEY (`id`),
UNIQUE INDEX `id_UNIQUE` (`id` ASC),
UNIQUE INDEX `name_UNIQUE` (`name` ASC));


CREATE TABLE `playtox`.`goods`
(
`id` INT NOT NULL AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL,
`description` VARCHAR(255) NOT NULL,
`price` FLOAT NOT NULL,
`stock` INT NOT NULL,
  
PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC));


CREATE TABLE `playtox`.`purchase` 
(
`id` INT NOT NULL AUTO_INCREMENT,
`user_id` INT NOT NULL,
`good_id` INT NOT NULL,
`data` TIMESTAMP(0) NOT NULL,
`amount` INT NOT NULL,
`quantity` INT NOT NULL,
  
PRIMARY KEY (`id`),
UNIQUE INDEX `id_UNIQUE` (`id` ASC),
INDEX `user_fk_idx` (`user_id` ASC),
INDEX `good_fk_idx` (`good_id` ASC),
  
CONSTRAINT `user_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `playtox`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
 
CONSTRAINT `good_fk`
    FOREIGN KEY (`good_id`)
    REFERENCES `playtox`.`goods` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



CREATE TABLE `playtox`.`user_roles` 
(
`user_id` INT NOT NULL,
`role` VARCHAR(45) NOT NULL,
  
UNIQUE INDEX `user_id_idx` (`user_id` ASC, `role` ASC),
  
CONSTRAINT ``
    FOREIGN KEY (`user_id`)
    REFERENCES `playtox`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION);




