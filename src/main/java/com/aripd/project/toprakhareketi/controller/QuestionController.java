package com.aripd.project.toprakhareketi.controller;

import javax.annotation.Resource;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aripd.project.toprakhareketi.domain.Answer;
import com.aripd.project.toprakhareketi.service.QuestionService;

@PreAuthorize("hasRole('ROLE_ADMIN')")
@Controller
@RequestMapping("/question")
public class QuestionController {

	@Resource(name = "questionService")
	private QuestionService questionService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listAction(Model model) {
		model.addAttribute("questionAttribute", questionService.findAll());
		return "question/list";
	}

	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public String showAction(@PathVariable Long id, Model model) {
		model.addAttribute("answerAttribute", new Answer());
		model.addAttribute("questionAttribute", questionService.findOne(id));
		return "question/show";
	}

}
