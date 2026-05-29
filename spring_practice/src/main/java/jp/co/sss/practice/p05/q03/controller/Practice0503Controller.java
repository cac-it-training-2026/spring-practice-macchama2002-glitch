package jp.co.sss.practice.p05.q03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.practice.p05.bean.FruitsSeasonBean;
import jp.co.sss.practice.p05.entity.FruitsSeason;
import jp.co.sss.practice.p05.repository.FruitsSeasonRepository;

@Controller
public class Practice0503Controller {
	@Autowired
	FruitsSeasonRepository repository;

	@RequestMapping(path = "/fruits/list/sort/id", method = RequestMethod.GET)
	public String idGet(Model model) {
		model.addAttribute("fruits", repository.findAllByOrderByFruitIdAsc());
		return "practice05/03/fruits_list";
	}

	@RequestMapping(path = "/fruits/detail/{fruitId}", method = RequestMethod.GET)
	public String fruitIdGet(@PathVariable Integer fruitId, Model model) {
		FruitsSeason fruit = repository.getReferenceById(fruitId);
		FruitsSeasonBean fruitBean = new FruitsSeasonBean();
		fruitBean.setFruitId(fruit.getFruitId());
		fruitBean.setFruitName(fruit.getFruitName());
		fruitBean.setSeasonMonth(fruit.getSeasonMonth());
		model.addAttribute("fruit", fruitBean);
		return "practice05/03/fruit_detail";
	}
}
