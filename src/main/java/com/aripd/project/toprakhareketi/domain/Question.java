package com.aripd.project.toprakhareketi.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.aripd.common.entity.BaseEntity;

@Entity
@Table(name = "question")
public class Question extends BaseEntity {

	private static final long serialVersionUID = -6971083598174918478L;

	@Column
	private String content;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany
	@OrderBy("createdAt DESC")
	private List<Answer> answers;
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

}
