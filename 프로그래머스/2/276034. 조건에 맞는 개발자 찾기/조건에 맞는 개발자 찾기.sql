-- 코드를 작성해주세요
SELECT 
    D.ID, D.EMAIL, D.FIRST_NAME, D.LAST_NAME
FROM 
    DEVELOPERS D
WHERE
    D.SKILL_CODE & (
        SELECT CODE 
        FROM SKILLCODES 
        WHERE NAME = 'Python') != 0
    OR
    D.SKILL_CODE & (
        SELECT CODE 
        FROM SKILLCODES 
        WHERE NAME = 'C#') != 0
ORDER BY
    D.ID;