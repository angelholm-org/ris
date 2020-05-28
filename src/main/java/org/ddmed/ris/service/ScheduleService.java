package org.ddmed.ris.service;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.api.MethodOutcome;
import ca.uhn.fhir.util.BundleUtil;
import org.hl7.fhir.instance.model.api.IIdType;
import org.hl7.fhir.r4.hapi.ctx.FhirServerR4;
import org.hl7.fhir.r4.model.Appointment;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Schedule;

import java.util.List;

public class ScheduleService {

    public static List<Schedule> getAll(){
        Bundle bundle = FHIRService.client()
                .search()
                .forResource(Schedule.class)
                .returnBundle(Bundle.class)
                .execute();
        return BundleUtil.toListOfResourcesOfType(FhirContext.forR4(), bundle, Schedule.class);
    }

    public static void save(Schedule schedule){

        MethodOutcome outcome = FHIRService.client().create()
                .resource(schedule)
                .prettyPrint()
                .encodedJson()
                .execute();
        IIdType id = outcome.getId();
        System.out.println("Got ID: " + id.getValue());
    }
}
