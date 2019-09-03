package com.crowd.funding.admin.manager;

import java.util.List;

public interface ManagerDAO {

		public List<ManagerDTO> listManager() throws Exception;
		public void insertManager(ManagerDTO dto) throws Exception;
		public void updateManager(ManagerDTO dto) throws Exception;
		public void deleteManager(String admin_id) throws Exception;
		public ManagerDTO viewManager(String admin_id) throws Exception;
		public boolean loginCheck(ManagerDTO dto) throws Exception;
}
