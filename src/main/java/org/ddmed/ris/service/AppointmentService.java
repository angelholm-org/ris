
package org.ddmed.ris.service;

import ca.uhn.fhir.rest.api.MethodOutcome;
import org.hl7.fhir.r4.model.Appointment;

import org.hl7.fhir.instance.model.api.IIdType;

import java.util.List;


public class AppointmentService {

    public static void save(Appointment appointment){

        MethodOutcome outcome = FHIRService.client().create()
                .resource(appointment)
                .prettyPrint()
                .encodedJson()
                .execute();
        IIdType id = outcome.getId();
        System.out.println("Got ID: " + id.getValue());

    }

   /* public static void update(Encounter encounter){

        MethodOutcome outcome = FHIRService.client().update()
                .resource(encounter)
                .prettyPrint()
                .encodedJson()
                .execute();

        IIdType id = outcome.getId();
        System.out.println("Got ID: " + id.getValue());

    }*/

    /*public static List<Encounter> get(String subjectId){

        List<Encounter> encounters = new ArrayList<Encounter>();

        Bundle results = FHIRService.client()
                .search()
                .forResource(Encounter.class)
                .include(Encounter.INCLUDE_DIAGNOSIS.asRecursive())
                .where(Encounter.SUBJECT.hasId(subjectId))
                .returnBundle(Bundle.class)
                .execute();


        for (Bundle.BundleEntryComponent component : results.getEntry()) {
            if (component.getResource() instanceof Encounter) {

                Encounter encounter = (Encounter) component.getResource();
                for(Encounter.DiagnosisComponent diagnose:   encounter.getDiagnosis()){
                    Condition condition = FHIRService.client()
                            .read()
                            .resource(Condition.class)
                            .withId(diagnose.getCondition().getReference())
                            .execute();
                    diagnose.setConditionTarget(condition);
                }
                encounters.add(encounter);
            }
        }


        return encounters;
    }*/

    /*public static List<Appointment> getAll(){

        List<Appointment> encounters = new ArrayList<Appointment>();

        Bundle results = FHIRService.client()
                .search()
                .forResource(Encounter.class)
                .returnBundle(Bundle.class)
                .execute();

        int count = results.getTotal();
        for(int i = 0; i < count; i++){
            Encounter encounter = (Encounter) results.getEntry().get(i).getResource();
            encounters.add(encounter);
        }

        return encounters;
    }*/
}