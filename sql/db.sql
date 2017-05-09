--题目信息表
create table questionInfo(
	id int primary key,				
	questionType varchar2(50),
	content varchar2(4000),	
	forComment varchar2(4000),
	itemA varchar2(200),
	itemB varchar2(200),
	itemC varchar2(200),
	itemD varchar2(200),
	answer varchar2(4000),			
	createTime date
);
--考试场次表
create table examSerialInfo(
	id int primary key,
	forDesc varchar2(200),
	createTime date
);
--考试信息表
create table examInfo(
	id int primary key,
	questionId int,	
	examId int,		
	createTime date	
);
--角色信息表
create sequence seq_for_roleInfo start with 100001;
create table roleInfo(
	id int primary key,
	name varchar2(50),
	forDesc varchar2(50),
	createTime date  
);
--角色权限表
create table roleAccessInfo(
	id int primary key,
	roleId int,			
	pemissionId int,	
	createTime date
);
--权限信息表
create table permissionInfo(
	id int primary key,
	name varchar2(20),
	url varchar2(50),
	forDesc varchar2(100),
	createTime date				
);
--用户信息表
create table userInfo(
	id int primary key,
	roleId int,
	college varchar2(50),
	name varchar2(50),		
	img varchar2(200), 			
	sign varchar2(200), 
	pwd varchar2(50),       
	idCard varchar2(20),
	phone varchar2(20), 
	addr varchar2(100), 
	gender char(4),      
	birthday varchar2(20),     
	classId int,              
	deptId int,                
	createTime date              
);
--班级信息表
create table classInfo(
	id int primary key,
	name varchar2(50),
	deptId int,
	createTime date
);
--系别信息表
create table deptInfo(
	id int primary key,
	name varchar2(50),
	createTime date
);
--学生答题表
create table stuAnswerInfo(
	id int primary key,
 	stuId int,
	questionId int,
	examId int,
	answer varchar2(4000),
	createTime date	
);
--学生成绩表
create table stuGradeInfo(
	id int primary key,
	examId int,
	stuId int,
	grade int,
	createTime date
);
--考试题型表
create table examQuestionType(
	id int primary key,
	examId int,
	type varchar2(20),
	sum int,
	createTime date
);
