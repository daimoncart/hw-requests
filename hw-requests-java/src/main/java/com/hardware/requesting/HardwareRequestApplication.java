package com.hardware.requesting;

import com.hardware.requesting.model.Component;
import com.hardware.requesting.model.Request;
import com.hardware.requesting.repository.RequestRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class HardwareRequestApplication {

	public static void main(String[] args) {
		SpringApplication.run(HardwareRequestApplication.class, args);
	}

	@Bean
	CommandLineRunner init(RequestRepository repository) {
		return args -> {
			var component1 = new Component("cases", "Fractal Design Define S2 TG", 2, 160.00);
			var component2 = new Component("motherboards (Intel)", "Asrock Q 270 Pro BTC", 1, 83.00);
			var component3 = new Component("motherboards (Intel)", "Asrock Q 270 Pro BTC", 2, 122.00);
			var component4 = new Component("processors (AMD)", "AMD Ryzen 7 5800 X 8 C/16 T", 3, 208.00);
			var component5 = new Component("motherboards (AMD)", "ASRock B 550 M Steel Legend", 1, 63.00);
			var component6 = new Component("RAM", "Corsair 32GB DD4, white", 1, 108.00);
			var request1 = new Request("PC class update", "New", 403.00, List.of(component1, component2));
			var request2 = new Request("I need this very much, thank you", "Rejected", 248.00, List.of(component3));
			var request3 = new Request("Hardware for the chess club", "Approved", 795.00, List.of(component4, component5, component6));
			repository.save(request1);
			repository.save(request2);
			repository.save(request3);
			repository.findAll().forEach(System.out::println);
		};
	}

}
