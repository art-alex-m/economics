INSERT INTO classifier(id, title, active, main, description, created_at, updated_at) VALUES
('4cea1173-dfc0-4eef-b1f2-af7a59534c28', 'Test classifier', true, false, 'Test classifier description', '2022-06-29 15:36:22.294', '2022-06-29 15:36:22.294')

ON CONFLICT DO NOTHING
;