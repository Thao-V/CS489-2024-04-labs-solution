# Guide to create the configuration for different environments and avoid to push the sensitive data to github
1. Create the new file `application-dev.properties` in recources and add this file to .gitignore
2. Configure the content below in the above file
spring.datasource.url=jdbc:mysql://localhost/database-name
spring.datasource.username=username
spring.datasource.password=password
3. Replace the above content by the following line in the file `application.properties`
spring.profiles.active=dev
