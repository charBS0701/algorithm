#### ORACLE 주의할 점
- order by 는 sql 제일 바깥 문장에만 있어야한다
- TABLE 명을 ALIAS 할 때 AS, " " 를 붙이면 오류난다 **그냥 띄워서 ALIAS 만 써라.**
- SELECT ALIAS 도 AS ALIAS, 또는 그냥 ALIAS 만 써라. 큰 따옴표 금지
- TO_DATE, TO_CHAR, TO_NUMBER 로 type 잘 맞춰서 계산
- sum() 같은 집계함수는 SELECT 절에서만 쓸 수 있다
- join 할 때 테이블 뒤에 , 붙이면 안된다
- SELECT 하려면 억지로 GROUP BY 해야한다
- COUNT(*) 는 모든 행의 개수를 세고 COUNT(NAME)은 NULL이 아닌 값의 수를 센다
- 문자열 잇기 ||
- WHERE 절에서는 집계함수를 쓸 수 없지만 HAVING 절에서는 가능하다
- ORDER BY 에서는 SELECT 의 ALIAS 를 쓸 수 있지만 JOIN ON 에서는 못 쓴다
- EXTRACT(part FROM date) &nbsp;&nbsp; part can be one of [these](https://www.w3schools.com/sql/func_mysql_extract.asp)
  -   mysql : YEAR(date) 가능
  -   orcale : TO_CHAR(date, 'YYYY')
      -   TO_CHAR(date, 'MM') : 1월일 경우 01 반환 (문자열)
      -   EXTRACT(MONTH FROM date) : 1월일 경우 1 반환 (정수)
 
### NULL
- NULL 값은 SQL에서 특별한 의미를 가지고 있어서, NOT IN 조건에서 NULL 값과의 비교는 항상 실패
- 집계 함수와 NULL 처리: 집계 함수(예: SUM(), COUNT())에서 NULL 값은 무시됩니다. 하지만 경우에 따라 0과 비교해야 할 때는 COALESCE()나 IFNULL()을 사용해 NULL 값을 적절히 처리하는 것이 중요합니다.
  
  > 예시: SUM(column)은 NULL 값을 무시하고 계산.
COALESCE(column, 0)을 사용하면 NULL 값을 0으로 변환해 계산.
