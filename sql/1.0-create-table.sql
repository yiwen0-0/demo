DROP TABLE IF EXISTS `tbl_person`;
DROP TABLE IF EXISTS `tbl_household`;

CREATE TABLE `tbl_household` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `housing_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

CREATE TABLE `tbl_person` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `annual_income` bigint DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `marital_status` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `occupation_type` varchar(255) DEFAULT NULL,
  `household_id` bigint DEFAULT NULL,
  `spouse` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY (`household_id`),
  CONSTRAINT FOREIGN KEY (`household_id`) REFERENCES `tbl_household` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;
