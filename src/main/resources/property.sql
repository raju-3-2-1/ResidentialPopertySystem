create database property;
use property;

insert into cat_description(category_id,description_of_the_prop) value
(1,'RCC buildings'),
(2,'RCC with cement/red oxide'),
(3,'Tiled/Sheet of all kinds');

insert into zonal_details(id,status,value,zone,category_id) value (4,"Tenanted",5.00,"zone_A",1),
(5,"Tenanted",4.00,"zone_B",1),
(6,"Tenanted",3.60,"zone_C",1),
(7,"Owner",2.50,"zone_A",1),
(8,"Owner",2.00,"zone_B",1),
(9,"Owner",1.80,"zone_C",1),
(10,"Tenanted",4.00,"zone_A",2),
(11,"Tenanted",3.50,"zone_B",2),
(12,"Tenanted",3.00,"zone_C",2),
(13,"Owner",1.80,"zone_A",2),
(14,"Owner",1.60,"zone_B",2),
(15,"Owner",1.20,"zone_C",2),
(16,"Tenanted",3.00,"zone_A",3),
(17,"Tenanted",2.50,"zone_B",3),
(18,"Tenanted",2.00,"zone_C",3),
(19,"Owner",1.25,"zone_A",3),
(20,"Owner",1.00,"zone_B",3),
(21,"Owner",0.75,"zone_C",3);


select * from cat_description;
select * from property_tax;
select * from zonal_details;
select * from property_tax;
use propertytax;
create database property;
use property;