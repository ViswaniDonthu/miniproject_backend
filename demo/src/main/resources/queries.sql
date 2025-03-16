use question_papers;
-- 2008-2009
INSERT INTO Branch(branch, semester) VALUES
('CSE', 1), ('CSE', 2), ('CSE', 3), ('CSE', 4), ('CSE', 5), ('CSE', 6), ('CSE', 7), ('CSE', 8),
('ECE', 1), ('ECE', 2), ('ECE', 3), ('ECE', 4), ('ECE', 5), ('ECE', 6), ('ECE', 7), ('ECE', 8),
('EEE', 1), ('EEE', 2), ('EEE', 3), ('EEE', 4), ('EEE', 5), ('EEE', 6), ('EEE', 7), ('EEE', 8),
('MECH', 1), ('MECH', 2), ('MECH', 3), ('MECH', 4), ('MECH', 5), ('MECH', 6), ('MECH', 7), ('MECH', 8),
('CHEMICAL', 1), ('CHEMICAL', 2), ('CHEMICAL', 3), ('CHEMICAL', 4), ('CHEMICAL', 5), ('CHEMICAL', 6), ('CHEMICAL', 7), ('CHEMICAL', 8),
('METALLURGY', 1), ('METALLURGY', 2), ('METALLURGY', 3), ('METALLURGY', 4), ('METALLURGY', 5), ('METALLURGY', 6), ('METALLURGY', 7), ('METALLURGY', 8),
('CIVIL', 1), ('CIVIL', 2), ('CIVIL', 3), ('CIVIL', 4), ('CIVIL', 5), ('CIVIL', 6), ('CIVIL', 7), ('CIVIL', 8),
('PUC1', 1), ('PUC1', 2),
('PUC2', 1), ('PUC2', 2);

INSERT INTO Academicyear (academicYear) VALUES
('2008-2009'),
('2009-2010'),
('2010-2011'),
('2011-2012'),
('2012-2013'),
('2013-2014'),
('2014-2015'),
('2015-2016'),
('2016-2017'),
('2017-2018'),
('2018-2019'),
('2019-2020'),
('2020-2021'),
('2021-2022'),
('2022-2023'),
('2023-2024'),
('2024-2025'),
('2025-2026');

INSERT INTO Subject(subject_name, subject_code, branch_id) VALUES
-- Semester 1 (branch_id = 17)
('Differential Equations and Multivariable Calculus', '22MA1101', 17),
('Engineering Physics', '22PY1101', 17),
('Engineering Physics Lab', '22PY1181', 17),
('Engineering Graphics & Computer Drafting', '22CE1114', 17),
('Electrical Technology', '22EE1101', 17),
('Electrical Technology Lab', '22EE1181', 17),
('Introduction to Latest Technical Advancements', '22EE1102', 17),
('Programming & Data Structures', '22CS1108', 17),
('Programming & Data Structures Lab', '22CS1188', 17),

-- Semester 2 (branch_id = 18)
('Mathematical Methods', '22MA1201', 18),
('Digital Logic Design', '22EC2102', 18),
('Digital Logic Design Lab', '22EC2182', 18),
('Computational Lab', '22EE1281', 18),
('English Language Communication Skills Lab', '22EG1281', 18),
('Electronics Devices and Circuits', '22EC1201', 18),
('Electronics Devices and Circuits Lab', '22EC1281', 18),
('Network Theory', '22EE1201', 18),
('Introduction to AI', '22EE1202', 18),

-- Semester 3 (branch_id = 19)
('Probability & Random Variables', '22MA2101', 19),
('Internet of Things Lab', '22EE2182', 19),
('Analog Electronic Circuits', '22EC2101', 19),
('Analog Electronic Circuits Lab', '22EC2181', 19),
('Object Oriented Programming', '22CS1209', 19),
('Object Oriented Programming Lab', '22CS1289', 19),
('Signals & Systems', '22ECXXXX', 19), -- Update after ECE BOS
('Electrical Machines', '22EE2101', 19),
('Electrical Machines Lab', '22EE2181', 19),

-- Semester 4 (branch_id = 20)
('Robotics Laboratory', '22EE2281', 20),
('Power Systems-I', '22EE2201', 20),
('Machine Learning', '22EE2204', 20),
('Control Systems', '22EE2202', 20),
('Control Systems Lab', '22EE2282', 20),
('Linear Integrated Circuits', '22EC2203', 20),
('Linear Integrated Circuits Lab', '22EC2283', 20),
('Power Electronics', '22EE2203', 20),
('Power Electronics Lab', '22EE2283', 20),

-- Semester 5 (branch_id = 21)
('Digital Signal Processing', '22EC31XX', 21),
('Power Systems-II', '22EE3101', 21),
('Power Systems Lab', '22EE3181', 21),
('English Language Communication Skills Lab-2', '22EE3182', 21),
('Electrical Vehicles', '22EE3102', 21),
('Electrical Vehicles Lab', '22EE3182', 21),
('Embedded Systems', '22EC31XX', 21),
('Embedded Systems Lab', '22EC31XX', 21),
('Mini-Project-I (Socially Relevant Project)', '22EE3190', 21),
('Product Design & Innovation', '22MG32XX', 21),

-- Semester 6 (branch_id = 22)
('English Language Communication Skills Lab-3', '22EG3283', 22),
('Elective-1', '22EE32XX', 22),
('Elective-2', '22EE32XX', 22),
('Open Elective-1', '22XX32XX', 22),
('Open Elective-2', '22XX32XX', 22),
('Mini Project-II', '22EE3290', 22),

-- Semester 7 (assuming branch_id = 23)
('Elective-3', '22EE41XX', 23),
('Elective-4', '22EE41XX', 23),
('Open Elective-3', '22XX41XX', 23),
('Summer Internship Project', '22EE4190', 23);

INSERT INTO question_paper (id,subject_id, exam_type, academicyear_id, file_url, isaccepted, uploaded_id) VALUES
-- Semester Exam Papers
(4,1, 'semester', 7, "C:/Users/DELL/Desktop/miniproject_backend/demo/src/main/resources/uploadsquestionpaper.pdf", FALSE, 1),
(5,2, 'semester', 2, "C:/Users/DELL/Desktop/miniproject_backend/demo/src/main/resources/uploadsquestionpaper.pdf", FALSE, 1),
(6,3, 'supply', 3, "C:/Users/DELL/Desktop/miniproject_backend/demo/src/main/resources/uploadsquestionpaper.pdf", FALSE, 1),
(7,4, 'semester', 4, "C:/Users/DELL/Desktop/miniproject_backend/demo/src/main/resources/uploadsquestionpaper.pdf", FALSE, 1),
(8,5, 'supply', 5, "C:/Users/DELL/Desktop/miniproject_backend/demo/src/main/resources/uploadsquestionpaper.pdf", FALSE, 1),
-- Semester Exam Papers
(9,3, 'semester', 4, 'path/to/file11.pdf', FALSE, 1),
(10,3, 'semester', 2, 'path/to/file2.pdf', FALSE, 1),
(11,1, 'supply', 3, 'path/to/file3.pdf', FALSE, 1),
(12,2, 'semester', 4, 'path/to/file4.pdf', FALSE, 1),
(13,3, 'supply', 5, 'path/to/file5.pdf', FALSE, 1)
