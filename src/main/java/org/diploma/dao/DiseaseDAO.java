package org.diploma.dao;

import org.diploma.entity.Disease;

import java.util.List;

public interface DiseaseDAO {

    Disease getById(Long id);

    List<Disease> getAll();

    void add(Disease disease);

    void update(Disease disease);

}
