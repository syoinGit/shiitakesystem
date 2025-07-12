-- スタッフテーブル
DROP TABLE IF EXISTS staff;

CREATE TABLE staff (
  id VARCHAR(36) PRIMARY KEY,
  name VARCHAR(50),
  login_code VARCHAR(20),
  deleted BOOLEAN DEFAULT false
);

DROP TABLE IF EXISTS house;

CREATE TABLE house (
  id VARCHAR(36) PRIMARY KEY,
  name VARCHAR(50),
  harvest_date TIMESTAMP,
  status VARCHAR(20),
  priority VARCHAR(20)
);


DROP TABLE IF EXISTS work_log;

 CREATE TABLE work_log (
     id VARCHAR(36) PRIMARY KEY,
     staff_id VARCHAR(36),
     date DATE,
     clock_in TIMESTAMP,
     clock_out TIMESTAMP,
     harvest_kg DOUBLE
 );

 DROP TABLE IF EXISTS task;

 CREATE TABLE task (
     id VARCHAR(36) PRIMARY KEY,
     worker_id VARCHAR(36),
     house_id VARCHAR(36),
     task_type VARCHAR(20),
     harvest_kg DOUBLE
 );

