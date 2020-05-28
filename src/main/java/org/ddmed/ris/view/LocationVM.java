package org.ddmed.ris.view;

import ca.uhn.fhir.model.primitive.CodeDt;
import lombok.Data;
import org.ddmed.ris.service.ResourceService;
import org.hl7.fhir.r4.model.*;
import org.hl7.fhir.r4.model.codesystems.LocationPhysicalType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;

import java.util.List;


@Data
public class LocationVM {

    private static final Logger log = LoggerFactory.getLogger(LocationVM.class);

    private Location location;

    @Init
    public void init() {

    }

    @Command
    public void save(){

        location = new Location();

        location.addIdentifier().setSystem("inner").setValue("room1");

        location.setStatus(Location.LocationStatus.ACTIVE);
        location.setOperationalStatus(new Coding().setCode("open").setSystem("inner"));
        location.setName("Room 1");
        location.addAlias("Оглядова 1");
        location.setDescription("Опис першої оглядової");
        location.setMode(Location.LocationMode.INSTANCE);
        location.addType(new CodeableConcept().setText("Consultation room").addCoding(new Coding().setCode("consultation-room").setDisplay("Consultation room").setSystem("inner")));
        location.addTelecom();
        location.setAddress(new Address());
        location.setPhysicalType(new CodeableConcept().setText("ROOM").addCoding(new Coding().setCode(LocationPhysicalType.RO.toCode())));

        List<DomainResource> organizations = ResourceService.getAll(Organization.class);
        organizations.forEach(resource ->
        {
            Organization organization = (Organization) resource;
            log.debug(organization.getName());
        });
        Organization organization = (Organization) organizations.get(0);

        location.setManagingOrganization(new Reference(organization.getIdElement().getValue()));

        location.addHoursOfOperation().addDaysOfWeek(Location.DaysOfWeek.MON).setOpeningTime("08:00").setClosingTime("20:00");
        location.addHoursOfOperation().addDaysOfWeek(Location.DaysOfWeek.TUE).setOpeningTime("08:00").setClosingTime("20:00");
        location.addHoursOfOperation().addDaysOfWeek(Location.DaysOfWeek.WED).setOpeningTime("08:00").setClosingTime("20:00");
        location.addHoursOfOperation().addDaysOfWeek(Location.DaysOfWeek.THU).setOpeningTime("08:00").setClosingTime("20:00");
        location.addHoursOfOperation().addDaysOfWeek(Location.DaysOfWeek.FRI).setOpeningTime("08:00").setClosingTime("20:00");


        ResourceService.save(location);


    }

}