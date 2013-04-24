package com.aripd.project.toprakhareketi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aripd.common.entity.BaseEntity;

@Entity
@Table(name = "help")
public class Help extends BaseEntity {

	private static final long serialVersionUID = 7880959848366871533L;

	@Column(nullable = false)
	private String title;
	
	@Column(columnDefinition = "TEXT")
	private String content;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
