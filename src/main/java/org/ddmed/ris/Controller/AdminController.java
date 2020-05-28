package org.ddmed.ris.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("admin")
    public String admin(){
        return "zkau/web/admin/admin";
    }
}
