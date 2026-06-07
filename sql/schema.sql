CREATE DATABASE IF NOT EXISTS week7_jpa_db DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE week7_jpa_db;

DROP TABLE IF EXISTS student;
CREATE TABLE student (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    student_no VARCHAR(32) NOT NULL UNIQUE,
    name VARCHAR(50) NOT NULL,
    gender VARCHAR(10),
    age INT,
    class_name VARCHAR(50),
    major VARCHAR(100)
);
