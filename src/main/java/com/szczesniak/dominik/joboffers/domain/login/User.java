package com.szczesniak.dominik.joboffers.domain.login;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class User {

	String id;

	String username;

	String password;

}
