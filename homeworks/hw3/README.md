
## Hi, I am Fagan Rasulov

# Added or Updated in Assignment 3

* You can also create your own user in db. However it is recommended to use register for this because of hashed password. I have used BCryptPasswordEncoder with 12 rounds.
* I have specified two data source. You can use one them by making primary. I made H2 DB primary. If you want to use Online postgres DB, make it primary. If you use Online Postgres DB, you need to wait about 3 mins minutes to run application because of connection.
* If you use H2 Database, data.sql will initialized. Or in online postgres already initialized. So, you can login with admin, admin to spring security and also to profile (username=admin, password=admin);
* Each user can have multiple profiles.
* Once you run application, you will be able to open only /login or /signup pages. /login post request is deafult request from Spring Security.
* While register, password stored in hashed format.
* When you switch to the new profile after Spring Security login, you can switch profiles which belong to logged User. As you seen from table, user is foreign key for profile.
 New user registered in USER mode. You can make them in ADMIN mode only from database.
 * After registering or logging to user, you can create new profile which is gonna belong to the current user.

#### Possible logins

* User:username = admin, password = admin
	* Profile: username=admin, password=admin
	* Profile: username=tqasimova, password=fagan123
* User: username=frasulov, password=frasulov123
	* Profile: username=frasulov4671, password=fagan123
	* Profile: username=jhaciyev, password=fagan123

#### Validations

##### Profile

|  Fullname  |  Username  |  Password  | Image |
|------------|------------|------------|-------|
|  Notblank  |  Notblank  |  Notblank  |  URL  |
| Size(2,65) | Size(5,65) | Size(8,65) |       |

###### Custom Profile exceptions
* Password cannot be same with username
* Full name must be written with space (' ')


##### Post

|   Title  | Body        | Image |
|----------|-------------|-------|
| Notblank | Notblank    |  URL  |
|   	   | Size(32,500)|       |

###### Custom Post exceptions
* Check permissions on delete and update. Only profile who create that post can update or delete
* It throws new PostException if user has no permission. In controller, exception is catched and redirect to /error url. I have used ModelAndView and RedirectAttributes attr for redirecting in order to no to lose Model attr after redirecting.


##### User

|   Email  | User Role  |  Username  |
|----------|------------|------------|
| NotBlank | Admin/User |  NotBlank  | 
| Email    | Admin/User | Size(5,65) | 

###### Custom User exceptions
* Username should be unique
* Email should be unique
* Username cannot be same with password
	* How works? It thorws exception and in controller exception is catched and new Errorfiled added to bindingResult;


### Logs

* Error logs when any exception or error happens
* Warning logs when permission denied or need login
* Info lofs when Entity created, updated or deleted

### Permission Class

* Generally, it passed to template and used for permission checking like 'isLiked', 'hasPermission'(for edit delete) and etc.


#### Tables

* User

| ID | Email | Enabled | Locked | Password | User Role  | Username |
|----|-------|---------|--------|----------|------------|----------|
| PK |unique | boolean |boolean |  hashed  | Admin/User |  unique  | 


* Profile (User id foreign key added)

| ID | Fullname | Username | Password | Image | Bio | Created | Updated |   User_ID   |
|----|----------|----------|----------|-------|-----|---------|---------|-------------|
| PK |          |  unique  |          | link  |     |  now()  |   now() | fk User(ID) |



# From Assignment 2

### My project has Profile and Post Models. Simple Blog application.

###### How works?

* Needs login in order to see all pages (except, register);
	* There is no login technology. Just checks, if there is an such user, assign user as a session attribute
	* Use admin for username and password
	* You can switch user, in the login page after logged in.
* You can create a post
* All Posts page shows all posts that created by profiles.
* You can edit or delete posts only and only if you are the author of the post
* You can like any post
	* I added hidden input in the like post. Which control redirect url. For example if you like any post in the Profile page you will redirect to profile page.
* Like Posts page show all posts that liked by you.
* My profile Page shows profile information.
	* If you go /profile, you will see logged profile information.
	* If you go /profile/{profileID}, you will see specified profile information
	* You will see info about profile
	* You will posts that created by that profile
* You can edit your profile, by clicking edit Profile link in the profile page
* You can remove your profile
* You can click profile author in the posts in order to go to the author's profile page


##### Tables
###### Second row represent constraint or default value.

* Profile

| ID | Fullname | Username | Password | Image | Bio | Created | Updated |
|----|----------|----------|----------|-------|-----|---------|---------|
| PK |          |  unique  |          |       |     |  now()  |   now() |



* Post

| ID |   Title  | Body | Image | Created | Updated |     Author     |
|----|----------|------|-------|---------|---------|----------------|
| PK | not null |      |       |  now()  |  now()  | fk Profile(ID) |


* Profile_liked_Posts

|   Post ID   |   Profile ID   |
|-------------|----------------|
| fk Post(ID) | fk Profile(ID) |


##### Kindly regards
##### Fagan
