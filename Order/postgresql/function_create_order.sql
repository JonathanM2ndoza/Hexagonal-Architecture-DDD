-- FUNCTION: public.create_order(character varying, timestamp with time zone, double precision)

-- DROP FUNCTION public.create_order(character varying, timestamp with time zone, double precision);

CREATE OR REPLACE FUNCTION public.create_order(
	p_customer_id character varying,
	p_created_at timestamp with time zone,
	p_amount_order double precision)
    RETURNS bigint
    LANGUAGE 'plpgsql'

    COST 100
    VOLATILE

AS $BODY$
DECLARE
p_order_id bigint;
BEGIN
   p_order_id := nextval('order_id_seq');
   INSERT INTO public."ORDERS"(
	order_id, customer_id, created_at, amount_order)
	VALUES (p_order_id, p_customer_id, p_created_at, p_amount_order);
	return p_order_id;

END;
$BODY$;

ALTER FUNCTION public.create_order(character varying, timestamp with time zone, double precision)
    OWNER TO postgres;

GRANT EXECUTE ON FUNCTION public.create_order(character varying, timestamp with time zone, double precision) TO postgres;

GRANT EXECUTE ON FUNCTION public.create_order(character varying, timestamp with time zone, double precision) TO PUBLIC;

