package jp.co.sss.practice.p05.q06.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.practice.p05.bean.FruitsSeasonBean;
import jp.co.sss.practice.p05.entity.FruitsSeason;
import jp.co.sss.practice.p05.form.FruitsSeasonForm;
import jp.co.sss.practice.p05.repository.FruitsSeasonRepository;

@Controller
public class Practice0506Controller {
	@Autowired
	FruitsSeasonRepository repository;

	@RequestMapping(path = "/fruits/update", method = RequestMethod.GET)
	public String updateGet(Model model) {
		model.addAttribute("fruits", repository.findAll());
		return "practice05/06/fruit_select";
	}

	@RequestMapping(path = "/fruits/update/input", method = RequestMethod.POST)
	public String inputPost(Integer fruitId, Model model) {
		FruitsSeason fs = repository.getReferenceById(fruitId);
		FruitsSeasonBean fsb = new FruitsSeasonBean();
		BeanUtils.copyProperties(fs, fsb);
		model.addAttribute("fruit", fsb);
		return "practice05/06/fruit_input";
	}

	@RequestMapping(path = "/fruits/update/complete/{fruitId}", method = RequestMethod.POST)
	public String completePost(@PathVariable Integer fruitId,
			FruitsSeasonForm fruitForm, Model model) {
		FruitsSeason fs = repository.getReferenceById(fruitId);
		BeanUtils.copyProperties(fruitForm, fs, "fruitId");
		fs = repository.save(fs);
		FruitsSeasonBean fsb = new FruitsSeasonBean();
		BeanUtils.copyProperties(fs, fsb);
		model.addAttribute("fruit", fsb);
		return "practice05/06/fruit_detail";
	}

}
