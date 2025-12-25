CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);
CREATE TABLE letters (
    id BIGSERIAL PRIMARY KEY,
    text VARCHAR(255)
);
CREATE TABLE users_letters (
    user_id BIGINT NOT NULL,
    letter_id BIGINT NOT NULL,

    CONSTRAINT pk_users_letters PRIMARY KEY (user_id, letter_id),
    CONSTRAINT fk_users_letters_user
        FOREIGN KEY (user_id)
            REFERENCES users (id)
            ON DELETE CASCADE,

    CONSTRAINT fk_users_letters_letter
        FOREIGN KEY (letter_id)
            REFERENCES letters (id)
            ON DELETE CASCADE
);
