-- Users table
CREATE TABLE forum_user (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    enabled BOOLEAN NOT NULL
);

-- Roles table
CREATE TABLE role (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(50) UNIQUE NOT NULL
);

-- User roles join table
CREATE TABLE user_roles (
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES forum_user (id),
    FOREIGN KEY (role_id) REFERENCES role (id)
);

-- Topics table
CREATE TABLE topic (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    message TEXT NOT NULL,
    creation_date TIMESTAMP NOT NULL,
    status VARCHAR(50) NOT NULL,
    author_id BIGINT NOT NULL,
    course VARCHAR(255) NOT NULL,
    FOREIGN KEY (author_id) REFERENCES forum_user (id)
);

-- Insert default roles
INSERT INTO role (name) VALUES ('USER'), ('ADMIN');