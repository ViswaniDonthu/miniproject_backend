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

INSERT INTO Academicyear (academic_year) VALUES
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


INSERT INTO Subject(subject_name, subject_code, branch_id) VALUES

-- Semester 1
('Differential Equations and Multivariable Calculus', '20MA1101', 25),
('English Language Communication Skills Lab-I', '20EG1181', 25),
('Engineering Physics', '20PY1102', 25),
('Basic Electrical and Electronics Engineering', '20EE1109', 25),
('Engineering Chemistry', '20CY1103', 25),
('Workshop Practice', '20ME1181', 25),
('Basic Electrical & Electronics Engineering Lab', '20EC1189', 25),
('Engineering Physics & Chemistry Lab', '20BS1183', 25),


-- Semester 2 (First Year)
('Mathematical Methods', '20MA1201', 26),
('Engineering Mechanics', '20ME1213', 26),
('Material Science & Metallurgy', '20ME1201', 26),
('Programming and Data Structures', '20CS1208', 26),
('Engineering Graphics and Computer Drafting', '20ME1214', 26),
('Programming and Data Structures Lab', '20CS1288', 26),
('Material Science and Metallurgy Lab', '20ME1281', 26),
('Environmental Science', '20BE1201', 26),

-- Semester 3 (Second Year - Semester 1)
('Transform Calculus', '20MA2103', 27),
('Kinematics of Machinery', '20ME2101', 27),
('Thermodynamics', '20ME2102', 27),
('Mechanics of Solids', '20ME2103', 27),
('Manufacturing Processes', '20ME2104', 27),
('Mechanics of Solids Lab', '20ME2181', 27),
('Computer Aided Machine Drawing', '20ME2105', 27),
-- Semester 4

('Design of Machine Elements', '20ME2201', 28),
('Dynamics of Machinery', '20ME2202', 28),
('Fluid Mechanics & Hydraulic Machinery', '20ME2203', 28),
('Metal Cutting and Machine Tools', '20ME2204', 28),
('Probability and Statistics', '20MA2201', 28),
('Metal cutting and Machine Tools Lab', '20ME2281', 28),
('Fluid Mechanics & Hydraulic Machinery Lab', '20ME2282', 28),
('Indian Constitution', '20HS2201', 28),
-- Semester 5

('Heat Transfer', '20ME3101', 29),
('Design of Transmission Elements', '20ME3102', 29),
('Applied Thermodynamics', '20ME3103', 29),
('Metrology and Mechanical Measurements', '20ME3104', 29),
('Metrology and Mechanical Measurements Lab', '20ME3181', 29),
('Heat Transfer Lab', '20ME3182', 29),
('Applied Thermodynamics Lab', '20ME3183', 29),
('English Language Communication Skills Lab-II', '20EG3182', 29),

-- Semester 6

('Operations Research', '20ME3201', 30),
('Finite Element Method', '20ME3202', 30),
('Managerial Economics and Financial Analysis', '20BM3201', 30),
('Program Elective Course-1', '20ME32XX', 30),
('Program Elective Course-2', '20ME32XX', 30),
('Computer Aided Modeling and Simulation Lab', '20ME3281', 30),
('English Language Communication Skills Lab-III', '20EG3283', 30),
('Summer Internship', '20ME3291', 30),
-- Semester 7

('Program Elective Course-3', '20ME41XX', 31),
('Open Elective Course-1', '20MX41XX', 31),
('Open Elective Course-2', '20MX41XX', 31),
('Project', '20ME4192', 31),

-- Semester 8

('Program Elective Course-4', '20ME42XX', 32),
('Open Elective Course-3', '20MX42XX', 32),
('Open Elective Course-4', '20MX42XX', 32),
('Community Service', '20ME42XX', 32),
('Project - 2', '20ME4293', 32);

INSERT INTO subject(subject_name, subject_code, branch_id) VALUES
('Biology for Engineers', '20BE1102', 33),
('Physical and Organic Chemistry', '20CY1101', 33),
('Differential Equations and Multivariable Calculus', '20MA1101', 33),
('Introductions of Chemical Engineering', '20CH1101', 33),
('Engineering and Solid Mechanics', '20ME1111', 33),
('English Language Communication Skills Lab-1', '20EG1181', 33),
('Physical and Organic Chemistry Lab', '20CY1181', 33),
('Workshop', '20ME1185', 33),


('Engineering Physics', '20PY1203', 34),
('Mathematical Methods', '20MA1201', 34),
('Engineering Graphics and Computer Drafting', '20CE1214', 34),
('Programming and Data Structures', '20CS1208', 34),
('Chemical Process Calculations', '20CH1201', 34),
('Fluid Mechanics', '20CH1202', 34),
('Programming and Data Structures Lab', '20CS1288', 34),


('Transform Calculus', '20MA2103', 35),
('Mechanical Technology', '20ME2112', 35),
('Thermodynamics-1', '20CH2101', 35),
('Heat Transfer', '20CH2102', 35),
('Mechanical Unit Operations', '20CH2103', 35),
('Managerial Economics and Financial Analysis', '20BM2101', 35),
('Fluid Mechanics Lab', '20CH2181', 35),



('Basics of Electrical and Electronics Engineering', '20EC2209', 36),
('Object Oriented Programming through Java', '20CS2207', 36),
('Chemical Reaction Engineering-1', '20CH2201', 36),
('Mass Transfer Operations-1', '20CH2202', 36),
('Thermodynamics - 2', '20CH2203', 36),
('Object Oriented Programming through Java2', '20CS2287', 36),
('Heat Transfer  Lab', '20CH2281', 36),
('Mechanical Unit Operations Lab', '20CH2282', 36),



('Chemical Process Dynamics and Control', '20CH3101', 37),
('Chemical Technology', '20CH3102', 37),
('Chemical Reaction Engineering-2', '20CH3103', 37),
('Mass Transfer Operations-2', '20CH3104', 37),
('Numerical Methods in Chemical Engineering', '20CH3105', 37),
('Chemical Reaction Engineering Lab', '20CH3181', 37),
('Numerical Methods in Chemical Engineering Lab', '20CH3182', 37),
('English Language Communication Skills Lab-2', '20EG3182', 37),



('Process Equipment Design', '20CH3201', 38),
('Plant Design and Economics', '20CH3202', 38),
('Transport Phenomena', '20CH3203', 38),
('Professional Elective Course-1', '20CH32XX', 38),
('Open Elective Course - 1', '20XX32XX', 38),
('Chemical Process Dynamics and Control Lab', '20CH3281', 38),
('Mass Transfer Operations Lab', '20CH3282', 38),
('English Language Communication Skills Lab-3', '20EG3283', 38),



('Professional Elective Course-2', '20CH41XX', 39),
('Professional Elective Course - 3', '20CH41XX', 39),
('Open Elective Course - 2', '20XX41XX', 39),
('Aptitude and Reasoning', '20HS4104', 39),
('Indian Constitution', '20HS4101', 39),




('Professional Elective Course - 4', '20CH42XX', 40),
('Professional Elective Course - 5', '20CH42XX', 40),
('Open Elective Course - 3', '20XX42XX', 40),
('Indian Community Services', '20HS4299', 40),
('Environmental Science', '20BE4201', 40);

-- Semester 1 (MME, Branch ID: 41)
INSERT INTO Subject(subject_name, subject_code, branch_id) VALUES
  ('Differential Equations and Multivariable Calculus', '20MA1101', 41),
  ('Engineering Physics', '20PY1103', 41),
  ('Engineering Graphics and Computer Drafting', '20CE1114', 41),
  ('Engineering Mechanics', '20ME1113', 41),
  ('Programming and Data Structures', '20CS1108', 41),
  ('English Language Communication Skills Lab-1', '20EG1181', 41),
  ('Engineering Physics Lab', '20PY1183', 41),
  ('Programming and Data Structures Lab', '20CS1188', 41),
  ('Workshop Manufacturing Practices', '20ME1186', 41);

-- Semester 2 (MME, Branch ID: 42)
INSERT INTO Subject(subject_name, subject_code, branch_id) VALUES
  ('Mathematical Methods', '20MA1201', 42),
  ('Engineering Chemistry', '20CY1204', 42),
  ('Basic Electrical and Electronics Engineering', '20EE1209', 42),
  ('Materials Thermodynamics', '20MM1201', 42),
  ('Physical Metallurgy', '20MM12002', 42),
  ('Engineering Chemistry lab', '20CY1284', 42),
  ('Basic Electrical and Electronics Engineering lab', '20EE1289', 42),
  ('Physical Metallurgy and Metallography lab', '20MM1281', 42),
  ('Indian Constitution', '20HS1201', 42);

-- Semester 3 (MME, Branch ID: 43)
INSERT INTO Subject(subject_name, subject_code, branch_id) VALUES
  ('Transform Calculus', '20MA2104', 43),
  ('Mineral Processing and Extractive Metallurgy', '20MM2101', 43),
  ('Phase Transformations and Heat Treatment', '20MM2102', 43),
  ('Mechanical Behaviour and Testing of Materials', '20MM2103', 43),
  ('Engineering Polymers', '20MM2104', 43),
  ('Mineral Processing and Extractive Metallurgy Lab', '20MM2181', 43),
  ('Phase Transformations and Heat Treatment Lab', '20MM2182', 43),
  ('Mechanical Behaviour and Testing of Materials Lab', '20MM2183', 43),
  ('Environmental Science', '20BE2101', 43);

-- Semester 4 (MME, Branch ID: 44)
INSERT INTO Subject(subject_name, subject_code, branch_id) VALUES
  ('Transport Phenomena in Materials', '20MM2201', 44),
  ('Iron making Technology', '20MM2202', 44),
  ('Metal Forming', '20MM2203', 44),
  ('Corrosion Engineering', '20MM2204', 44),
  ('Science and Technology of Ceramics', '20MM2205', 44),
  ('Open Elective Course-2', '20XX22XX', 44),
  ('Metal Forming Lab', '20MM2281', 44),
  ('Corrosion Engineering Lab', '20MM2282', 44);

-- Semester 5 (MME, Branch ID: 45)
INSERT INTO Subject(subject_name, subject_code, branch_id) VALUES
  ('Materials Characterization', '20MM3101', 45),
  ('Solidification Process and Casting', '20MM3102', 45),
  ('Non-Ferrous Extractive Metallurgy', '20MM3103', 45),
  ('Semiconductor Materials', '20MM3104', 45),
  ('Steel Making Technology', '20MM3105', 45),
  ('Materials Characterization Lab', '20MM3181', 45),
  ('Solidification Process and Casting Lab', '20MM3182', 45),
  ('English Language Communication Skills Lab-2', '20EG3182', 45),
  ('Gender Sensitization', '20MM3109', 45);

-- Semester 6 (MME, Branch ID: 46)
INSERT INTO Subject(subject_name, subject_code, branch_id) VALUES
  ('Metal Joining and Non-Destructive Testing', '20MM3201', 46),
  ('Computational Materials Engineering', '20MM3202', 46),
  ('Professional Elective Course-1', '20MM32XX', 46),
  ('Metal Joining and Non-Destructive Testing', '20MM3281', 46),
  ('Computational Materials Engineering Lab', '20MM3282', 46),
  ('Minor Project', '20MM3291', 46),
  ('English Language Communications Skills Lab-3', '20EG3282', 46);

-- Semester 7 (MME, Branch ID: 47)
INSERT INTO Subject(subject_name, subject_code, branch_id) VALUES
  ('Managerial Economics and Financial Analysis', '20BM4101', 47),
  ('Major Project - 1', '20MM4191', 47),
  ('Professional Elective Course-2', '20MM41XX', 47),
  ('Professional Elective Course-3', '20MM41XX', 47),
  ('Open Elective Course - 2', '20YY41XX', 47);

-- Semester 8 (MME, Branch ID: 48)
INSERT INTO Subject(subject_name, subject_code, branch_id) VALUES
  ('Major Project - 2', '20MM4291', 48),
  ('Professional Elective Course-4', '20MM42XX', 48),
 ('Open Elective Course - 3', '20YY42XX', 48),
 ('Open Elective Course - 4', '20YY42XX', 48),
 ('Indian Community Services', '20HS4299', 48);





INSERT INTO subject(subject_name, subject_code, branch_id) VALUES
-- Semester 1(Civil - E1)
('Engineering Chemistry', '20CY1102', 49),
('Differential Equations and Multivariable Calculus', '20MA1101', 49),
('Programming and Data Structures', '20CS1108', 49),
('Engineering Graphics and Computer Drafting', '20CE1114', 49),
('Engineering Chemistry Lab', '20CY1182', 49),
('English Language Communication Skills Lab-I', '20EG1181', 49),
('Programming and Data Structures Lab', '20CS1188', 49),
('Aptitude and Reasoning', '20HS1104', 49),

-- Semester 2(CE - E1)
('Engineering Physics', '20PY1202', 50),
('Mathematical Methods', '20MA1201', 50),
('Basic Electrical and Electronics Engineering', '20EE1209', 50),
('Engineering Mechanics', '20CE1201', 50),
('Engineering Geology', '20CE1202', 50),
('Engineering Physics Lab', '20PY1282', 50),
('Workshop', '20ME 1285', 50),
('Environmental Science', '20BE1201', 50),

-- Semester 1(CE - E2)
('Management Economics and Financial Analysis', '20BM 2101', 51),
('Building Materials and Construction', '20CE 2101', 51),
('Concrete Technology', '20CE2102', 51),
('Mechanics of Fluids', '20CE2103', 51),
('Mechanics of Materials-I', '20CE2104', 51),
('Surveying-I', '20CE2105', 51),
('Mechanics of Materials Lab', '20CE2181', 51),
('Surveying Lab', '20CE2182', 51),
('Indian Constitution', '20HS2101', 51),

-- Semester 2(CE - E2)
('Hydraulics Engineering', '20CE2201', 52),
('Mechanics of Materials-II', '20CE2202', 52),
('Soil Mechanics', '20CE2203', 52),
('Structural Analysis', '20CE2204', 52),
('Surveying-II', '20CE2205', 52),
('Water Resources Engineering', '20CE2206', 52),
('Concrete Technology Lab', '20CE2282', 52),
('Hydraulics Engineering Lab', '20CE2281', 52),

-- Semester 1(CE - E3)
('Advanced Structural Analysis', '20CE3101', 53),
('Design of Reinforced Concrete Structures', '20CE3102', 53),
('Environmental Engineering-I', '20CE3103', 53),
('Estimation and Costing', '20CE3104', 53),
('Transportation Engineering-I', '20CE3105', 53),
('English Language Communication Skills Lab-II', '20EG3182', 53),
('Soil Mechanics Lab', '20CE3181', 53),
('Transportation Engineering Lab', '20CE3182', 53),

-- Semester 2(CE - E3)
('Building Planning and Computer Aided Drawing Lab', '20CE3201', 54),
('Design of Steel Structures', '20CE3202', 54),
('Environmental Engineering-II', '20CE3203', 54),
('Foundation Engineering', '20CE3204', 54),
('Transportation Engineering-II', '20CE3205', 54),
('Professional Elective Course-1 / MOOC-1', '20CE32XX', 54),
('English Language Communication Skills Lab-1', '20EG3283', 54),
('Environmental Engineering Lab', '20CE3282', 54),

-- Semester 1(CE - E4)
('Professional Elective Course-2 / MOOC-2', '20CE41XX', 55),
('Professional Elective Course-3', '20CE41XX', 55),
('Professional Elective Course-4', '20CE41XX', 55),
('Open Elective Course-1', '20XX41XX', 55),
('Project-1', '20CE 4191', 55),
('Seminar', '20CE 4194', 55),

-- Semester 2(CE - E4)
('Professional Elective Course-5', '20CE42XX', 56),
('Open Elective Course-2 / MOOC-3', '20CE42XX', 56),
('Open Elective Course-3', '20XX42XX', 56),
('Project-2', '20CE4192', 56),
('Indian Community Services', '20HS4299',56);

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

