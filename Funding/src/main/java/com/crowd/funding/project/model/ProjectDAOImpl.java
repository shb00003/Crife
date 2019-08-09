package com.crowd.funding.project.model;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectDAOImpl implements ProjectDAO {

	@Inject
	SqlSession sqlSession;

	@Override
	public void add(ProjectDTO dto) {
		sqlSession.insert("project.add", dto);
	}

	@Override
	public ProjectDTO pro_detail(int pro_id) {
		return sqlSession.selectOne("project.pro_detail", pro_id);
	}

	@Override
	public void save1(ProjectDTO dto) {
		sqlSession.update("project.save1", dto);
	}

	@Override
	public String nameSelect(int pro_id) {
		return sqlSession.selectOne("project.pro_name", pro_id);
	}

	@Override
	public int idSelect(String pro_name) {
		return sqlSession.selectOne("project.pro_id", pro_name);
	}

	@Override
	public List<ProjectDTO> listProject() {
		return sqlSession.selectList("project.pro_list");
	}

	@Override
	public List<ProjectDTO> my_pro(int mem_idx) {
		return sqlSession.selectList("project.my_pro", mem_idx);
	}

	@Override
	public void my_delete(int pro_id) {
		sqlSession.delete("project.my_delete", pro_id);
	}

	@Override
	public void story_update(ProjectDTO dto) {
		sqlSession.update("project.story_update", dto);
	}

}
