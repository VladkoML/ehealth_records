package org.diploma.entity;

public class Specialization {

    private Long specializationId;
    private String nameSpecialization;

    public Long getSpecializationId() {
        return specializationId;
    }

    public void setSpecializationId(Long specializationId) {
        this.specializationId = specializationId;
    }

    public String getNameSpecialization() {
        return nameSpecialization;
    }

    public void setNameSpecialization(String nameSpecialization) {
        this.nameSpecialization = nameSpecialization;
    }

    @Override
    public String toString() {
        return "ID: " + getSpecializationId() + " || " + getNameSpecialization();
    }
}
