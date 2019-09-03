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
	public List<ProjectDTO> proSearch(String searchOption, String keyword, 
			int start, int end) throws Exception {
		return proDao.proSearch(searchOption, keyword, start, end);
	}


	@Override
	public int searchCount(String searchOption, String keyword) throws Exception {
		return proDao.searchCount(searchOption, keyword);
	}


	@Override
	public int totalCount() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
