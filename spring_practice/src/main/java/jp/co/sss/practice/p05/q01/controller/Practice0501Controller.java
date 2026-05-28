package jp.co.sss.practice.p05.q01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sss.practice.p05.repository.FruitsSeasonRepository;

// Practice6-01
@Controller
public class Practice0501Controller {

	@Autowired
	FruitsSeasonRepository repository;

	@RequestMapping("/fruits/list/all")
	public String showFruitsSeasonList(Model model) {
		model.addAttribute("fruits_season", repository.findAll());
		return "practice05/01/fruits_list";
	}
}
