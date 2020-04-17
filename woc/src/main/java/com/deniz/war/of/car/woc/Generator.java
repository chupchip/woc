package com.deniz.war.of.car.woc;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Generator {

	private static final Random RANDOM = new Random(System.currentTimeMillis());

	private static final List<Integer> FUEL_LEVEL = Arrays.asList(12, 12, 12, 126, 1569, 12, 12, 16);
	private static final List<Integer> AMMO_STOCK = Arrays.asList(5, 6, 10, 5, 6, 10, 5, 6, 10);
	private static final List<Integer> DAMAGING_RATIO = Arrays.asList(1, 3, 8, 13, 1991, 18, 8, 113, 1991, 18);

	public static Integer randomFuelLevel() {
		return FUEL_LEVEL.get(RANDOM.nextInt(FUEL_LEVEL.size()));
	}

	public static Integer randomAmmoStock() {
		return AMMO_STOCK.get(RANDOM.nextInt(AMMO_STOCK.size()));
	}

	public static Integer randomDamagingRatio() {
		return DAMAGING_RATIO.get(RANDOM.nextInt(DAMAGING_RATIO.size()));
	}
	
	public static List<Car> generateState(long interval) {
		Car obj = new Car(Generator.randomFuelLevel(), Generator.randomAmmoStock(), Generator.randomDamagingRatio());
		return Arrays.asList(obj);

	}


}
