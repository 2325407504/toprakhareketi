package com.aripd.project.toprakhareketi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aripd.common.entity.BaseEntity;

@Entity
@Table(name = "answer")
public class Answer extends BaseEntity {

	private static final long serialVersionUID = -2208184725975693849L;

	@Column
	private String content;

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
