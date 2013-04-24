package com.aripd.project.toprakhareketi.service;

import java.util.List;

import com.aripd.project.toprakhareketi.domain.Question;

public interface QuestionService {

	List<Question> findAll();

	Question findOne(Long id);

	Question save(Question question);

	void delete(Long id);

	void delete(Question question);

}
