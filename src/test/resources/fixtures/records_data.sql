INSERT INTO records (id, classifier_id, title, active, created_at, updated_at) VALUES
('4cea1173-dfc0-4eef-b1f2-af7a59534c31', '4cea1173-dfc0-4eef-b1f2-af7a59534c28', 'Record 1', true, '2022-06-29 15:36:22.294', '2022-06-29 15:36:22.294'),
('4cea1173-dfc0-4eef-b1f2-af7a59534c32', '4cea1173-dfc0-4eef-b1f2-af7a59534c28', 'Record 2', true, '2022-06-29 15:36:22.294', '2022-06-29 15:36:22.294'),
('4cea1173-dfc0-4eef-b1f2-af7a59534c33', '4cea1173-dfc0-4eef-b1f2-af7a59534c28', 'Record 3', true, '2022-06-29 15:36:22.294', '2022-06-29 15:36:22.294'),
('4cea1173-dfc0-4eef-b1f2-af7a59534c34', '4cea1173-dfc0-4eef-b1f2-af7a59534c28', 'Record 4', false, '2022-06-29 15:36:22.294', '2022-06-29 15:36:22.294'),
('4cea1173-dfc0-4eef-b1f2-af7a59534c35', '4cea1173-dfc0-4eef-b1f2-af7a59534c28', 'Record 5', true, '2022-06-29 15:36:22.294', '2022-06-29 15:36:22.294')

ON CONFLICT DO NOTHING
;