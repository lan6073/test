package mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import mvc.service.JoinService;

@Controller
@RequestMapping("/account")
public class JoinController {
	@Autowired
	JoinService joinService;
	
	@RequestMapping("/join.do")
	public String accountJoinHandle( ) {
		return "account/join";
	}
	
	@RequestMapping(path="/sendKey.do", produces="application/json;charset=utf-8")
	@ResponseBody
	public String accountSendKeyHandle(@RequestParam String email) {
		boolean result = joinService.sendAuthKey(email);
		System.out.println("{\"result\":"+result+"}");
		
		return "{\"result\":"+result+"}";
	}
}
