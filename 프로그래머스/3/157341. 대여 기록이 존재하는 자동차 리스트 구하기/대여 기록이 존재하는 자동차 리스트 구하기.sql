-- 코드를 입력하세요
SELECT DISTINCT car.CAR_ID
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY his
JOIN CAR_RENTAL_COMPANY_CAR car
ON his.car_id = car.car_id
WHERE car.car_type = '세단'
    AND TO_CHAR(start_date, 'MM') = '10'
ORDER BY car.CAR_ID DESC
;