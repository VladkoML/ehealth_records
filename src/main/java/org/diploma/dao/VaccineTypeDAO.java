package org.diploma.dao;

import org.diploma.entity.VaccineType;

import java.util.List;

public interface VaccineTypeDAO {

    VaccineType getById(Long id);

    List<VaccineType> getAll();

}
