# MongoDB CRUD API with Spring Boot

[![Java](https://img.shields.io/badge/Java-17+-blue?logo=openjdk)](https://openjdk.java.net/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1.5-brightgreen?logo=springboot)](https://spring.io/projects/spring-boot)
[![MongoDB](https://img.shields.io/badge/MongoDB-7.0-green?logo=mongodb)](https://www.mongodb.com/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

Это учебный RESTful API бэкенд-приложение, демонстрирующее базовые операции (CRUD) с базой данных **MongoDB** с использованием фреймворка **Spring Boot**.

Проект реализует простую модель данных для сущности `Student` и предоставляет полный набор эндпоинтов для взаимодействия с ней.

## 🚀 Возможности (Features)

- **Полный CRUD функционал**: Create, Read, Update, Delete для сущности Student.
- **Использование Spring Data MongoDB**: Для простого и эффективного взаимодействия с БД.
- **Гибкие запросы**:
  - Получение всех студентов (`GET /api/students`)
  - Получение студента по его ID (`GET /api/students/{id}`)
  - Получение студента по email (`GET /api/students/email/{email}`)
  - Создание нового студента (`POST /api/students`)
  - Обновление данных студента (`PUT /api/students`)
  - Удаление студента по ID (`DELETE /api/students/{id}`)
- **Валидация данных**: Аннотации `@NotNull`, `@NotBlank` для проверки входящих запросов.
- **Централизованная обработка ошибок**: Глобальный обработчик исключений (`@ControllerAdvice`) для возврата структурированных ошибок API.
- **Подробное логирование**: Логирование на уровне INFO для отслеживания операций.

## 📦 Технологический стек (Tech Stack)

- **Backend Framework**: Spring Boot 3.1.5
- **Language**: Java 17
- **Database**: MongoDB
- **Build Tool**: Maven
- **Дополнительные зависимости**:
  - Spring Data MongoDB
  - Spring Web
  - Spring Validation
  - Lombok (для сокращения boilerplate кода)

## 📋 Модель данных (Data Model)

Сущность **Student** представлена следующим образом:

| Поле       | Тип данных     | Описание                          | Обязательное |
|------------|----------------|-----------------------------------|--------------|
| `id`       | `String`       | Уникальный идентификатор (генерируется MongoDB) | Нет          |
| `name`     | `String`       | Имя студента                      | Да           |
| `surname`  | `String`       | Фамилия студента                  | Да           |
| `email`    | `String`       | Email адрес (уникальный)          | Да           |
| `gender`   | `Gender` (Enum)| Пол (`MALE`, `FEMALE`, `OTHER`)   | Да           |
| `subjects` | `List<String>` | Список изучаемых предметов        | Нет          |
| `totalSpentInBooks` | `BigDecimal` | Общая сумма, потраченная на книги | Нет          |
| `created`  | `LocalDateTime`| Дата и время создания записи      | Нет (авто)   |

## 🛠️ Установка и запуск (Installation & Setup)

### Предварительные требования

1. **Java 17** или выше ([Download & Install](https://adoptium.net/))
2. **Maven** ([Download & Install](https://maven.apache.org/download.cgi))
3. **MongoDB** (Локально установленная или облачный инстанс, например, [MongoDB Atlas](https://www.mongodb.com/atlas/database))

### Шаги для запуска

1. **Клонируйте репозиторий**
   ```bash
   git clone https://github.com/Am1nch1k/MongoDB_InSpringBoot.git
   cd MongoDB_InSpringBoot
   ```

2. **Настройте подключение к MongoDB**

   Откройте файл `src/main/resources/application.properties` и измените строку подключения в соответствии с вашей конфигурацией MongoDB.

   *Пример для локальной MongoDB:*
   ```properties
   spring.data.mongodb.uri=mongodb://localhost:27017/studentdb
   ```

   *Пример для MongoDB Atlas (замените на свои значения):*
   ```properties
   spring.data.mongodb.uri=mongodb+srv://<username>:<password>@<your-cluster-url>/studentdb?retryWrites=true&w=majority
   ```

3. **Соберите и запустите приложение**
   ```bash
   # Сборка проекта
   mvn clean install

   # Запуск приложения
   mvn spring-boot:run
   ```

   Приложение будет запущено на `http://localhost:8080`.

## 📡 API Endpoints

| Метод | Эндпоинт                     | Описание                                  |
|-------|-------------------------------|-------------------------------------------|
| GET   | `/api/students`               | Получить список всех студентов            |
| GET   | `/api/students/{id}`          | Получить студента по его ID               |
| GET   | `/api/students/email/{email}` | Получить студента по его email            |
| POST  | `/api/students`               | Создать нового студента                   |
| PUT   | `/api/students`               | Обновить данные существующего студента    |
| DELETE| `/api/students/{id}`          | Удалить студента по ID                    |

### Примеры запросов с помощью cURL

**1. Создание студента (POST)**
```bash
curl -X POST http://localhost:8080/api/students \
-H "Content-Type: application/json" \
-d '{
  "name": "Alex",
  "surname": "Johnson",
  "email": "alex.johnson@example.com",
  "gender": "MALE",
  "subjects": ["Math", "Computer Science"],
  "totalSpentInBooks": 250.50
}'
```

**2. Получение всех студентов (GET)**
```bash
curl -X GET http://localhost:8080/api/students
```

**3. Получение студента по email (GET)**
```bash
curl -X GET http://localhost:8080/api/students/email/alex.johnson@example.com
```

**4. Обновление студента (PUT)**
```bash
curl -X PUT http://localhost:8080/api/students \
-H "Content-Type: application/json" \
-d '{
  "id": "507f1f77bcf86cd799439011",
  "name": "Alexander",
  "surname": "Johnson",
  "email": "alexander.johnson@example.com",
  "gender": "MALE",
  "totalSpentInBooks": 300.00
}'
```

**5. Удаление студента по ID (DELETE)**
```bash
curl -X DELETE http://localhost:8080/api/students/507f1f77bcf86cd799439011
```

## 🤝 Как можно помочь проекту (Contributing)

Вклады в проект приветствуются! Если у вас есть предложения по улучшению:

1. Сделайте форк репозитория.
2. Создайте feature-ветку (`git checkout -b feature/AmazingFeature`).
3. Закоммитьте ваши изменения (`git commit -m 'Add some AmazingFeature'`).
4. Запушите в ветку (`git push origin feature/AmazingFeature`).
5. Откройте Pull Request.

## 📜 Лицензия (License)

Этот проект распространяется под лицензией MIT. Подробнее см. в файле [LICENSE](LICENSE).

## 👤 Автор (Author)

**Am1nch1k**

- GitHub: [@Am1nch1k](https://github.com/Am1nch1k)

---

⭐ Не забудьте поставить звезду репозиторию, если этот проект был вам полезен!
```

---

### Что еще можно добавить в будущем:

1.  **Документация Swagger/OpenAPI:** Добавление зависимостей `springdoc-openapi` для автоматической генерации красивого API-документации.
2.  **Тесты:** Разделы с примерами Unit-тестов (с помощью `@DataMongoTest`) и Integration-тестов.
3.  **Деплой:** Инструкции по деплою на облачные платформы (Heroku, Railway, AWS).
4.  **Docker:** Добавление `Dockerfile` и `docker-compose.yml` для запуска всего стека (App + MongoDB) одной командой.

Этот `README.md` уже сейчас представляет ваш проект как качественный и профессиональный учебный пример.
