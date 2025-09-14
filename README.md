# 📚 Book Management System (Spring MVC + Thymeleaf)

## 📌 Description
The **Book Management System** is a web application built using **Spring MVC, Thymeleaf, and MySQL**.  
It allows users to **add, view, update, and delete books** while applying **genre-based discounts and taxes**.

This project demonstrates the use of **Spring MVC architecture** with **Model-View-Controller** pattern,  
making it a perfect example of a small-scale CRUD application for learning purposes.

---

## 🚀 Features
- ➕ Add new books with details (title, author, price, genre)
- 📖 View all books in a structured table
- ✏️ Update book information
- ❌ Delete books
- 💰 Automatic **Discount and Tax Calculation** based on selected genre
- 🎨 User-friendly UI with Thymeleaf templates

---

## 🛠️ Tech Stack
- **Frontend:** Thymeleaf, HTML, CSS, Bootstrap
- **Backend:** Spring MVC, Java
- **Database:** MySQL
- **Build Tool:** Maven

---

## ⚙️ Installation & Setup
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/Book-Management-System.git

2. Import the project into Eclipse/IntelliJ as a Maven Project.

3. Configure the application.properties file with your MySQL credentials:
   spring.datasource.url=jdbc:mysql://localhost:3306/bookdb
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update


4. Run the Spring Boot application.

5. Open in browser:
   http://localhost:8080/
