package jp.co.sss.practice.p01.q02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Practice0102Controller {

	@RequestMapping("/hello/world")
	public String helloWorld() {
		return "hello";
	}
}
