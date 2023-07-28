package com.szczesniak.dominik.joboffers.infrastructure.offer.http;

import com.szczesniak.dominik.joboffers.domain.offer.OfferFetchable;
import com.szczesniak.dominik.joboffers.domain.offer.dto.JobOfferResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@AllArgsConstructor
@Slf4j
public class OfferHttpClient implements OfferFetchable {

	private final RestTemplate restTemplate;
	private final String uri;
	private final int port;

	@Override
	public List<JobOfferResponse> fetchOffers() {
		log.info("Started fetching offers.");
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		final HttpEntity<HttpHeaders> requestEntity = new HttpEntity<>(headers);
		final String urlForService = getUrlForService("/offers");
		final String url = UriComponentsBuilder.fromHttpUrl(urlForService).toUriString();

		final ResponseEntity<List<JobOfferResponse>> response = restTemplate.exchange(
				url,
				HttpMethod.GET,
				requestEntity,
				new ParameterizedTypeReference<>() {
				});
		return response.getBody();
	}

	private String getUrlForService(final String service) {
		return uri + ":" + port + service;
	}

}
