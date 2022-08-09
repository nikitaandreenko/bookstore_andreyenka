/*
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS languages;
*/

create TABLE IF NOT EXISTS languages
(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) UNIQUE NOT NULL
);
create TABLE IF NOT EXISTS books
(
    id BIGSERIAL NOT NULL,
    book_name VARCHAR(75) NOT NULL,
    author VARCHAR(30),
    isbn VARCHAR(75) UNIQUE NOT NULL,
    price numeric NOT NULL,
    pages INTEGER NOT NULL,
    binding VARCHAR(30) NOT NULL,
    year_publishing INTEGER,
    language_id BIGINT REFERENCES languages
 );

create TABLE IF NOT EXISTS roles
(
    id   BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) UNIQUE NOT NULL
);
create TABLE IF NOT EXISTS users
(
    id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    age INTEGER,
    email VARCHAR(100)UNIQUE NOT NULL,
    role_id BIGINT REFERENCES roles
);

