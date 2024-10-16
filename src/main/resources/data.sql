create table category
(
    id          serial
        constraint category_pk
            primary key,
    name        text,
    description text
);

create table product
(
    id          serial
        constraint product_pk
            primary key,
    category_id integer not null
        constraint product_category_fk
            references category,
    name        text,
    price       double precision,
    description text
);

INSERT INTO category (name, description)
VALUES ( 'Electronics', 'Devices and gadgets'),
       ( 'Clothing', 'Apparel and accessories'),
       ( 'Home & Kitchen', 'Furniture and kitchenware'),
       ( 'Books', 'Printed and digital books'),
       ( 'Sports & Outdoors', 'Sporting goods and outdoor equipment'),
       ( 'Beauty & Personal Care', 'Cosmetics and personal care products'),
       ( 'Toys & Games', 'Children’s toys and games'),
       ( 'Automotive', 'Car parts and accessories'),
       ( 'Health & Wellness', 'Health products and supplements'),
       ( 'Office Supplies', 'Stationery and office equipment');


INSERT INTO product (name, price, description, category_id)
VALUES ( 'Smartphone', 699.99, 'Latest model smartphone with advanced features.', 1),
       ( 'Laptop', 999.99, 'High-performance laptop for gaming and work.', 1),
       ( 'Wireless Headphones', 199.99, 'Noise-cancelling over-ear headphones.', 1),
       ( 'Digital Camera', 499.99, 'Compact camera with high-resolution capabilities.', 1),
       ( 'T-shirt', 19.99, 'Cotton t-shirt available in various colors.', 2),
       ( 'Jeans', 39.99, 'Stylish denim jeans for casual wear.', 2),
       ( 'Jacket', 89.99, 'Warm winter jacket with a stylish design.', 2),
       ( 'Sneakers', 59.99, 'Comfortable sneakers for everyday use.', 2),
       ( 'Sofa', 399.99, 'Comfortable sofa for living room.', 3),
       ( 'Dining Table', 299.99, 'Elegant dining table made of solid wood.', 3);


