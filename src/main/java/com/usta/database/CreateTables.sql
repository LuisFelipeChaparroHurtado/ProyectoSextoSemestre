CREATE TABLE publisher(
                            id_publisher serial not null,
                            name_publisher varchar(200) not null,
                            country_publisher varchar(30) not null,
                            number_phone_publisher varchar(20) not null,
                            constraint PK_PUBLISHER primary key(id_publisher)
);
ALTER TABLE publisher owner to user_node;

CREATE TABLE book(
                          id_book serial not null,
                          title_book varchar(200) not null,
                          date_publication date not null,
                          code_book int not null,
                          isbn_book varchar(10) not null,
                          fk_publisher int4 not null,
                          constraint PK_BOOK primary key(id_book)
);
ALTER TABLE book owner to user_node;

CREATE TABLE author(
                     id_author serial not null,
                     name_author varchar(200) not null,
                     surname_author varchar(200) not null,
                     nationality_author varchar(200) not null,
                     description_author varchar(200) not null,
                     constraint PK_AUTHOR primary key(id_author)
);
ALTER TABLE author owner to user_node;

CREATE TABLE authors_books(
                         id_authors_books serial not null,
                         fk_book int4 not null,
                         fk_author int4 not null,
                         constraint PK_AUTHORS_BOOKS primary key(id_authors_books)
);
ALTER TABLE authors_books owner to user_node;

CREATE TABLE customer(
                        id_customer serial not null,
                        customer_identification varchar(50) not null,
                        name_customer varchar(200) not null,
                        surname_customer varchar(200) not null,
                        customer_address varchar(50) not null,
                        number_phone_customer varchar(20) not null,
                        constraint PK_CUSTOMER primary key(id_customer)
);
ALTER TABLE customer owner to user_node;

CREATE TABLE loans(
                            id_loan serial not null,
                            start_date_loan date not null,
                            description varchar(200) not null,
                            fk_customer int4 not null,
                            constraint PK_LOANS primary key(id_loan)
);
ALTER TABLE loans owner to user_node;

CREATE TABLE loan_detail(
                      id_loan_detail serial not null,
                      return_date date not null,
                      days_arrears int not null,
                      description varchar(200) not null,
                      delivery_date date not null,
                      fk_book int4 not null,
                      fk_loans int4 not null,
                      constraint PK_LOAN_DETAIL primary key(id_loan_detail)
);
ALTER TABLE loan_detail owner to user_node;

ALTER TABLE loans
    add constraint FK_LOANS_REF_CUSTOMER foreign key (fk_customer)
        references customer (id_customer)
        on delete restrict on update cascade;

ALTER TABLE loan_detail
    add constraint FK_LOANDETAIL_REF_LOANS foreign key (fk_loans)
        references loans (id_loan)
        on delete restrict on update cascade;

ALTER TABLE loan_detail
    add constraint FK_LOANDETAIL_REF_BOOK foreign key (fk_book)
        references book (id_book)
        on delete restrict on update cascade;

ALTER TABLE book
    add constraint FK_BOOK_REF_PUBLISHER foreign key (fk_publisher)
        references publisher (id_publisher)
        on delete restrict on update cascade;

ALTER TABLE authors_books
    add constraint FK_AUTHORSBOOKS_REF_BOOK foreign key (fk_book)
        references book (id_book)
        on delete restrict on update cascade;

ALTER TABLE authors_books
    add constraint FK_AUTHORSBOOKS_REF_AUTHOR foreign key (fk_author)
        references author (id_author)
        on delete restrict on update cascade;