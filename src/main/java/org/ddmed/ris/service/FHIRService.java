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
        ctx.getRestfulClientFactory().setServerValidationMode(ServerValidationModeEnum.NEVER);


        client = FhirContext.forR4().newRestfulGenericClient("http://angelholm.aidbox.app/fhir");
        token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJodHRwczovL2FuZ2VsaG9sbS5haWRib3guYXBwIiwic3ViIjoiYXV0aC1jbGllbnQiLCJpYXQiOjE1OTA2NDg5MTgsImp0aSI6IjBkNjUyZjBkLTA5MzEtNDgzYS05ZDc3LWI1MTI2Y2Q2MDg2ZiIsImF1ZCI6Imh0dHA6Ly9yZXNvdXJjZS5zZXJ2ZXIuY29tIiwiZXhwIjoxNTkwNjUwOTE4fQ.AD3PVa5TbUAty0TtTDK2ZrTHIPkjzJTXVtyN5iW6wJODnx-Nu5Gi45UXPPDyZ1eFW_L7LuCPETFYvj3nNp0rY-x0XK_0NYdeiYKrR7a0dtdzxopXqPqXUn9NtF2Ilx_AImAGZfYulersgO1J_8p36_zbwL9pe-nHq5HETaGqxSk";

        BearerTokenAuthInterceptor authInterceptor = new BearerTokenAuthInterceptor(token);
        client.registerInterceptor(authInterceptor);

        client.setEncoding(EncodingEnum.JSON);

    }

    public static IGenericClient client(){
        return FHIRService.client;
    }

}
