package org.ddmed.ris.service;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.api.EncodingEnum;
import ca.uhn.fhir.rest.api.SummaryEnum;
import ca.uhn.fhir.rest.client.api.IGenericClient;

import ca.uhn.fhir.rest.client.api.ServerValidationModeEnum;
import ca.uhn.fhir.rest.client.interceptor.BearerTokenAuthInterceptor;
import org.springframework.stereotype.Service;

import javax.net.ssl.SSLContext;

@Service
public class FHIRService {

    private static FhirContext ctx;
    private static IGenericClient client;
    private static String token;

    static {
        ctx = FhirContext.forR4();


        client = FhirContext.forR4().newRestfulGenericClient("http://192.168.3.216:9093/hapi-fhir-jpaserver/fhir");



    }

    public static IGenericClient client(){
        return FHIRService.client;
    }

}
