CREATE TABLE IF NOT EXISTS `test_discipline` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_discipline` bigint(20) NOT NULL,
  `id_student` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `total_value` double DEFAULT NULL,
  `value_achieved` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_registration` (`id`),
  CONSTRAINT `fk_student_discipline_test` FOREIGN KEY (`id_discipline`) REFERENCES `student_discipline` (`id_discipline`),
  CONSTRAINT `fk_discipline_student_test` FOREIGN KEY (`id_student`) REFERENCES `student_discipline` (`id_student`)
);