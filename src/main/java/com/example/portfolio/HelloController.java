package com.example.portfolio;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping(value="/index")
    public String index() {
        return "index";
    }
	@PostMapping(value="/hello")
	public String hello() {
		String str = "hello ";
		return str;
	}

}
