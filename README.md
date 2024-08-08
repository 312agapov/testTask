Для запуска требуется Docker
Команда для сборки образа: docker build -t testtask .
Команда для запуска: docker run -p 8080:8080 testtask

Для сборки и запуска без Docker:
mvn clean install
java -jar target/testTask-0.0.1-SNAPSHOT.jar

Описание endpoint-ов:
/computer - компьютеры
/harddrive - жесткие диски
/monitor - мониторы
/notebook - ноутбуки

Реализовано согласно REST принципам
Приложил файл Postman с запросами