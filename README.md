## George Wu's solution for the ReliaQuest Entry Level Java Challenge
This is my solution for the ReliaQuest Entry Level Java Challenge. I have created three REST API endpoints, a service layer, a controller layer, and a repository layer.

## Endpoint Functions:

getAllEmployees(): Gets all of the employee objects inside of the repository.

getEmployeeByUuid(UUID uuid): Gets an employee by their unique UUID.

createEmployee(Object requestbody): Attempts to create a new Employee object with an object in JSON format passed into the function.

## How to Run (Postman)

Run the **EntryLevelJavaChallengeApplication.java** on **IntelliJ** or another IDE that supports Java. Then, open **Postman**. If you have an account, navigate to "Send an API Request" and click on the button next to it. You can change the HTTP method (GET/POST/PUT/DELETE) and enter the url. They are shown below:

```
Local Server: http://localhost:8080

Request Mapping: /api/v1/employee

Base URL: http://localhost:8080/api/v1/employee

getAllEmployees(): GET http://localhost:8080/api/v1/employee/employees

getEmployeeByUuid(): GET http://localhost:8080/api/v1/employee/employees/{uuid}

createEmployee(): POST http://localhost:8080/api/v1/employee/employees
```

## Testing

Here is the Employee object I used in testing:

```
{
  "uuid": "123e4567-e89b-12d3-a456-426614174000",
  "firstName": "Jon",
  "lastName": "Doe",
  "fullName": "Jon Doe",
  "salary": 150000,
  "age": 45,
  "jobTitle": "Senior Software Engineer",
  "email": "jon.doe@work.com",
  "contractHireDate": "2023-01-15T08:00:00Z",
  "contractTerminationDate": null
}
```

## Assumptions

Some assumptions will have to be made regarding the creation of an Employee and whether or not certain fields will be automatically be filled:

- All Employees need a UUID.

- The Employee's full name might not only be their first and last name together. A person may have a prefix, such as "Dr.", a suffix, such as "Sr.", and/or a middle name.

- The time that an Employee is added to the database might not be the date and time their contract started. They may have been hired earlier than the date and time their data was entered into the database.

