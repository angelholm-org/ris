package org.ddmed.ris.view;

import lombok.Data;

import org.ddmed.ris.service.ResourceService;
import org.ddmed.ris.service.ScheduleService;
import org.hl7.fhir.r4.model.Schedule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;

import java.util.List;

@Data
public class ScheduleVM {

    private static final Logger log = LoggerFactory.getLogger(ScheduleVM.class);
    private List<Schedule> scheduleList;
    private Schedule selected;

    @Init
    public void init() {
   //     scheduleList = ScheduleService.getAll();
    }

    @Command
    public void add(){

    }

    @Command
    public void edit() {

    }

    @Command
    public void delete() {

    }



}