package com.crowd.funding.project.service;

import java.util.List;

import com.crowd.funding.project.model.ProjectDTO;

public interface ProjectService {
	List<ProjectDTO> listProject();
	void add(ProjectDTO dto);
	ProjectDTO pro_detail(int pro_id);
	void save1(ProjectDTO dto);
	String nameSelect(int pro_id);
	int idSelect(String pro_name);
	List<ProjectDTO> my_pro(int mem_idx);
	void my_delete(int pro_id);
	void story_update(ProjectDTO dto);
}
