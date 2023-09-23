CREATE TABLE IF NOT EXISTS `pessoa` (
  `idpessoa` bigint NOT NULL AUTO_INCREMENT,
  `logradouro` varchar(45) NOT NULL,
  `cep` varchar(45) NOT NULL,
  `cidade` varchar(45) NOT NULL,
  `cpf` varchar(14) NOT NULL,
  `nomepai` varchar(45) NOT NULL,
  `nomemae` varchar(45) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `bairro` varchar(45) NOT NULL,
  `numero` varchar(45) NOT NULL,
  `rg` varchar(45) NOT NULL,
  `salario` double NOT NULL,
  `estado` varchar(45) NOT NULL,
  `telefone` varchar(45) NOT NULL,
  `idusuario` bigint DEFAULT NULL,
  PRIMARY KEY (`idpessoa`)
)