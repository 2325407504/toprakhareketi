package com.aripd.project.toprakhareketi.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aripd.project.toprakhareketi.domain.Question;
import com.aripd.project.toprakhareketi.repository.QuestionRepository;
import com.aripd.project.toprakhareketi.service.QuestionService;

@Service("questionService")
@Transactional(readOnly = true)
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private MailSender mailSender;

	@Autowired
	private SimpleMailMessage message;

	@PersistenceContext
	private EntityManager em;

	@Resource
	private QuestionRepository repository;

	public List<Question> findAll() {
		return repository.findAll();
	}
	
	public Question findOne(Long id) {
		return repository.findOne(id);
	}

	@Transactional
	public Question save(Question question) {
		return repository.save(question);
	}
	
	@Transactional
	public void delete(Long id) {
		repository.delete(id);
	}

	@Transactional
	public void delete(Question question) {
		repository.delete(question);
	}

}