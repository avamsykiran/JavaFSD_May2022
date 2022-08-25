package in.tp.is.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DefaultController {

	/*
	 * ""		http://localhost:8888
	 * "/"		http://localhost:8888/
	 * "/home"	http://localhost:8888/home
	 */
	@RequestMapping(value= {"","/","/home"},method = RequestMethod.GET)
	public String showHome() {
		return "home";
	}
}
