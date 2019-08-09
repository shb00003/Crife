package com.crowd.funding.project.model;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class ProjectDTO {
	private int pro_id;
	private String pro_name;
	private int pro_type1;
	private int pro_status;
	private String pro_summary;
	private String pro_content;
	private int pro_price;
	private String pro_imageURL;
	private Date pro_datetime;
	private int mem_idx;
	private String pro_category;
	private String pro_keyword1;
	private String pro_keyword2;
	private String pro_keyword3;
	private String pro_start;
	private String pro_end;
	private String pro_policy;
	private String pro_video;
	private MultipartFile file1;
	private MultipartFile file2;
	private String day;

	public int getPro_id() {
		return pro_id;
	}

	public void setPro_id(int pro_id) {
		this.pro_id = pro_id;
	}

	public String getPro_name() {
		return pro_name;
	}

	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}

	public int getPro_type1() {
		return pro_type1;
	}

	public void setPro_type1(int pro_type1) {
		this.pro_type1 = pro_type1;
	}

	public int getPro_status() {
		return pro_status;
	}

	public void setPro_status(int pro_status) {
		this.pro_status = pro_status;
	}

	public String getPro_summary() {
		return pro_summary;
	}

	public void setPro_summary(String pro_summary) {
		this.pro_summary = pro_summary;
	}

	public String getPro_content() {
		return pro_content;
	}

	public void setPro_content(String pro_content) {
		this.pro_content = pro_content;
	}

	public int getPro_price() {
		return pro_price;
	}

	public void setPro_price(int pro_price) {
		this.pro_price = pro_price;
	}

	public String getPro_imageURL() {
		return pro_imageURL;
	}

	public void setPro_imageURL(String pro_imageURL) {
		this.pro_imageURL = pro_imageURL;
	}

	public Date getPro_datetime() {
		return pro_datetime;
	}

	public void setPro_datetime(Date pro_datetime) {
		this.pro_datetime = pro_datetime;
	}

	public int getMem_idx() {
		return mem_idx;
	}

	public void setMem_idx(int mem_idx) {
		this.mem_idx = mem_idx;
	}

	public String getPro_category() {
		return pro_category;
	}

	public void setPro_category(String pro_category) {
		this.pro_category = pro_category;
	}

	public String getPro_keyword1() {
		return pro_keyword1;
	}

	public void setPro_keyword1(String pro_keyword1) {
		this.pro_keyword1 = pro_keyword1;
	}

	public String getPro_keyword2() {
		return pro_keyword2;
	}

	public void setPro_keyword2(String pro_keyword2) {
		this.pro_keyword2 = pro_keyword2;
	}

	public String getPro_keyword3() {
		return pro_keyword3;
	}

	public void setPro_keyword3(String pro_keyword3) {
		this.pro_keyword3 = pro_keyword3;
	}

	public String getPro_start() {
		return pro_start;
	}

	public void setPro_start(String pro_start) {
		this.pro_start = pro_start;
	}

	public String getPro_end() {
		return pro_end;
	}

	public void setPro_end(String pro_end) {
		this.pro_end = pro_end;
	}

	public String getPro_policy() {
		return pro_policy;
	}

	public void setPro_policy(String pro_policy) {
		this.pro_policy = pro_policy;
	}

	public String getPro_video() {
		return pro_video;
	}

	public void setPro_video(String pro_video) {
		this.pro_video = pro_video;
	}

	public MultipartFile getFile1() {
		return file1;
	}

	public void setFile1(MultipartFile file1) {
		this.file1 = file1;
	}

	public MultipartFile getFile2() {
		return file2;
	}

	public void setFile2(MultipartFile file2) {
		this.file2 = file2;
	}

	@Override
	public String toString() {
		return "ProjectDTO [pro_id=" + pro_id + ", pro_name=" + pro_name + ", pro_type1=" + pro_type1 + ", pro_status="
				+ pro_status + ", pro_summary=" + pro_summary + ", pro_content=" + pro_content + ", pro_price="
				+ pro_price + ", pro_imageURL=" + pro_imageURL + ", pro_datetime=" + pro_datetime + ", mem_idx="
				+ mem_idx + ", pro_category=" + pro_category + ", pro_keyword1=" + pro_keyword1 + ", pro_keyword2="
				+ pro_keyword2 + ", pro_keyword3=" + pro_keyword3 + ", pro_start=" + pro_start + ", pro_end=" + pro_end
				+ ", pro_policy=" + pro_policy + ", pro_video=" + pro_video + ", file1=" + file1 + ", file2=" + file2
				+ "]";
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

}
