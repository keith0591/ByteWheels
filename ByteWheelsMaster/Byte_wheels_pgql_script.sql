create schema bytewheels

create table bytewheels.category(
id serial primary key,
category_name varchar(20) not null,
cost numeric(7,2) not null  );

COPY bytewheels.category(category_name,cost) 
FROM 'D:\ByteWheelsMaster\category.csv' DELIMITER ',' CSV HEADER;

--select * from bytewheels.category

create table bytewheels.cars(
id serial primary key,
car_name varchar(20) not null,
car_type integer not null REFERENCES bytewheels.category(id),
availability integer not null  
);

COPY bytewheels.cars(car_name,car_type,availability) 
FROM 'D:\ByteWheelsMaster\cars.csv' DELIMITER ',' CSV HEADER;

--select * from bytewheels.cars

create table bytewheels.rental(
id serial primary key,
car_id integer not null references bytewheels.cars(id),
from_date timestamp without time zone not null,
to_date timestamp without time zone not null,
booked_count integer,
user_email_id text not null
);

--select * from bytewheels.rental
