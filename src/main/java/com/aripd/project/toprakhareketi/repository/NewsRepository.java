package com.aripd.project.toprakhareketi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aripd.project.toprakhareketi.domain.News;

public interface NewsRepository extends JpaRepository<News, Long> {

}
