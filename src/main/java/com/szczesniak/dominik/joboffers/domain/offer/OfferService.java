package com.szczesniak.dominik.joboffers.domain.offer;

import com.szczesniak.dominik.joboffers.domain.offer.exceptions.OfferDuplicateException;
import com.szczesniak.dominik.joboffers.domain.offer.exceptions.OfferSavingException;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class OfferService {

	private final OfferFetchable offerFetcher;
	private final OfferRepository offerRepository;

	List<Offer> fetchAllOffersAndSaveAllIfNotExists() {
		final List<Offer> jobOffers = fetchOffers();
		final List<Offer> offers = filterNotExistingOffers(jobOffers);
		try {
			return offerRepository.saveAll(offers);
		} catch (OfferDuplicateException duplicateKeyException) {
			throw new OfferSavingException(duplicateKeyException.getMessage(), jobOffers);
		}
	}

	private List<Offer> filterNotExistingOffers(final List<Offer> jobOffers) {
		return jobOffers.stream()
				.filter(offerDto -> !offerDto.getOfferUrl().isEmpty())
				.filter(offerDto -> !offerRepository.existsByOfferUrl(offerDto.getOfferUrl()))
				.collect(Collectors.toList());
	}

	private List<Offer> fetchOffers() {
		return offerFetcher.fetchOffers()
				.stream()
				.map(OfferMapper::mapFromJobOfferResponseToOffer)
				.toList();
	}

}
