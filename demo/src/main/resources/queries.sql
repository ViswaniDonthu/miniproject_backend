USE question_papers;

DROP TABLE IF EXISTS academicyear;
DROP TABLE IF EXISTS examtypes;
DROP TABLE IF EXISTS batch;
DRO TABLE IF EXISTS department;

INSERT INTO academicyear VALUES
(1, "2008-2009"), (2, "2009-2010"), (3, "2010-2011"), (4, "2011-2012"), (5, "2012-2013"), (6, "2013-2014"),(7,"2014-2015"),(8,"2015-2016")
(201);

INSERT INTO examtypes VALUES
(1, "mid1"), (2, "mid2"), (3, "mid3"), (4, "at1"), (5, "at2"),
(6, "at3"), (7, "at4"), (8, "sem"), (9, "supply");

insert into  department values(1,"puc"),(2,"cse"),(3,"ece"),(4,"eee"),(5,"mech"),(6,"civil"),(7,"chemical"),(8,"metallurgy")

