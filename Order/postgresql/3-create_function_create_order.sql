-- FUNCTION: public.create_order(character varying, timestamp with time zone, double precision, text)

-- DROP FUNCTION public.create_order(character varying, timestamp with time zone, double precision, text);

CREATE OR REPLACE FUNCTION public.create_order(
	p_customer_id character varying,
	p_created_at timestamp with time zone,
	p_amount_order double precision,
	p_order_product text)
    RETURNS bigint
    LANGUAGE 'plpgsql'

    COST 100
    VOLATILE

AS $BODY$
DECLARE
    p_order_id bigint;
    p_order_product_id bigint;
	p_json json;
BEGIN
    p_order_id := nextval('order_id_seq');
    INSERT INTO public."ORDERS"(
        order_id, customer_id, created_at, amount_order)
    VALUES (p_order_id, p_customer_id, p_created_at, p_amount_order);

	FOR p_json IN SELECT * FROM json_array_elements(p_order_product::json)
  	LOOP
	    p_order_product_id := nextval('order_product_id_seq');
            INSERT INTO public."ORDERS_PRODUCTS"(
                order_product_id, quantity, product_id, product_price, order_id)
            VALUES (p_order_product_id, CAST (p_json->>'quantity' AS bigint) , p_json->>'productId', CAST(p_json->>'productPrice' AS double precision), p_order_id);
  	END LOOP;

    RETURN p_order_id;

END;
$BODY$;

ALTER FUNCTION public.create_order(character varying, timestamp with time zone, double precision, text)
    OWNER TO postgres;
