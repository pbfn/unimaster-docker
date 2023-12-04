CREATE TABLE IF NOT EXISTS `registration` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_user` bigint(20) NOT NULL,
  `id_course` bigint(20) NOT NULL,
  `year_of_entry` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_registration` (`id`),
  CONSTRAINT `fk_user_registration` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`),
  CONSTRAINT `fk_course_registration` FOREIGN KEY (`id_course`) REFERENCES `course` (`id`)
);