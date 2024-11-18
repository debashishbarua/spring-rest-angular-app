insert into department(department_id, department_name, department_location) values(10,'CS', 'Kolkata');
insert into department(department_id, department_name, department_location) values(20,'IT', 'Delhi');
insert into department(department_id, department_name, department_location) values(30,'EC', 'Mumbai');


insert into address(id, street, city, state, country, zip_code) values(100,'Park', 'Kolkata','West Bengal', 'India', '732922');
insert into address(id, street, city, state, country, zip_code) values(101,'Ripon', 'Kolkata','West Bengal', 'India', '732921');
insert into address(id, street, city, state, country, zip_code) values(102,'Camac', 'Kolkata','West Bengal', 'India', '732923');

insert into employee(first_name, last_name,department_id, address_id) values('Akash', 'Verma',10, 100);
insert into employee(first_name, last_name,department_id, address_id) values('Rajesh', 'Kumar',20, 101);
insert into employee(first_name, last_name,department_id, address_id) values('Vinod', 'Kumar',30, 102);

