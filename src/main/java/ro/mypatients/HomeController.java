package ro.mypatients;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@RequestMapping("/")
	public String Home() {
		return "Das Boot, reportyng for duty";
	}
}
