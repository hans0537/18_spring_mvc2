package com.spring.mvc2.data_transfer.dao;

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
}
