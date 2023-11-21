package com.example.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Data;

@Data
@Entity
@Table(name = "notes")
public class Notes extends Audit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private String content;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private UserDtls userDtls;

	public Notes() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public UserDtls getUserDtls() {
		return userDtls;
	}

	public void setUserDtls(UserDtls userDtls) {
		this.userDtls = userDtls;
	}

	public Notes(Date cratedDate, Date updateDate) {
		super(cratedDate, updateDate);
		// TODO Auto-generated constructor stub
	}

	public Notes(Date cratedDate, Date updateDate, int id, String title, String content, UserDtls userDtls) {
		super(cratedDate, updateDate);
		this.id = id;
		this.title = title;
		this.content = content;
		this.userDtls = userDtls;
	}

}