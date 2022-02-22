CREATE DATABASE viceri;
--https://bcrypt-generator.com/

--o hibernate se encarrega de criar as tabelas e fazer as suas devidas ligações

INSERT INTO usuario (id_usuario, email, nome, senha) VALUES 
(1, 'rodrigo.ccalmon@gmail.com', 'rodrigo', '$2a$12$2k/wS0BcvTB4hP07BXfld.Z5XzBsrrDIHvlnzHS2/tKzd.PNhXBS.'); 
--senha = admin
INSERT INTO usuario (id_usuario, email, nome, senha) VALUES 
(2, 'gisele.ccalmon@gmail.com', 'gisele', '$2a$12$2k/wS0BcvTB4hP07BXfld.Z5XzBsrrDIHvlnzHS2/tKzd.PNhXBS.'); 
--senha = admin

INSERT INTO tarefa (id_tarefa, descricao_tarefa, prioridade, id_usuario) VALUES (1, 'Realizar teste Viceri', 'alta', 1);
INSERT INTO tarefa (id_tarefa, descricao_tarefa, prioridade, id_usuario) VALUES (2, 'Entregar até quarta-feira', 'alta', 1);

INSERT INTO tarefa (id_tarefa, descricao_tarefa, prioridade, id_usuario) VALUES (3, 'Alterar fluxo de usuário da ge2gether', 'alta', 2);
INSERT INTO tarefa (id_tarefa, descricao_tarefa, prioridade, id_usuario) VALUES (4, 'Entregar pesquisa para Diego', 'alta', 2);



