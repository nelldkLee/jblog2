package com.cafe24.jblog.vo;

public class BlogVo {

	private String blogId;
	private String title;
	private String logo;
	private String name;

	public String getBlogId() {
		return blogId;
	}
	public BlogVo setBlogId(String blogId) {
		this.blogId = blogId;
		return this;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public BlogVo setName(String name) {
		this.name = name;
		return this;
	}
	public String getBlogTitle() {
		return name + "의 블로그"; 
	}
	@Override
	public String toString() {
		return "BlogVo [blogId=" + blogId + ", title=" + title + ", logo=" + logo + "]";
	}
	
}
