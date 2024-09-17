-- 코드를 작성해주세요
SELECT EXTRACT(YEAR FROM YM) YEAR, ROUND(AVG(PM_VAL1),2) 'PM10', ROUND(AVG(PM_VAL2),2) 'PM2.5'
FROM AIR_POLLUTION
WHERE LOCATION2 = '수원'
GROUP BY EXTRACT(YEAR FROM YM)
ORDER BY YEAR;