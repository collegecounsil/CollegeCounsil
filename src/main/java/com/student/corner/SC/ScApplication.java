package com.student.corner.SC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Class Containing Main Method 
 * 
 * @author Raj
 * @since V1.0.0_14012017
 */
@SpringBootApplication
public class ScApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScApplication.class, args);
	}
}

