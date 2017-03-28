/*
 * 每个表都要考虑到方便记录日志，添加时间为基本原则
 * 
 * 
 * 如果将数据都存在redis，采用观察者模式，及时改变redis中的数据
 * */

/*
 * 要不要记录登录日志呢，每次操作都要记录日志还是关键操作要记录日志？
 * */

--选择题
create sequence seq_for_chooseObj start with 100001;
create table chooseObj(
	id int primary key,			--主键
	content varchar2(4000),		--内容
	comment varchar2(4000),		--解析
	itemA varchar2(200),
	itemB varchar2(200),
	itemC varchar2(200),
	itemD varchar2(200),
	answer char(4),				--答案：A,B,C,D
	occurTime date				--题目存进去的时间
);
--填空题，判断题，程序题等
create sequence seq_for_blankObj start with 100001;
create table blankObj(
	id int primary key,
	content varchar2(4000),
	comment varchar2(4000),
	answer varchar2(200),
	occurTime date
);
--通过角色和用户来区分
--角色表：管理员，教师，学生
create sequence seq_for_roleObj start with 100001;
create table roleObj(
	roleId int primary key,
	roleName varchar2(50),
	roleDesc varchar2(50),
	occurTime date	
);
--用户表：学生才会有班级和系别
create sequence seq_for_userObj start with 100001;
create table userObj(
	stuId int primary key,	--学号
	roleId int,				--角色
	stuName varchar2(50),	--姓名
	stuImg varchar2(200),	--学生头像
	sign varchar2(200),		--个性签名
	stuPwd varchar2(50),	--学生登录密码
	idCard varchar2(20),	--身份证号
	phone varchar2(20),		--手机号码
	stuAddr varchar2(100),	--住址
	stuGender char(4),		--性别
	birthday date,			--出生日期
	classId int,			--班级
	deptId int,				--系别
	occurTime date			--注册时间
);
--班级信息表
create sequence seq_for_classObj start with 100001;
create table classObj(
	classId int primary key,
	className varchar2(50),
	deptId int,
	occurTime date
);
--系别信息表
create sequence seq_for_deptObj start with 100001;
create table deptObj(
	deptId int primary key,
	deptName varchar2(50),
	occurTime date
);
--学生成绩表
create sequence seq_for_stuGradeObj start with 100001;
create table stuGradeObj(
	id int primary key,
	stuId int,
	stuGrade int,
	occurTime date
);