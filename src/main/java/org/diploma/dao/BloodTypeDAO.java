package org.diploma.dao;

import org.diploma.entity.BloodType;

import java.util.List;

public interface BloodTypeDAO {

    BloodType getById(Long id);

    List<BloodType> getAll();

}
