package com.crowd.funding.admin.ad_project;

import java.util.List;

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
	
}
