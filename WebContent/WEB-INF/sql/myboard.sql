DROP TABLE member;
CREATE TABLE member (
    memberid VARCHAR2(50) PRIMARY KEY,
    name VARCHAR2(20) NOT NULL,
    password VARCHAR2(10) NOT NULL,
    regdate DATE not null
);

select * from member;