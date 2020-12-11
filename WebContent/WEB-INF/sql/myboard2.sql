DROP TABLE member;
CREATE TABLE member (
    memberid VARCHAR2(50) PRIMARY KEY,
    name VARCHAR2(20) NOT NULL,
    password VARCHAR2(50) NOT NULL,
    regdate DATE not null
);

select * from member;


CREATE TABLE article (
    article_no NUMBER GENERATED AS IDENTITY,
    writer_id VARCHAR2(50) NOT NULL,
    writer_name VARCHAR2(50) NOT NULL,
    title VARCHAR2(255) NOT NULL,
    regdate DATE NOT NULL,
    moddate DATE NOT NULL,
    read_cnt NUMBER,
    PRIMARY KEY (article_no)
);

drop table article; 

select * from article;
select * from article_content;

CREATE TABLE article_content(
article_no NUMBER PRIMARY KEY,
content VARCHAR2(4000)
);

-- page 처리

SELECT COUNT(*) FROM article;

INSERT INTO article (writer_id, writer_name, title, regdate, moddate, read_cnt)
VALUES ('a', 'a', 'a', sysdate, sysdate, 0);

SELECT * FROM article ORDER BY article_no DESC;

SELECT * FROM (SELECT article_no, title, ROW_NUMBER() OVER(ORDER BY article_no DESC) rn FROM article) WHERE rn BETWEEN 1 AND 5;