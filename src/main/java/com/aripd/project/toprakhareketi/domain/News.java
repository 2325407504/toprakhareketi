package com.aripd.project.toprakhareketi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aripd.common.entity.BaseEntity;

@Entity
@Table(name = "news")
public class News extends BaseEntity {

	private static final long serialVersionUID = -589268234592371850L;

	@Column(nullable = false)
	private String title;
	
	@Column
	private String description;

	@Column(columnDefinition = "TEXT")
	private String content;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
