package org.goya.daw2.ud3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorWeb {
	 @GetMapping("/")
	    public String home() {
	        return "home";
	    }

	 @GetMapping("/home")
	    public String home2() {
	        return "home";
	    }
	 
	    @GetMapping("/hello")
	    public String hello() {
	        return "hello";
	    }

	    @GetMapping("/login")
	    public String login() {
	        return "login";
	    }

}
