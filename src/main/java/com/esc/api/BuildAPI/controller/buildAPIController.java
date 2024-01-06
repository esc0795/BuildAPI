package com.esc.api.BuildAPI.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController("/beta")
public class buildAPIController {

    @GetMapping("/getRequest")
    public String getRequest() {
        return "Test";
    }

}
