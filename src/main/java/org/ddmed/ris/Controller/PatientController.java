package org.ddmed.ris.Controller;

import org.ddmed.ris.model.Patient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class PatientController {


    @GetMapping("/patients")
    public ArrayList<Patient> patients(@RequestParam(value = "name", defaultValue = "World") String name) {

        ArrayList<Patient> patients = new ArrayList<Patient>();
        Patient a = new Patient("BLA123", "Melnyk Dmytro", "19960427", "M");
        Patient b = new Patient("BLA124", "Ivanov Ivan", "19960429", "M");
        patients.add(a);
        patients.add(b);
        return patients;
    }

}


