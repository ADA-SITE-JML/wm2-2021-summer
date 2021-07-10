# Hi, I am Fagan Rasulov.

#### What i have tested

* Permission class methods
	* hasPermission
	* isLoggedIn
* Post Service methods
	* getAllPosts
	* getLikedPosts
	* getPost
	* getPost (testing exception)
	* GetPostByAuthor
	* savePost
* Post Controller methods
	* listPosts
	* listPosts (with no logging to any profile)
	* createPostView
	* createPostView (with form errors)
	* createPostView (with no logging to any profile)
	* togglePost
	* togglePost (with no logging to any profile)
	* deletePost
* Post Controller test with Selenium
	* BeforeAll (login and switch to profile)
	* Create new Post
	* Edit a Post
	* Edit Post which is not allowed
	* Delete Post
	* AfterAll (logout and close the driver)
