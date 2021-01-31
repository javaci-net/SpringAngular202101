package net.javaci.thymleafExamples._00_basic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	
	@GetMapping("merhaba")
	public String renderHello(Model model) {
		model.addAttribute("welcome_message", "Merhaba Arkadaşlar");
		return "hello";
	}
	
	@GetMapping("merhaba2")
	public String renderHello2(Model model, @RequestParam(required = false, defaultValue = "World") String name) {
		
		model.addAttribute("name", name);
		return "hello2";
	}

}
