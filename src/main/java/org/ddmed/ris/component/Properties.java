package org.ddmed.ris.component;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
@Data
@Configuration
@ConfigurationProperties("fhir")
public class Properties {
    private String serverbase;
}