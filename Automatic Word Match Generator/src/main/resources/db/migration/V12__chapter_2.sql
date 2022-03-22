INSERT INTO book (id,title,author,account_id) VALUES (2, 'Graph Traversals', 'Evan Gertis', 1);
INSERT INTO chapter (id, title, book_id) VALUES (2,'Lesson 1',2);

UPDATE exercise
SET chapter_id = 2
WHERE id = 2;

UPDATE exercise
SET chapter_id = 2
WHERE id = 3;