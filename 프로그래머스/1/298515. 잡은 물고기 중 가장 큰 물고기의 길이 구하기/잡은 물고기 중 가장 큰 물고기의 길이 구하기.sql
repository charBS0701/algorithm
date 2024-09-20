-- 코드를 작성해주세요
SELECT 
    CONCAT(LENGTH,'cm') MAX_LENGTH
FROM
    FISH_INFO
WHERE
    LENGTH = (SELECT MAX(LENGTH)
                FROM FISH_INFO)
        ;
    