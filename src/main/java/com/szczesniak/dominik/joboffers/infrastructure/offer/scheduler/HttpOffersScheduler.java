package com.szczesniak.dominik.joboffers.infrastructure.offer.scheduler;

import com.szczesniak.dominik.joboffers.domain.offer.OfferFacade;
import com.szczesniak.dominik.joboffers.domain.offer.dto.OfferResponseDto;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
@Log4j2
public class HttpOffersScheduler {

	private final OfferFacade offerFacade;

	@Scheduled(fixedDelayString = "${http.offers.scheduler.request.delay}")
	public List<OfferResponseDto> fetchAllOffersAndSaveAllIfNotExists() {
		log.info("Started fetching offers");
		final List<OfferResponseDto> addedOffers = offerFacade.fetchAllOffersAndSaveAllIfNotExists();
		log.info("Added " + addedOffers.size() + " offers");
		return addedOffers;
	}

}

