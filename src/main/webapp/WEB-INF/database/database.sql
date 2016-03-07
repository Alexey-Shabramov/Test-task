DROP DATABASE `test_task`;
CREATE DATABASE IF NOT EXISTS `test_task`;
USE `test_task`;

DROP TABLE IF EXISTS `client`;
CREATE TABLE `client` (
  `id`                    BIGINT(21)   NOT NULL AUTO_INCREMENT,
  `login`                 VARCHAR(255) NOT NULL,
  `email`                 VARCHAR(100) NOT NULL,
  `name`                 VARCHAR(100) DEFAULT NULL,
  `password`              VARCHAR(200) NOT NULL,
  `registration_date`     TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `admin`                 TINYINT(1)   NOT NULL DEFAULT '0',
  `moderator`             TINYINT(1)   NOT NULL DEFAULT '0',
  `active`                TINYINT(1)   NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `login` (`login`),
  UNIQUE KEY `email` (`email`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 10
  DEFAULT CHARSET = utf8;
