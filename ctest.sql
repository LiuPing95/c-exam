--for test
--select t.*, t.rowid from CLASSINFO t
create table test(
	now date 
);
--insert  into test values(sysdate)
--select * from test where now = to_date('2017-03-16 23-37-18','yyyy-MM-dd HH24-mi-ss')
-----------------------------------------------------------------------------------------
--alter table questionInfo add (type varchar2(10));
--drop table questionInfo;
--question table
delete from questionInfo;
create sequence seq_for_questionInfo start with 100001;
create table questionInfo(
	id int primary key,				
	questionType varchar2(50),		--the question type
	content varchar2(4000),			--the question content
	forComment varchar2(4000),		--comment for question
	itemA varchar2(200),
	itemB varchar2(200),
	itemC varchar2(200),
	itemD varchar2(200),
	answer varchar2(4000),			
	createTime date
);
update questionInfo set answer='A' where id>100081 and id<=100100;
commit;
select * from(
			select c.*,rownum rn 
			from (select * from questionInfo) c
			where rownum > 0
		)
		where 10 >= rn
--select * from questionInfo;
-----------------------------------------------------------------------------------------
--examination serial number
create sequence seq_for_examSerialInfo start with 100001;
create table examSerialInfo(
	id int primary key,
	forDesc varchar2(200),
  status int,
	createTime date
);
select * from examSerialInfo
commit;
drop table examSerialInfo
-----------------------------------------------------------------------------------------
--some question for one examination
create sequence seq_for_examInfo start with 100001;
create table examInfo(
	id int primary key,
	questionId int,			--which question
	examId int,				--which examination
	createTime date			--examination date
);
-----------------------------------------------------------------------------------------
--role table 
create sequence seq_for_roleInfo start with 100001;
create table roleInfo(
	id int primary key,
	name varchar2(50),
	forDesc varchar2(50),
	createTime date  
);
insert into roleInfo(id,name,Fordesc,Createtime) values (seq_for_roleinfo.nextval,'教师','较多权限',sysdate);
--select * from roleInfo;
-----------------------------------------------------------------------------------------
--roleAccess table
create sequence seq_for_roleAccessInfo start with 100001;
create table roleAccessInfo(
	id int primary key,
	roleId int,				--which role
	pemissionId int,		--which permission
	createTime date
);
select * from Roleaccessinfo;
insert into Roleaccessinfo(id,roleId,Pemissionid,Createtime) values(seq_for_roleAccessInfo.Nextval,100001,1000024,sysdate);
commit;

-----------------------------------------------------------------------------------------
create sequence seq_for_permissionInfo start with 100001;
create table permissionInfo(
	id int primary key,
	name varchar2(20),		--
	url varchar2(50),		--
	forDesc varchar2(100),	--for description
	createTime date				
);
select * from permissioninfo;
insert into permissioninfo(id,name,url,forDesc,createtime) values(seq_for_permissionInfo.Nextval,'权限管理','/permission/list','管理所有权限',sysdate);
-----------------------------------------------------------------------------------------
--drop table userInfo;
--select seq_for_userInfo.Nextval from dual;
--user table
create sequence seq_for_userInfo start with 100001;
create table userInfo(
	id int primary key,
	roleId int,
	college varchar2(50),		--which university
	name varchar2(50),		
	img varchar2(200), 			
	sign varchar2(200), 
	pwd varchar2(50),   		--for login in      
	idCard varchar2(20),   		--for login in
	phone varchar2(20),    		--for login in
	addr varchar2(100), 
	gender char(4),      
	birthday varchar2(20),     
	classId int,              
	deptId int,                
	createTime date              
);
update userinfo set phone='15675974359';
update userinfo set idcard='430581199501276010';
update userinfo set sign='时光静好，与君语；细水流年，与君同。';
commit;
--锟斤拷页锟斤拷询
select * from userInfo
(select u.*,rownum rn from userInfo u where rownum < 10)
where rn > 0

--select * from userInfo;
-----------------------------------------------------------------------------------------
--class table
--select * from classInfo;
create sequence seq_for_classInfo start with 100001;
create table classInfo(
	id int primary key,
	name varchar2(50),
	deptId int,
	createTime date
);
insert into classInfo(id,name,Deptid,Createtime) values(seq_for_classinfo.nextval,'物联网工程',100001,sysdate);
-----------------------------------------------------------------------------------------
--insert into deptInfo(id,name,createTime) select seq_for_deptInfo.Nextval,'engeneering',sysdate from dual union select seq_for_deptInfo.Nextval,'系锟斤拷2',sysdate from dual;
--department table
create sequence seq_for_deptInfo start with 100001;
create table deptInfo(
	id int primary key,
	name varchar2(50),
	createTime date
);
insert into deptInfo(id,name) values select 11,'fsdf' from dual union select 21,'fsdf' from dual);
insert all into deptInfo(id) values(seq_for_deptInfo.Nextval)
           into deptInfo(id) values(seq_for_deptInfo.Nextval)
           select 1 from dual;
--select * from deptInfo;
-----------------------------------------------------------------------------------------
--answer record for exam of students
create sequence seq_for_stuAnswerInfo start with 100001;
create table stuAnswerInfo(
	id int primary key,
 	stuId int,					--which student
	questionId int,				--which question
	examId int, 				--which examination
	answer varchar2(4000), 		--answer of the question
	createTime date				--when the event occur
);
-----------------------------------------------------------------------------------------
--student examination result
create sequence seq_for_stuGradeInfo start with 100001;
create table stuGradeInfo(
	id int primary key,
	examId int, 		--which examination
	stuId int,			--which student 
	grade int,			--how many score the student got
	createTime date
);
--select * from stuGradeInfo;
-----------------------------------------------------------------------------------------
create sequence seq_for_examQuestionType start with 100001;
create table examQuestionType(
	id int primary key,
	examId int,
	type varchar2(20),
	sum int,
	createTime date
);
delete from userInfo where name in ('na','n') or id in (1,2)
--batch and multuple condition delete
delete from userInfo where exists
(
  select * from userInfo where name='name' and id=100001
  union
  select * from userInfo where name='name' and id=100002
)
