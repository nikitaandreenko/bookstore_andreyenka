CREATE TABLE books (
    id bigserial NOT NULL,
    book_name character varying(75) NOT NULL,
    author character varying(30),
    isbn character varying(75) UNIQUE NOT NULL,
    price numeric NOT NULL,
    pages integer NOT NULL,
    binding character varying(30) NOT NULL,
    year_publising integer
);

INSERT INTO books (book_name, author, isbn, price, pages, binding, year_publising) 
VALUES ('it starts us', 'Collen Hoover', '978-1668001226', 11.99, 366, 'solid', 2022),
               ('I train update books', 'Collen Hoover', '978-1533723738', 11.99, 326, 'solid', 2019),
               ('Beautiful Ruins', 'Jess Walter', '978-1668001228', 13.79, 372, 'solid', 2014),
               ('Ugly love', 'Collen Hooveer', '978-1476753188', 11.86, 437, 'soft', 2004),
               ('Every Summer After', 'Carley Fortune', '978-0593438534', 11.40, 320, 'solid', 2020),
               ('The Very Hungry Caterpillar', 'Eric Carle', '978-0399226908', 5.74, 26, 'soft', 2013),
               ('Book Lovers', 'Emily Henry', ' 978-0593334836', 9.99, 400, 'solid', 2015),
               ('Big Prescool', 'Joan Hoffman', '978-0887431456', 5.99, 420, 'solid', 2022),
               ('The Silent Patient', 'Alex Michaelides', '978-1250301703', 12.99, 368, 'solid', 2019),
               ('The Power of Now', 'Eckhart Tolle', '978-1577314806', 11.99, 236, 'soft', 2021),
               ('The Lord of the Rings Part One', 'J.R.R. Tolkien', '978-0063270886', 14.89, 432, 'solid', 2016),
               ('Fire & Blood: 300 Years Before A Game of Thrones', 'George R. R. Martin', '978-0063270835', 24.89, 754, 'solid', 2014),
               ('Maybe Someday', 'Colleen Hoover', '978-1476753164', 11.62, 384, 'solid', 2017),
               ('Harry Potter Spellbook: The Unofficial ', 'Newt Flamel', '979-8447208332', 7.95, 100, 'solid', 2021),
               ('Harry Potter and the Goblet of Fire ', 'J. K. Rowling', '978-0545791427', 13.99, 464, 'solid', 2021),
               ('Harry Potter and the Sorcerer Stone', 'J. K. Rowling', '978-0545791422', 13.13, 345, 'solid', 2019),
               ('Harry Potter and the Chamber of Secrets', 'J. K. Rowling', '978-1338716535', 7.80, 400, 'solid', 2017),
               ('Sparring Partners: Novellas', 'John Grisham', '978-1338715534', 16.50, 350, 'soft', 2009),
               ('A Time for Mercy', 'John Grisham', '978-1338725536', 7.50, 469, 'soft', 2010),
               ('Mastering the Art of French Cooking', 'Julia Child', '978-1238725736', 19.50, 1244, 'soft', 2015),
               ('A Letter From Your Teacher: On the First Day of School', 'Shannon Olsen', '978-1735414126', 13.99, 31, 'soft', 2007);


