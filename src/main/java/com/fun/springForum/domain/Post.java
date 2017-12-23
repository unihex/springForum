package com.fun.springForum.domain;

import java.util.Objects;

public class Post extends BaseDomainObject {
	
	private Long postId;
	private Long threadId;
	private Long userId;
	private String content;
	
	public Long getPostId() {
		return postId;
	}
	
	public void setPostId(Long postId) {
		this.postId = postId;
	}
	
	public Long getThreadId() {
		return threadId;
	}
	
	public void setThreadId(Long threadId) {
		this.threadId = threadId;
	}
	
	public Long getUserId() {
		return userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return String.format("Post [postId=%s, threadId=%s, poster=%s, content=%s, createdDate=%s, modifiedDate=%s", 
				this.postId, this.threadId, this.userId, this.content, this.createdDate, this.modifiedDate);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.postId);
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean result;
		
		if (this == obj) {result = true;}
		if (obj == null || getClass() != obj.getClass()) {result = false;}
		
		Post otherPost = (Post) obj;
		
		result = Objects.equals(this.postId, otherPost.getPostId());
		
		return result;
	}

}
