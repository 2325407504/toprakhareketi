package com.aripd.project.toprakhareketi.service.impl;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aripd.project.toprakhareketi.domain.Answer;
import com.aripd.project.toprakhareketi.repository.AnswerRepository;
import com.aripd.project.toprakhareketi.service.AnswerService;

@Service("answerService")
@Transactional(readOnly = true)
public class AnswerServiceImpl implements AnswerService {

	@PersistenceContext
    private EntityManager em;
	
	@Resource
	private AnswerRepository repository;

	@Transactional
	public Answer save(Answer answer) {
		return repository.save(answer);
	}

}