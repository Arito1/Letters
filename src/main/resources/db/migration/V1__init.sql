CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(255),
    password VARCHAR(255),
    letter TEXT
);

INSERT INTO users (username, password, letter)
VALUES
    ('Arito', 'arthur123', 'Админ может создавать письма для пользователей.'),
    ('test', 'test123', 'Привет! Это тестовое письмо пользователя.');