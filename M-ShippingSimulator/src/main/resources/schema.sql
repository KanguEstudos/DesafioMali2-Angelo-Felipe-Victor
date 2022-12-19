CREATE TABLE tb_simulation
(
    id          BIGINT AUTO_INCREMENT NOT NULL,
    vlrFrete    DOUBLE                NULL,
    prazoEnt    INT                   NULL,
    dtPrevEnt   datetime              NULL,
    transp_nome VARCHAR(255)          NULL,
    descricao   VARCHAR(255)          NULL,
    idSimulacao BIGINT                NULL,
    CONSTRAINT pk_tb_simulation PRIMARY KEY (id)
);