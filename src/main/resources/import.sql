----====================================================
--INSERTS TO DATA AT TABLES DEFAULT - 16-06-2020
----====================================================
BEGIN TRANSACTION;
INSERT INTO ESTUDANTE (id, email, nome, telefone, matricula, curso) VALUES (1, 'xawoy@tms.com.br', 'Xawoy', '7777', '123456', 'Engenharia da Computação');
INSERT INTO ESTUDANTE (id, email, nome, telefone, matricula, curso) VALUES(2, 'furae@tms.com.br', 'Furae', '7778', '678912', 'Ciência da Computação');
INSERT INTO ESTUDANTE (id, email, nome, telefone, matricula, curso) VALUES(3, 'fupuy@tms.com.br', 'Fupuy', '7779', '321654', 'Engenharia da Computação');
INSERT INTO ESTUDANTE (id, email, nome, telefone, matricula, curso) VALUES(4, 'kuer@tms.com.br', 'Kuer',  '7780', '654987', 'Análise de Dados');
INSERT INTO ESTUDANTE (id, email, nome, telefone, matricula, curso) VALUES(5, 'blias@tms.com.br', 'Blias',  '7781', '666131', 'Ciência da Computação');
COMMIT;