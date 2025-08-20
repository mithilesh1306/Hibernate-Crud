# Java CRUD Application with Hibernate & MySQL

This repository contains a command-line Java application that demonstrates fundamental database operations (Create, Read, Update, Delete) using Hibernate for Object-Relational Mapping (ORM).

## 1. Problem Statement

The goal of this project was to build a data persistence layer for a Java application without writing raw SQL. The primary challenge was to efficiently map Java `Student` objects to a `student_details` table in a MySQL database, creating a clean separation between business logic and data access code.

## 2. Tech Stack

* **Language:** Java
* **Framework:** Hibernate (ORM)
* **Database:** MySQL
* **Build Tool:** Apache Maven

## 3. Key Features

This application showcases the core principles of data management through a `StudentDao` (Data Access Object) class:

* **Create:** `saveStudent()` method to persist new student objects into the database.
* **Read:** `getStudent()` to fetch a single student by their ID and `getAllStudents()` to retrieve a list of all students.
* **Update:** `updateStudent()` to modify the details of an existing student record.
* **Delete:** `deleteStudent()` to remove a student from the database.
* **DAO Pattern:** The code is structured using the Data Access Object design pattern to cleanly separate the data persistence logic.

## 4. Challenges and What I Learned

A key challenge was correctly configuring the Hibernate session factory and managing the lifecycle of session objects to ensure efficient and error-free database transactions. This project solidified my understanding of ORM principles, the importance of the DAO design pattern, and how to effectively manage application data in a professional, scalable way.
