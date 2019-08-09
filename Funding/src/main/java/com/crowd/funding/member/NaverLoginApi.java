package com.crowd.funding.member;

import com.github.scribejava.core.builder.api.DefaultApi20;

//싱글톤
public class NaverLoginApi extends DefaultApi20 implements SNSurls{
	
	 protected NaverLoginApi(){
	    }

	    private static class InstanceHolder{
	        private static final NaverLoginApi INSTANCE = new NaverLoginApi();
	    }


	    public static NaverLoginApi instance(){
	        return InstanceHolder.INSTANCE;
	    }

	    @Override
	    public String getAccessTokenEndpoint() {
	        return NAVER_ACCESS_TOKEN;
	    }                   

	    @Override
	    protected String getAuthorizationBaseUrl() {
	        return NAVER_AUTH;
	    }   

}
