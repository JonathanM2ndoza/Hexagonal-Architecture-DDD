-- Table: public.ORDERS_PRODUCTS

-- DROP TABLE public."ORDERS_PRODUCTS";

CREATE TABLE public."ORDERS_PRODUCTS"
(
    order_product_id bigint NOT NULL,
    quantity bigint NOT NULL,
    product_id character varying COLLATE pg_catalog."default" NOT NULL,
    product_price double precision NOT NULL,
    order_id bigint NOT NULL,
    CONSTRAINT "ORDERS_PRODUCTS_pkey" PRIMARY KEY (order_product_id),
    CONSTRAINT order_id_fk FOREIGN KEY (order_id)
        REFERENCES public."ORDERS" (order_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

    TABLESPACE pg_default;

ALTER TABLE public."ORDERS_PRODUCTS"
    OWNER to postgres;

GRANT ALL ON TABLE public."ORDERS_PRODUCTS" TO postgres;