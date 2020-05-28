package org.ddmed.ris.view;

import lombok.Data;
import org.ddmed.ris.service.ResourceService;
import org.hl7.fhir.r4.model.ContactPoint;
import org.hl7.fhir.r4.model.Enumerations;
import org.hl7.fhir.r4.model.Organization;
import org.hl7.fhir.r4.model.Practitioner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;


@Data
public class PractitionerVM {

    private static final Logger log = LoggerFactory.getLogger(PractitionerVM.class);
    private Practitioner practitioner;

    @Init
    public void init() {

    }

    @Command
    public void save(){

        practitioner = new Practitioner();

        practitioner.addIdentifier().setSystem("inner").setValue("19960427MED0");
        practitioner.setActive(true);
        practitioner.addName().
                setFamily("Юрценюк")
                .addGiven("Андрій")
                .addGiven("Володимирович")
                .addPrefix("Лікар")
                .setText("Андрій Юрценюк");
        practitioner.setGender(Enumerations.AdministrativeGender.FEMALE);
        practitioner.addTelecom().setSystem(ContactPoint.ContactPointSystem.EMAIL).setValue("yu@gmail.com");



        ResourceService.save(practitioner);

    }

}