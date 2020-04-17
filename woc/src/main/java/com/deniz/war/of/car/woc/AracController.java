package com.deniz.war.of.car.woc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/car")
public class AracController 
{
    @GetMapping(path="/fuelLevel")//http://localhost:8080/woc/car/fuelLevel
    public String getFuelLevel() 
    {
        return "yakitSeviyesi";
    }

    @GetMapping(path="/ammoStock")//http://localhost:8080/woc/car/ammoStock
    public String getAmmoStock() 
    {
    	return "mühimmatSeviyesi";
    }
    @GetMapping(path="/damagingRatio")//http://localhost:8080/woc/car/damagingRatio
    public String getDamagingRatio() 
    {
    	return "hasarOrani";
    }
     
}