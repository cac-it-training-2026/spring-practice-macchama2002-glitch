package jp.co.sss.practice.p02.q02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Practice0202Controller {

	@RequestMapping("/show/redirect_page")
	public String show() {
		return "practice02/02/redirect_link";
	}

	@RequestMapping("/absolute")
	public String absolute() {
		return "redirect:https://www.google.co.jp";
	}

	@RequestMapping("/relative")
	public String relative() {
		return "redirect:/result";
	}

	@RequestMapping("/result")
	public String result() {
		return "practice02/02/redirect_result";
	}
}
