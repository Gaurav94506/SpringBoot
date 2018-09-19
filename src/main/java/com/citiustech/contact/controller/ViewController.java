package com.citiustech.contact.controller;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {


	
	/*@GetMapping(value = "/welcome")
	public String index() {
		return "index";
	}*/
	@GetMapping(value = "/")
	public String welcome() {

		return "index";
	}
	
}

/*package com.citiustech.contact.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

	/*@GetMapping(value = "/welcome")
	public String index() {
		return "index";
	}*/
	@GetMapping(value = "/")
	public String welcome() {
		return "index";
	}
}
*/
