DROP TABLE IF EXISTS tb_user;

CREATE TABLE tb_user
(
    id       BIGINT AUTO_INCREMENT NOT NULL,
    name     VARCHAR(255)          NULL,
    document VARCHAR(255)          NULL,
    email    VARCHAR(255)          NULL,
    password VARCHAR(255)          NULL,
    type     VARCHAR(255)          NULL,
    CONSTRAINT pk_tb_user PRIMARY KEY (id)
);

ALTER TABLE tb_user
    ADD CONSTRAINT uc_tb_user_document UNIQUE (document);

ALTER TABLE tb_user
    ADD CONSTRAINT uc_tb_user_email UNIQUE (email);