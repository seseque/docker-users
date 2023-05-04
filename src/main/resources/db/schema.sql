create table users (
    id integer primary key,
    username varchar(40) not null,
    amount_of_posts integer default 0
);

