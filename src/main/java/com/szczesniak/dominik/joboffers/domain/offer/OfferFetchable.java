package com.szczesniak.dominik.joboffers.domain.offer;

import com.szczesniak.dominik.joboffers.domain.offer.dto.JobOfferResponse;

import java.util.List;

public interface OfferFetchable {

	List<JobOfferResponse> fetchOffers();

}
