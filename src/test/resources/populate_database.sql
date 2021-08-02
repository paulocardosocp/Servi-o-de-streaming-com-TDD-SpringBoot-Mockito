INSERT INTO genero(descricao) VALUES ('Drama');
INSERT INTO genero(descricao) VALUES ('Fantasia');
INSERT INTO genero(descricao) VALUES ('Comedia');
INSERT INTO genero(descricao) VALUES ('Policial');

INSERT INTO tipo_producao(descricao) VALUES ('Filme');
INSERT INTO tipo_producao(descricao) VALUES ('Serie');
INSERT INTO tipo_producao(descricao) VALUES ('Documentario');

INSERT INTO producao(titulo, ano, classificacao, id_genero, id_tipo) VALUES (
'O Poderoso Chefao', 1972, 'LARANJA', 4, 1
);
INSERT INTO producao(titulo, ano, classificacao, id_genero, id_tipo) VALUES (
'E o Vento Levou', 1939, 'AMARELO', 1, 1
);
INSERT INTO producao(titulo, ano, classificacao, id_genero, id_tipo) VALUES (
'Game of Thrones', 2011, 'LARANJA', 2, 3
);

