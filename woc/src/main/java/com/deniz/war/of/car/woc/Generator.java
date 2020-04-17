package com.deniz.war.of.car.woc;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Generator {

	private Random random = new Random();

	private static Integer carOneFuelLevel = 100;
	private static Integer carOneAmmoStock = 100;
	private static Integer carOneDamagingRatio = 100;

	private static Integer carTwoFuelLevel = 100;
	private static Integer carTwoAmmoStock = 100;
	private static Integer carTwoDamagingRatio = 100;

	public void randomCarOne() {
		carOneFuelLevel = ((random.nextInt(100)%2 == 0) ? true : false) && carOneFuelLevel > 0 ? carOneFuelLevel-5 : carOneFuelLevel;
		carOneAmmoStock = ((random.nextInt(100)%2 == 0) ? true : false) && carOneAmmoStock > 0 ? carOneAmmoStock-5 : carOneAmmoStock;
		carOneDamagingRatio = ((random.nextInt(100)%2 == 0) ? true : false) && carOneDamagingRatio > 0 ? carOneDamagingRatio-10
				: carOneDamagingRatio;
	}

	public void randomCarTwo() {
		carTwoFuelLevel = ((random.nextInt(100)%2 == 0) ? true : false) && carTwoFuelLevel > 0 ? carTwoFuelLevel-5 : carTwoFuelLevel;
		carTwoAmmoStock = ((random.nextInt(100)%2 == 0) ? true : false) && carTwoAmmoStock > 0 ? carTwoAmmoStock-5 : carTwoAmmoStock;
		carTwoDamagingRatio = ((random.nextInt(100)%2 == 0) ? true : false) && carTwoDamagingRatio > 0 ? carTwoDamagingRatio-10
				: carTwoDamagingRatio;
	}

	public List<Car> generateCarOneState(long interval) {
		randomCarOne();
		Car obj = new Car(carOneFuelLevel, carOneAmmoStock, carOneDamagingRatio);
		return Arrays.asList(obj);

	}

	public List<Car> generateCarTwoState(long interval) {
		randomCarTwo();
		Car obj = new Car(carTwoFuelLevel, carTwoAmmoStock, carTwoDamagingRatio);
		return Arrays.asList(obj);

	}

}
