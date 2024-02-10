package io.apiglue.clonebyt.clonebytserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

public class ClonebytServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClonebytServerApplication.class, args);
	}
	@GetMapping("/hello")
	public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
		return String.format("Hello java %s!", name);
	}
}

