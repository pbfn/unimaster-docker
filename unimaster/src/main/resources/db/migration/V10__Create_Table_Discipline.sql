CREATE TABLE IF NOT EXISTS `discipline` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name_discipline` varchar(255) DEFAULT NULL,
  `description_discipline` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
)