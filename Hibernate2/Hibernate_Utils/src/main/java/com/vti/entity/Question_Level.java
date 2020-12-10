package com.vti.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.vti.entity.enumerate.Level;
import com.vti.entity.enumerate.LevelConvert;

@Entity
@Table(name = "Question_Level", catalog = "hibernate")
public class Question_Level implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(name = "level", nullable = false, unique = true)
	@Convert(converter = LevelConvert.class)
	private Level name;

	public Question_Level() {

	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public Level getName() {
		return name;
	}

	public void setName(Level name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Question_Level [id=" + id + ", name=" + name + "]";
	}
}
