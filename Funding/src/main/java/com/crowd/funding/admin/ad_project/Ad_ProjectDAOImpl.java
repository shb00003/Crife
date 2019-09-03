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
	public List<ProjectDTO> proSearch(String searchOption, String keyword, 
			int start, int end) throws Exception {
		
		Map<String, Object> map=new HashMap<>();
		map.put("searchOption", searchOption);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);
		map.put("end", end);
		return sql.selectList("admin.proSearch", map);
	}

	@Override
	public int searchCount(String searchOption, String keyword) 
			throws Exception {
		Map<String, Object> map=new HashMap<>();
		map.put("searchOption", searchOption);
		map.put("keyword", "%"+keyword+"%");	
		return sql.selectOne("admin.searchCount", map);
	}

	@Override
	public int totalCount() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	
}
