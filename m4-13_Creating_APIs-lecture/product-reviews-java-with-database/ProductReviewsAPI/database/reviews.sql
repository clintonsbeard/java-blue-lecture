DROP TABLE IF EXISTS product_reviews;

CREATE TABLE product_reviews (
        id serial primary key,
        name varchar(128),
        title varchar(128),
        avatar varchar(128),
        review text,
        created timestamp
);

INSERT INTO product_reviews (id, name, title, review, avatar, created) 
VALUES (DEFAULT, 'Nandita Vanda', 'Life Changing', 'Amazing how it works', 'https://randomuser.me/api/portraits/women/6.jpg', current_timestamp),
(DEFAULT, 'Wilfried Breanna', 'Wow!', 'This may be the best thing I have ever seen, used, or heard', 'https://randomuser.me/api/portraits/men/54.jpg', current_timestamp),
(DEFAULT, 'Uliana Calisto', 'Attacked my Dog', 'It was great until it attacked my dog and hugged my cat!', 'https://randomuser.me/api/portraits/women/50.jpg', current_timestamp),
(DEFAULT, 'Vibius Ruiha', 'Meh', 'Would be better in red', 'https://randomuser.me/api/portraits/women/9.jpg', current_timestamp),
(DEFAULT, 'Aseem Oded', 'Wicked good like my pickup truck!', 'Best. Thing. Ever.', 'https://randomuser.me/api/portraits/men/72.jpg', current_timestamp),
(DEFAULT, 'Shanthi Leandros', 'Best every', 'I loved this book, and how the characters developed.', 'https://randomuser.me/api/portraits/women/28.jpg', current_timestamp);