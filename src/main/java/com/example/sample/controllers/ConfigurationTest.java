package com.example.sample.controllers;

import com.example.sample.DTO.ContactInfo;
import io.github.resilience4j.retry.annotation.Retry;
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

    @Retry(name="getContactInfo",fallbackMethod = "getContactInfoFallback")
    @GetMapping("/contact")
    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public ContactInfo getContactInfoFallback() {
        return new ContactInfo();
    }
}
