insert into user (id, user_name, password) VALUES (1, "root", "test123");
insert into account (id, user_id, billing_address, billing_province, billing_country, zip, phone_number) VALUES (1, 1, "123 fake street", "NY", "US", "14530", "555-123-4165");
insert into book (id, title, author, account_id) VALUES (1, "How to program", "Evan Gertis", 1);
insert into chapter (id, title, book_id) VALUES (1,"Lesson 1", 1);
insert into exercise (id,one,answer,two,three,exercise,question,chapter_id) VALUES (1,"hello",3,"hello wor","hello world","HelloWorld.txt","What is the output from this program?",1);
