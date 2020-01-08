Drop Table IF EXISTS tasks;

CREATE TABLE IF NOT EXISTS tasks (
    id          INT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(1000) NOT NULL
);

INSERT INTO tasks (description) VALUES
    ('Eat Dinner'),
    ('Wash the dishes'),
    ('Walk the dog');
