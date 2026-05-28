package jp.co.sss.practice.p03.q02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.practice.p03.q02.form.FavoriteForm;

@Controller
public class Practice0302Controller {
	@RequestMapping(path = "/favorite/input", method = RequestMethod.GET)
	public String input() {
		return "practice03/02/favorite_input";
	}

	@RequestMapping(path = "/favorite/result", method = RequestMethod.POST)
	public String formMethod(FavoriteForm favoriteForm) {
		System.out.println("==パラメータを受け取りました。");
		System.out.println("==果物:" + favoriteForm.getFruit());
		System.out.println("==スナック:" + favoriteForm.getSnack());
		System.out.println("==スイーツ:" + favoriteForm.getSweet());
		System.out.println("==おかず:" + favoriteForm.getSidedish());
		return "practice03/02/favorite_result";
	}
}
