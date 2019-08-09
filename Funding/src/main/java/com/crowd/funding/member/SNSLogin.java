package com.crowd.funding.member;

import com.crowd.funding.member.model.MemberDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth20Service;

public class SNSLogin {
	private OAuth20Service oauthService;
	private String profileUrl;
	private String service;	
	private SNSvalue sns;

	public SNSLogin(SNSvalue sns) {
		this.oauthService = new ServiceBuilder(sns.getClientId()).apiSecret(sns.getClientSecret())
				.callback(sns.getRedirectUrl()).scope("profile").build(sns.getApi20Instance());

		this.profileUrl = sns.getProfileUrl();
		this.service = sns.getService();
	}

	public String getNaverAuthURL() {
		return this.oauthService.getAuthorizationUrl();
	}

	public MemberDTO getUserProfile(String code) throws Exception {
		OAuth2AccessToken accessToken = oauthService.getAccessToken(code);

		OAuthRequest request = new OAuthRequest(Verb.GET, this.profileUrl);
		oauthService.signRequest(accessToken, request);

		Response response = oauthService.execute(request);
		System.out.println("ㄱㄱㄱㄱㄱㄱ " +response.getBody());

		return parseJson(response.getBody());
	}

	// json to string
	private MemberDTO parseJson(String body) throws Exception {
		MemberDTO mem = new MemberDTO();

		ObjectMapper mapper = new ObjectMapper();
		JsonNode rootNode = mapper.readTree(body);

		JsonNode resNode = rootNode.get("response");
		mem.setNaver_idx(resNode.get("id").asText());
		mem.setMem_email("n"+resNode.get("id").asInt());
		mem.setMem_name(resNode.get("name").asText());
		
		if (resNode.get("gender").asText().equals("F")) {
			mem.setMem_sex(2);
		} else if (resNode.get("gender").asText().equals("M")) {
			mem.setMem_sex(1);
		} else if (resNode.get("gender").asText().equals("U")) {
			mem.setMem_sex(0); // 확인불가
		}

		return mem;
	}

	

}