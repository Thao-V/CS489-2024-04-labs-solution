insert into addresses(`street`, `city`, `state`, `zip_code`) values('1000 N 4th ST', 'fairfield', 'Iowa', '52556');
insert into addresses(`street`, `city`, `state`, `zip_code`) values('800 N 4th ST', 'fairfield', 'Iowa', '52556');
insert into addresses(`street`, `city`, `state`, `zip_code`) values('600 N 4th ST', 'fairfield', 'Iowa', '52556');
insert into addresses(`street`, `city`, `state`, `zip_code`) values('600 W 4th ST', 'Ottumwa', 'Iowa', '52501');
select * from addresses;
select street, city from addresses where zip_code = '52556';
update addresses set `street`='700 N 4th ST' where `addr_id`=2;
delete from addresses where `addr_id`=3;

insert into locations(`name`, `address_id`) values('Star Dental Clinics', 1);
insert into locations(`name`, `address_id`) values('Star Dental Clinics', 2);
insert into locations(`name`, `address_id`) values('Happy Dental Clinics', 1);
select * from locations where address_id in (select addr_id from addresses where addr_id=1);
select locations.name, addresses.street, addresses.city, addresses.state from locations inner join addresses on locations.address_id=addresses.addr_id;