INSERT INTO EXPERTISE (id, name) VALUES (1, 'foo');
INSERT INTO EXPERTISE (id, name) VALUES (2, 'poop');
INSERT INTO EXPERTISE (id, name) VALUES (3, 'skim');


INSERT INTO PERSON (fname, lname, uname, pwd, email, ssnr, id, role_id) VALUES
                    ('taoudi','youssef', 'tods', '123', 'taoudi123@whatver', '1234', 1,1),
                    ('chris', 'robberts', 'vinkel', '123', 'asd@asd.se', '1337', 2, 2),
                    ('petta', 'svensson', 'pettap', '123', 'asd@asd.se', '1338', 3, 3);
INSERT INTO APPLICATION (status, applicationdate, id, person) VALUES
('not checked', '1999-01-02 00:00:00', 1, 1),
('not checked', '2000-02-05 00:00:00', 2, 2);

INSERT INTO EXPERTISEPROFILE (id, expertise,application,years) VALUES (1,1,1,3);
INSERT INTO EXPERTISEPROFILE (id, expertise,application,years) VALUES (2,1,2,2);
INSERT INTO EXPERTISEPROFILE (id, expertise,application,years) VALUES (3,3,1,1);


INSERT INTO AVAILABILITY (id, fd, td, application) VALUES (1, '1999-01-02 00:00:00', '2000-02-05 00:00:00',1);
INSERT INTO AVAILABILITY (id, fd, td, application) VALUES (2, '2002-01-02 00:00:00', '2004-02-03 00:00:00',2);
INSERT INTO AVAILABILITY (id, fd, td, application) VALUES (3, '1999-01-02 00:00:00', '2000-02-01 00:00:00',1);