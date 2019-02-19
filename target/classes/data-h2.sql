INSERT INTO EXPERTISE (id, name) VALUES (1, 'foo');
INSERT INTO EXPERTISE (id, name) VALUES (2, 'poop');
INSERT INTO EXPERTISE (id, name) VALUES (3, 'skim');


INSERT INTO PERSON (fname, lname, uname, pwd, email, ssnr, id, role_id) VALUES
                    ('taoudi','youssef', 'tods', '123', 'taoudi123@whatver', '1234', 1,1),
                    ('chris', 'robberts', 'vinkel', '123', 'asd@asd.se', '1337', 2, 2),
                    ('petta', 'svensson', 'pettap', '123', 'asd@asd.se', '1338', 3, 3),
                    ('xyz','xyzxyz', 'tods', '123', 'taoudi123@whatver', '1234', 4,4),
                    ('abc', 'asdada', 'vinkel', '123', 'asd@asd.se', '1337', 5, 5),
                    ('a', 'svensson', 'pettap', '123', 'asd@asd.se', '1338', 6, 6),
                    ('b', 'svensso', 'pettap', '123', 'asd@asd.se', '1338', 7, 7),
                    ('c', 'svenss', 'pettap', '123', 'asd@asd.se', '1338', 8, 8),
                    ('d', 'svens', 'pettap', '123', 'asd@asd.se', '1338', 9, 9),
                    ('e', 'sven', 'pettap', '123', 'asd@asd.se', '1338', 10, 10),
                    ('f', 'sve', 'pettap', '123', 'asd@asd.se', '1338', 11, 11),
                    ('g', 'sv', 'pettap', '123', 'asd@asd.se', '1338', 12, 12),
                    ('h', 's', 'pettap', '123', 'asd@asd.se', '1338', 13, 13),
                    ('i', 'sv', 'pettap', '123', 'asd@asd.se', '1338', 14, 14),
                    ('j', 'sve', 'pettap', '123', 'asd@asd.se', '1338', 15, 15),
                    ('k', 'sven', 'pettap', '123', 'asd@asd.se', '1338', 16, 16),
                    ('l', 'svens', 'pettap', '123', 'asd@asd.se', '1338', 17, 17),
                    ('m', 'svenss', 'pettap', '123', 'asd@asd.se', '1338', 18, 18),
                    ('n', 'svensso', 'pettap', '123', 'asd@asd.se', '1338', 19, 19),
                    ('o', 'svensson', 'pettap', '123', 'asd@asd.se', '1338', 20, 20),
                    ('p', 'svensson', 'pettap', '123', 'asd@asd.se', '1338', 21, 21);



INSERT INTO APPLICATION (status, applicationdate, id, person) VALUES
('not checked', '1999-01-02 00:00:00', 1, 1),
('not checked', '2000-02-05 00:00:00', 2, 2),
('not checked', '2000-02-05 00:00:00', 3, 3),
('not checked', '2000-02-05 00:00:00', 4, 4),
('not checked', '2000-02-05 00:00:00', 5, 5),
('not checked', '2000-02-05 00:00:00', 6, 6),
('not checked', '2000-02-05 00:00:00', 7, 7),
('not checked', '2000-02-05 00:00:00', 8, 8),
('not checked', '2000-02-05 00:00:00', 9, 9),
('not checked', '2000-02-05 00:00:00', 10, 10),
('not checked', '2000-02-05 00:00:00', 11, 11),
('not checked', '2000-02-05 00:00:00', 12, 12),
('not checked', '2000-02-05 00:00:00', 13, 13),
('not checked', '2000-02-05 00:00:00', 14, 14),
('not checked', '2000-02-05 00:00:00', 15, 15),
('not checked', '2000-02-05 00:00:00', 16, 16),
('not checked', '2000-02-05 00:00:00', 17, 17),
('not checked', '2000-02-05 00:00:00', 18, 18),
('not checked', '2000-02-05 00:00:00', 19, 19),
('not checked', '2000-02-05 00:00:00', 20, 20),
('not checked', '2000-02-05 00:00:00', 21, 21);

INSERT INTO EXPERTISEPROFILE (id, expertise,application,years) VALUES (1,1,1,3);
INSERT INTO EXPERTISEPROFILE (id, expertise,application,years) VALUES (2,1,2,2);
INSERT INTO EXPERTISEPROFILE (id, expertise,application,years) VALUES (3,3,3,1);
INSERT INTO EXPERTISEPROFILE (id, expertise,application,years) VALUES (4,3,4,1);
INSERT INTO EXPERTISEPROFILE (id, expertise,application,years) VALUES (5,3,5,1);
INSERT INTO EXPERTISEPROFILE (id, expertise,application,years) VALUES (6,3,6,1);
INSERT INTO EXPERTISEPROFILE (id, expertise,application,years) VALUES (7,3,7,1);
INSERT INTO EXPERTISEPROFILE (id, expertise,application,years) VALUES (8,3,8,1);
INSERT INTO EXPERTISEPROFILE (id, expertise,application,years) VALUES (9,3,9,1);
INSERT INTO EXPERTISEPROFILE (id, expertise,application,years) VALUES (10,3,10,1);
INSERT INTO EXPERTISEPROFILE (id, expertise,application,years) VALUES (11,3,11,1);
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


INSERT INTO AVAILABILITY (id, fd, td, application) VALUES (1, '1999-01-02 00:00:00', '2000-02-05 00:00:00',1);
INSERT INTO AVAILABILITY (id, fd, td, application) VALUES (2, '2002-01-02 00:00:00', '2004-02-03 00:00:00',2);
INSERT INTO AVAILABILITY (id, fd, td, application) VALUES (3, '1999-01-02 00:00:00', '2000-02-01 00:00:00',1);