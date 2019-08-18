package com.crowd.funding.admin.ad_project;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.crowd.funding.project.model.ProjectDTO;

@Service
public class Ad_ProjectServiceImpl implements Ad_ProjectService {
	
	@Inject
	Ad_ProjectDAO proDao;
	
	
	@Override
	public List<ProjectDTO> projectAll(String searchOption, String keyword) throws Exception {
		return proDao.projectAll(searchOption, keyword);
	}


	@Override
	public int proCount(String searchOption, String keyword) throws Exception {
		return proDao.proCount(searchOption, keyword);
	}
	
	
}
