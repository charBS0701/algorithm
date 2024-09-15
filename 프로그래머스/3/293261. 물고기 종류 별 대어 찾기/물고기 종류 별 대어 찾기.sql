-- 코드를 작성해주세요
-- ID, FISH_NAME, LENGTH
SELECT FI2.ID, FNI.FISH_NAME, FI.LENGTH
FROM FISH_NAME_INFO FNI
JOIN 
        (SELECT FISH_TYPE, MAX(LENGTH) LENGTH
        FROM FISH_INFO
        GROUP BY FISH_TYPE) FI
ON FNI.FISH_TYPE = FI.FISH_TYPE
JOIN FISH_INFO FI2
ON FI2.FISH_TYPE = FNI.FISH_TYPE
WHERE FI.LENGTH = FI2.LENGTH
ORDER BY FI2.ID ASC;