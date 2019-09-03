package com.crowd.funding.admin.ad_project;

import java.util.List;

import com.crowd.funding.project.model.ProjectDTO;

public interface Ad_ProjectDAO {
	//include로 검색기능 따로 구현
	public List<ProjectDTO> proSearch(String searchOption, String keyword, int start, int end) throws Exception;
	public int searchCount(String searchOption, String keyword) throws Exception;
	public int totalCount() throws Exception;
	
		

	
}
