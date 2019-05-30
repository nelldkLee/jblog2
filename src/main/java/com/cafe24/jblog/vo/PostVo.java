package com.cafe24.jblog.vo;

public class PostVo {
	
	private Integer no;
	private Integer categoryNo;
	private String title;
	private String content;
	private String regDate;

	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	public Integer getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(Integer categoryNo) {
		this.categoryNo = categoryNo;
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
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "PostVo [no=" + no + ", categoryNo=" + categoryNo + ", title=" + title + ", content=" + content
				+ ", regDate=" + regDate + "]";
	}
}
