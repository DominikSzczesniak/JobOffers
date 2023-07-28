package com.szczesniak.dominik.joboffers.domain.offer;

import com.szczesniak.dominik.joboffers.domain.offer.exceptions.OfferDuplicateException;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryOfferRepository implements OfferRepository {

	private final Map<String, Offer> offers = new ConcurrentHashMap<>();

	@Override
	public boolean existsByOfferUrl(final String offerUrl) {
		long count = offers.values()
				.stream()
				.filter(offer -> offer.getOfferUrl().equals(offerUrl))
				.count();
		return count == 1;
	}

	@Override
	public List<Offer> saveAll(final List<Offer> offers) {
		return offers.stream()
				.map(this::save)
				.toList();
	}

	@Override
	public Optional<Offer> findById(final String id) {
		return Optional.ofNullable(offers.get(id));
	}

	@Override
	public Offer save(final Offer entity) {
		if (offers.values().stream().anyMatch(offer -> offer.getOfferUrl().equals(entity.getOfferUrl()))) {
			throw new OfferDuplicateException(entity.getOfferUrl());
		}
		final UUID id = UUID.randomUUID();
		final Offer offer = new Offer(
				id.toString(),
				entity.getCompanyName(),
				entity.getPosition(),
				entity.getSalary(),
				entity.getOfferUrl()
		);
		offers.put(id.toString(), offer);
		return offer;
	}

	@Override
	public List<Offer> findAll() {
		return offers.values().stream().toList();
	}

}
