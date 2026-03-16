package com.msedcl.main.transaction.dto;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@ConfigurationProperties(prefix = "transactions")
@Data
public class TransactionContactInfoDTO {
	String message;
	Map<String, String> contactDetails;
	List<String> onCallSupport;

}