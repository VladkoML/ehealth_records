package org.diploma.dao;

import org.diploma.entity.Vaccination;

import java.util.List;

public interface VaccinationDAO {

    Vaccination getById(Long id);

    List<Vaccination> getAll();

    void add(Vaccination vaccination);

    void update(Vaccination vaccination);

}
