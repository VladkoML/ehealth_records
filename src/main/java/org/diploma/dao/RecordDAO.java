package org.diploma.dao;

import org.diploma.entity.Record;

import java.util.List;

public interface RecordDAO {

    Record getById(Long id);

    List<Record> getAll();

    void add(Record record);

    void update(Record record);

}
