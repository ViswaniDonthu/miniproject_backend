USE question_papers;

DROP TABLE IF EXISTS academicyear;
DROP TABLE IF EXISTS examtypes;
DROP TABLE IF EXISTS batch;
DROP TABLE IF EXISTS department;

INSERT INTO academicyear VALUES
(8, "2008-2009"), (9, "2009-2010"), (10, "2010-2011"), (11, "2011-2012"), (12, "2012-2013"), (13, "2013-2014"),(14,"2014-2015"),(15,"2015-2016")
,(16,"2016-2017"),(17,"2017-2018"),(18,"2018-2019"),(19,"2019-2020"),(20,"2020-2021"),(21,"2021-2022"),(22,"2022-2023"),(23,"2023-2024"),(24,"2024-2025");

INSERT INTO examtypes VALUES
(1, "mid1"), (2, "mid2"), (3, "mid3"), (4, "at1"), (5, "at2"),
(6, "at3"), (7, "at4"), (8, "sem"), (9, "supply");

insert into  department values(1,"puc"),(2,"cse"),(3,"ece"),(4,"eee"),(5,"mech"),(6,"civil"),(7,"chemical"),(8,"metallurgy");
insert into batch values(1,)
