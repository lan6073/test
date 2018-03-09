package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TemplateController {
	@RequestMapping("/tiles.do")
	public String tilesHandle() {
		/*
		 * 
		 */
		return "template";
	}
	
}
