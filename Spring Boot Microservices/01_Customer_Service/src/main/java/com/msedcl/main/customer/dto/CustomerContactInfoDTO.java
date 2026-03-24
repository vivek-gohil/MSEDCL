package com.msedcl.main.customer.dto;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties(prefix = "customer")
@Data
public class CustomerContactInfoDTO {
	String message;
	Map<String, String> contactDetails;
	List<String> onCallSupport;

}