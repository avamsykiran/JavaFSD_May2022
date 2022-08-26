package in.tp.is.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DefaultController {

	/*
	 * ""		http://localhost:8888
	 * "/"		http://localhost:8888/
	 * "/home"	http://localhost:8888/home
	 */
	@RequestMapping(value= {"","/","/home"},method = RequestMethod.GET)
	public ModelAndView showHome(@RequestParam(value = "unm",required = false) String userName) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		
		if(userName!=null)
			mv.addObject("msg","Hello " + userName);
		
		return mv;
	}
	
	@RequestMapping("/header")
	public ModelAndView showHeader() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("appTitle", "Income Statement");
		mv.setViewName("header-segment");
		return mv;
	}
}
