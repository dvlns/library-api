CREATE TABLE loans (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    loan_date DATE NOT NULL,
    return_date DATE,
    returned BOOLEAN DEFAULT FALSE,

    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users (id)
);
