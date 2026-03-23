INSERT INTO countries (name, continent) VALUES
                                            ('Macedonia', 'Europe'),
                                            ('United States', 'North America'),
                                            ('Italy', 'Europe');

INSERT INTO authors (name, surname, country_id, created_at, updated_at) VALUES
                                                                            ('Zivko', 'Cingo', 1, NOW(), NOW()),
                                                                            ('Colleen', 'Hover', 2, NOW(), NOW()),
                                                                            ('Italo', 'Calvino', 3, NOW(), NOW());
INSERT INTO books (name, category, author_id, state, available_copies, created_at, updated_at) VALUES
                                                                                                   ('Golemata voda', 'NOVEL', 1, 'GOOD', 10, NOW(), NOW()),
                                                                                                   ('It Starts with Us', 'DRAMA', 2, 'BAD', 5, NOW(), NOW()),
                                                                                                   ('Invisible Cities', 'FANTASY', 3, 'GOOD', 3, NOW(), NOW());
