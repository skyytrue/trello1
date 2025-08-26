INSERT INTO users(username, password, full_name, age, created_date, modified_date)
values ('admin','$2a$12$0GhjLVLPJu3TKHKM8r5E8e/nBFQoRvVNEVnRHlNXsKwJN.D5KVKeq', 'ADMIN ADMIN', 30,current_timestamp, current_timestamp );

Insert into roles(name, description, created_date, modified_date)
values ('ADMIN_ROLE', 'Role of admin', current_timestamp, current_timestamp),
       ('MANAGER_ROLE', 'Role of manager', current_timestamp,current_timestamp),
       ('USER_ROLE', 'Role of user', current_timestamp, current_timestamp);

Insert into user_role(USER_ID, ROLE_ID)
values (1,1),
       (1,2),
       (1,3);