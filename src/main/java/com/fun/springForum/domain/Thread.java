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
public class Thread extends BaseDomainObject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long threadId;
	
	private String threadTitle;
	private Long userId;
	private boolean locked;
	
	public Long getThreadId() {
		return threadId;
	}
	
	public void setThreadId(Long threadId) {
		this.threadId = threadId;
	}
	
	public String getThreadTitle() {
		return threadTitle;
	}
	
	public void setThreadTitle(String threadTitle) {
		this.threadTitle = threadTitle;
	}
	
	public Long getUserId() {
		return userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public boolean isLocked() {
		return locked;
	}
	
	public void setLocked(boolean locked) {
		this.locked = locked;
	}
	
	@Override
	public String toString() {
		return String.format("Thread [threadId=%s, threadTitle=%s, creator=%s, createdDate=%s, modifiedDate=%s",
				this.threadId, this.threadTitle, this.userId, this.createdDate, this.modifiedDate);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.threadId);
	}
	
	public boolean equals(Object obj) {
		boolean result;
		
		if (this == obj) {result = true;}
		if (obj == null || getClass() != obj.getClass()) {result = false;}
		
		Thread otherThread = (Thread) obj;
		
		result = Objects.equals(this.threadId, otherThread.getThreadId());
		
		return result;
	}
	
	

}
