package com.szczesniak.dominik.joboffers.domain.offer.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class OfferResponseDto {

	String id;

	String companyName;

	String position;

	String salary;

	String offerUrl;

}
