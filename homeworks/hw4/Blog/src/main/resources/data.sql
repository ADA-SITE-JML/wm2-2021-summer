insert into users(email, enabled,locked,password,user_role, username) values
('admin@gmail.com', true , false, '$2a$12$sYtBcALafNcIw1O2X7P0Lun0bHvVSCbFxZyYyP/zGLWJg.wy5.yxS','ADMIN', 'admin');


insert into users(email, enabled,locked,password,user_role, username) values
('frasulov@gmail.com', true , false, '$2a$12$dXd2DoAqbEhiMuJWGCv2ye5kz2kNDt7z1Y0J3SQHpgLihKnaEuVHm','USER', 'frasulov');

insert into PROFILES(full_name, username, password, image, bio,user_id) values ('Admin user', 'admin', 'admin', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRfrLAZZRhW85ny1UWBbuyo4_ATKJgx7dHK6Q&usqp=CAU', 'my bio',1);
insert into PROFILES(full_name, username, password, image, bio,user_id) values ('Fagan Rasulov', 'frasulov4671', 'fagan123', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSOd256TcC6vcaQ99TYzoP0pBbch9_Q-bbrmw&usqp=CAU', 'lorem text',2);
insert into PROFILES(full_name, username, password, image,user_id) values ('Jamal Haciyev', 'jhaciyev', 'fagan123', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRC8kiSH5ZSAcVoj3tAQQDoP_ux0sSricMyUg&usqp=CAU',2);
insert into PROFILES(full_name, username, password, image,user_id) values ('Tehmine Qasimova', 'tqasimova', 'fagan123','https://i.pinimg.com/originals/39/1e/e1/391ee12077ba9cabd10e476d8b8c022b.jpg',1);

insert into POSTS(title,body, profile_id, image) values ('Problems with Managing Your Own Property', 'Another great area of problems to explore in your blogging strategy is the types of problems someone might experience in their role, if that role is someone you typically target as a decision-maker — or, at least an influencer in the decision-making process. It demonstrates you understand their most pressing challenges and concerns in their day-to-day, which is key to winning their trust as a resource. ', 1, 'https://media.istockphoto.com/photos/bloggingblog-concepts-ideas-with-worktable-picture-id922745190?k=6&m=922745190&s=612x612&w=0&h=qBmau_GKQZasMW14NJBp3u2vU-f5YFCcN1N71Exa8iE=');
insert into POSTS(title,body, profile_id, image) values ('WPEngine vs. GoDaddy', 'No, we don''t sell WPEngine or GoDaddy website hosting for WordPress websites. But it''s probably one of the most important decisions a company will make about their business website hosted on WordPress, and they usually don''t even realize it. (Short version: The hosting you choose for your WordPress website will drastically impact how well your content shows up in search results.) So, we wrote about it in this detailed comparison article.', 1, 'https://www.goodcore.co.uk/blog/wp-content/uploads/2019/08/coding-vs-programming-2.jpg');
insert into POSTS(title,body, profile_id, image) values ('Project Manager vs. Construction Manager', 'Sometimes it''s not about comparing product or service A to product or service B. Sometimes, you need to talk about who are the best people you need to hire to get a project done. This fantastic example from Aquila, we''re talking about the best fit for an office build-out. ', 2, 'https://spectrum.ieee.org/image/MzI0NDQ4Ng.jpeg');
insert into POSTS(title,body, profile_id, image) values ('Spring boot Development', 'Learn with us', 2, 'https://javacodehouse.com/assets/img/spring-boot/what-is-spring-boot.jpg');
insert into POSTS(title,body, profile_id, image) values ('Django Development', 'Create projects', 3, 'https://i.ytimg.com/vi/04L0BbAcCpQ/maxresdefault.jpg');
insert into POSTS(title,body, profile_id, image) values ('Apartment Therapy', 'Apartment Therapy is a blog focusing on interior design. It was launched by Maxwell Ryan in 2001. Ryan is an interior designer who turned to blogging (using the moniker “the apartment therapist”). The blog has reached 20 million followers and has expanded into a full-scale media company.', 4, 'https://firstsiteguide.com/wp-content/uploads/2021/01/Best-mom-blog-examples-1.png');

insert into PROFILE_LIKED_POSTS(POST_ID, PROFILE_ID) values (1,3);
insert into PROFILE_LIKED_POSTS(POST_ID, PROFILE_ID) values (1,1);
insert into PROFILE_LIKED_POSTS(POST_ID, PROFILE_ID) values (1,2);
insert into PROFILE_LIKED_POSTS(POST_ID, PROFILE_ID) values (3,2);
insert into PROFILE_LIKED_POSTS(POST_ID, PROFILE_ID) values (2,2);
insert into PROFILE_LIKED_POSTS(POST_ID, PROFILE_ID) values (5,2);
insert into PROFILE_LIKED_POSTS(POST_ID, PROFILE_ID) values (6,1);