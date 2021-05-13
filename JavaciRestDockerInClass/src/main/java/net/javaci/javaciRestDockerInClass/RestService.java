package net.javaci.javaciRestDockerInClass;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestService {

	@GetMapping("/")
	public String home() {
		return "Merhaba arkadaslar";
	}
}
