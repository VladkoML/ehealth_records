package org.diploma.dao;

import org.diploma.entity.Hospital;

import java.util.List;

public interface HospitalDAO {

    Hospital getById(Long id);

    void add(Hospital hospital);

    void update(Hospital hospital);

}
