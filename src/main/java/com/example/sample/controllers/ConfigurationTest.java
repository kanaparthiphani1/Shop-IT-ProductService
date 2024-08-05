package com.example.sample.controllers;

import com.example.sample.DTO.ContactInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/config")
public class ConfigurationTest {

    private ContactInfo contactInfo;

    public ConfigurationTest(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    @GetMapping("/contact")
    public ContactInfo getContactInfo() {
        return contactInfo;
    }
}
