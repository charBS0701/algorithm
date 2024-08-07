SELECT EXTRACT(YEAR FROM DIFFERENTIATION_DATE) YEAR, 
    (SUB.MAXSIZE - E1.SIZE_OF_COLONY) YEAR_DEV,
    E1.ID
FROM ECOLI_DATA E1
JOIN
        (
        SELECT MAX(E2.SIZE_OF_COLONY) MAXSIZE, EXTRACT(YEAR FROM DIFFERENTIATION_DATE) YEAR
        FROM ECOLI_DATA E2
        GROUP BY EXTRACT(YEAR FROM DIFFERENTIATION_DATE)
        ) SUB
ON EXTRACT(YEAR FROM DIFFERENTIATION_DATE) = SUB.YEAR
ORDER BY YEAR, YEAR_DEV;