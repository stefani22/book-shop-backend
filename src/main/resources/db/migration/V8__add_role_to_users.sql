ALTER TABLE users ADD COLUMN role VARCHAR(255);

UPDATE users SET role = 'ROLE_ADMINISTRATOR' WHERE username = 'admin';

INSERT INTO users (username, password, role)
SELECT 'user', '$2a$10$Mi8DwYUaHCxFkoobnkUabuynlgBw50ehDPmZSUXXkHvFec5HIQK4W', 'ROLE_USER'
    WHERE NOT EXISTS (SELECT 1 FROM users WHERE username = 'user');