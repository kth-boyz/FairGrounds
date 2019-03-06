INSERT INTO EXPERTISE (id, name) VALUES (1, 'foo');
INSERT INTO EXPERTISE (id, name) VALUES (2, 'bar');
INSERT INTO EXPERTISE (id, name) VALUES (3, 'skim');

INSERT INTO PERSON (fname, lname, username, pwd, email, ssnr, id, role) VALUES
                    ('chris', 'robberts', 'vinkelg', '123', 'asd@asd.se', '1337', 2, 'applicant'),
                    ('petta', 'svensson', 'pettap3', '123', 'asd@asd.se', '1338', 3, 'applicant'),
                    ('xyz','xyzxyz', 'todsss', '1232', 'taoudi123@whatver', '1234', 4,'applicant'),
                    ('abc', 'asdada', 'vinkedl', '1231', 'asd@asd.se', '1337', 5, 'applicant'),
                    ('a', 'svensson', 'pettafp', '1253', 'asd@asd.se', '1338', 6, 'applicant'),
                    ('b', 'svensso', 'pettafasp', '1263', 'asd@asd.se', '1338', 7, 'applicant'),
                    ('c', 'svenss', 'pettewrap', '123', 'asd@asd.se', '1338', 8, 'applicant'),
                    ('d', 'svens', 'pettaqwep', '123', 'asd@asd.se', '1338', 9, 'applicant'),
                    ('e', 'sven', 'pettasdap', '123', 'asd@asd.se', '1338', 10, 'applicant'),
                    ('f', 'sve', 'pettavfdp', '123', 'asd@asd.se', '1338', 11, 'applicant'),
                    ('g', 'sv', 'pettabfdgp', '123', 'asd@asd.se', '1338', 12, 'applicant'),
                    ('h', 's', 'petta213p', '123', 'asd@asd.se', '1338', 13, 'applicant'),
                    ('i', 'sv', 'pett123ap', '123', 'asd@asd.se', '1338', 14, 'applicant'),
                    ('j', 'sve', 'pett251ap', '123', 'asd@asd.se', '1338', 15, 'applicant'),
                    ('k', 'sven', 'pettaferp', '123', 'asd@asd.se', '1338', 16, 'applicant'),
                    ('l', 'svens', 'pettfdap', '123', 'asd@asd.se', '1338', 17, 'applicant'),
                    ('m', 'svenss', 'petyrtap', '123', 'asd@asd.se', '1338', 18, 'applicant'),
                    ('n', 'svensso', 'pdsfettap', '123', 'asd@asd.se', '1338', 19, 'applicant'),
                    ('o', 'svensson', 'pettap', '123', 'asd@asd.se', '1338', 20, 'applicant'),
                    ('p', 'svensson', 'pewewttap', '123', 'asd@asd.se', '1338', 21, 'applicant'),
                    ('yus','todi','skimmaren','$2a$10$DOvhm/LzukVhULgnymKu1urcnVDhHGNBhmlehP7AxFJflU2h/sKPK',
                    'email@email','9876567893',22,'recruit');

INSERT INTO APPLICATION (status, applicationdate, id, person) VALUES
('not checked', '2000-02-05 00:00:00', 2, 2),
('not checked', '2000-02-05 00:00:00', 3, 3),
('not checked', '2000-02-05 00:00:00', 4, 4),
('not checked', '2000-02-05 00:00:00', 5, 5);

INSERT INTO EXPERTISEPROFILE (id, expertise,application,years) VALUES (2,1,2,2);
INSERT INTO EXPERTISEPROFILE (id, expertise,application,years) VALUES (3,3,3,1);
INSERT INTO EXPERTISEPROFILE (id, expertise,application,years) VALUES (4,3,4,1);
INSERT INTO EXPERTISEPROFILE (id, expertise,application,years) VALUES (5,1,5,1);
INSERT INTO EXPERTISEPROFILE (id, expertise,application,years) VALUES (6,3,5,1);
INSERT INTO EXPERTISEPROFILE (id, expertise,application,years) VALUES (7,2,5,1);



INSERT INTO AVAILABILITY (id, fd, td, application) VALUES (1, '1999-01-02 00:00:00', '2000-02-05 00:00:00',2);
INSERT INTO AVAILABILITY (id, fd, td, application) VALUES (2, '2002-01-02 00:00:00', '2004-02-03 00:00:00',5);
INSERT INTO AVAILABILITY (id, fd, td, application) VALUES (3, '1999-01-02 00:00:00', '2000-02-01 00:00:00',5);

