-- Type: order_product_type

-- DROP TYPE public.order_product_type;

CREATE TYPE public.order_product_type AS
(
    order_product_id bigint,
    quantity bigint,
    product_id character varying,
    product_price double precision
);

ALTER TYPE public.order_product_type
    OWNER TO postgres;

GRANT USAGE ON TYPE public.order_product_type TO PUBLIC;

GRANT USAGE ON TYPE public.order_product_type TO postgres;

