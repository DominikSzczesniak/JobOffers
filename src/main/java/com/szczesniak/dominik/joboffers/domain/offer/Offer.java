package com.szczesniak.dominik.joboffers.domain.offer;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Offer {

	String id;

	String companyName;

	String position;

	String salary;

	String offerUrl;

}
