package com.crowd.funding.project.model;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
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
	private int maker_idx;
	private String maker_name;
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
	private String pro_search;
		


}