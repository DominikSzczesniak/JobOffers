package com.szczesniak.dominik.joboffers.domain.login;

import com.szczesniak.dominik.joboffers.domain.login.dto.RegisterUserDto;
import com.szczesniak.dominik.joboffers.domain.login.dto.RegistrationResultDto;
import com.szczesniak.dominik.joboffers.domain.login.dto.UserDto;
import com.szczesniak.dominik.joboffers.domain.login.exceptions.UsernameNotFoundException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LoginFacade {

	private final LoginRepository repository;

	public UserDto findByUsername(final String username) {
		return repository.findByUsername(username)
				.map(user -> new UserDto(user.getId(), user.getUsername(), user.getPassword()))
				.orElseThrow(() -> new UsernameNotFoundException("User not found"));
	}

	public RegistrationResultDto register(RegisterUserDto registerUserDto) {
		final User user = User.builder()
				.username(registerUserDto.getUsername())
				.password(registerUserDto.getPassword())
				.build();
		final User savedUser = repository.save(user);
		return new RegistrationResultDto(savedUser.getId(), true, savedUser.getUsername());
	}

}
