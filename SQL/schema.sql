/*
 DROP TABLE IF EXISTS users;
 DROP TABLE IF EXISTS roles;
 DROP TABLE IF EXISTS books;
 DROP TABLE IF EXISTS languages;
 */

CREATE TABLE IF NOT EXISTS languages
(
    id   BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS books
(
    id              bigserial                    NOT NULL,
    book_name       character varying(75)        NOT NULL,
    author          character varying(30),
    isbn            character varying(75) UNIQUE NOT NULL,
    price           numeric                      NOT NULL,
    pages           integer                      NOT NULL,
    binding         character varying(30)        NOT NULL,
    year_publishing integer,
    language_id     BIGINT REFERENCES languages
);

CREATE TABLE IF NOT EXISTS roles
(
    id   BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS users
(
    id         BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(100)        NOT NULL,
    last_name  VARCHAR(100)        NOT NULL,
    age        INTEGER,
    email      VARCHAR(100) UNIQUE NOT NULL,
    role_id    BIGINT REFERENCES roles
);
