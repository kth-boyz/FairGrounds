<<<<<<< HEAD
INSERT INTO EXPERTISE (id, name) VALUES (1, 'porn');
INSERT INTO EXPERTISE (id, name) VALUES (2, 'poop');
INSERT INTO EXPERTISE (id, name) VALUES (3, 'skim');


INSERT INTO PERSON (fname, lname, uname, pwd, email, ssnr, id, role_id) VALUES
                    ('taoudi','youssef', 'tods', '123', 'taoudi123@whatver', '1234', 1,1);
INSERT INTO APPLICATION (status, id, person) VALUES ('not checked', 1, 1);

INSERT INTO EXPERTISEPROFILE (id, expertise,application,years) VALUES (1,1,1,3);
INSERT INTO EXPERTISEPROFILE (id, expertise,application,years) VALUES (2,2,1,2);
INSERT INTO EXPERTISEPROFILE (id, expertise,application,years) VALUES (3,3,1,1);


INSERT INTO AVAILABILITY (id, fd, td, application) VALUES (1, '1999-01-02', '2000-02-05',1);
INSERT INTO AVAILABILITY (id, fd, td, application) VALUES (2, '1999-01-02', '2000-02-03',1);
INSERT INTO AVAILABILITY (id, fd, td, application) VALUES (3, '1999-01-02', '2000-02-01',1);

=======
INSERT INTO EXPERTISE (NAME, ID) VALUES ('IT AND COMPUTER SCIENCE', 1);
INSERT INTO EXPERTISE (NAME, ID) VALUES ('ECONOMICS', 2);
INSERT INTO EXPERTISE (NAME, ID) VALUES ('EDUCATION', 3);
>>>>>>> little bit broken atm
