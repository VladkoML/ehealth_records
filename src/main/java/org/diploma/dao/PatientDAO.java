package org.diploma.dao;

import org.diploma.entity.Patient;

public interface PatientDAO {

    Patient getById(Long id);

    void add(Patient patient);

    void update(Patient patient);

}
