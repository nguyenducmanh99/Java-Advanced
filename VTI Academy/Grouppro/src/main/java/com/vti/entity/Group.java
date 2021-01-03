package com.vti.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import com.vti.validation.NameNotExist;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "groupmanager", catalog = "Groupp")
public class Group implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "Id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(name = "Groupname", length = 50, nullable = false, unique = true)
	private String name;
	@Column(name = "`Member`", length = 50, nullable = false)
	private String member;
	@Column(name = "Creator", length = 50, nullable = false)
	private String creator;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Createdate",nullable = false)
	private Date createDate;

	public Group() {
	}

	public Group(String name, String member, String creator, Date createDate) {
		this.name = name;
		this.member = member;
		this.creator = creator;
		this.createDate = createDate;
	}

	public Group(String name) {
		this.name = name;
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMember() {
		return member;
	}

	public void setMember(String member) {
		this.member = member;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + ", member=" + member + ", creator=" + creator + ", createDate="
				+ createDate + "]";
	}






}
