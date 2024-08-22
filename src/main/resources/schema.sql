CREATE TABLE IF NOT EXISTS employee (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    role VARCHAR(50) NOT NULL
    );
CREATE TABLE IF NOT EXISTS task (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    task_status VARCHAR(50) NOT NULL,
    deadline DATE,
    employee_id BIGINT,
    CONSTRAINT fk_employee
    FOREIGN KEY (employee_id)
    REFERENCES employee(id)
    ON DELETE SET NULL
    );

-- INSERT INTO employee (username, password, role)
-- VALUES ('kamiloses', 'kamiloses', 'ROLE_ADMIN');