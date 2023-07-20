package com.szczesniak.dominik.joboffers.domain.offer.exceptions;

import lombok.Getter;

@Getter
public class OfferNotFoundException extends RuntimeException {

	private final String offerId;

	public OfferNotFoundException(final String offerId) {
		super(String.format("Offer with id %s not found", offerId));
		this.offerId = offerId;
	}
}
