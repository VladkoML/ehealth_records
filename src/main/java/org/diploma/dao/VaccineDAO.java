package org.diploma.dao;

import org.diploma.entity.Vaccine;

import java.util.List;

public interface VaccineDAO {

    Vaccine getById(Long id);

    List<Vaccine> getAll();

}
