-- 依存関係に配慮して削除
DROP TABLE IF EXISTS task;
DROP TABLE IF EXISTS work_log;
DROP TABLE IF EXISTS house;
DROP TABLE IF EXISTS staff;

-- スタッフテーブル
CREATE TABLE staff (
  id VARCHAR(36) PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  login_code VARCHAR(20) NOT NULL,
  deleted BOOLEAN DEFAULT FALSE
);

-- ハウステーブル
CREATE TABLE house (
  id VARCHAR(36) PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  harvest_date TIMESTAMP,
  status VARCHAR(20) NOT NULL,
  priority VARCHAR(20) NOT NULL
);

-- 作業ログテーブル（❌ work_log_id は不要）
CREATE TABLE work_log (
  id VARCHAR(36) PRIMARY KEY,
  staff_id VARCHAR(36) NOT NULL,
  date DATE NOT NULL,
  clock_in TIMESTAMP,
  clock_out TIMESTAMP,
  harvest_kg DOUBLE,
  FOREIGN KEY (staff_id) REFERENCES staff(id)
);

-- タスクテーブル（✅ こっちに work_log_id を追加）
CREATE TABLE task (
  id VARCHAR(36) PRIMARY KEY,
  worker_id VARCHAR(36) NOT NULL,
  house_id VARCHAR(36) NOT NULL,
  task_type VARCHAR(20) NOT NULL,
  work_log_id VARCHAR(36),
  FOREIGN KEY (worker_id) REFERENCES staff(id),
  FOREIGN KEY (house_id) REFERENCES house(id),
  FOREIGN KEY (work_log_id) REFERENCES work_log(id)
);