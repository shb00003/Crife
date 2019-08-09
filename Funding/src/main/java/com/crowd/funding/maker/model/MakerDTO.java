package com.crowd.funding.maker.model;

import lombok.Data;

@Data
public class MakerDTO {

	private int maker_idx;
	private String maker_name;
	private String maker_phone;

	private int maker_zipcode;
	private String maker_address1;
	private String maker_address2;
	private String maker_address3;
	private String maker_address4;

	private String maker_intro;
	private String maker_photo;

	private int mem_idx;

}
