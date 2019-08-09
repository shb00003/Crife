package com.crowd.funding.admin.manager;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.crowd.funding.admin.manager.ManagerDTO;

@Repository
public class ManagerDAOImpl implements ManagerDAO {

	@Inject
	SqlSession sql;

	@Override
	public List<ManagerDTO> listManager() {
		return  sql.selectList("admin.managerList");
	}

	@Override
	public void insertManager(ManagerDTO dto) {
		sql.insert("admin.insertManager");

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
