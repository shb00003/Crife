package com.crowd.funding.community.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDAOImple implements NoticeDAO {

	@Inject
	SqlSession sqlSession;

	@Override
	public void deleteFile(String fullName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<String> getAttach(int notice_idx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addAttach(String fullName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAttach(String fullName, int notice_idx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(NoticeDTO dto) throws Exception {
		sqlSession.insert("notice.insert_notice", dto);
	}

	@Override
	public NoticeDTO read(int notice_idx) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(NoticeDTO dto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int notice_idx) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<NoticeDTO> listAll(int start, int end, String search_option, String keyword) throws Exception {
		return sqlSession.selectList("notice.noticeList");
	}

	@Override
	public void increaseViewcnt(int notice_idx) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int countArticle(String search_option, String keyword) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
