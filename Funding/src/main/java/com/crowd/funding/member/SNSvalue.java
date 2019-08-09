package com.crowd.funding.member;

import org.apache.commons.lang3.StringUtils;

import com.github.scribejava.core.builder.api.DefaultApi20;

import lombok.Data;

//@Getter, @Setter, @RequiredArgsConstructor, @ToString, @EqualsAndHashCode을 한꺼번에 설정
//소스를 줄일 수 있어서 매우 유용하다.
@Data
public class SNSvalue implements SNSurls{

	private String service;
	private String clientId;
	private String clientSecret;
	private String redirectUrl;
	private DefaultApi20 api20Instance;
	private String profileUrl;

	private boolean isNaver;
//	private boolean isGoogle;

	public SNSvalue(String service, String clientId, String clientSecret, String redirectUrl) {
		this.service = service;
		this.clientId = clientId;
		this.clientSecret = clientSecret;
		this.redirectUrl = redirectUrl;

		this.isNaver = StringUtils.endsWithIgnoreCase("naver", this.service);
		// this.isGoogle = StringUtils.equalsIgnoreCase("google", this.service);

		if (isNaver) {
			this.api20Instance = NaverLoginApi.instance();
			this.profileUrl=NAVER_PROFILE_URL;

		}

		/*
		 * else if (isGoogle) { this.api20Instance = GoogleApi20.instance();
		 * this.profileUrl = GOOGLE_PROFILE_URL; }
		 */

	}

}
