SELECT
    II.ITEM_ID, II.ITEM_NAME
FROM
    ITEM_INFO II
WHERE
    II.ITEM_ID IN
        (SELECT 
            IT.ITEM_ID
        FROM 
            ITEM_TREE IT
        WHERE 
            IT.PARENT_ITEM_ID IS NULL)
ORDER BY 
    II.ITEM_ID;