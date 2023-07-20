package com.szczesniak.dominik.joboffers.domain.login;

import org.testcontainers.shaded.org.apache.commons.lang3.RandomStringUtils;

public class UsernameSample {

	public static String createAnyUsername() {
		return RandomStringUtils.randomAlphabetic(5);
	}

}