package no.martinsolaas.origodemo;

import no.martinsolaas.origodemo.service.StationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
public class OrigoDemoApplication {

	private final StationFacade stationFacade;

	public OrigoDemoApplication(@Autowired StationFacade stationFacade) {
		this.stationFacade = stationFacade;
	}

	public static void main(String[] args) {
		SpringApplication.run(OrigoDemoApplication.class, args);
	}

}
