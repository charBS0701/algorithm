WITH RECURSIVE CTE AS (
    SELECT 
        ID, 
        PARENT_ID, 
        1 AS GENERATION
    FROM 
        ECOLI_DATA
    WHERE 
        PARENT_ID IS NULL

    UNION ALL

    SELECT 
        E.ID, 
        E.PARENT_ID, 
        C.GENERATION + 1 AS GENERATION
    FROM 
        ECOLI_DATA E
    JOIN 
        CTE C ON E.PARENT_ID = C.ID
)
SELECT 
    ID
FROM 
    CTE
WHERE 
    GENERATION = 3
ORDER BY 
    ID;
