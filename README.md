# Stock Management System (Java + MySQL)

A console-based inventory management system built using **Core Java** and **JDBC**.

## Features
- Add, update, delete, and view stock items
- Checks for low-stock items (below minimum level)
- MySQL database integration using JDBC

## Tech Stack
- Java
- MySQL
- JDBC (MySQL Connector/J)

## Setup Instructions
1. Create MySQL database:
   ```sql
   CREATE DATABASE stock_system;
   USE stock_system;
   CREATE TABLE items (
       id INT AUTO_INCREMENT PRIMARY KEY,
       name VARCHAR(100),
       current_stock INT,
       min_stock INT
   );
