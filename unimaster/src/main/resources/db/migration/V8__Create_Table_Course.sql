CREATE TABLE IF NOT EXISTS `course` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name_course` varchar(255) DEFAULT NULL,
  `description_course` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
)