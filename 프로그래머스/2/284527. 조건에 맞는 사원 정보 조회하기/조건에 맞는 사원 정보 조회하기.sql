WITH sub AS (
    SELECT EMP_NO, SUM(SCORE) SC
    FROM HR_GRADE
    GROUP BY EMP_NO
)

select sc SCORE, SUB.EMP_NO, EMP_NAME, POSITION, EMAIL
from SUB
join HR_EMPLOYEES HE
on SUB.EMP_NO = HE.EMP_NO
where sc = (select max(sc)
            from sub);

