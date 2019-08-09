package com.crowd.funding.admin.manager;


import java.util.List;

import com.crowd.funding.admin.manager.ManagerDTO;
import com.crowd.funding.admin.manager.ManagerDAO;

public interface ManagerService {
	public List<ManagerDTO> listManager();
	public void insertManager(ManagerDTO dto);
	public void updateManager(ManagerDTO dto);
	public void deleteManager(String admin_id);
	public ManagerDTO viewManager(String admin_id);

}
