CREATE TABLE tb_order
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    seller_id     BIGINT                NULL,
    buyer_id      BIGINT                NULL,
    simulation_id BIGINT                NULL,
    product_id    BIGINT                NULL,
    paymentStatus BIT(1) DEFAULT 0      NULL,
    totalAmount   DOUBLE                NULL,
    CEPDestin     VARCHAR(255)          NULL,
    CEPOrigin     VARCHAR(255)          NULL,
    Status        VARCHAR(255)          NULL,
    CONSTRAINT pk_tb_order PRIMARY KEY (id)
);

ALTER TABLE tb_order
    ADD CONSTRAINT FK_TB_ORDER_ON_BUYER FOREIGN KEY (buyer_id) REFERENCES tb_client (id);

ALTER TABLE tb_order
    ADD CONSTRAINT FK_TB_ORDER_ON_PRODUCT FOREIGN KEY (product_id) REFERENCES tb_product (id);

ALTER TABLE tb_order
    ADD CONSTRAINT FK_TB_ORDER_ON_SELLER FOREIGN KEY (seller_id) REFERENCES tb_user (id);

ALTER TABLE tb_order
    ADD CONSTRAINT FK_TB_ORDER_ON_SIMULATION FOREIGN KEY (simulation_id) REFERENCES tb_simulation (id);