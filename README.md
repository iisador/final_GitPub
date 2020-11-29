Перед сборкой\запуском скачать архив https://www.dropbox.com/s/vgnys9aznvop2f2/sphinx.7z?dl=0
и распаковать в rest/src/main/resources/sphinx

- Для сборки серверной части выполнить: `mvn clean compile war -pl rest`
- Для запуска серверной части выполнить: `mvn spring-boot:run -pl rest`

- Для сборки клиентской части выполнить: `mvn clean compile -pl ui`
