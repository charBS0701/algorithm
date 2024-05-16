SELECT f1.category, MAX(f1.price) AS max_price, f1.product_name
FROM food_product f1
INNER JOIN (
    SELECT category, MAX(price) AS max_price
    FROM food_product
    WHERE CATEGORY IN ('과자','국','김치','식용유')
    GROUP BY category
) f2 ON f1.category = f2.category AND f1.price = f2.max_price
GROUP BY f1.category, f1.product_name
ORDER BY max_price DESC;
