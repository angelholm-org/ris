package org.ddmed.ris.view;

import lombok.Data;

import org.ddmed.ris.service.ResourceService;
import org.hl7.fhir.r4.model.ContactPoint;
import org.hl7.fhir.r4.model.Organization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;


@Data
public class OrganizationVM {

    private static final Logger log = LoggerFactory.getLogger(OrganizationVM.class);

    private Organization organization;

    @Init
    public void init() {

    }

    @Command
    public void save(){

        organization = new Organization();
        organization.setId("angelnolm-organization");
        organization.setLanguage("uk-UA");
        organization.addIdentifier().setSystem("inner").setValue("angelholm-organization");
        organization.setActive(true);
        organization.setName("Angelholm Hospital");
        organization.addAlias("Angelholm");

        organization.addAddress().setState("Chernivtsy oblast").setCountry("Ukraine").setCity("Chernivtsy");
        organization.addTelecom().setValue("+380505050103").setUse(ContactPoint.ContactPointUse.WORK).setSystem(ContactPoint.ContactPointSystem.PHONE);

        ResourceService.save(organization);

    }

}