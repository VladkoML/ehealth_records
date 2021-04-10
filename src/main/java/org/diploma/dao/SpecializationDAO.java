package org.diploma.dao;

import org.diploma.entity.Specialization;

import java.util.List;

public interface SpecializationDAO {

    Specialization getById(Long id);

    List<Specialization> getAll();

}
