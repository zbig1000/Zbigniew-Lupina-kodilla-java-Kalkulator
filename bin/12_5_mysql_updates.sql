Dodanie nowego postu do tabeli POSTS.

INSERT INTO POSTS (USER_ID, BODY)
VALUES (5, "raveling to Brasil not easuy");
commit;
============
SELECT * FROM POSTS;

Modyfikacje w dodanym rekordzie warto�� pola BODY 

UPDATE POSTS
SET BODY = ("Traveling to Brasil not easy")
WHERE ID = 7
commit;
==============
Modyfikacje w dodanym rekordzie warto�� pola BODY i ustawienia jej na "To delete".
Usuni�cie dodany przed chwil� rekord.

DELETE FROM POSTS
WHERE ID = 7;
commit;

