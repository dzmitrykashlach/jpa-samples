alter table address add constraint fk_address_1 foreign key (user_id) references user_details;

insert into user_details (name, email, mobile_number) values ('John', 'john_1@gmail.com', '_919876543219');
insert into user_details (name, email, mobile_number) values ('John Carter', 'john_carter@gmail.com', '_919876543218');

select * from user_details;
 INSERT INTO address
   (
        address1,
        address2,
        street,
        city,
        state,
        country,
        user_id
   )
   SELECT
   'address1_john',
   'address2_john',
   'street_john',
   'Hyderabad',
   'Telangana',
    'India',
    id
   FROM
       user_details
   WHERE
       email = 'john_1@gmail.com';

  INSERT INTO address
    (
         address1,
         address2,
         street,
         city,
         state,
         country,
         user_id
    )
    SELECT
    'address1_john_1',
    'address2_john_1',
    'street_john_1',
    'Hyderabad',
    'Telangana',
     'India',
     id
    FROM
        user_details
    WHERE
        email = 'john_1@gmail.com';

  INSERT INTO address
    (
         address1,
         address2,
         street,
         city,
         state,
         country,
         user_id
    )
    SELECT
    'address1_john_carter',
    'address2_john_carter',
    'street_john_carter',
    'Hyderabad',
    'Telangana',
     'India',
     id
    FROM
        user_details
    WHERE
        email = 'john_carter@gmail.com';