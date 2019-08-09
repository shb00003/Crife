package com.crowd.funding.project.service;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.crowd.funding.project.model.ProjectDAO;
import com.crowd.funding.project.model.ProjectDTO;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Inject
	ProjectDAO projectDao;

	@Override
	public void add(ProjectDTO dto) {
		projectDao.add(dto);

	}
	
	@Override
	public String nameSelect(int pro_id) {
		return projectDao.nameSelect(pro_id);
	}

	@Override
	public ProjectDTO pro_detail(int pro_id) {
		return projectDao.pro_detail(pro_id);
	}

	@Override
	public void save1(ProjectDTO dto) {
		projectDao.save1(dto);
	}

	@Override
	public int idSelect(String pro_name) {
		return projectDao.idSelect(pro_name);
	}

	@Override
	public List<ProjectDTO> listProject() {
		return projectDao.listProject();
	}

	@Override
	public List<ProjectDTO> my_pro(int mem_idx) {
		return projectDao.my_pro(mem_idx);
	}

	@Override
	public void my_delete(int pro_id) {
		projectDao.my_delete(pro_id);
	}

	@Override
	public void story_update(ProjectDTO dto) {
		projectDao.story_update(dto);
	}

}
