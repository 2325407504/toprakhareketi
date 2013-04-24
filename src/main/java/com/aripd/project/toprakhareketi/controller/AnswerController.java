package com.aripd.project.toprakhareketi.controller;

import java.security.Principal;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aripd.project.toprakhareketi.domain.Answer;
import com.aripd.project.toprakhareketi.domain.Question;
import com.aripd.project.toprakhareketi.service.AnswerService;
import com.aripd.project.toprakhareketi.service.QuestionService;

@PreAuthorize("hasRole('ROLE_ADMIN')")
@Controller
@RequestMapping("/answer")
public class AnswerController {

	@Resource(name = "answerService")
	private AnswerService answerService;

	@Resource(name = "questionService")
	private QuestionService questionService;

	@RequestMapping(value = "/save/question/{question_id}", method = RequestMethod.POST)
	public String saveAction(
			final RedirectAttributes redirectAttributes,
			Principal principal,
			@PathVariable Long question_id,
			@ModelAttribute("answerAttribute") @Valid Answer formData,
			BindingResult result) {
		if (result.hasErrors()) {
			return "question/show/"+question_id;
		}

		Answer answer = answerService.save(formData);
		
		Question question = questionService.findOne(question_id);
		question.getAnswers().add(answer);
		questionService.save(question);
		
		redirectAttributes.addFlashAttribute("message", "Başarı ile kaydedildi");
		return "redirect:/question/show/"+question_id;
	}

}
