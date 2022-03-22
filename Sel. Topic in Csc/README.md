
# algorthmic intuition

## Term Paper
1. [Algorithmic Intuition](https://github.com/EvanGertis/AlgorithmicIntuition/blob/master/term-paper/algorithmic-intuition.pdf)

## Research
1. [Designing Educationally Effective Algorithm Visualizations](https://github.com/EvanGertis/AlgorithmicIntuition/blob/master/papers/DesigningEducationallyEffectiveAlgorithmVisualizations.pdf)
2. [TOCE](https://github.com/EvanGertis/AlgorithmicIntuition/blob/master/papers/TOCE.pdf)

## Demonstration
1. [youtube video demonstration 1](https://www.youtube.com/watch?v=KFO0vJ1Ihwg)
2. [youtube video demonstration 2](https://www.youtube.com/watch?v=Eysu65LyC04)

## Stack
- Spring Boot 2.2.0.RELEASE
- Servlet API 2.5
- JSP, HTML, JS, CSS
- Tomcat 9

## Windows Set up
``` bash
set AV_DATABASE_URL=jdbc:mysql://localhost:3306/AlgorithmVisualization?serverTimezone=UTC
set DATABASE_USER=root
set DATABASE_PASSWORD=test123
set AV_SCHEMA=AlgorithmVisualization
```

## Docker
```bash
docker run -p 3307:3306 -e MYSQL_ROOT_PASSWORD=test123 -e MYSQL_DATABASE=AlgorithmVisualization mysql:5.7
```

## Install
1. To clean and build maven project, use:
    ```bash
    mvn clean install
    ```
2. To create and run the Spring boot application, run the following code:
    ```bash
    $ mvn spring-boot:run
    ```
## Example
[Algorithmic Visualization App](https://algorithmic-intuition.herokuapp.com/avs/show/1)
## Author
Evan Gertis

<br>

## License
Project is released under the [MIT](https://en.wikipedia.org/wiki/MIT_License).
