package com.szczesniak.dominik.joboffers.domain.offer;

import com.szczesniak.dominik.joboffers.domain.offer.dto.JobOfferResponse;
import com.szczesniak.dominik.joboffers.domain.offer.dto.OfferRequestDto;
import com.szczesniak.dominik.joboffers.domain.offer.dto.OfferResponseDto;

public class OfferMapper {

	public static OfferResponseDto mapFromOfferToOfferDto(final Offer offer) {
		return OfferResponseDto.builder()
				.id(offer.getId())
				.companyName(offer.getCompanyName())
				.position(offer.getPosition())
				.salary(offer.getSalary())
				.offerUrl(offer.getOfferUrl())
				.build();
	}

	public static Offer mapFromOfferDtoToOffer(final OfferRequestDto offerDto) {
		return Offer.builder()
				.companyName(offerDto.getCompanyName())
				.position(offerDto.getPosition())
				.salary(offerDto.getSalary())
				.offerUrl(offerDto.getOfferUrl())
				.build();
	}

	public static Offer mapFromJobOfferResponseToOffer(final JobOfferResponse jobOfferDto) {
		return Offer.builder()
				.offerUrl(jobOfferDto.getOfferUrl())
				.salary(jobOfferDto.getSalary())
				.position(jobOfferDto.getTitle())
				.companyName(jobOfferDto.getCompany())
				.build();
	}

}
