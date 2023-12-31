package com.example.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.auditing.config.AuditingConfiguration;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Audit {

	
	@Temporal(TemporalType.DATE)
	@CreatedDate
	@Column(name = "create_dt",nullable = false,updatable = false)
	private Date cratedDate;
	
	
	@Temporal(TemporalType.DATE)
	@LastModifiedDate
	@Column(name = "update_dt",nullable = false)
	private Date updateDate;


	public Audit(Date cratedDate, Date updateDate) {
		super();
		this.cratedDate = cratedDate;
		this.updateDate = updateDate;
	}


	public Audit() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Date getCratedDate() {
		return cratedDate;
	}


	public void setCratedDate(Date cratedDate) {
		this.cratedDate = cratedDate;
	}


	public Date getUpdateDate() {
		return updateDate;
	}


	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}