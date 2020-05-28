package org.ddmed.ris.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "PACS")
public class PACS {

    @Id
    @GeneratedValue
    @Column(name = "PACS_ID")
    private long id;
    @Column(name = "PACS_NAME")
    private String name;
    @Column(name = "PACS_HOSTNAME")
    private String hostname;
    @Column(name = "PACS_HTTP_PORT")
    private String httpPort;
    @Column(name = "PACS_AE_TITLE")
    private String aetitle;
    @Column(name = "PACS_DICOM_PORT")
    private String dicomPort;
    @Column(name = "PACS_PROTOCOL")
    private String protocol;
    @Column(name = "PACS_URL")
    private String url;

    public String getRestBase(){
        return this.protocol +
                "://" + this.hostname +
                ":" + this.httpPort +
                "/" + this.url;
    }

    public PACS(){

    }

}