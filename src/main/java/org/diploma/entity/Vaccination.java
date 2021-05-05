package org.diploma.entity;

import java.time.LocalDate;

public class Vaccination {

    private Integer vaccinationId;
    private String vaccineName;
    private LocalDate vaccinated;
    private String reaction;
    private Patient patient;

    public Vaccination(){

    }

    public Vaccination(Integer vaccinationId, String vaccineName, LocalDate vaccinated,
                       String reaction, Patient patient) {

        this.vaccinationId = vaccinationId;
        this.vaccineName = vaccineName;
        this.vaccinated = vaccinated;
        this.reaction = reaction;
        this.patient = patient;

    }

    public Integer getVaccinationId() {
        return vaccinationId;
    }

    public void setVaccinationId(Integer vaccinationId) {
        this.vaccinationId = vaccinationId;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public LocalDate getVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(LocalDate vaccinated) {
        this.vaccinated = vaccinated;
    }

    public String getReaction() {
        return reaction;
    }

    public void setReaction(String reaction) {
        this.reaction = reaction;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
