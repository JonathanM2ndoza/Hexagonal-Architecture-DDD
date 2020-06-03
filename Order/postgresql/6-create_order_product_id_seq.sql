-- SEQUENCE: public.order_product_id_seq

-- DROP SEQUENCE public.order_product_id_seq;

CREATE SEQUENCE public.order_product_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.order_product_id_seq
    OWNER TO postgres;

GRANT ALL ON SEQUENCE public.order_product_id_seq TO postgres;