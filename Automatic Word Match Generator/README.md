# programming_teacher

## Stack
- Spring Boot 2.2.0.RELEASE
- Servlet API 2.5
- JSP, HTML, JS, CSS
- Tomcat 9

## Windows Set up
``` bash
set JAVA_HOME=`/usr/libexec/java_home -v 1.8`; java -version
set DATABASE_URL=jdbc:mysql://localhost:3307/TestExercise?serverTimezone=UTC
set DATABASE_USER=root
set DATABASE_PASSWORD=test123
set SCHEMA=TestExercise
```

## macOS
```
export JAVA_HOME=`/usr/libexec/java_home -v 1.8`; java -version
export DATABASE_URL=jdbc:mysql://localhost:3307/TestExercise?serverTimezone=UTC;
export DATABASE_USER=root;
export DATABASE_PASSWORD=test123;
export SCHEMA=TestExercise;
```

## Docker
```bash
docker run -p 3307:3306 -e MYSQL_ROOT_PASSWORD=test123 -e MYSQL_DATABASE=TestExercise mysql:5.7
```
[docker mysql getting started](https://phoenixnap.com/kb/mysql-docker-container)

## Install
1. To clean and build maven project, use:
    ```bash
    mvn clean install
    ```
2. To create and run the Spring boot application, run the following code:
    ```bash
    $ mvn spring-boot:run
    ```

