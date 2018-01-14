package com.student.corner.SC.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.student.corner.SC.bean.Car;

/**
 * For Test Perpose only  
 * 
 * @author Raj
 * @since V1.0.0_14012017
 */

// [TODO] Remove it later

@RestController
public class testController {

	@RequestMapping(value={"/", "/carList"}, method = RequestMethod.GET)
	public List<Car> carList(){
		return Arrays.asList(
				new Car(1, "Audi"),
				new Car(2, "BMW"),
				new Car(3, "Farari")
				);
	}
}
