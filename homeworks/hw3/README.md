##### In my project, I have two entities that are Films-Actors and have a many-to-many relationship. 
###### In one of the main pages, called "Films", you can:

* find list of all the movies added to the database
* search for films by their categories (added by a non-native query) 
* search for films with more actors than the number you specified in the field (added by a native query)
* add new movies by clicking the “Add “a New Film” button and entering their information
* read detailed information about the films by clicking the "Click for More Info" button
* From there, edit and delete existing movie information
* add and remove actors from the listed films (you can add  several actors for one film)

##### All of the above mentioned operations can also be performed on the "Actors" page. Additionally, in order to handle my errors, I added an error page. For convenience, I've also added Films, Actors, and Return  Back buttons on the pages to make it easier to navigate from one page to another.





###### In addition (for the 3rd Assignment),
I used a database based login page and a PasswordEncoder with a strength of 8 for hashing passwords. I have added the following 5 logins manually from which you can login and check my project:

      (login, password):

* (‘elvina', ‘elvina’)
* (‘aydan', ‘aydan’)
* (‘gunel', ‘gunel’)
* (‘rashad', ‘rashad’)
* (‘ali', ‘ali’)


###### I also performed some validation on the entered data:

* In terms of film data, I have a @Size validation for the entered film title, producer, category and language. The length of all these values should be between the given min and max attributes.

* As for the actor data, I have @NotBlank and @Size validations for the entered first name, last name and birth place. If these fields are empty, a message will appear. In addition, the length of all entered values must be between the given min and max attributes.



###### I also used different logging levels for each controller:
###### ActorController, FilmController:
* Info logs while new actors(films) added or deleted
* Warn logs while there is an error with input data
* Error logs while there are some exceptions and errors

###### IndexController:
* Info logs while redirecting to other pages
