package com.crowd.funding.admin.manager;


import java.util.List;

import javax.servlet.http.HttpSession;

import com.crowd.funding.admin.manager.ManagerDTO;
import com.crowd.funding.admin.manager.ManagerDAO;

public interface ManagerService {
	public List<ManagerDTO> listManager() throws Exception;
	public void insertManager(ManagerDTO dto) throws Exception;
	public void updateManager(ManagerDTO dto) throws Exception;
	public void deleteManager(String admin_id) throws Exception;
	public ManagerDTO viewManager(String admin_id) throws Exception;
	public boolean loginCheck(ManagerDTO dto, 
			                  HttpSession session) throws Exception;
	public void logout(HttpSession session) throws Exception;

}
