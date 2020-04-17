package com.deniz.war.of.car.woc;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

//@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
@RequestMapping(path="/car")
public class CarController {

	@GetMapping(path = "/carOneStates", produces = MediaType.TEXT_EVENT_STREAM_VALUE) // http://localhost:8080/woc/car/carOneStates
	public Flux<Car> getCarOneStates() {
		return Flux.interval(Duration.ofSeconds(1)).onBackpressureDrop().map(this::generateState)
				.flatMapIterable(x -> x);
	}
	
	@GetMapping(path = "/carTwoStates", produces = MediaType.TEXT_EVENT_STREAM_VALUE) // http://localhost:8080/woc/car/carTwoStates
	public Flux<Car> getCarTwoStates() {
		return Flux.interval(Duration.ofSeconds(1)).onBackpressureDrop().map(this::generateState)
				.flatMapIterable(x -> x);
	}

	private List<Car> generateState(long interval) {
		Car obj = new Car(Generator.randomFuelLevel(), Generator.randomAmmoStock(), Generator.randomDamagingRatio());
		return Arrays.asList(obj);

	}

}