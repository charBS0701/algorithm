SELECT COUNT(*) FISH_COUNT, EXTRACT(MONTH FROM TIME) MONTH
FROM FISH_INFO
GROUP BY EXTRACT(MONTH FROM TIME)
ORDER BY MONTH;