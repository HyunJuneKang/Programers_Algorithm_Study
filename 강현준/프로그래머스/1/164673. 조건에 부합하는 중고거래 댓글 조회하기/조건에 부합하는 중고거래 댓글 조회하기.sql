-- 코드를 입력하세요
--  2022년 10월에 작성된 게시글 제목, 게시글 ID, 댓글 ID, 댓글 작성자 ID, 댓글 내용, 댓글 작성일을 조회하는 SQL문을 작성
-- 결과는 댓글 작성일을 기준으로 오름차순 정렬해주시고, 댓글 작성일이 같다면 게시글 제목을 기준으로 오름차순 정렬
SELECT TITLE,BOARD_ID,REPLY_ID,r.WRITER_ID,r.CONTENTS,r.CREATED_DATE
FROM USED_GOODS_BOARD b JOIN USED_GOODS_REPLY r USING (BOARD_ID)
WHERE b.CREATED_DATE BETWEEN "20221001" AND "20221031"
ORDER BY r.CREATED_DATE ASC , b.TITLE ASC;