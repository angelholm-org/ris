package org.ddmed.ris.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class CalendarController {

    @GetMapping("/calendar")
    public String calendar() {
        return "calendar";
    }
}
