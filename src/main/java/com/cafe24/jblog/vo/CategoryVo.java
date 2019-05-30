package com.cafe24.jblog.vo;

public class CategoryVo {

	private Integer no;
	private String blogId;
	private String title;
	private String description;
	private String regDate;
	private int postCount;

	public Integer getNo() {
		return no;
	}
	public CategoryVo setNo(Integer no) {
		this.no = no;
		return this;
	}
	public String getBlogId() {
		return blogId;
	}
	public CategoryVo setBlogId(String blogId) {
		this.blogId = blogId;
		return this;
	}
	public String getDescription() {
		return description;
	}
	public CategoryVo setDescription(String description) {
		this.description = description;
		return this;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	public int getPostCount() {
		return postCount;
	}
	public void setPostCount(int postCount) {
		this.postCount = postCount;
	}
	
	public String getTitle() {
		return title;
	}
	public CategoryVo setTitle(String title) {
		this.title = title;
		return this;
	}
	@Override
	public String toString() {
		return "CategoryVo [no=" + no + ", blogId=" + blogId + ", title=" + title + ", description=" + description
				+ ", regDate=" + regDate + ", postCount=" + postCount + "]";
	}
}
