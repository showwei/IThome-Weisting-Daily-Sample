
create sequence hibernate_sequence start 1 increment 1 ;
create table dancing_table (
    id   int4 not null,
    name varchar(255),
    rank int,
    primary key (id)
);

insert into dancing_table(id, name, rank)values (1, 'Two Steps From Hell - Victory', 1);