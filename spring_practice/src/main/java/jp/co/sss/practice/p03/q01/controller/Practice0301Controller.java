package jp.co.sss.practice.p03.q01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Practice0301Controller {
	@RequestMapping(path = "/input", method = RequestMethod.GET)
	public String input() {
		return "practice03/01/input_form";
	}

	@RequestMapping(path = "/send/get_method", method = RequestMethod.GET)
	public String getMethod(String color) {
		System.out.println("##GETメソッドで受けとりました");
		System.out.println("##パラメータの値：" + color);
		return "practice03/01/get_result";
	}

	@RequestMapping(path = "/send/post_method", method = RequestMethod.POST)
	public String postMethod(String color) {
		System.out.println("==POSTメソッドで受けとりました");
		System.out.println("==パラメータの値：" + color);
		return "practice03/01/post_result";
	}
}
