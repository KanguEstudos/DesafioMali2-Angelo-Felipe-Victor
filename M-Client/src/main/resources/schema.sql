CREATE TABLE tb_client
(
    id       BIGINT AUTO_INCREMENT NOT NULL,
    name     VARCHAR(255)          NULL,
    document VARCHAR(255)          NULL,
    email    VARCHAR(255)          NULL,
    type     VARCHAR(255)          NULL,
    user_id  BIGINT                NULL,
    CEP      VARCHAR(255)          NULL,
    CONSTRAINT pk_tb_client PRIMARY KEY (id)
);

ALTER TABLE tb_client
    ADD CONSTRAINT FK_TB_CLIENT_ON_USER FOREIGN KEY (user_id) REFERENCES tb_user (id);