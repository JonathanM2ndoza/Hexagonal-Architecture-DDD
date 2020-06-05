-- FUNCTION: public.get_order(bigint)

-- DROP FUNCTION public.get_order(bigint);

CREATE OR REPLACE FUNCTION public.get_order(
    p_order_id bigint)
    RETURNS json
    LANGUAGE 'plpgsql'

    COST 100
    VOLATILE

AS $BODY$
DECLARE
    json_op json;
    json_result json;
BEGIN

    json_op:= (SELECT
                   json_agg(
                           json_build_object(
                                   'orderProductId',OP.order_product_id,
                                   'quantity', OP.quantity,
                                   'productId',OP.product_id,
                                   'productPrice',OP.product_price))
               FROM public."ORDERS_PRODUCTS" AS OP
               WHERE OP.order_id = p_order_id);

    json_result:= (SELECT
                       json_build_object(
                               'orderId', O.order_id,
                               'customerId', O.customer_id,
                               'createdAt', O.created_at,
                               'orderProductList',json_op,
                               'amountOrder', O.amount_order)
                   FROM public."ORDERS" AS O
                   WHERE O.order_id = p_order_id);

    RETURN json_result;

END;
$BODY$;

ALTER FUNCTION public.get_order(bigint)
    OWNER TO postgres;

GRANT EXECUTE ON FUNCTION public.get_order(bigint) TO postgres;

GRANT EXECUTE ON FUNCTION public.get_order(bigint) TO PUBLIC;

