
create table products (
    id                      bigserial primary key,
    title                   varchar(255),
    price                   int
);

insert into products (title, price)
values
('Bread', 1),
('Samsung V100', 2),
('Acer X1000', 3);

