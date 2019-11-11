package com.tencorners.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners") // set base mapping
@Controller
public class OwnerController {

    @RequestMapping({"", "/index", "/index.html"})
    public String getOwners()
    {
        return "owners/index";
    }
}
