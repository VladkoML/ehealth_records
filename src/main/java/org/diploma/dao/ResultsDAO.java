package org.diploma.dao;

import org.diploma.entity.Results;

import java.util.List;

public interface ResultsDAO {

    Results getById(Long id);

    List<Results> getAll();

    void add(Results results);

    void update(Results results);

}
