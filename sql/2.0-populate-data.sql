# Household Creation
INSERT INTO `tbl_household`
(`id`,`housing_type`)
VALUES
(1,"Landed");

INSERT INTO `tbl_household`
(`id`,`housing_type`)
VALUES
(2,"HDB");

INSERT INTO `tbl_household`
(`id`,`housing_type`)
VALUES
(3,"Condominium");

INSERT INTO `tbl_household`
(`id`,`housing_type`)
VALUES
(4,"HDB");

# Family member Creation
# 120000 Landed with 5-year kid
INSERT INTO `tbl_person`
(`id`,`annual_income`,`date_of_birth`,`gender`,`marital_status`,`name`,`occupation_type`,`household_id`,`spouse`)
VALUES
(1, 60000, "1970-04-05", "FEMALE", "MARRIED", "Rose", "Employed", 1, 2);
INSERT INTO `tbl_person`
(`id`,`annual_income`,`date_of_birth`,`gender`,`marital_status`,`name`,`occupation_type`,`household_id`,`spouse`)
VALUES
(2, 60000, "1970-04-05", "MALE", "MARRIED", "Jack", "Employed", 1, 1);
INSERT INTO `tbl_person`
(`id`,`annual_income`,`date_of_birth`,`gender`,`marital_status`,`name`,`occupation_type`,`household_id`,`spouse`)
VALUES
(3, 0, "2020-04-05", "FEMALE", "SINGLE", "Amy", "Student", 1, null);

# 60000 HDB divoced 17 year kid
INSERT INTO `tbl_person`
(`id`,`annual_income`,`date_of_birth`,`gender`,`marital_status`,`name`,`occupation_type`,`household_id`,`spouse`)
VALUES
(4, 60000, "1970-04-05", "FEMALE", "DIVORCED", "Rose", "Employed", 2, null);
INSERT INTO `tbl_person`
(`id`,`annual_income`,`date_of_birth`,`gender`,`marital_status`,`name`,`occupation_type`,`household_id`,`spouse`)
VALUES
(5, 0, "2004-04-05", "FEMALE", "SINGLE", "Amy", "Student", 2, null);

# 2000000 Condominium elder
INSERT INTO `tbl_person`
(`id`,`annual_income`,`date_of_birth`,`gender`,`marital_status`,`name`,`occupation_type`,`household_id`,`spouse`)
VALUES
(6, 2000000, "1960-04-05", "FEMALE", "DIVORCED", "Rose", "Employed", 3, null);

# 2000000 HDB kid and elder
INSERT INTO `tbl_person`
(`id`,`annual_income`,`date_of_birth`,`gender`,`marital_status`,`name`,`occupation_type`,`household_id`,`spouse`)
VALUES
(7, 2000000, "1960-04-05", "FEMALE", "DIVORCED", "Rose", "Employed", 4, null);
INSERT INTO `tbl_person`
(`id`,`annual_income`,`date_of_birth`,`gender`,`marital_status`,`name`,`occupation_type`,`household_id`,`spouse`)
VALUES
(8, 0, "2018-04-05", "FEMALE", "SINGLE", "Rose", "Employed", 4, null);



