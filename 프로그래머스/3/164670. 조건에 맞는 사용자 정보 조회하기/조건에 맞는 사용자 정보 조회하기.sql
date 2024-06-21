-- 코드를 입력하세요
select user_id, nickname, city || ' ' || street_address1 || ' ' || street_address2 "전체주소" , 
substr(tlno,1,3) || '-' || substr(tlno,4,4) || '-' || substr(tlno,8,4) "전화번호"
from USED_GOODS_USER
where user_id in 
    (SELECT b.writer_id
    FROM USED_GOODS_BOARD b
    JOIN USED_GOODS_USER u
    ON b.WRITER_ID = u.USER_ID
    GROUP BY b.writer_id
    having count(*) >= 3) 
order by user_id desc
;