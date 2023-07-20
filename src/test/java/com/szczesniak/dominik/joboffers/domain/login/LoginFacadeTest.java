package com.szczesniak.dominik.joboffers.domain.login;

import com.szczesniak.dominik.joboffers.domain.login.dto.RegisterUserDto;
import com.szczesniak.dominik.joboffers.domain.login.dto.RegistrationResultDto;
import com.szczesniak.dominik.joboffers.domain.login.dto.UserDto;
import com.szczesniak.dominik.joboffers.domain.login.exceptions.UsernameNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.szczesniak.dominik.joboffers.domain.login.UsernameSample.createAnyUsername;
import static com.szczesniak.dominik.joboffers.domain.login.TestLoginFacadeConfiguration.loginAndRegisterFacade;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class LoginFacadeTest {

	private LoginFacade tut;

	@BeforeEach
	void setUp() {
		tut = loginAndRegisterFacade();
	}

	@Test
	void should_register_user() {
		// given
		final RegisterUserDto registerUserDto = new RegisterUserDto("username", "password");

		// when
		final RegistrationResultDto register = tut.register(registerUserDto);

		// then
		assertThat(register.isCreated()).isTrue();
		assertThat(register.getUsername()).isEqualTo(registerUserDto.getUsername());
	}

	@Test
	void should_find_registered_user_by_username() {
		// given
		final RegisterUserDto registerUserDto = new RegisterUserDto("username", "password");
		final RegistrationResultDto register = tut.register(registerUserDto);

		// when
		final UserDto foundUser = tut.findByUsername(register.getUsername());

		// then
		assertThat(foundUser.getId()).isEqualTo(register.getId());
		assertThat(foundUser.getUsername()).isEqualTo(register.getUsername());
		assertThat(foundUser.getPassword()).isEqualTo(registerUserDto.getPassword());
	}

	@Test
	void should_throw_exception_when_user_not_found() {
		// given
		final String randomUsername = createAnyUsername();

		// when
		final Throwable thrown = catchThrowable(() -> tut.findByUsername(randomUsername));

		// then
		assertThat(thrown).isInstanceOf(UsernameNotFoundException.class);
	}

}