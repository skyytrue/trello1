create table users
(
    ID  bigserial primary key ,
    FULL_NAME varchar(255) not null ,
    USERNAME varchar(255) not null ,
    PASSWORD varchar(255) not null ,
    AGE int,
    CREATED_DATE timestamp,
    MODIFIED_DATE timestamp

);

create table roles
(
    ID  bigserial primary key ,
    NAME varchar(255) not null ,
    DESCRIPTION varchar(255) not null ,
    CREATED_DATE timestamp,
    MODIFIED_DATE timestamp

);

create table user_role
(
    USER_ID bigint not null references users(ID),
    ROLE_ID bigint not null references roles(ID),
    PRIMARY KEY (USER_ID, ROLE_ID)

);