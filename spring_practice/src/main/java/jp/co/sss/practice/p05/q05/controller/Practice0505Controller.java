package jp.co.sss.practice.p05.q05.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.practice.p05.bean.FruitsSeasonBean;
import jp.co.sss.practice.p05.entity.FruitsSeason;
import jp.co.sss.practice.p05.form.FruitsSeasonForm;
import jp.co.sss.practice.p05.repository.FruitsSeasonRepository;

@Controller
public class Practice0505Controller {
	@Autowired
	FruitsSeasonRepository repository;

	@RequestMapping(path = "/fruits/add/input", method = RequestMethod.GET)
	public String inputGet() {
		return "practice05/05/fruit_input";
	}

	@RequestMapping(path = "/fruits/add/complete", method = RequestMethod.POST)
	public String completePost(FruitsSeasonForm fruitForm, Model model) {
		FruitsSeason fs = new FruitsSeason();
		BeanUtils.copyProperties(fruitForm, fs, "fruitId");
		fs = repository.save(fs);
		FruitsSeasonBean fsb = new FruitsSeasonBean();
		BeanUtils.copyProperties(fs, fsb);
		model.addAttribute("fs", fsb);
		return "practice05/05/fruit_detail";
	}

}
