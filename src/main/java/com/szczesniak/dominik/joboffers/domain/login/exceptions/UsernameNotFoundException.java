package com.szczesniak.dominik.joboffers.domain.login.exceptions;

public class UsernameNotFoundException extends RuntimeException{

	public UsernameNotFoundException(final String message) {
		super(message);
	}

}
