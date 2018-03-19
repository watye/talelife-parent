package com.talelife.myproject.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@RequestMapping("/")
    public String home() {
        return "this is home!";
    }

}
