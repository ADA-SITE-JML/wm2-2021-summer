# Player & Football team management
* I have two entities - Players and Teams. The relationship is one-to-many.
* For authentication I used DB based authentication. BCrypt with 12 rounds has been used as the password encoder. admin admin can be used as default login credentials. 
* /login is where the login page is located. I used MvcConfig to point to the login view template.
* I added ExceptionController for managing exceptions. 
* templates/error_pages is the directory where the error pages are located.
* Logging level varies from controller to controller:
    * ExceptionController - Debug
    * PlayerController - Info
    * TeamController - Error
    * IndexController - Debug
    * Hibernate - Debug
* I also added the necessary validations. Names and Last names cannot be blank and need to be in a certain range.
* I made necessary changes in Controllers (adding BindingResult) and in HTMLs to display errors to the user.
