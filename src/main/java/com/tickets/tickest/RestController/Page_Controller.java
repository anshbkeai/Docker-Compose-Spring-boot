package com.tickets.tickest.RestController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller

public class Page_Controller {


    @GetMapping("/comment")
    public String getMethodName() {
        return "comment";
    }
    
    
}
