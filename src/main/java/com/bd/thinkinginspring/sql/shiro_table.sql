use thinkinginmysql;

DROP TABLE if exists role_info;
create TABLE IF not EXISTS  role_info
(
	id int PRIMARY key auto_increment;
	role_name varchar(100)
);

DROP TABLE if exists user_info;
create TABLE IF not EXISTS user_info(
	id int PRIMARY key auto_increment;
	user_name varchar(100),
	password VARCHAR(100)
);


DROP TABLE if exists user_role;
create TABLE IF not EXISTS  user_role
(
	id int PRIMARY key auto_increment;
	user_id INT,
	role_id INT
);

DROP TABLE if exists permission_role;
create TABLE IF not EXISTS  permission_role
(
	id int PRIMARY key auto_increment;
	permission_name varchar(100),
	role_id INT
);

