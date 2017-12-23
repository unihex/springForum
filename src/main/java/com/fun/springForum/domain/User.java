package com.fun.springForum.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class User extends BaseDomainObject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	private String userName;
	private String userTag;
	
	public Long getUserId() {
		return userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserTag() {
		return userTag;
	}
	
	public void setUserTag(String userTag) {
		this.userTag = userTag;
	}
	
	@Override
	public String toString() {
		return String.format("User [userId=%s, userName=%s, userTag=%s, createdDate=%s, modifiedDate=%s",
				this.userId, this.userName, this.userTag, this.createdDate, this.modifiedDate);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.userId);
	}
	
	public boolean equals(Object obj) {
		boolean result;
		
		if (this == obj) {result = true;}
		if (obj == null || getClass() != obj.getClass()) {result = false;}
		
		User otherUser = (User) obj;
		
		result = Objects.equals(this.userId, otherUser.getUserId());
		
		return result;
	}
	

}
