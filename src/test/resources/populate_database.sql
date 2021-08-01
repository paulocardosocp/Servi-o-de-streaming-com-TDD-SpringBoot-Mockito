INSERT INTO genero(descricao) VALUES ('Drama');
INSERT INTO genero(descricao) VALUES ('Fantasia');
INSERT INTO genero(descricao) VALUES ('Comédia');
INSERT INTO genero(descricao) VALUES ('Policial');

INSERT INTO tipo_producao(descricao) VALUES ('Filme');
INSERT INTO tipo_producao(descricao) VALUES ('Série');
INSERT INTO tipo_producao(descricao) VALUES ('Documentário');

INSERT INTO producao(titulo, ano, classificacao, id_genero, id_tipo) VALUES (
'O Poderoso Chefão', 1972, 'LARANJA', SELECT id FROM genero WHERE descricao = 'Policial', SELECT id FROM tipo_producao WHERE descricao = 'Filme')
);
INSERT INTO producao(titulo, ano, classificacao, id_genero, id_tipo) VALUES (
'E o Vento Levou', 1939, 'AMARELO', SELECT id FROM genero WHERE descricao = 'Drama', SELECT id FROM tipo_producao WHERE descricao = 'Filme')
);
INSERT INTO producao(titulo, ano, classificacao, id_genero, id_tipo) VALUES (
'Game of Thrones', 2011, 'LARANJA', SELECT id FROM genero WHERE descricao = 'Fantasia', SELECT id FROM tipo_producao WHERE descricao = 'Documentário')
);


