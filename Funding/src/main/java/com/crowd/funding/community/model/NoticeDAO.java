package com.crowd.funding.community.model;

import java.util.List;

import com.crowd.funding.community.model.NoticeDTO;

public interface NoticeDAO {
	public void deleteFile(String fullName);	// 첨부파일 삭제
	public List<String> getAttach(int notice_idx);	// 첨부파일 등록
	public void addAttach(String fullName);	// 첨부파일 저장
	public void updateAttach(String fullName, int notice_idx);	// 첨부파일 수정
	public void insert(NoticeDTO dto) throws Exception;	// 글쓰기
	public NoticeDTO read(int notice_idx) throws Exception;		// 글읽기
	public void update(NoticeDTO dto) throws Exception;	// 글수정
	public void delete(int notice_idx) throws Exception;	// 글삭제
	// 목록(페이지 나누기, 검색 기능 포함)
	public List<NoticeDTO> listAll(int start, int end, String search_option, String keyword) throws Exception;
	// 조회수 증가 처리
	public void increaseViewcnt(int notice_idx) throws Exception;
	// 레코드 갯수 계산
	public int countArticle(String search_option, String keyword) throws Exception;
}
