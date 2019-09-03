package com.crowd.funding.admin.ad_member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.crowd.funding.member.model.MemberDTO;


@Repository
public class Ad_MemberDAOImpl implements Ad_MemberDAO {

	@Inject
	SqlSession sql;

	@Override
	public List<MemberDTO> memList(String memSearch, String keyword, 
			                          int start, int end) throws Exception {
		Map<String, Object> map=new HashMap<>();
		map.put("memSearch", memSearch);
		map.put("keyword", "%"+keyword+"%");
		map.put("start", start);
		map.put("end", end);
		//Mapper에는 2개 이상의 값을 전달 할 수 없음(dto 또는 map 사용)
		return sql.selectList("admin.memList", map);
	}

	@Override
	public int memCount(String memSearch, String keyword) throws Exception {
		Map<String, Object> map=new HashMap<>();
		map.put("memSearch", memSearch);
		map.put("keyword", "%"+keyword+"%");
		return sql.selectOne("admin.memCount", map);
		
	}

	@Override
	public int memTotCount() throws Exception {
		return sql.selectOne("admin.memTotCount");
	}
	@Override
	public int memTotCount_3() throws Exception {
		return sql.selectOne("admin.memTotCount_3");
	}

	@Override
	public MemberDTO memView(int mem_idx) throws Exception {
		return sql.selectOne("admin.memView", mem_idx);
	}

	@Override
	public void memUpdate(MemberDTO dto) throws Exception {
		sql.update("admin.memUpdate", dto);
		
	}

	@Override
	public void memDelete(int mem_idx) throws Exception {
		sql.delete("admin.memDelete", mem_idx);
		
	}


}