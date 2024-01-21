CREATE TABLE users (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  lastname VARCHAR(255) NOT NULL,
  dni VARCHAR(9) NOT NULL,
  born_day DATE NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE libros (
  id INT NOT NULL AUTO_INCREMENT,
  title VARCHAR(255) NOT NULL,
  author VARCHAR(255) NOT NULL,
  isbn VARCHAR(13) NOT NULL,
  publication_day DATE NOT NULL,
  state VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE prestamos (
  id INT NOT NULL AUTO_INCREMENT,
  user_id INT NOT NULL,
  book_id INT NOT NULL,
  borrowed_day DATE NOT NULL,
  return_day DATE,
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (book_id) REFERENCES books (id)
);