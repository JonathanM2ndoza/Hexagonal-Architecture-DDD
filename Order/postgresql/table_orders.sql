-- Table: public.ORDERS

-- DROP TABLE public."ORDERS";

CREATE TABLE public."ORDERS"
(
    order_id bigint NOT NULL,
    customer_id character varying COLLATE pg_catalog."default" NOT NULL,
    created_at timestamp with time zone NOT NULL,
    amount_order double precision NOT NULL,
    CONSTRAINT "ORDERS_pkey" PRIMARY KEY (order_id)
)

    TABLESPACE pg_default;

ALTER TABLE public."ORDERS"
    OWNER to postgres;

GRANT ALL ON TABLE public."ORDERS" TO postgres;