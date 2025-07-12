-- スタッフ
INSERT INTO staff (id, name, login_code, deleted) VALUES
  ('staff-001', '山田太郎', 'login001', false),
  ('staff-002', '佐藤花子', 'login002', false);

-- ハウス
INSERT INTO house (id, name, harvest_date, status, priority) VALUES
  ('house-001', '第1ハウス', '2025-07-12 09:00:00', 'READY', 'HIGH'),
  ('house-002', '第2ハウス', '2025-07-11 10:30:00', 'HARVESTED', 'LOW');

-- 作業ログ
INSERT INTO work_log (id, staff_id, date, clock_in, clock_out, harvest_kg) VALUES
  ('log-001', 'staff-001', '2025-07-12', '2025-07-12 08:00:00', '2025-07-12 17:00:00', 12.5),
  ('log-002', 'staff-002', '2025-07-11', '2025-07-11 09:00:00', '2025-07-11 16:00:00', 8.3);

-- タスク
INSERT INTO task (id, worker_id, house_id, task_type, harvest_kg) VALUES
  ('task-001', 'staff-001', 'house-001', 'HARVEST', 12.5),
  ('task-002', 'staff-002', 'house-002', 'CLEANUP', 0);