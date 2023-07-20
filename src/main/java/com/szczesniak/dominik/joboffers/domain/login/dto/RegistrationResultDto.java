package com.szczesniak.dominik.joboffers.domain.login.dto;

import lombok.Value;

@Value
public class RegistrationResultDto {

	String id;

	boolean created;

	String username;

}
