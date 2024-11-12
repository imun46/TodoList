DROP TABLE USER_ROLES CASCADE CONSTRAINTS;
DROP TABLE ROLES CASCADE CONSTRAINTS;
DROP TABLE TASK CASCADE CONSTRAINTS;
DROP TABLE CATEGORY CASCADE CONSTRAINTS;
DROP TABLE USERS CASCADE CONSTRAINTS;

/**********************************/
/* Table Name: USERS */
/**********************************/
CREATE TABLE USERS(
		user_no                       		NUMBER(10)		 NULL ,
		id                            		VARCHAR2(100)		 NOT NULL,
		password                      		VARCHAR2(100)		 NOT NULL,
		email                         		VARCHAR2(100)		 NOT NULL
);

DROP SEQUENCE USERS_user_no_SEQ;

CREATE SEQUENCE USERS_user_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;


/**********************************/
/* Table Name: CATEGORY */
/**********************************/
CREATE TABLE CATEGORY(
		category_no                   		NUMBER(10)		 NULL ,
		name                          		VARCHAR2(100)		 NULL 
);

DROP SEQUENCE CATEGORY_category_no_SEQ;

CREATE SEQUENCE CATEGORY_category_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;


/**********************************/
/* Table Name: TASK */
/**********************************/
CREATE TABLE TASK(
		task_no                       		NUMBER(10)		 NULL ,
		title                         		VARCHAR2(100)		 NOT NULL,
		content                       		VARCHAR2(200)		 NULL ,
		startDate                     		DATE		 DEFAULT sysdate		 NULL ,
		endDate                       		DATE		 NULL ,
		state                         		VARCHAR2(10)		 DEFAULT 'active'		 NULL ,
		user_no                       		NUMBER(10)		 NULL ,
		category_no                   		NUMBER(10)		 NULL 
);

DROP SEQUENCE TASK_task_no_SEQ;

CREATE SEQUENCE TASK_task_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;


/**********************************/
/* Table Name: ROLES */
/**********************************/
CREATE TABLE ROLES(
		role_no                       		NUMBER(10)		 NULL ,
		name                          		VARCHAR2(50)		 NULL 
);

DROP SEQUENCE ROLES_role_no_SEQ;

CREATE SEQUENCE ROLES_role_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;


/**********************************/
/* Table Name: USER_ROLES */
/**********************************/
CREATE TABLE USER_ROLES(
		userRole_no                   		NUMBER(10)		 NULL ,
		role_no                       		NUMBER(10)		 DEFAULT 2 NULL ,
		user_no                       		NUMBER(10)		 NULL 
);

DROP SEQUENCE USER_ROLES_userRole_no_SEQ;

CREATE SEQUENCE USER_ROLES_userRole_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



ALTER TABLE USERS ADD CONSTRAINT IDX_USERS_PK PRIMARY KEY (user_no);

ALTER TABLE CATEGORY ADD CONSTRAINT IDX_CATEGORY_PK PRIMARY KEY (category_no);

ALTER TABLE TASK ADD CONSTRAINT IDX_TASK_PK PRIMARY KEY (task_no);
ALTER TABLE TASK ADD CONSTRAINT IDX_TASK_FK0 FOREIGN KEY (user_no) REFERENCES USERS (user_no);
ALTER TABLE TASK ADD CONSTRAINT IDX_TASK_FK1 FOREIGN KEY (category_no) REFERENCES CATEGORY (category_no);

ALTER TABLE ROLES ADD CONSTRAINT IDX_ROLES_PK PRIMARY KEY (role_no);

ALTER TABLE USER_ROLES ADD CONSTRAINT IDX_USER_ROLES_PK PRIMARY KEY (userRole_no);
ALTER TABLE USER_ROLES ADD CONSTRAINT IDX_USER_ROLES_FK0 FOREIGN KEY (role_no) REFERENCES ROLES (role_no);
ALTER TABLE USER_ROLES ADD CONSTRAINT IDX_USER_ROLES_FK1 FOREIGN KEY (user_no) REFERENCES USERS (user_no);

