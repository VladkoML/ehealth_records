package org.diploma.dao;

import org.diploma.entity.Doctor;

public interface DoctorDAO {

    Doctor getById(Long id);

    void add(Doctor doctor);

    void update(Doctor doctor);

}
