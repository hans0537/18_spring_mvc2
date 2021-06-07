package com.spring.mvc2.data_transfer.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.mvc2.data_transfer.domain.OrderDTO;

@Repository
public class OrderDAO {

	@Autowired
	private SqlSession sqlSession;

	// DAO > Mapper 전송 예시 1) 단일 데이터 전송
	public void insertOne(String productName) {
		sqlSession.insert("order.insertOneData", productName);
	}

	// DAO > Mapper 전송 예시 2) DTO 클래스 전송
	public void insertDTO(OrderDTO odto) {
		sqlSession.insert("order.insertDTO", odto);
	}

	// DAO > Mapper 전송 예시 3) Map 데이터 전송
	public void insertMap(Map<String, String> orderMap) {
		sqlSession.insert("order.insertMap", orderMap);
	}

	public List<OrderDTO> selectAllData() {
		return sqlSession.selectList("order.selectAll");
	}

	// Mapper > DAO 전송 예시 1) 단일 데이터 전송
	public int selectData1() {
		return sqlSession.selectOne("order.select1");
	}

	// Mapper > DAO 전송 예시 2) DTO 클래스 전송
	public List<OrderDTO> selectData2() {
		return sqlSession.selectList("order.select2");
	}

	// Mapper > DAO 전송 예시 3) Map 데이터 전송
	public List<Map<String, Object>> selectData3() {
		return sqlSession.selectList("order.select3");
	}
	// 애초에 Map 데이터가 {(키 ,벨류), ....} 이게 한줄이므로
	// 여러줄일수도 있으니 각 Map 데이터를 List안에 감싸준다
	
	// Mapper > DAO 전송 예시 4) Map 데이터 전송
	public List<Map<String, Object>> selectData4() {
		return sqlSession.selectList("order.select4");
	}
	
}
