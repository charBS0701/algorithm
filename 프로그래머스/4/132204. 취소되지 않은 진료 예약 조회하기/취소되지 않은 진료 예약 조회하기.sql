-- 코드를 입력하세요
-- 2022년 4월 13일 취소되지 않은 흉부외과(CS) 진료 예약 내역
-- 진료예약번호, 환자이름, 환자번호, 진료과코드, 의사이름, 진료예약일시
-- 진료예약일시를 기준으로 오름차순
SELECT sub.APNT_NO, p.PT_NAME, p.PT_NO, d.MCDP_CD, d.DR_NAME, sub.APNT_YMD
FROM (
    SELECT *
    FROM APPOINTMENT
    WHERE TO_CHAR(APNT_YMD,'YYYYMMDD') = '20220413'
        AND APNT_CNCL_YN = 'N'
        AND MCDP_CD = 'CS') sub,
    PATIENT p, DOCTOR d
WHERE sub.PT_NO = p.PT_NO AND sub.MDDR_ID=DR_ID
ORDER BY APNT_YMD ASC;