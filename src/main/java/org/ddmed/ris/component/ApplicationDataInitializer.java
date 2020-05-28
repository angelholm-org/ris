package org.ddmed.ris.component;

import ca.uhn.fhir.context.*;
import org.ddmed.ris.service.FHIRService;
import org.ddmed.ris.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import javax.annotation.PostConstruct;

@Component
class ApplicationDataInitializer {

    private static final Logger log = LoggerFactory.getLogger(ApplicationDataInitializer.class);

    private final UserService userService;
    private Properties properties;


    @Autowired
    ApplicationDataInitializer(UserService userService, Properties properties) {
        this.userService = userService;
        this.properties = properties;
    }

    @PostConstruct
    private void init() {
        log.info("Creating default admin user");
        userService.createDefaultUser();


    }













}