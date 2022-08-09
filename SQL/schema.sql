/*
<<<<<<< HEAD
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS languages;
*/

CREATE TABLE IF NOT EXISTS languages
(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS books (
    id bigserial NOT NULL,
    book_name VARCHAR(75) NOT NULL,
    author VARCHAR(30),
    isbn VARCHAR(75) UNIQUE NOT NULL,
    price numeric NOT NULL,
    pages INTEGER NOT NULL,
    binding VARCHAR(30) NOT NULL,
    year_publishing INTEGER
    language_id BIGINT REFERENCES languages
=======
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
>>>>>>> 91808789275cb37ff1373a0a52ad398128afaa50
);

CREATE TABLE IF NOT EXISTS roles
(
<<<<<<< HEAD
    id BIGSERIAL PRIMARY KEY,
=======
    id   BIGSERIAL PRIMARY KEY,
>>>>>>> 91808789275cb37ff1373a0a52ad398128afaa50
    name VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS users
(
<<<<<<< HEAD
    id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    age INTEGER,
    email VARCHAR(100)UNIQUE NOT NULL,
    role_id BIGINT REFERENCES roles
);
=======
    id         BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(100)        NOT NULL,
    last_name  VARCHAR(100)        NOT NULL,
    age        INTEGER,
    email      VARCHAR(100) UNIQUE NOT NULL,
    role_id    BIGINT REFERENCES roles
);
>>>>>>> 91808789275cb37ff1373a0a52ad398128afaa50
