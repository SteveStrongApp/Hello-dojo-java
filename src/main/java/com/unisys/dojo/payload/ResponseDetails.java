package com.unisys.dojo.payload;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class ResponseDetails {
	private String userId;
	private String questionId;
	private Boolean answer;
	@JsonIgnore
	private Long id;

}
