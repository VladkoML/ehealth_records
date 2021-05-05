CREATE TABLE IF NOT EXISTS patients(
    patient_id SERIAL PRIMARY KEY,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(50) NOT NULL,
    full_name VARCHAR(50) NOT NULL,
    birthday DATE NOT NULL,
    weight INT,
    height INT,
    sex VARCHAR(10) NOT NULL,
    info TEXT,
    address_of_residence VARCHAR(255) NOT NULL,
    address_of_work VARCHAR(255),
    blood_type VARCHAR(10) NOT NULL,
    profession VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS records(
    record_id SERIAL PRIMARY KEY,
    created_in TIMESTAMP NOT NULL,
    disease VARCHAR(100) NOT NULL,
    complains TEXT,
    medical_treatment TEXT NOT NULL,
    name_of_hospital VARCHAR(255) NOT NULL,
    address_of_hospital VARCHAR(255) NOT NULL,
    name_of_doctor VARCHAR(255) NOT NULL,
    patient_id INT NOT NULL,
    FOREIGN KEY (patient_id)
        REFERENCES patients (patient_id)
);

CREATE TABLE IF NOT EXISTS vaccinations(
    vaccination_id SERIAL PRIMARY KEY,
    vaccine_name VARCHAR(50) NOT NULL,
    vaccinated DATE NOT NULL,
    reaction TEXT,
    patient_id INT NOT NULL,
    FOREIGN KEY (patient_id)
        REFERENCES patients (patient_id)
);

CREATE TABLE IF NOT EXISTS results(
    result_id SERIAL PRIMARY KEY,
    created_in TIMESTAMP NOT NULL,
    file_path VARCHAR(255) NOT NULL,
    patient_id INT NOT NULL,
    FOREIGN KEY (patient_id)
        REFERENCES patients (patient_id)
);