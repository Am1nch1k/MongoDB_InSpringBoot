# MongoDB CRUD API with Spring Boot

[![Java](https://img.shields.io/badge/Java-17+-blue?logo=openjdk)](https://openjdk.java.net/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1.5-brightgreen?logo=springboot)](https://spring.io/projects/spring-boot)
[![MongoDB](https://img.shields.io/badge/MongoDB-7.0-green?logo=mongodb)](https://www.mongodb.com/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

Это RESTful API бэкенд-приложение, демонстрирующее базовые операции (CRUD) с базой данных **MongoDB** с использованием фреймворка **Spring Boot**.

## 📦 Технологический стек (Tech Stack)

- **Backend Framework**: Spring Boot 3.1.5
- **Language**: Java 21
- **Database**: MongoDB
- **Build Tool**: Maven
- **Дополнительные зависимости**:
  - Spring Data MongoDB
  - Spring Web
  - Spring Validation
  - Lombok (для сокращения boilerplate кода)


## 📡 API Endpoints

| Метод | Эндпоинт                     | Описание                                  |
|-------|-------------------------------|-------------------------------------------|
| GET   | `/api/students`               | Получить список всех студентов            |
| GET   | `/api/students/{id}`          | Получить студента по его ID               |
| GET   | `/api/students/email/{email}` | Получить студента по его email            |
| POST  | `/api/students`               | Создать нового студента                   |
| PUT   | `/api/students`               | Обновить данные существующего студента    |
| DELETE| `/api/students/{id}`          | Удалить студента по ID                    |


