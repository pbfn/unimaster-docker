INSERT INTO `users` (`user_name`, `full_name`, `password`, `account_non_expired`, `account_non_locked`, `credentials_non_expired`, `enabled`) VALUES
	('pedro_bruno', 'Pedro Bruno', 'dae993604044f7b4fae8673f9f9d72fa77924e9bf0cf5430365c1890ac53805cebfdad4ad133477c', b'1', b'1', b'1', b'1'),
	('filipe', 'Filipe', '3e2831cd75fcd23ab0310ceb6a460dab3f635252d80ae93fbd756bdd07b2be89a2ce11b4994302b1', b'1', b'1', b'1', b'1');
INSERT INTO `registration` (`id_user`,`id_course`,`year_of_entry`,`status`) values (3,1,'2023','Cursando');
INSERT INTO `student_discipline` (`id_student`,`id_teacher`,`id_discipline`,`period`,`status`) values (3,4,3, '8', 'Cursando');
INSERT INTO `student_discipline` (`id_student`,`id_teacher`,`id_discipline`,`period`,`status`) values (3,4,6, '8', 'Cursando');
INSERT INTO `student_discipline` (`id_student`,`id_teacher`,`id_discipline`,`period`,`status`) values (3,4,8, '8', 'Cursando');

INSERT INTO `test_discipline` (`id_discipline`,`id_student`,`description`,`total_value`, `value_achieved`) values (3,3,'Prova 1',30.0,25.0);
INSERT INTO `test_discipline` (`id_discipline`,`id_student`,`description`,`total_value`, `value_achieved`) values (3,3,'Prova 2',30.0,27.0);
INSERT INTO `test_discipline` (`id_discipline`,`id_student`,`description`,`total_value`, `value_achieved`) values (3,3,'Trabalho 1',20.0,20.0);
INSERT INTO `test_discipline` (`id_discipline`,`id_student`,`description`,`total_value`, `value_achieved`) values (3,3,'Trabalho 2',20.0,17.0);

INSERT INTO `test_discipline` (`id_discipline`,`id_student`,`description`,`total_value`, `value_achieved`) values (6,3,'Prova 1',30.0,12);
INSERT INTO `test_discipline` (`id_discipline`,`id_student`,`description`,`total_value`, `value_achieved`) values (6,3,'Prova 2',30.0,15.0);
INSERT INTO `test_discipline` (`id_discipline`,`id_student`,`description`,`total_value`, `value_achieved`) values (6,3,'Trabalho 1',20.0,16.0);
INSERT INTO `test_discipline` (`id_discipline`,`id_student`,`description`,`total_value`, `value_achieved`) values (6,3,'Trabalho 2',20.0,11.0);

INSERT INTO `test_discipline` (`id_discipline`,`id_student`,`description`,`total_value`, `value_achieved`) values (8,3,'Prova 1',30.0,15.0);
INSERT INTO `test_discipline` (`id_discipline`,`id_student`,`description`,`total_value`, `value_achieved`) values (8,3,'Prova 2',30.0,19.0);
INSERT INTO `test_discipline` (`id_discipline`,`id_student`,`description`,`total_value`, `value_achieved`) values (8,3,'Trabalho 1',20.0,19.0);
INSERT INTO `test_discipline` (`id_discipline`,`id_student`,`description`,`total_value`, `value_achieved`) values (8,3,'Trabalho 2',20.0,15.0);

INSERT INTO `user_permission` (`id_user`,`id_permission`) values (3,1);
INSERT INTO `user_permission` (`id_user`,`id_permission`) values (3,2);
INSERT INTO `user_permission` (`id_user`,`id_permission`) values (4,1);
INSERT INTO `user_permission` (`id_user`,`id_permission`) values (4,2);

INSERT INTO `pessoa` (`idpessoa`,`logradouro`,`cep`,`cidade`,`cpf`,`nomepai`,`nomemae`,`nome`,`bairro`,`numero`,`rg`,`salario`,`estado`,`telefone`,`idusuario`)
values (1,'Logradouro 1','CEP 1','Cidade 1','CPF1','Nome Pai','Nome Mão','Nome','Bairro','Numero','RG',5000.0,'Estado','Telefone',3);
INSERT INTO `pessoa` (`idpessoa`,`logradouro`,`cep`,`cidade`,`cpf`,`nomepai`,`nomemae`,`nome`,`bairro`,`numero`,`rg`,`salario`,`estado`,`telefone`,`idusuario`)
values (2,'Logradouro 1','CEP 1','Cidade 1','CPF1','Nome Pai','Nome Mão','Nome','Bairro','Numero','RG',5000.0,'Estado','Telefone',4);

