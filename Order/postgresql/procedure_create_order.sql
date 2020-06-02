-- PROCEDURE: public.create_order(character varying, timestamp with time zone, double precision)

-- DROP PROCEDURE public.create_order(character varying, timestamp with time zone, double precision);

CREATE OR REPLACE PROCEDURE public.create_order(
	p_customer_id character varying,
	p_created_at timestamp with time zone,
	p_amount_order double precision)
LANGUAGE 'plpgsql'
AS $BODY$
DECLARE
p_order_id bigint;
BEGIN
   p_order_id := nextval('order_id_seq');
   INSERT INTO public."ORDERS"(
	order_id, customer_id, created_at, amount_order)
	VALUES (p_order_id, p_customer_id, p_created_at, p_amount_order);

END;
$BODY$;

GRANT EXECUTE ON PROCEDURE public.create_order(character varying, timestamp with time zone, double precision) TO postgres WITH GRANT OPTION;

GRANT EXECUTE ON PROCEDURE public.create_order(character varying, timestamp with time zone, double precision) TO PUBLIC;

