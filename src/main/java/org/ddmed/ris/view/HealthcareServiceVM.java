package org.ddmed.ris.view;

import lombok.Data;
import org.ddmed.ris.service.ResourceService;
import org.hl7.fhir.r4.model.*;
import org.hl7.fhir.r4.model.codesystems.ServiceCategory;
import org.hl7.fhir.r4.model.codesystems.ServiceType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;

import java.util.ArrayList;
import java.util.List;


@Data
public class HealthcareServiceVM {

    private static final Logger log = LoggerFactory.getLogger(HealthcareServiceVM.class);

    private HealthcareService healthcareService;

    @Init
    public void init() {

    }

    @Command
    public void save(){

        healthcareService = new HealthcareService();

        healthcareService.addIdentifier().setSystem("inner").setValue("healthcareservice-angelholm");
        healthcareService.setActive(true);

        List<DomainResource> organizations = ResourceService.getAll(Organization.class);
        organizations.forEach(resource ->
        {
            Organization organization = (Organization) resource;
            log.debug(organization.getName());
        });
        Organization organization = (Organization) organizations.get(0);

        healthcareService.setProvidedBy(new Reference(organization.getIdElement().getValue()));

        healthcareService.addCategory(new CodeableConcept().setText("Hospital").addCoding(new Coding().setCode("hospital").setSystem("inner").setDisplay("Hospital consultations")));
        healthcareService.addType(new CodeableConcept().setText("Orthopedic Surgery").addCoding(new Coding().setCode("orthopedic surgery").setSystem("inner").setDisplay("Orthopedic Surgery")));
        healthcareService.addSpecialty().setText("Doctor neurosurgery");

        ResourceService.save(healthcareService);

    }

}