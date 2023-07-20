package com.szczesniak.dominik.joboffers.domain.login;

public class TestLoginFacadeConfiguration {

	static LoginFacade loginAndRegisterFacade() {
		return new LoginFacade(new InMemoryLoginRepository());
	}

}
