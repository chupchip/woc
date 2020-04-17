package com.deniz.war.of.car.woc;

import java.time.Duration;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;


@RestController
@RequestMapping(path="/car")
public class CarController {

	@GetMapping(path = "/carOneStates", produces = MediaType.TEXT_EVENT_STREAM_VALUE) 
	public Flux<Car> getCarOneStates() {
		return Flux.interval(Duration.ofSeconds(1)).onBackpressureDrop().map(Generator::generateState)
				.flatMapIterable(x -> x);
	}
	
	@GetMapping(path = "/carTwoStates", produces = MediaType.TEXT_EVENT_STREAM_VALUE) 
	public Flux<Car> getCarTwoStates() {
		return Flux.interval(Duration.ofSeconds(1)).onBackpressureDrop().map(Generator::generateState)
				.flatMapIterable(x -> x);
	}

}