DROP TABLE IF EXISTS tb_category;

CREATE TABLE tb_category
(
    id   BIGINT AUTO_INCREMENT NOT NULL,
    name VARCHAR(255)          NULL,
    CONSTRAINT pk_tb_category PRIMARY KEY (id)
);

DROP TABLE IF EXISTS tb_product;

CREATE TABLE tb_product
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    title         VARCHAR(255)          NULL,
    `description` VARCHAR(255)          NULL,
    price         DOUBLE                NULL,
    factor        DOUBLE                NULL,
    category_id   BIGINT                NULL,
    CONSTRAINT pk_tb_product PRIMARY KEY (id)
);

ALTER TABLE tb_product
    ADD CONSTRAINT FK_TB_PRODUCT_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES tb_category (id);
