package com.aripd.project.toprakhareketi.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aripd.project.toprakhareketi.domain.Answer;
import com.aripd.project.toprakhareketi.repository.AnswerRepository;
import com.aripd.project.toprakhareketi.service.AnswerService;

@Service("helpService")
@Transactional(readOnly = true)
public class HelpServiceImpl implements AnswerService {

	@Resource
	private AnswerRepository repository;

	@Transactional
	public Answer save(Answer help) {
		return repository.save(help);
	}

}