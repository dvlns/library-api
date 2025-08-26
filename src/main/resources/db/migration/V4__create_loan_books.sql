CREATE TABLE loan_books (
    loan_id BIGINT NOT NULL,
    book_id BIGINT NOT NULL,

    CONSTRAINT fk_loan FOREIGN KEY (loan_id) REFERENCES loans (id) ON DELETE CASCADE,
    CONSTRAINT fk_book FOREIGN KEY (book_id) REFERENCES books (id) ON DELETE CASCADE,
    CONSTRAINT pk_loan_books PRIMARY KEY (loan_id, book_id)
);
