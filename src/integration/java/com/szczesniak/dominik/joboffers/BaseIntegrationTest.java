package com.szczesniak.dominik.joboffers;

import com.github.tomakehurst.wiremock.junit5.WireMockExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;
import com.fasterxml.jackson.databind.ObjectMapper;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

@SpringBootTest(classes = JobOffersSpringBootApplication.class)
@ActiveProfiles("integration")
@AutoConfigureMockMvc
@Testcontainers
public class BaseIntegrationTest {

	public static final String WIRE_MOCK_HOST = "http://localhost";

	@Autowired
	public ObjectMapper objectMapper;

	@Autowired
	public MockMvc mockMvc;

	@Container
	public static final MongoDBContainer mongoDBContainter = new MongoDBContainer(DockerImageName.parse("mongo:4.0.10"));

	@RegisterExtension
	public static WireMockExtension wireMockServer = WireMockExtension.newInstance()
			.options(wireMockConfig().dynamicPort())
			.build();

	@DynamicPropertySource
	public static void propertyOverride(final DynamicPropertyRegistry registry) {
		registry.add("spring.data.mongodb.uri", mongoDBContainter::getReplicaSetUrl);
		registry.add("offer.http.client.config.uri", () -> WIRE_MOCK_HOST);
		registry.add("offer.http.client.config.port", () -> wireMockServer.getPort());
	}

	@Test
	void name() {
		// given

		// when

		// then
	}

}
