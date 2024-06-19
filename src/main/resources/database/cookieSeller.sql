CREATE SCHEMA IF NOT EXISTS pancakes;
CREATE TABLE IF NOT EXISTS pancakes.cookie_seller (
    sellerID SERIAL PRIMARY KEY,
    name varchar(255)
);