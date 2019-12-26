package com.unisys.dojo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.unisys.dojo.payload.ResponseDetails;
import com.unisys.dojo.service.IdojoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class DOJOController {
	@Autowired
	IdojoService dojoService;
    
    @GetMapping("/")
    public String index() {
        return "DOJO Services";
    }
    
    @PostMapping("/submitResponse")
    public String submitDOJOResponse(@RequestBody ResponseDetails details) {
    	dojoService.submitResponse(details);
        return "Saved Successfully";
    }
    
}
