package org.ddmed.ris.service;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.api.MethodOutcome;

import ca.uhn.fhir.util.BundleUtil;
import org.hl7.fhir.instance.model.api.IDomainResource;
import org.hl7.fhir.r4.model.Appointment;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.DomainResource;
import org.hl7.fhir.r4.model.Encounter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ResourceService {

    private static final Logger log = LoggerFactory.getLogger(ResourceService.class);

    public static  List<DomainResource> getAll(Class type){

        List<DomainResource> resources = new ArrayList<>();

        Bundle results = FHIRService.client()
                .search()
                .forResource(type.getSimpleName())
                .returnBundle(Bundle.class)
                .execute();


        resources =  BundleUtil.toListOfResourcesOfType(FhirContext.forR4(), results, type);
        return resources;

    }
    public static void save(DomainResource resource) {

        try{
            MethodOutcome outcome = FHIRService.client().create()
                    .resource(resource)
                    .prettyPrint()
                    .encodedJson()
                    .execute();

            log.info("CREATED: " + resource.getClass().getSimpleName() + " ID: " + outcome.getId());

        }
        catch (Exception e){
            log.error(e.getLocalizedMessage());
        }

    }

    public static void update(DomainResource resource){

        try{
            MethodOutcome outcome = FHIRService.client().update()
                    .resource(resource)
                    .prettyPrint()
                    .encodedJson()
                    .execute();

            log.info("UPDATE: " + resource.getClass().getSimpleName() + " ID: " + outcome.getId());

        }
        catch (Exception e){
            log.error(e.getLocalizedMessage());
        }

    }
}
