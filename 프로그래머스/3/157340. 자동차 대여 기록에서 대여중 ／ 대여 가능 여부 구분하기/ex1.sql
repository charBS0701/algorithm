-- 예시 답안 
-- 출처 : https://school.programmers.co.kr/questions/76488

-- 코드를 입력하세요
-- 출력: 자동차 ID, Availability (2022.10.16 대여중 표시, 그 외 대여가능 표시 )
-- 조건: 22.10.16 대여중, 반납날짜도 포함
-- 정렬: ID기준 내림차순

select car_id, 
    case when max(availability) = '1' then '대여중' 
    else '대여 가능' end as availability 
from CAR_RENTAL_COMPANY_RENTAL_HISTORY as A 
    left join (select history_id, '1' as availability from CAR_RENTAL_COMPANY_RENTAL_HISTORY where start_date <= '2022-10-16' and end_date >= '2022-10-16') as B 
    on A.history_id = B.history_id 
group by car_id 
order by car_id desc
