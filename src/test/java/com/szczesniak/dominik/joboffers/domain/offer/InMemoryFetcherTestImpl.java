package com.szczesniak.dominik.joboffers.domain.offer;

import com.szczesniak.dominik.joboffers.domain.offer.dto.JobOfferResponse;

import java.util.List;

public class InMemoryFetcherTestImpl implements OfferFetchable {

	private final List<JobOfferResponse> listOfOffers;

	InMemoryFetcherTestImpl(final List<JobOfferResponse> listOfOffers) {
		this.listOfOffers = listOfOffers;
	}

	@Override
	public List<JobOfferResponse> fetchOffers() {
		return listOfOffers;
	}

}
