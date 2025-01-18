--카테고리 초기 설정
INSERT INTO category
VALUES(CATEGORY_category_no_SEQ.nextval,'업무');
INSERT INTO category
VALUES(CATEGORY_category_no_SEQ.nextval,'공부');
INSERT INTO category
VALUES(CATEGORY_category_no_SEQ.nextval,'습관');
INSERT INTO category
VALUES(CATEGORY_category_no_SEQ.nextval,'기타');

--권한 초기 설정
INSERT INTO roles
VALUES(ROLES_role_no_SEQ.nextval, 'admin');
INSERT INTO roles
VALUES(ROLES_role_no_SEQ.nextval, 'user');

--유저 1
INSERT INTO users
VALUES(USERS_user_no_SEQ.nextval, 'test','$2a$10$0H7PRpTgR565XlJj.5Sxj.rDeWGcL.SfPJShHkq//pFXkmoWrgJYi','aaa@naver.com');
INSERT INTO USER_ROLES
VALUES(USER_ROLES_user_role_no_SEQ.nextval, USERS_user_no_SEQ.currval, 2);

--유저 2
INSERT INTO users
VALUES(USERS_user_no_SEQ.nextval, 'test2','2222','bbb@gmail.com');
INSERT INTO USER_ROLES
VALUES(USER_ROLES_user_role_no_SEQ.nextval, USERS_user_no_SEQ.currval, 2);
--admin
INSERT INTO users
VALUES(USERS_user_no_SEQ.nextval, 'admin','admin','관리자');
INSERT INTO USER_ROLES
VALUES(USER_ROLES_user_role_no_SEQ.nextval, USERS_user_no_SEQ.currval, 1);

--Task 추가
--유저1번의 task
INSERT INTO task
VALUES(TASK_task_no_SEQ.nextval,'회의 준비','주제선정 회의',sysdate,sysdate,'active',1,1);
INSERT INTO task
VALUES(TASK_task_no_SEQ.nextval,'오전 업무','메일 확인',sysdate,sysdate,'active',1,1);
INSERT INTO task
VALUES(TASK_task_no_SEQ.nextval,'개발공부','백엔드 프로젝트 수정',sysdate,sysdate,'active',2,1);

commit;