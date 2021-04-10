package org.diploma.entity;

public class Laboratory {

    private Long laboratoryId;
    private String nameLaboratory;
    private String addressLaboratory;
    private String phoneNumber;

    public Long getLaboratoryId() {
        return laboratoryId;
    }

    public void setLaboratoryId(Long laboratoryId) {
        this.laboratoryId = laboratoryId;
    }

    public String getNameLaboratory() {
        return nameLaboratory;
    }

    public void setNameLaboratory(String nameLaboratory) {
        this.nameLaboratory = nameLaboratory;
    }

    public String getAddressLaboratory() {
        return addressLaboratory;
    }

    public void setAddressLaboratory(String addressLaboratory) {
        this.addressLaboratory = addressLaboratory;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
