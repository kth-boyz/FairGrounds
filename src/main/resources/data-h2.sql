INSERT INTO EXPERTISE (id, name) VALUES (1, 'foo');
INSERT INTO EXPERTISE (id, name) VALUES (2, 'bar');
INSERT INTO EXPERTISE (id, name) VALUES (3, 'skim');

INSERT INTO PERSON (fname, lname, username, pwd, email, ssnr, id, role) VALUES
                    ('chris', 'robberts', 'vinkelg', '123', 'asd@asd.se', '1337', 2, 'USER'),
                    ('petta', 'svensson', 'pettap3', '123', 'asd@asd.se', '1338', 3, 'USER'),
                    ('xyz','xyzxyz', 'todsss', '1232', 'taoudi123@whatver', '1234', 4,'USER'),
                    ('abc', 'asdada', 'vinkedl', '1231', 'asd@asd.se', '1337', 5, 'USER'),
                    ('a', 'svensson', 'pettafp', '1253', 'asd@asd.se', '1338', 6, 'USER'),
                    ('b', 'svensso', 'pettafasp', '1263', 'asd@asd.se', '1338', 7, 'USER'),
                    ('c', 'svenss', 'pettewrap', '123', 'asd@asd.se', '1338', 8, 'USER'),
                    ('d', 'svens', 'pettaqwep', '123', 'asd@asd.se', '1338', 9, 'USER'),
                    ('e', 'sven', 'pettasdap', '123', 'asd@asd.se', '1338', 10, 'USER'),
                    ('f', 'sve', 'pettavfdp', '123', 'asd@asd.se', '1338', 11, 'USER'),
                    ('g', 'sv', 'pettabfdgp', '123', 'asd@asd.se', '1338', 12, 'USER'),
                    ('h', 's', 'petta213p', '123', 'asd@asd.se', '1338', 13, 'USER'),
                    ('i', 'sv', 'pett123ap', '123', 'asd@asd.se', '1338', 14, 'USER'),
                    ('j', 'sve', 'pett251ap', '123', 'asd@asd.se', '1338', 15, 'USER'),
                    ('k', 'sven', 'pettaferp', '123', 'asd@asd.se', '1338', 16, 'USER'),
                    ('l', 'svens', 'pettfdap', '123', 'asd@asd.se', '1338', 17, 'USER'),
                    ('m', 'svenss', 'petyrtap', '123', 'asd@asd.se', '1338', 18, 'USER'),
                    ('n', 'svensso', 'pdsfettap', '123', 'asd@asd.se', '1338', 19, 'USER'),
                    ('o', 'svensson', 'pettap', '123', 'asd@asd.se', '1338', 20, 'USER'),
                    ('p', 'svensson', 'pewewttap', '123', 'asd@asd.se', '1338', 21, 'USER'),
                   -- ('taoudi','youssef', 'tods', '123', 'taoudi123@whatver', '1234', 1,'USER'),
                    ('chris', 'robberts', 'vinkel', '123', 'asd@asd.se', '1337', 2, 'USER'),
                    ('petta', 'svensson', 'pettap', '123', 'asd@asd.se', '1338', 3, 'USER'),
                    ('xyz','xyzxyz', 'todss', '123', 'taoudi123@whatver', '1234', 4,'USER'),
                    ('abc', 'asdada', 'vinkel', '123', 'asd@asd.se', '1337', 5, 'USER'),
                    ('yus','todi','skimmaren','$2a$10$DOvhm/LzukVhULgnymKu1urcnVDhHGNBhmlehP7AxFJflU2h/sKPK',
                    'email@email','9876567893',22,'ADMIN');

INSERT INTO APPLICATION (status, applicationdate, id, person) VALUES
('not checked', '2000-02-05 00:00:00', 2, 2),
('not checked', '2000-02-05 00:00:00', 3, 3),
('not checked', '2000-02-05 00:00:00', 4, 4),
('not checked', '2000-02-05 00:00:00', 5, 5);

INSERT INTO EXPERTISEPROFILE (id, expertise,application,years) VALUES (2,1,2,2);
INSERT INTO EXPERTISEPROFILE (id, expertise,application,years) VALUES (3,3,3,1);
INSERT INTO EXPERTISEPROFILE (id, expertise,application,years) VALUES (4,3,4,1);
INSERT INTO EXPERTISEPROFILE (id, expertise,application,years) VALUES (5,3,5,1);
INSERT INTO EXPERTISEPROFILE (id, expertise,application,years) VALUES (6,3,6,1);
INSERT INTO EXPERTISEPROFILE (id, expertise,application,years) VALUES (7,3,7,1);
INSERT INTO EXPERTISEPROFILE (id, expertise,application,years) VALUES (8,3,8,1);
INSERT INTO EXPERTISEPROFILE (id, expertise,application,years) VALUES (9,3,9,1);
INSERT INTO EXPERTISEPROFILE (id, expertise,application,years) VALUES (10,3,10,1);
INSERT INTO EXPERTISEPROFILE (id, expertise,application,years) VALUES (11,2,10,70);
INSERT INTO EXPERTISEPROFILE (id, expertise,application,years) VALUES (12,3,12,1);
INSERT INTO EXPERTISEPROFILE (id, expertise,application,years) VALUES (13,3,13,1);
INSERT INTO EXPERTISEPROFILE (id, expertise,application,years) VALUES (14,3,14,1);
INSERT INTO EXPERTISEPROFILE (id, expertise,application,years) VALUES (15,3,15,1);
INSERT INTO EXPERTISEPROFILE (id, expertise,application,years) VALUES (16,3,16,1);
INSERT INTO EXPERTISEPROFILE (id, expertise,application,years) VALUES (17,3,17,1);
INSERT INTO EXPERTISEPROFILE (id, expertise,application,years) VALUES (18,3,18,1);
INSERT INTO EXPERTISEPROFILE (id, expertise,application,years) VALUES (19,3,19,1);
INSERT INTO EXPERTISEPROFILE (id, expertise,application,years) VALUES (20,3,20,1);
INSERT INTO EXPERTISEPROFILE (id, expertise,application,years) VALUES (21,3,21,1);



INSERT INTO AVAILABILITY (id, fd, td, application) VALUES (1, '1999-01-02 00:00:00', '2000-02-05 00:00:00',2);
INSERT INTO AVAILABILITY (id, fd, td, application) VALUES (2, '2002-01-02 00:00:00', '2004-02-03 00:00:00',10);
INSERT INTO AVAILABILITY (id, fd, td, application) VALUES (3, '1999-01-02 00:00:00', '2000-02-01 00:00:00',10);

