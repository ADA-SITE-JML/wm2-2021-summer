# INFT2405 – AS03 – Car-Rental

**Car-Rental** is my Spring Boot project intended to be used by car rental agencies. Users can log in to modify the existing data in the system. There are 2 entities (besides the User): Car & Customer. Both entities support **New/Edit/List/Delete** operations.

**Database**: H2
**Template Engine**: Thymeleaf
**Java Version**: 11


*Info*, *warning*, and *error* levels are used for **logging**. Logger is used to print information regarding successful/unsuccessful login and registration attempts, rent/unrent requests, CRUD operations, attempts to access protected resources without login.

Input data is validated on the front end. Minimal password length is 6. All fields in the login and registration pages are mandatory.

### Dummy user account credentials:
* **Email**: nuray@mail.com
* **Password**: 123123123

