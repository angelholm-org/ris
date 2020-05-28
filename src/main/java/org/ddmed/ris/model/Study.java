package org.ddmed.ris.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Study {

    @Id
    @JsonProperty("StudyInstanceUID")
    private String StudyInstanceUID;

    @JsonProperty("StudyID")
    private String StudyID;

    @JsonProperty("StudyDate")
    private String StudyDate;

    @JsonProperty("Modality")
    private String Modality;

    @JsonProperty("StudyDescription")
    private String StudyDescription;

    @JsonProperty("Symptoms")
    private String Symptoms;

    @JsonProperty("Notes")
    private String Notes;

    @JsonProperty("ImageCount")
    private String ImageCount;

    @JsonProperty("InstitutionName")
    private String InstitutionName;

    @JsonProperty("Value")
    private String Value;

    @JsonProperty("ReferringPhysicianName")
    private String ReferringPhysicianName;



}
