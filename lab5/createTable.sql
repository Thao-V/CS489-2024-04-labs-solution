use ads;

create table addresses(
  `addr_id` int AUTO_INCREMENT primary key,
  `street` varchar(255),
  `city` varchar(64),
  `state` varchar(64),
  `zip_code` varchar(32)
);

create table users(
  `user_id` int AUTO_INCREMENT primary key,
  `first_name` varchar(64),
  `last_name` varchar(64),
	`address_id` int,
  `email` varchar(255),
  `password` varchar(255),
  `role` varchar(16),
  `dob` varchar(64),
  `phone` varchar(16),
  foreign key (`address_id`) references addresses(addr_id)
);

create table locations(
  `location_id` int AUTO_INCREMENT primary key,
  `name` varchar(64),
  `address_id` int,
  foreign key (`address_id`) references addresses(addr_id)
);


create table appointments(
  `appointment_id` int AUTO_INCREMENT primary key,
  `date` DATE,
  `time` TIME,
  `dentist_id` int,
  `patient_id` int,
  `location_id` int,
  `status` varchar(32),
  foreign key (`dentist_id`) references users(user_id),
  foreign key (`patient_id`) references users(user_id),
  foreign key (`location_id`) references locations(location_id)
);

create table bills(
  `bill_id` int AUTO_INCREMENT primary key,
  `amount` int,
  `appointment_id` int,
  `status` varchar(32),
  foreign key (`appointment_id`) references appointments(appointment_id)
);
