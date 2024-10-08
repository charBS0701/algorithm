-- 코드를 작성해주세요
SELECT
    SUB.FISH_COUNT, FNI.FISH_NAME
FROM 
    FISH_NAME_INFO FNI
RIGHT JOIN
    (SELECT 
        FISH_TYPE, COUNT(*) FISH_COUNT
    FROM
        FISH_INFO FI
    GROUP BY
        FISH_TYPE) SUB
ON FNI.FISH_TYPE = SUB.FISH_TYPE
ORDER BY
    1 DESC;