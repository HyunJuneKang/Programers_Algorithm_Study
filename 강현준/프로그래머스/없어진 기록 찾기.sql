-- 천재지변으로 인해 일부 데이터가 유실되었습니다. 
-- 입양을 간 기록은 있는데, 
-- 보호소에 들어온 기록이 없는 동물의 ID와 이름을 ID 순으로 조회하는 SQL문을 작성해주세요.
SELECT i.ANIMAL_ID , i.NAME
        FROM ANIMAL_OUTS i
        LEFT OUTER JOIN ANIMAL_INS o 
        ON i.ANIMAL_ID = o.ANIMAL_ID
        WHERE o.ANIMAL_ID IS NULL
        ORDER BY ANIMAL_ID,NAME;