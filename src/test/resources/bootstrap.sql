CREATE TABLE patient (
  id          SERIAL NOT NULL  PRIMARY KEY,
  patientId   VARCHAR(255),
  firstName   VARCHAR(255),
  middleName  VARCHAR(255),
  lastName    VARCHAR(255),
  dateOfBirth DATE
);


CREATE TABLE provider (
  id          SERIAL NOT NULL  PRIMARY KEY,
  providerId  VARCHAR(255),
  firstName   VARCHAR(255),
  middleName  VARCHAR(255),
  lastName    VARCHAR(255),
  dateOfBirth DATE
);

CREATE TABLE facility (
  id   SERIAL NOT NULL  PRIMARY KEY,
  name VARCHAR(255)
);

CREATE TABLE bulk_data (
  id          SERIAL NOT NULL  PRIMARY KEY,
  patient_id  INT REFERENCES patient (id),
  provider_id INT REFERENCES provider (id),
  value       VARCHAR(255)
);
