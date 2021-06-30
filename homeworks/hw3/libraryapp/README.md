# Login Page
1. By entering http://localhost:8080/ URL firstly a page will be openned with two button options: Person List and Book List. DB-based login is used for this page
2. Then, by clicking one of the option their will be opened login page. 
    * The USERNAME AND PASSWORD are set mamed and mamed123 respectively.
    
## Validation for the Data Entry

* For both Add and Update operations of Person entity are used:
    * Annotations like- @Size indicates size of the name and surname the person which cannot be less than 2 characters
    * @Positive - which indicates that age cannot be minus 
    * @Max -Age should not be bigger than 200
    * @NotNull - Person's age cannot be null
    
* For both Add and Update operations of Book entity are used:
    * @NotEmpty - Book's name cannot be empty
    * @Size - Name cannot be less than 2 characters
    * @NotEmpty - Book's desciption cannot be empty
    * @Size - Description should not be shorter than 5 characters
    * @NotEmpty - Book's author cannot be empty
    * @Size - Name cannot be less than 2 characters
    

## Logging
* It is used different logging levels for each controller which are displayed on console in different pages:
    * WARNING - information on warnings
    * INFO - showing general information
    * SEVERE (ERROR) - output of error messages


