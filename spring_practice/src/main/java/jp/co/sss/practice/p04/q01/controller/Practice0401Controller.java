package jp.co.sss.practice.p04.q01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.practice.p04.q01.form.BmiForm;

@Controller
public class Practice0401Controller {

	@RequestMapping(path = "/bmi/input", method = RequestMethod.GET)
	public String bmiInput() {
		return "practice04/01/bmi_input";
	}

	@RequestMapping(path = "/bmi/result", method = RequestMethod.POST)
	public String bmiResult(BmiForm bmiForm, Model model) {
		double height = bmiForm.getHeight() / 100;
		double bmi = bmiForm.getWeight() / (height * height);
		bmiForm.setBmi(bmi);
		model.addAttribute("bmiForm", bmiForm);
		return "practice04/01/bmi_result";
	}
}
