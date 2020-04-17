package com.deniz.war.of.car.woc;

import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WocApplicationTests {

//	@Autowired
//	private WebTestClient webClient;
//
//	@Test
//	public void testAracYakitStream() {
//
//		List<Arac> arac = webClient.get().uri("/car/fuelLevel")
//				.accept(MediaType.valueOf(MediaType.TEXT_EVENT_STREAM_VALUE)).exchange().expectStatus().isOk()
//				.returnResult(Arac.class).getResponseBody().take(3) // take 3
//																	// comment
//																	// objects
//				.collectList().block();
//
//		arac.forEach(x -> System.out.println(x));
//
//		assertEquals(3, arac.size());
//
//	}
//
//	@Test
//	public void testAracMuhimmatStream() {
//
//		List<Arac> arac = webClient.get().uri("/car/fuelLevel")
//				.accept(MediaType.valueOf(MediaType.TEXT_EVENT_STREAM_VALUE)).exchange().expectStatus().isOk()
//				.returnResult(Arac.class).getResponseBody().take(3) // take 3
//																	// comment
//																	// objects
//				.collectList().block();
//
//		arac.forEach(x -> System.out.println(x));
//
//		assertEquals(3, arac.size());
//
//	}
//
//	@Test
//	public void testAracHasarStream() {
//
//		List<Arac> arac = webClient.get().uri("/car/ammoStock")
//				.accept(MediaType.valueOf(MediaType.TEXT_EVENT_STREAM_VALUE)).exchange().expectStatus().isOk()
//				.returnResult(Arac.class).getResponseBody().take(3) // take 3
//																	// comment
//																	// objects
//				.collectList().block();
//
//		arac.forEach(x -> System.out.println(x));
//
//		assertEquals(3, arac.size());
//
//	}

}
