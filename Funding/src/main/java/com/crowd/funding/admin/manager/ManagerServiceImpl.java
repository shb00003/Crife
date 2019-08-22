package com.crowd.funding.admin.manager;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl implements ManagerService {
	
	@Inject
	ManagerDAO managerDao;

	@Override
	public List<ManagerDTO> listManager() throws Exception {
		return managerDao.listManager();
	}

	@Override
	public void insertManager(ManagerDTO dto) throws Exception {
		managerDao.insertManager(dto);
	}

	@Override
	public void updateManager(ManagerDTO dto) throws Exception {
		managerDao.updateManager(dto);

	}

	@Override
	public void deleteManager(String admin_id) throws Exception {
		managerDao.deleteManager(admin_id);

	}

	@Override
	public ManagerDTO viewManager(String admin_id) throws Exception {
		return managerDao.viewManager(admin_id);
	}

	@Override
	public boolean loginCheck(ManagerDTO dto, 
			                  HttpSession session) throws Exception {
		boolean result=managerDao.loginCheck(dto);
		if(result) {  //로그인 성공
			ManagerDTO dto2=viewManager(dto.getAdmin_id()); //세션 변수에 값 저장
			session.setAttribute("admin", dto.getAdmin_id());
			session.setAttribute("admin_name", dto2.getAdmin_name());
			System.out.println(session.getAttribute("admin_id"));
			System.out.println(session.getAttribute("admin_name"));
		}
		return result;
		}

	@Override
	public void logout(HttpSession session) throws Exception {
		session.invalidate(); //세션 초기화
	}
	

}
