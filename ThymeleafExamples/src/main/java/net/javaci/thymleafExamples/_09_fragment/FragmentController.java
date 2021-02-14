package net.javaci.thymleafExamples._09_fragment;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fragment")
public class FragmentController {
	
	@GetMapping("/include")
	public String renderIncludePage() {
		// include include ettigi tag in içeriğini alır tag i almaz

		// insert tagla birlikte alır

		// replace kendini siler
		return "fragment/include";
	}

}
