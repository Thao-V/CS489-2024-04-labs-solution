# Deploy all apps in docker containers by using docker-compose
# Configuration
1. In Frontend app: Change the `URL` in the file `constants.js ` to: 
```JavaScript
export const URL = "http://127.0.0.1:8080/api/v1";
```
2. In the backend app: Allow the origin `"http://frontend:3000/"` in CORS configuration
```Java
public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("https://restifyme.com/", "http://localhost:3000/", "http://frontend:3000/")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
```
# Run 
1. docker-compose down
2. docker-compose build
3. docker-compose up
# As a result, you will see there different containers:
1. Frontend(React)
2. Backend (Spring-boot)
3. MySql