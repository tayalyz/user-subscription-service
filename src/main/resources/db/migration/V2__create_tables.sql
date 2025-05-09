CREATE TABLE users
(
    id   BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);

-- CREATE TYPE subscription_type AS ENUM ('YOUTUBE', 'NETFLIX', 'YANDEX_PLUS', 'VK_MUSIC');

CREATE TABLE subscriptions
(
    id                BIGSERIAL PRIMARY KEY,
    subscription_type VARCHAR(255) NOT NULL CHECK (subscription_type IN ('YOUTUBE', 'NETFLIX', 'YANDEX_PLUS', 'VK_MUSIC')),
    user_id           BIGINT       NOT NULL,
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);