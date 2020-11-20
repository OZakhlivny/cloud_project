create table orders (
    id                      bigserial primary key,
    user_id                 bigint,
    price                   int,
    address                 varchar(1000)
);

create table order_items (
    id                      bigserial primary key,
    product_id              bigint,
    order_id                bigint references orders(id),
    price                   int,
    price_per_product       int,
    quantity                int
);

insert into orders (user_id, price, address)
values
(1, 100, 'Rostov'),
(2, 200, 'Moscow');

insert into order_items (product_id, order_id, price, price_per_product, quantity)
values
(1, 1, 2, 1, 2),
(2, 1, 4, 1, 4),
(1, 2, 1, 1, 1),
(2, 2, 1, 1, 1);

