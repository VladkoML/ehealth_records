package org.diploma.dao;

import org.diploma.entity.Laboratory;

public interface LaboratoryDAO {

    Laboratory getById(Long id);

    void add(Laboratory laboratory);

    void update(Laboratory laboratory);

}
