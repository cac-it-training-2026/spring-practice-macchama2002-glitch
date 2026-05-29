package jp.co.sss.practice.p01.q01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Practice0101Controller {

	@RequestMapping("/opening")
	public String opening() {
		return "opening";
	}
}
