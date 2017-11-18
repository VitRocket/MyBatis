INSERT INTO `mybatis`.`country` (`country_name`, `language`) VALUES ('Ukraine', 'Ukrainian');

INSERT INTO `mybatis`.`location` (`location_name`, `country_id`, `latitude`, `longitude`) VALUES (' Kyiv', '1', '50.516245', '30.491715');

INSERT INTO `mybatis`.`user_group` (`group_name`) VALUES ('FirstGroup');

INSERT INTO `mybatis`.`user` (`user_name`, `location_id`, `user_group_id`) VALUES ('1236547892', '1', '1');

INSERT INTO `mybatis`.`session` (`user_id`, `date_opened`, `date_closed`) VALUES ('1', '2017-01-10', '2017-01-25');