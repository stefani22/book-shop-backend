CREATE TABLE book_activities (
                                 id BIGSERIAL PRIMARY KEY,
                                 book_name VARCHAR(255) NOT NULL,
                                 event_type VARCHAR(100) NOT NULL,
                                 created_at TIMESTAMP NOT NULL
);