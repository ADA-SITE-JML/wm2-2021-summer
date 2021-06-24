insert into PROFILES(full_name, username, password, image, bio) values ('Fagan Rasulov', 'frasulov4671', 'fagan123', 'https://pixabay.com/get/gda872a398ea2132d0deab8c629b2cc28d0380593ab1935c963d4db2096a09230377fdb320faaf72fcea39dd4fce74d92_340.jpg', 'lorem text');
insert into PROFILES(full_name, username, password, image) values ('Jamal Haciyev', 'jhaciyev', 'fagan123', 'https://pixabay.com/get/gda872a398ea2132d0deab8c629b2cc28d0380593ab1935c963d4db2096a09230377fdb320faaf72fcea39dd4fce74d92_340.jpg');
insert into PROFILES(full_name, username, password, image) values ('Rewad Necefli', 'rnecefli', 'fagan123', 'https://pixabay.com/get/gda872a398ea2132d0deab8c629b2cc28d0380593ab1935c963d4db2096a09230377fdb320faaf72fcea39dd4fce74d92_340.jpg');

insert into POSTS(title,body, profile_id, image) values ('New Test blog', 'I am blog body', 1 , 'https://pixabay.com/get/gda872a398ea2132d0deab8c629b2cc28d0380593ab1935c963d4db2096a09230377fdb320faaf72fcea39dd4fce74d92_340.jpg');
insert into POSTS(title,body, profile_id, image) values ('New Test blog 2', 'I am blog body 2', 1, 'https://pixabay.com/get/gda872a398ea2132d0deab8c629b2cc28d0380593ab1935c963d4db2096a09230377fdb320faaf72fcea39dd4fce74d92_340.jpg');
insert into POSTS(title,body, profile_id, image) values ('New Test blog 3', 'I am blog body 3', 2, 'https://pixabay.com/get/gda872a398ea2132d0deab8c629b2cc28d0380593ab1935c963d4db2096a09230377fdb320faaf72fcea39dd4fce74d92_340.jpg');
insert into POSTS(title,body, profile_id, image) values ('New Test blog 4', 'I am blog body 4', 2, 'https://pixabay.com/get/gda872a398ea2132d0deab8c629b2cc28d0380593ab1935c963d4db2096a09230377fdb320faaf72fcea39dd4fce74d92_340.jpg');
insert into POSTS(title,body, profile_id, image) values ('New Test blog 5', 'I am blog body 5', 3, 'https://pixabay.com/get/gda872a398ea2132d0deab8c629b2cc28d0380593ab1935c963d4db2096a09230377fdb320faaf72fcea39dd4fce74d92_340.jpg');


insert into PROFILE_LIKED_POSTS(POST_ID, PROFILE_ID) values (1,3);
insert into PROFILE_LIKED_POSTS(POST_ID, PROFILE_ID) values (1,1);
insert into PROFILE_LIKED_POSTS(POST_ID, PROFILE_ID) values (1,2);
insert into PROFILE_LIKED_POSTS(POST_ID, PROFILE_ID) values (3,2);
insert into PROFILE_LIKED_POSTS(POST_ID, PROFILE_ID) values (2,2);
insert into PROFILE_LIKED_POSTS(POST_ID, PROFILE_ID) values (5,2);
