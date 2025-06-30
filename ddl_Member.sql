CREATE TABLE book.member
(
    seq        BIGINT       NOT NULL,
    user_email VARCHAR(255) NOT NULL,
    password   VARCHAR(255) NOT NULL,
    name       VARCHAR(255) NOT NULL,
    nickname   VARCHAR(255) NOT NULL,
    CONSTRAINT pk_member PRIMARY KEY (seq)
);

ALTER TABLE book.member
    ADD CONSTRAINT uc_member_useremail UNIQUE (user_email);