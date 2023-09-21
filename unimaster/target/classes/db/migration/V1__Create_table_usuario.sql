CREATE TABLE IF NOT EXISTS `usuario` (
  `idusuario` bigint NOT NULL AUTO_INCREMENT,
  `login` varchar(50) NOT NULL,
  `senha` varchar(80) NOT NULL,
  `perfil` varchar(50) NOT NULL,
  PRIMARY KEY (`idusuario`)
)

