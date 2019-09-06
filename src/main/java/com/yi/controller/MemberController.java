package com.yi.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yi.domain.Member;
import com.yi.service.MemberService;

@RestController
@RequestMapping("/test")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	MemberService service;
	
	@RequestMapping(value="",method=RequestMethod.POST)
	public ResponseEntity<String> list(@RequestBody Member member){
		ResponseEntity<String> entity = null;
		
		logger.info("insert---------------");
		try {
			service.insert(member);
			entity = new ResponseEntity<>("success",HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		
		return entity;
	}
	
	
	@RequestMapping(value="",method=RequestMethod.GET)
	public ResponseEntity<List<Member>> list(){
		logger.info("all----------------");
		ResponseEntity<List<Member>> entity = null;
		
		try {
			List<Member> list = service.list();
			entity = new ResponseEntity<>(list,HttpStatus.OK);
			logger.info("사이즈 : "+list.size());
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		
		return entity;
	}
	
}
