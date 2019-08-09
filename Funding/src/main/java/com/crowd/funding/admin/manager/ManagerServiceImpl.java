package com.crowd.funding.admin.manager;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl implements ManagerService {
	
	@Inject
	ManagerDAO managerDao;

	@Override
	public List<ManagerDTO> listManager() {
		return managerDao.listManager();
	}

	@Override
	public void insertManager(ManagerDTO dto) {
		managerDao.insertManager(dto);
	}

	@Override
	public void updateManager(ManagerDTO dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteManager(String admin_id) {
		// TODO Auto-generated method stub

	}

	@Override
	public ManagerDTO viewManager(String admin_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
