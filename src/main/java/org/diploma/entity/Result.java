package org.diploma.entity;

import java.time.LocalDate;

public class Result {

    private Integer resultId;
    private LocalDate createdIn;
    private String filePath;
    private Patient patient;

    public Result(){

    }

    public Result(Integer resultId, LocalDate createdIn, String filePath, Patient patient) {

        this.resultId = resultId;
        this.createdIn = createdIn;
        this.filePath = filePath;
        this.patient = patient;

    }

    public Integer getResultId() {
        return resultId;
    }

    public void setResultId(Integer resultId) {
        this.resultId = resultId;
    }

    public LocalDate getCreatedIn() {
        return createdIn;
    }

    public void setCreatedIn(LocalDate createdIn) {
        this.createdIn = createdIn;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
