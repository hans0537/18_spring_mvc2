package com.spring.mvc2.data_transfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mvc2.data_transfer.dao.MemberDAO;

@Controller
@RequestMapping("cTOv")
public class ControllerToView {

	@Autowired
	private MemberDAO memberDAO;
	
	/*
	 * 
	 *  예시 1) Model
	 *  
	 *  메서드의 파라미터로 Model을 추가하여 addAttribute() 메서드로 뷰에서 사용할 데이터를 전달 한다.
	 * 
	 */
	
	@RequestMapping(value="/list1")
	public String list1(Model model) {
		
		model.addAttribute("from", "list");
		model.addAttribute("memberList", memberDAO.selectAllMember());
		return "member/memberList";
	}
	
	/*
	 * 예시 2) ModelAndView 클래스 이용
	 * 
	 * ModelAndView객체를 생성하여  addObject() 메서드로 뷰에서 사용할 데이터를 전달 한다.
	 * 관용적으로 객체명으로 mv 혹은 mav로 작성한다.
	 * 
	 */
	
	@RequestMapping(value="/list2")
	public ModelAndView list2() { // return 타입은 String이 아닌 ModelAndView 클래스
		
		ModelAndView mv = new ModelAndView(); // ModelAndView 객체 생성
		
		mv.setViewName("member/memberList"); // 포워딩할 jsp파일명 작성
		
		mv.addObject("from", "list2"); //addObject 메소드를 사용하여 데이터를 전송 (Model과 유사)
		mv.addObject("memberList", memberDAO.selectAllMember());
		
		return mv; // ModelAndView 객체를 반환
	}
	
	

}
