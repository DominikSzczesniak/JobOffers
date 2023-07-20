package com.szczesniak.dominik.joboffers.domain.offer.exceptions;

import com.szczesniak.dominik.joboffers.domain.offer.Offer;
import lombok.Getter;

import java.util.List;

@Getter
public class OfferDuplicateException extends RuntimeException {

	private final List<String> offerUrls;

	public OfferDuplicateException(final String offerUrl) {
		super(String.format("Offer with offerUrl [%s] already exists", offerUrl));
		this.offerUrls = List.of(offerUrl);
	}

	public OfferDuplicateException(final String message, final List<Offer> offers) {
		super(String.format("error" + message + offers.toString()));
		this.offerUrls = offers.stream().map(Offer::getOfferUrl).toList();
	}
}
