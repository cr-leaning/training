CREATE TABLE `POSITION_M` (
	`POSITION_ID` TINYINT UNSIGNED NOT NULL AUTO_INCREMENT,
	`POSITION_NAME` VARCHAR(50),
	`POSITION_ALLOWANCE` INT, 
	`STATUS_FLG` TINYINT(4) NOT NULL DEFAULT '0',
	`REG_USER` INT(11) ,
	`REG_DATE` DATETIME ,
	`UPD_USER` INT(11) ,
	`UPD_DATE` DATETIME ,
	PRIMARY KEY (`POSITION_ID`)
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=6
;
