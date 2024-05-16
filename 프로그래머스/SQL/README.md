#### ORACLE 주의할 점
- order by 는 sql 제일 바깥 문장에만 있어야한다
- TABLE 명을 ALIAS 할 때 AS 를 붙이면 오류난다
- TO_DATE, TO_CHAR, TO_NUMBER 로 type 잘 맞춰서 계산
- sum() 같은 집계함수는 SELECT 절에서만 쓸 수 있다
