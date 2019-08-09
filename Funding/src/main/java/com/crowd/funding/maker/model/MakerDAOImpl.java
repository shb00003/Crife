package com.crowd.funding.maker.model;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.crowd.funding.member.model.MemberDTO;

@Repository
public class MakerDAOImpl implements MakerDAO {

	@Inject
	SqlSession sql;

	@Override
	public void makerPOST(MakerDTO maDTO) throws Exception {
		System.out.println("### makerDAO : makerPOST 메이커 등록 ####");
		sql.insert("maker.join", maDTO);
		// member 테이블의 mem_type 변경
		sql.update("maker.memtype", maDTO.getMem_idx());
	}

	@Override
	public int idx(int mem_idx) throws Exception {
		System.out.println("### makerDAO : idx ####");
		return sql.selectOne("maker.idx", mem_idx);
	}

	@Override
	public int makeridx(int mem_idx) throws Exception {
		System.out.println("### makerDAO : makeridx ####");
		return sql.selectOne("maker.makeridx", mem_idx);
	}

	@Override
	public MakerDTO makerinfo(int mem_idx) throws Exception {
		System.out.println("### makerDAO : makerinfo 메이커 정보 ####");
		return sql.selectOne("maker.makerinfo", mem_idx);
	}

	@Override
	public void makerinfoUP(MakerDTO maDTO) throws Exception {
		System.out.println("### makerDAO : makerinfoUP 메이커 정보 수정 ####");
		sql.selectOne("maker.infoup", maDTO);
	}

	@Override
	public void makerinfoDEL(MakerDTO maDTO) throws Exception {
		System.out.println("### makerDAO : makerinfoDEL 메이커 정보 삭제 ####");
		sql.delete("maker.infodel", maDTO.getMem_idx());
		sql.update("maker.delmemtype", maDTO.getMem_idx());
	}

}
