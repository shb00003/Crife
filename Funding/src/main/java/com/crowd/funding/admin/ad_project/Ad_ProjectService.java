package com.crowd.funding.admin.ad_project;

import java.util.List;

import com.crowd.funding.project.model.ProjectDTO;

public interface Ad_ProjectService {
	public List<ProjectDTO> projectAll(String searchOption, String keyword) throws Exception;
	public int proCount(String searchOption, String keyword) throws Exception;
	
}
