package com.aripd.project.toprakhareketi.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aripd.project.toprakhareketi.domain.News;
import com.aripd.project.toprakhareketi.repository.NewsRepository;
import com.aripd.project.toprakhareketi.service.NewsService;

@Service("newsService")
@Transactional(readOnly = true)
public class NewsServiceImpl implements NewsService {

	@Resource
	private NewsRepository repository;

	@Transactional
	public News save(News news) {
		return repository.save(news);
	}

}