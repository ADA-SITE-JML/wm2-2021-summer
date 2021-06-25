
## Hi, I am Fagan Rasulov

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