# 📚 Library Management System (Java + JDBC)

## 📌 Project Overview

This project is a **console-based Library Management System** developed using **Java and JDBC** with **MySQL** as the backend database. It provides core functionalities required to manage a library such as **adding books, managing users, borrowing books, returning books, and tracking transactions**.

The project demonstrates real-world usage of **JDBC CRUD operations**, **database transactions**, and **clean separation of concerns using DAO classes**, making it suitable for **SDE-1 interviews, academic submissions, and resume portfolios**.

---

## 🛠️ Tech Stack

* **Programming Language:** Java
* **Database:** MySQL
* **Connectivity:** JDBC
* **Application Type:** Console-based
* **Architecture:** DAO (Data Access Object)

---

## 🗄️ Database Schema

### 📖 Books Table

Stores information about books available in the library.

```sql
CREATE TABLE books (
    book_id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100),
    author VARCHAR(100),
    available_copies INT
);
```

### 👤 Users Table

Stores registered library users.

```sql
CREATE TABLE users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100)
);
```

### 🔄 Transactions Table

Tracks borrowing and returning of books.

```sql
CREATE TABLE transactions (
    transaction_id INT PRIMARY KEY AUTO_INCREMENT,
    book_id INT,
    user_id INT,
    borrow_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    return_date TIMESTAMP,
    FOREIGN KEY (book_id) REFERENCES books(book_id),
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);
```

---

## 📁 Project Structure

```
LibraryManagementSystem/
│
├── DBConnection.java     // Database connection utility
├── BookDAO.java          // CRUD operations for books
├── UserDAO.java          // CRUD operations for users
├── TransactionDAO.java   // Borrow & return logic with transactions
└── Main.java              // Application entry point
```

---

## ⚙️ Features Implemented

✔ Add new books to the library
✔ Add and manage users
✔ Borrow books with availability check
✔ Return books with proper updates
✔ Maintain transaction history
✔ JDBC transaction handling using commit & rollback

---

## 🔄 Transaction Management (Key Highlight)

The borrowing and returning of books are handled using **JDBC transactions**:

* Auto-commit is disabled
* All operations execute as a single atomic unit
* Rollback is triggered on failure to maintain data consistency

This ensures **ACID properties** during critical operations.

---

## ▶️ How to Run the Project

### 1️⃣ Configure Database

* Create a MySQL database (e.g., `librarydb`)
* Execute the provided table creation queries
* Update database credentials in `DBConnection.java`

### 2️⃣ Compile the Project

```bash
javac *.java
```

### 3️⃣ Run the Application

```bash
java Main
```

---

## ⏱️ Time Complexity

| Operation     | Complexity |
| ------------- | ---------- |
| Add Book/User | O(1)       |
| Borrow Book   | O(1)       |
| Return Book   | O(1)       |
| Fetch Records | O(n)       |

---

## 🧠 Key Concepts Demonstrated

* JDBC CRUD Operations
* SQL and Database Design
* Transaction Management (`commit`, `rollback`)
* DAO Design Pattern
* Exception Handling
* Backend System Design

---

## 📄 Resume-Ready Project Description

> Developed a Library Management System using Java and JDBC with MySQL backend. Implemented CRUD operations for books and users, managed borrowing and returning using JDBC transactions, and ensured data consistency using commit and rollback mechanisms.

---

## 🚀 Future Enhancements

* Search and filter books
* User authentication and roles
* GUI using JavaFX or Swing
* REST API using Spring Boot
* Pagination and indexing for large datasets

---

## 🏁 Conclusion

This project showcases a complete backend-focused Library Management System using Java and JDBC. It reflects real-world database interaction, transaction handling, and clean code practices expected in professional software development.

---

**Author:** Vijaya babu
**Language:** Java
**Category:** Java | JDBC | Database Management
