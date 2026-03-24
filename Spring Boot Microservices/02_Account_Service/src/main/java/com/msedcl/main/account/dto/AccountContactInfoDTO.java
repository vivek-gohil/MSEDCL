package com.msedcl.main.account.dto;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties(prefix = "account")
@Data
public class AccountContactInfoDTO {
	String message;
	Map<String, String> contactDetails;
	List<String> onCallSupport;

}