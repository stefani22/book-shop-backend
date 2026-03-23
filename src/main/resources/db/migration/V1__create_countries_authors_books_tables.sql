CREATE TABLE countries (
        id BIGSERIAL PRIMARY KEY,
        name VARCHAR(255) NOT NULL UNIQUE,
        continent VARCHAR(255) NOT NULL
);

CREATE TABLE authors (
        id BIGSERIAL PRIMARY KEY,
        created_at TIMESTAMP NOT NULL,
        updated_at TIMESTAMP NOT NULL,
        name VARCHAR(255) NOT NULL,
        surname VARCHAR(255) NOT NULL,
        country_id BIGINT NOT NULL,
        CONSTRAINT fk_author_country
            FOREIGN KEY (country_id)
            REFERENCES countries(id)
            ON DELETE CASCADE
);

CREATE TABLE books (
        id BIGSERIAL PRIMARY KEY,
        created_at TIMESTAMP NOT NULL,
        updated_at TIMESTAMP NOT NULL,
        name VARCHAR(255) NOT NULL,
        category VARCHAR(50),
        author_id BIGINT NOT NULL,
        state VARCHAR(50),
        available_copies INTEGER,
        CONSTRAINT fk_book_author
            FOREIGN KEY (author_id)
            REFERENCES authors(id)
            ON DELETE CASCADE
);
