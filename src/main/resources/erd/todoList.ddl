DROP TABLE TASK CASCADE CONSTRAINTS;
DROP TABLE USERS CASCADE CONSTRAINTS;

CREATE TABLE USERS(
		user_no                       		NUMBER(10)		 NULL ,
		name                          		VARCHAR2(100)		 NOT NULL,
		password                      		VARCHAR2(100)		 NOT NULL,
		email                         		VARCHAR2(100)		 NOT NULL
);

DROP SEQUENCE USERS_user_no_SEQ;

CREATE SEQUENCE USERS_user_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;


CREATE TABLE TASK(
		task_no                       		NUMBER(10)		 NULL ,
		title                         		VARCHAR2(100)		 NOT NULL,
		content                       		VARCHAR2(200)		 NULL ,
		category                      		VARCHAR2(100)		 NULL ,
		startDate                     		DATE		 DEFAULT 'sysdate'		 NULL ,
		endDate                       		DATE		 NULL ,
		state                         		VARCHAR2(10)		 DEFAULT active		 NULL ,
		user_no                       		VARCHAR2(10)		 NULL 
);

DROP SEQUENCE TASK_task_no_SEQ;

CREATE SEQUENCE TASK_task_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;


ALTER TABLE USERS ADD CONSTRAINT IDX_USERS_PK PRIMARY KEY (user_no);

ALTER TABLE TASK ADD CONSTRAINT IDX_TASK_PK PRIMARY KEY (task_no);
ALTER TABLE TASK ADD CONSTRAINT IDX_TASK_FK0 FOREIGN KEY (user_no) REFERENCES USERS (user_no);

