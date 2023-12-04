CREATE TABLE IF NOT EXISTS `student_discipline` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_student` bigint(20) NOT NULL,
  `id_teacher` bigint(20) NOT NULL,
  `id_discipline` bigint(20) NOT NULL,
  `period` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_registration` (`id`),
  CONSTRAINT `fk_student_student_discipline` FOREIGN KEY (`id_student`) REFERENCES `users` (`id`),
  CONSTRAINT `fk_teacher_student_discipline` FOREIGN KEY (`id_teacher`) REFERENCES `users` (`id`),
  CONSTRAINT `fk_discipline_student_discipline` FOREIGN KEY (`id_discipline`) REFERENCES `discipline` (`id`)
);