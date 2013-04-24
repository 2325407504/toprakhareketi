package com.aripd.project.toprakhareketi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aripd.project.toprakhareketi.domain.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {

}
