package com.crowd.funding.admin.ad_project;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.crowd.funding.project.model.ProjectDTO;

@Repository
public class Ad_ProjectDAOImpl implements Ad_ProjectDAO {

	@Inject
	SqlSession sql;

	@Override
	public List<ProjectDTO> projectAll(){
		return sql.selectList("admin.project_all");
	}
	@Override
	public List<ProjectDTO> projectSearch
	(String searchOption, String keyword) throws Exception {
		Map<String, String> map=new HashMap<String, String>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		return sql.selectList("admin.project_all",map);
	}
	
}
