package com.szczesniak.dominik.joboffers.domain.offer.dto;

import lombok.Value;

@Value
public class JobOfferResponse {

	String title;

	String company;

	String salary;

	String offerUrl;

}
