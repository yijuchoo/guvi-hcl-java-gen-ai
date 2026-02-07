# MySQL Task: Clinic Database Setup

## Scenario

You’ve joined a small engineering team building an internal system for a local clinic.
The clinic currently tracks patients and appointments in spreadsheets, which is causing duplicate entries, missing data, and confusion during busy hours.

Your job is to set up the initial MySQL database so the clinic can reliably store and query:

1. Patient details
2. Appointment records

Follow the instructions below exactly. Use clean naming and write queries that are readable.

## Part A: Database Setup

1. Create a new database named: `clinic_db`
2. Switch to the database so the rest of your queries run inside `clinic_db`.

## Part B: Create Tables

### 3) Create `patients` table

Create a table named `patients` with the following columns and data types (**do not add constraints yet**):

* `patient_id`: INT
* `full_name`: VARCHAR(100)
* `phone`: VARCHAR(15)
* `age`: INT
* `city`: VARCHAR(50)

### 4) Create `appointments` table

Create a table named `appointments` with the following columns and data types (**do not add constraints yet**):

* `appointment_id`: INT
* `patient_id`: INT
* `doctor_name`: VARCHAR(100)
* `visit_date`: DATE
* `status`: VARCHAR(20)

## Part C: Insert Data

### 5) Insert patient records

Insert at least **6 patients** into the `patients` table. Your dataset must include:

* At least two patients from Bangalore (or your favorite city)
* At least one patient from Chennai (or a different city)
* At least two patients with age above 40
* At least one patient with age below 18

Use realistic names and phone numbers.

### 6) Insert appointment records

Insert at least **8 appointments** into the `appointments` table. Your dataset must include:

* At least two appointments for the same patient
* A mix of at least two doctors
* At least three different status values (e.g., Scheduled, Completed, Cancelled)
* At least two appointments scheduled on the same date

Use realistic dates (any year is fine).

## Part D: Read Queries

Write SQL queries for each of the following:

7. Fetch all patients who live in Bangalore.
8. Fetch patients who are older than 40, showing only: `full_name`, `age`, `city`
9. Fetch all appointments with `status = 'Scheduled'`.
10. Fetch appointments for a specific doctor (choose one from your inserted data), showing only:

    * `appointment_id`, `patient_id`, `visit_date`, `status`

## Part E: Update and Delete

11. A patient changed their phone number.

    * Update the phone of one specific patient (pick by `patient_id`).

12. One appointment was incorrectly marked as Scheduled.

    * Update that appointment’s status to Cancelled (pick by `appointment_id`).

13. A test record was inserted by mistake.

    * Delete one appointment using `appointment_id`.

## Part F: Relational Challenge

You will now enforce the relationship between appointments and patients, and then use a join to answer a reporting question.

### 14) Add constraints

* Make `patients.patient_id` the Primary Key
* Make `appointments.appointment_id` the Primary Key
* Add a Foreign Key so that `appointments.patient_id` references `patients.patient_id`

### 15) INNER JOIN report query

Write an INNER JOIN query that produces this output for all appointments:

* `appointment_id`
* `patient_name` (from `patients.full_name`)
* `doctor_name`
* `visit_date`
* `status`

Sort the results by `visit_date` (latest to oldest).

## Submission Checklist

Before submitting, confirm you have:

* Created `clinic_db`
* Created both tables with the specified columns and types
* Inserted the required minimum data (6 patients, 8 appointments)
* Written all SELECT queries with correct filters/projection
* Performed update + delete correctly
* Added PK + FK
* Written the INNER JOIN report query
