package com.msedcl.main.account.dto;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@ConfigurationProperties("accounts")
public class AccountContactInfoDTO {

	private String message;
	private Map<String, String> contactDetails;
	private List<String> onCallSupport;

}
