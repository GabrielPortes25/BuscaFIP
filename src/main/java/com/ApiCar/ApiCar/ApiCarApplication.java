package com.ApiCar.ApiCar;

import com.ApiCar.ApiCar.Principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiCarApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ApiCarApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.ExibeMenu();
	}

}
