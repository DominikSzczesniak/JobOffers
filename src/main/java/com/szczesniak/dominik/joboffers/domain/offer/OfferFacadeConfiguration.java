package com.szczesniak.dominik.joboffers.domain.offer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Optional;

@Configuration
public class OfferFacadeConfiguration {

	@Bean
	OfferFacade offerFacade(final OfferFetchable offerFetchable) {

		final OfferRepository repo = new OfferRepository() {
			@Override
			public boolean existsByOfferUrl(String offerUrl) {
				return false;
			}

			@Override
			public List<Offer> saveAll(List<Offer> offers) {
				return null;
			}

			@Override
			public List<Offer> findAll() {
				return null;
			}

			@Override
			public Optional<Offer> findById(String id) {
				return Optional.empty();
			}

			@Override
			public Offer save(Offer offer) {
				return null;
			}
		};

		final OfferService offerService = new OfferService(offerFetchable, repo);
		return new OfferFacade(repo, offerService);
	}

}
