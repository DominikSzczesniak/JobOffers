package com.szczesniak.dominik.joboffers.domain.offer.dto;

import lombok.Value;

@Value
public class OfferRequestDto {

	String companyName;

	String position;

	String salary;

	String offerUrl;

}
