package com.vti.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.hibernate.validator.constraints.Length;

import com.vti.entity.Group;
import com.vti.validation.NameNotExist;
import com.vti.validation.onCreate;
import com.vti.validation.onUpdate;



public class GroupDTO {
//	@Null(groups = onCreate.class)
//	@NotNull(groups = onUpdate.class)
	@NotBlank(message = "{CreateDto.name.NotBlank}")
	@NameNotExist(message = "{CreateDto.name.NameNotExist}")
	@Length(min = 6, max = 50, message = "{CreateDto.name.Length}")
	private String name;
	private String member;
	private String creator;
	private Date createDate;
	

	public GroupDTO( String name, String member,
			String creator, Date createDate) {
		
		this.name = name;
		this.member = member;
		this.creator = creator;
		this.createDate = createDate;
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

	public void setDate(Date createDate) {
		this.createDate = createDate;
	}


	public GroupDTO() {
	}

	public Group toEntity() {
		return new Group (name,member,creator,createDate);
	}

}
