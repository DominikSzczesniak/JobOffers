package com.szczesniak.dominik.joboffers.domain.login;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryLoginRepository implements  LoginRepository{

	final Map<String, User> users = new ConcurrentHashMap<>();

	@Override
	public Optional<User> findByUsername(final String username) {
		return Optional.ofNullable(users.get(username));
	}

	@Override
	public User save(final User user) {
		final UUID id = UUID.randomUUID();
		final User userToSave = new User(id.toString(),	user.getUsername(),	user.getPassword());
		users.put(userToSave.getUsername(), userToSave);
		return userToSave;
	}

}
