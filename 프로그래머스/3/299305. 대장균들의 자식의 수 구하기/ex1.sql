SELECT 
    e1.ID, 
    COUNT(e2.ID) AS CHILD_COUNT
FROM 
    ECOLI_DATA e1
LEFT JOIN 
    ECOLI_DATA e2 ON e1.ID = e2.PARENT_ID
GROUP BY 
    e1.ID
ORDER BY 
    e1.ID;

-- ECOLI_DATA 테이블을 e1과 e2 두 번 사용하여 자기 조인을 합니다. e1은 부모 개체를 나타내고, e2는 자식 개체를 나타냅니다.
-- LEFT JOIN을 사용하여 e1.ID와 e2.PARENT_ID가 일치하는 행을 연결합니다. LEFT JOIN을 사용하면 자식이 없는 개체도 포함됩니다.
-- GROUP BY를 사용하여 각 부모 개체의 ID별로 그룹화합니다.
-- 각 그룹에 대해 자식 개체의 수를 세고, 이를 CHILD_COUNT로 지정합니다.
-- 결과를 부모 개체의 ID에 대해 오름차순으로 정렬합니다.
-- 이 쿼리를 실행하면, 각 개체의 ID와 자식의 수를 오름차순으로 정렬한 결과를 얻을 수 있습니다.
