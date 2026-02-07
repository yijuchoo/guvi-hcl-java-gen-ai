-- MySQL Task: Clinic Database Setup
-- Part A: Database Setup
-- Create a new database named: clinic_db
CREATE DATABASE clinic_db;
-- Switch to the database so the rest of your queries run inside clinic_db.
USE clinic_db;

-- Part B: Create Tables
-- 3) Create patients table
-- Create a table named patients with the following columns and data types (do not add constraints yet):
CREATE TABLE patients (
	patient_id INT,
    full_name VARCHAR(100),
    phone VARCHAR(15),
    age int,
    city varchar(50)
);

DROP TABLE patients;
DROP TABLE appointments;

-- 4) Create appointments table
-- Create a table named appointments with the following columns and data types (do not add constraints yet):
CREATE TABLE appointments (
	appointment_id INT,
    patient_id INT,
    doctor_name VARCHAR(100),
    visit_date DATE,
    status VARCHAR(20)
);

-- Part C: Insert Data
-- 5) Insert patient records
-- Insert at least 6 patients into the patients table. Your dataset must include:
INSERT INTO patients(patient_id, full_name, phone, age, city) VALUES
(1, 'Soumyajit Nandi', 91243527, 24, 'Bangalore'),
(2, 'Nikhil Nair', 96425502, 28, 'Bangalore'),
(3, 'Sridhar Ramadoss', 84622011, 23, 'Chennai'),
(4, 'Yirou Choo', 86633523, 41, 'Bangalore'),
(5, 'Tuvesh Nair', 96425502, 45, 'Chennai'),
(6, 'Malini Muthusami', 84002010, 16, 'Chennai');

-- At least two patients from Bangalore (or your favorite city)
INSERT INTO patients(patient_id, full_name, phone, age, city) VALUES
(1, 'Soumyajit Nandi', 91243527, 24, 'Bangalore'),
(2, 'Nikhil Nair', 96425502, 28, 'Bangalore');

-- At least one patient from Chennai (or a different city)
INSERT INTO patients(patient_id, full_name, phone, age, city) VALUES(3, 'Sridhar Ramadoss', 84622011, 23, 'Chennai');

-- At least two patients with age above 40
INSERT INTO patients(patient_id, full_name, phone, age, city) VALUES
(4, 'Yirou Choo', 86633523, 41, 'Bangalore'),
(5, 'Tuvesh Nair', 96425502, 45, 'Chennai');

-- At least one patient with age below 18
INSERT INTO patients(patient_id, full_name, phone, age, city) VALUES(6, 'Malini Muthusami', 84002010, 16, 'Chennai');

-- 6) Insert appointment records
-- Insert at least 8 appointments into the appointments table. Your dataset must include:
INSERT INTO appointments(appointment_id, patient_id, doctor_name, visit_date, status) VALUES
(1, 1, 'Dr Darius Yang', '2025-12-15', 'Completed'),
(2, 1, 'Dr Darius Yang', '2026-01-02', 'Completed'),
(3, 2, 'Dr Melvin Goh', '2026-01-02', 'Completed'),
(4, 3, 'Dr Doreen Chia', '2026-01-03', 'Completed'),
(5, 5, 'Dr Melvin Goh', '2026-01-03', 'Cancelled'),
(6, 4, 'Dr Darius Yang', '2026-01-05', 'Completed'),
(7, 4, 'Dr Doreen Chia', '2026-01-12', 'Scheduled'),
(8, 5, 'Dr Melvin Goh', '2026-01-10', 'Scheduled'),
(9, 6, 'Dr Darius Yang', '2026-01-10', 'Scheduled');

-- At least two appointments for the same patient
INSERT INTO appointments(appointment_id, patient_id, doctor_name, visit_date, status) VALUES
(1, 1, 'Dr Darius Yang', '2025-12-15', 'Completed'),
(2, 1, 'Dr Darius Yang', '2026-01-02', 'Completed');

-- A mix of at least two doctors
INSERT INTO appointments(appointment_id, patient_id, doctor_name, visit_date, status) VALUES
(3, 2, 'Dr Melvin Goh', '2026-01-02', 'Completed'),
(4, 3, 'Dr Doreen Chia', '2026-01-03', 'Completed');

-- At least three different status values (e.g., Scheduled, Completed, Cancelled)
INSERT INTO appointments(appointment_id, patient_id, doctor_name, visit_date, status) VALUES
(5, 5, 'Dr Melvin Goh', '2026-01-03', 'Cancelled'),
(6, 4, 'Dr Darius Yang', '2026-01-05', 'Completed'),
(7, 4, 'Dr Doreen Chia', '2026-01-12', 'Scheduled');

-- At least two appointments scheduled on the same date
-- Use realistic dates (any year is fine).
INSERT INTO appointments(appointment_id, patient_id, doctor_name, visit_date, status) VALUES
(8, 5, 'Dr Melvin Goh', '2026-01-10', 'Scheduled'),
(9, 6, 'Dr Darius Yang', '2026-01-10', 'Scheduled');


-- Part D: Read Queries
-- Write SQL queries for each of the following:

-- Fetch all patients who live in Bangalore.
SELECT *
FROM patients
WHERE city = 'Bangalore';

-- Fetch patients who are older than 40, showing only: full_name, age, city
SELECT full_name, age, city
FROM patients
WHERE age > 40;

-- Fetch all appointments with status = 'Scheduled'.
SELECT *
FROM appointments
WHERE status = 'Scheduled';

-- Fetch appointments for a specific doctor (choose one from your inserted data), showing only:
-- appointment_id, patient_id, visit_date, status
SELECT appointment_id, patient_id, visit_date, status
FROM appointments
WHERE doctor_name = 'Dr Melvin Goh';


-- Part E: Update and Delete
-- A patient changed their phone number.
-- Update the phone of one specific patient (pick by patient_id).
UPDATE patients
SET phone = '90043500'
WHERE patient_id = 1;

-- One appointment was incorrectly marked as Scheduled.
-- Update that appointment’s status to Cancelled (pick by appointment_id).
UPDATE appointments
SET status = 'Cancelled'
WHERE appointment_id = 7;

-- A test record was inserted by mistake.
-- Delete one appointment using appointment_id.
DELETE 
FROM appointments
WHERE appointment_id = 9;

-- DESCRIBE the table schema
DESCRIBE patients;
DESCRIBE appointments;

-- Part F: Relational Challenge
-- You will now enforce the relationship between appointments and patients, and then use a join to answer a reporting question.
-- 14) Add constraints
-- Make patients.patient_id the Primary Key
ALTER TABLE patients
MODIFY patient_id INT NOT NULL AUTO_INCREMENT,
ADD PRIMARY KEY (patient_id);

-- Make appointments.appointment_id the Primary Key
ALTER TABLE appointments
MODIFY appointment_id INT NOT NULL AUTO_INCREMENT,
ADD PRIMARY KEY (appointment_id);

-- Add a Foreign Key so that appointments.patient_id references patients.patient_id
ALTER TABLE appointments
ADD CONSTRAINT fk_appointments_patient
FOREIGN KEY (patient_id)
REFERENCES patients(patient_id);


-- 15) INNER JOIN report query
-- Write an INNER JOIN query that produces this output for all appointments:
-- appointment_id
-- patient_name (from patients.full_name)
-- doctor_name
-- visit_date
-- status
-- Sort the results by visit_date (latest to oldest).
SELECT 
	a.appointment_id, 
    p.full_name AS patient_name,
    a.doctor_name,
    a.visit_date,
    a.status
FROM appointments a
INNER JOIN patients p
ON a.patient_id = p.patient_id
ORDER BY a.visit_date DESC;

