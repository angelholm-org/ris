package org.ddmed.ris.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Patient {

    @Id
    @JsonProperty("PatientID")
    private String PatientID;
    @JsonProperty("PatientName")
    private String PatientName;
    @JsonProperty("PatientBirthDate")
    private String PatientBirthDate;
    @JsonProperty("PatientSex")
    private String PatientSex;

    public Patient(String PatientID, String PatientName, String PatientBirthDate, String PatientSex){
        this.PatientID = PatientID;
        this.PatientName = PatientName;
        this.PatientBirthDate = PatientBirthDate;
        this.PatientSex = PatientSex;
    }

}
