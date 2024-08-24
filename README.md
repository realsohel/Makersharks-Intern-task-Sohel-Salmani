### Steps to run the application -
1. Download the zip file in your local machine.
2. Open Intellij and run the application

### Run the API - 

1. create a post request on api - http://localhost:8080/api/supplier/addsupplier to add the supplier into the h2 db.
2. To check the supplier on h2-database run http://localhost:8080/h2-console on your brower and enter the credentials like - JDBC URL:	jdbc:h2:file:C:/Users/salma/Desktop/SpringTut/db1 (this should vary in your system), User Name: test and Password: test.
3. Create a Post request on api - http://localhost:8080/api/supplier/query to filter the data with the params - location, natureOfBusiness, manufacturingProcesses and size. Through this you'll get the data accordingly.

### Check the api on swagger api -
You can check the api documentation on swagger ui with the url - http://localhost:8080/swagger-ui/index.html

Please review it and hope you'll like the project. Please provide me with the honest feedback about the same. Thank you.
