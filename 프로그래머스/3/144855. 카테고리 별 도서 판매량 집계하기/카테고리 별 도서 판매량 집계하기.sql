-- 코드를 입력하세요
SELECT CATEGORY, sum(sales) "TOTAL_SALES"
from book b, book_sales bs
where b.book_id = bs.book_id
and TO_CHAR(sales_date, 'YYYYMM') = '202201'
group by category
order by category;