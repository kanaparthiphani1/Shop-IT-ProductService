package com.example.sample.DTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "support")
@Setter
@Getter
public class ContactInfo {
    private String  message;
    private Map<String,String> contact;
    private List<String> mobile;
}
