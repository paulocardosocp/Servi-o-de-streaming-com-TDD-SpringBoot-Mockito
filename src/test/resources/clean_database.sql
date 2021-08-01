DELETE FROM producao;
ALTER SEQUENCE producao_id_seq RESTART WITH 1;

DELETE FROM genero;
ALTER SEQUENCE genero_id_seq RESTART WITH 1;

DELETE FROM tipo_producao;
ALTER SEQUENCE tipo_producao_id_seq RESTART WITH 1;
